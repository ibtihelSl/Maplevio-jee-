package Resources;



import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Entities.Candidate;
import Entities.Client;
import Services.UserService;

@Path("users")
@RequestScoped
public class UserResource {
	@EJB
	UserService service = new UserService();
	/*
	@GET
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response authenticateUserByUsername(@QueryParam("email") String email,
			@QueryParam("password") String password) {
		
			
			try {

				return Response.ok(service.getUserByEmailAndPassword(email, password)).build();

			} catch (Exception e) {
				System.out.println(e.getMessage());
				return Response.status(Response.Status.FORBIDDEN).entity("!!!! !").build();
			}
		
	}
	
	*/
	
	
	
	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListClients() {
		//UserService sc = new UserService();
		return Response.status(Status.OK).entity(service.clients()).build();
 
	}
	
	//////////////////////
	
	/*
	@GET
	@Path("rs")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListResources() {
		return Response.status(Status.OK).entity(service.resources()).build();
 
	}
	
	////////////////////////////
	

	
	//////////////////////////  Client
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response  addClient(Client client) {
		if (client != null) {
			
	
		service.ajouterClient(client);
		return Response.status(Status.CREATED).entity("success").build();
		}
		return Response.status(Status.NOT_FOUND).entity("not found").build();
	}
	
	
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
		public Response delete(@QueryParam(value ="id")int id) {
		
			service.deleteClient(id);
			return Response.status(Status.OK).entity(service.clients()).build();
			
		
	}
	
	////////////////////////////////// Candidate
	
	
	@POST
	@Path("addcd")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response  addCandidate(Candidate candidate) {
		if (candidate != null) {
			
	
		service.ajouterCandidate(candidate);
		return Response.status(Status.CREATED).entity("success").build();
		}
		return Response.status(Status.NOT_FOUND).entity("not found").build();
	}

	
	
	
	

*/
	@GET
	@Path("c")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getListCandidates() {
		return Response.status(Status.OK).entity(service.candidates()).build();
 
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("update/{id}")
	public Response update(@QueryParam(value ="id")int id , Candidate candidate) {
		if (service.getCandidateById(id) !=null) {
			service.update(candidate);
			return Response.status(Status.OK).entity(service.getCandidateById(id)).build();
			
		}
		return Response.status(Status.NOT_FOUND).entity("aucun candidat vous ").build();
	}
	
	///////////////////////////////  
	
	 
}
