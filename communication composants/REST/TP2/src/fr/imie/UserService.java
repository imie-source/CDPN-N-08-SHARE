package fr.imie;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Don;
import model.Personne;

@Path("user")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Stateless
public class UserService {
	
	@PersistenceContext
    private EntityManager entityManager;

	
	@GET
	public Response getAllUsers(){
		List<Personne> resultList = entityManager.createNamedQuery("Personne.findAll").getResultList();
		
		return Response.ok(resultList).build();
	}
}
