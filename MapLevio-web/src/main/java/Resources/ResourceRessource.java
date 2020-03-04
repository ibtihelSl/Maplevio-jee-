package Resources;


import java.util.List;

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

import Entities.Resource;
import Enumerates.Role;
import Services.ResourceService;

@Path("/Resource")
@RequestScoped
public class ResourceRessource {

	
	@EJB
	ResourceService rs;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("addresource")
	public Response addResource(Resource resource) {
		
		if(resource !=null) {
			
		rs.AjouterResource(resource);
					
		return Response.status(Status.CREATED).entity("ajout avec succ").build();
		
	}
		return Response.status(Status.NOT_FOUND).entity("prob d'ajout").build();

	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetListResource() {
		
		return Response.status(Status.OK).entity(rs.findAllResources()).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response GetResourceById(@PathParam(value="id") int id) {
		return Response.status(Status.OK).entity(rs.findResourceById(id)).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("resarchive")
	public Response GetListResourceArchivé() {
		
		return Response.status(Status.OK).entity(rs.Resourcesarchive()).build();
	}
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response SupprimerResource(@PathParam(value="id") int id) {

	if (rs.findResourceById(id)!=null) {
		rs.deleteResource(id, true);;
		return Response.status(Status.OK).entity("supp").build();

	}
	return Response.status(Status.NOT_FOUND).entity("Resource not found").build();

	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response UpdateResource(@PathParam(value="id") int id,Resource resource) {

	if (rs.findResourceById(id)!=null) {
		rs.updateResource(resource);
		return Response.status(Status.OK).entity(rs.findResourceById(id)).build();

	}
	
	return Response.status(Status.NOT_FOUND).entity("Resource not found").build();

}
	
	
	
	
}
