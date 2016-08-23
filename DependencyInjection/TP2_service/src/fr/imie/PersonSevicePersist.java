package fr.imie;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Named;

import fr.imie.DTO.PersonneDTO;
@Default
@RequestScoped
public class PersonSevicePersist extends ADAO implements PersonServiceInterface{

	@Override
	public List<PersonneDTO> getPersons() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<PersonneDTO> retour = new ArrayList<PersonneDTO>();
		try {
			connection = openConnection();
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("SELECT id,nom,prenom,datenaiss FROM personne");

			while (resultSet.next()) {
				PersonneDTO personneDTO = buildDTOFromResultset(resultSet);
				retour.add(personneDTO);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeJDBC(connection, statement, resultSet);
		}
		return retour;
	}

	@Override
	public PersonneDTO addPersons(PersonneDTO personneToInsert) throws ImieException  {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		PersonneDTO retour = null;
		try {
			connection = openConnection();

			List<ParamJDBC> paramsList = new ArrayList<ParamJDBC>();
			if (personneToInsert.getNom() != null) {
				paramsList.add(new ParamJDBC("nom", personneToInsert.getNom()));
			}
			if (personneToInsert.getPrenom() != null) {
				paramsList.add(new ParamJDBC("prenom", personneToInsert
						.getPrenom()));
			}
			if (personneToInsert.getDateNaiss() != null) {
				paramsList.add(new ParamJDBC("datenaiss", new Date(
						personneToInsert.getDateNaiss().getTime())));
			}

			String fields = "";
			String params = "";
			Boolean firstField = true;
			for (ParamJDBC paramJDBC : paramsList) {
				fields = fields.concat(firstField ? "" : ",").concat(
						paramJDBC.getNom());
				params = params.concat(firstField ? "" : ",").concat("?");
				firstField = false;
			}

			String query = "INSERT into personne ("
					.concat(fields)
					.concat(") values (")
					.concat(params)
					.concat(") returning id, nom, prenom, datenaiss");

			statement = connection.prepareStatement(query);

			Integer paraNumber = 1;
			for (ParamJDBC paramJDBC : paramsList) {
				statement.setObject(paraNumber++, paramJDBC.getValue());
			}

			resultSet = statement.executeQuery();
			resultSet.next();
			retour = buildDTOFromResultset(resultSet);

		} catch (SQLException e) {
			throw new ImieException("impossible d'insérer une personne", e);
		} finally {
			closeJDBC(connection, statement, resultSet);
		}
		return retour;
		
	}
	
	private PersonneDTO buildDTOFromResultset(ResultSet resultSet)
			throws SQLException {
		PersonneDTO retour;
		retour = new PersonneDTO();
		retour.setId(resultSet.getInt("id"));
		retour.setNom(resultSet.getString("nom"));
		retour.setPrenom(resultSet.getString("prenom"));
		retour.setDateNaiss(resultSet.getDate("datenaiss"));
		return retour;
	}

	
	
}
