package fr.imie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import fr.imie.DTO.PersonneDTO;

@Named("personsService")
@SessionScoped
public class PersonService implements PersonServiceInterface, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9177870700641734061L;
	List<PersonneDTO> persons = new ArrayList<PersonneDTO>();
	
	
	public PersonService() {
		PersonneDTO person1 = new PersonneDTO();
		person1.setNom("lorem");
		person1.setPrenom("ipsum");
		persons.add(person1);
		PersonneDTO person2 = new PersonneDTO();
		person2.setNom("monroe");
		person2.setPrenom("Maryline");
		persons.add(person2);// TODO Auto-generated constructor stub
	}

	@Override
	public List<PersonneDTO> getPersons() {
		// TODO Auto-generated method stub
		return persons;
	}
	
	@Override
	public void addPersons(PersonneDTO person) {
		// TODO Auto-generated method stub
		persons.add(person);
	}

}
