package Resources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
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
import javax.ws.rs.core.Response.Status;

import Entities.Client;
import Entities.Project;
import Service.ProjectServiceLocal;

@Path("projets")
@RequestScoped
public class ProjectResource {

	@EJB
	ProjectServiceLocal projetservice;

	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    @Path("list")
	    public Response displayProjetList(){
	    	
	    	return Response.ok(projetservice.GetAllProjet()).build();
	    	
	    }
	    
	    @POST
		@Consumes(MediaType.APPLICATION_JSON)
	    @Path("add")
		public Response addProject(Project p) {
			return Response.ok(projetservice.ajouterProjet(p), MediaType.TEXT_PLAIN).build();
		}
	    
	  
	    
	    
	   
	    @DELETE
	    @Path("del/{projectId}")
	    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	    public String deleteClient(@PathParam("projectId") int projectId){
	    	projetservice.DeleteProjetById(projectId);
	         return"PROJET supprimé";
	      
	    }
	   
	    
	    
	    
	    
	    @PUT
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		@Path("edit/{projectId}")
		public Response UpdateProject(@PathParam(value="projectId") int id,Project pr) {
	    	
		if (projetservice.findProjectById(id)!=null) {
			projetservice.Update(pr);
			return Response.status(Status.OK).entity(projetservice.findProjectById(id)).build();

		}
		
		return Response.status(Status.NOT_FOUND).entity("project not found").build();

	}
	        @GET
	  		@Produces(MediaType.APPLICATION_JSON)
	  		@Path("/{projectId}")
	  		public Response GetClientById(@PathParam(value="projectId") int id) {
	  			return Response.status(Status.OK).entity(projetservice.findProjectById(id)).build();
	  		}    
	    
	    
}
