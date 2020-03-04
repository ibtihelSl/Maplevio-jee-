package Resources;


import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Entities.Client;
import Entities.Project;
import Enumerates.ClientCategory;
import Service.ClientServiceLocal;
import Service.ProjectServiceLocal;




@Path("clients")
@RequestScoped
public class ClientResource {
	
	
	
	
	@EJB
	ClientServiceLocal clientservice;
	@EJB
	ProjectServiceLocal projectservice;


	    @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    @Path("list")
	    public Response displayClientList(){
	    	 
	    	return Response.ok(clientservice.GetAllClient()).build();
	    	
	    }
	    

   
	    
	    
	    @POST
		@Consumes(MediaType.APPLICATION_JSON)
	    @Path("add")
		public Response addClient(Client c)
	    {
	    	/*System.out.println("client === > "+c.getNom());
	    	if (c.getClientCategory().equals("private"))
	    	{
	    		c.setClientCategory(ClientCategory.Private);
	    	}
	    	if (c.getClientCategory().equals("public"))
	    	{
	    		c.setClientCategory(ClientCategory.Public);
	    	}*/
	    	
			return Response.ok(clientservice.ajouterClient(c), MediaType.TEXT_PLAIN).build();
		}
	    
	   
	    @DELETE
	    @Path("del/{userId}")
	    @Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	    public String deleteClient(@PathParam("userId") int userid){
	    	clientservice.DeleteClientById(userid);
	         return"client supprimé";
	      
	    }
	    
	    
	    
	    
	    
	    @PUT
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		@Path("edit/{userId}")
		public Response UpdateClient(@PathParam(value="userId") int id,Client pr) {
	    	
		if (clientservice.findClientById(id)!=null) {
			clientservice.Update(pr);
			return Response.status(Status.OK).entity(clientservice.findClientById(id)).build();

		}
		
		return Response.status(Status.NOT_FOUND).entity("client not found").build();

	}

	    @GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/{userId}")
		public Response GetClientById(@PathParam(value="userId") int id) {
			return Response.status(Status.OK).entity(clientservice.findClientById(id)).build();
		}
	
		
		
}
		
		
		
		
		
		
		
		
		



