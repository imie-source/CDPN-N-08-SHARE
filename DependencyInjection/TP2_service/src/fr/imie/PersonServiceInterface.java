package fr.imie;

import java.sql.SQLException;
import java.util.List;

import fr.imie.DTO.PersonneDTO;

public interface PersonServiceInterface {
	public List<PersonneDTO> getPersons() throws SQLException;

	PersonneDTO addPersons(PersonneDTO person) throws SQLException ;
}
