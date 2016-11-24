package fr.imie;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Don;

@Path("don")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Stateless
public class DonService {

	@PersistenceContext
    private EntityManager entityManager;

	
	@GET
	public Response getAllProjects(){
		List<Don> resultList = entityManager.createNamedQuery("Don.findAll").getResultList();
		return Response.ok(resultList).build();
	}
	
	@GET
	@Path("/{id}")
	public Response getOneProject(@PathParam("id") Integer id){
		Don don = entityManager.find(Don.class, id);
		return Response.ok(don).build();
	}
	
}
