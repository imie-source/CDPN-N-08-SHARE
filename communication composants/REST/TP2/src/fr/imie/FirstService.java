package fr.imie;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Projet;

@Path("projet")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Stateless
public class FirstService {
	@PersistenceContext
    private EntityManager entityManager;

	
	@GET
	public Response getAllProjects(){
		List<Projet> resultList = entityManager.createNamedQuery("Projet.findAll").getResultList();
		return Response.ok(resultList).build();
	}
	
	@GET
	@Path("/{id}")
	public Response getOneProject(@PathParam("id") Integer id){
		Projet projet = entityManager.find(Projet.class, id);
		return Response.ok(projet).build();
	}
	
	@POST
	public Response addOneProject(Projet projet){
		entityManager.persist(projet);
		return Response.ok(projet).build();
	}
	
	@PUT
	@Path("/{id}")
	public Response updateOneProject(@PathParam("id") Integer id,Projet projet){
		Projet existingProjet = entityManager.find(Projet.class, id);
		existingProjet.setDescription(projet.getDescription());
		existingProjet.setNom(projet.getNom());
		existingProjet.setObjectif(projet.getObjectif());
		return Response.ok(existingProjet).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteOneProject(@PathParam("id") Integer id){
		Projet existingProjet = entityManager.find(Projet.class, id);
		entityManager.remove(existingProjet);
		return Response.ok(existingProjet).build();
	}

}
