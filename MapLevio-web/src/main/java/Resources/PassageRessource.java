package Resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import Entities.Passage;
import ServicesRecrutement.PassageServicesLocal;


@Path("passage")
@RequestScoped
public class PassageRessource {
@EJB
PassageServicesLocal metier;
@POST
@Path("/affecterDateTech/{id}/{date}")
@Consumes(MediaType.APPLICATION_JSON)
public Response affecterDateTech(@PathParam(value="id")int id,@PathParam(value="date")String date) throws ParseException{
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	Date d = df.parse(date);
	metier.affecterDateTech(id,d);
	return Response.status(Status.NO_CONTENT).entity("le date affecter ").build();
}
@POST
@Path("/affecterDateFR/{id}/{date}")
@Consumes(MediaType.APPLICATION_JSON)
public Response affecterDateFR(@PathParam(value="id")int id,@PathParam(value="date")String date) throws ParseException{
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	Date d = df.parse(date);
	metier.affecterDateFR(id,d);
	return Response.status(Status.NO_CONTENT).entity("le date affecter ").build();
}
@GET
@Path("/getPassage/{id}")
@Produces(MediaType.APPLICATION_JSON)
public Response getPassage(@PathParam(value="id")int id){
	Passage p = metier.getPassage(id);
	if(p !=null){
		return Response.ok(p).build();
	}else{
		return Response.status(Status.NO_CONTENT).entity("No Passage Found").build();

	}
}
}
