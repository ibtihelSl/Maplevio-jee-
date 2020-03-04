package Resources;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;
import Entities.Test;
import ServicesRecrutement.TestServicesLocal;


@Path("test")
@RequestScoped
public class TestRessource {
@EJB
TestServicesLocal metier;

@POST
@Path("/createTest")
@Consumes(MediaType.APPLICATION_JSON)
public Response createTest(Test t ,@Context UriInfo uriInfo){
	UriBuilder builder = uriInfo.getAbsolutePathBuilder();
	metier.createTest(t);
	builder.path(Integer.toString(t.getTestId())).build();
	return Response.created(builder.build()).entity(t).build();
}
@GET
@Path("/afficheTest/{id}")
@Produces(MediaType.APPLICATION_JSON)
public Response afficheTest(@PathParam(value="id")int id){
	Test t = metier.afficheTest(id);
	if(t !=null){
		return Response.ok(t).build();
	}else{
		return Response.status(Status.NO_CONTENT).entity("No Test Found").build();

	}
}
@DELETE
@Path("/deletTest/{id}")
public Response deletTest(@PathParam(value="id")int id){
	metier.deletTest(id);
	return Response.status(Status.NO_CONTENT).entity("Test successfully deleted ").build();
}
@GET
@Path("/afficherTest")
@Produces(MediaType.APPLICATION_JSON)
public Response afficherTest(){
	
	return Response.ok(metier.afficherTest()).build();
}
}
