package Resources;

import java.lang.Thread.State;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import Entities.Candidate;
import Entities.Mandate;
import Services.MandateService;

@Path("mandate")
@RequestScoped
public class MandateRessource {
	@EJB
	MandateService mandateservice;
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response ajouterMandate(Mandate  mandat) {
	//	Date a = new Date();
		if  (mandat!=null)
		{	mandateservice.ajouterMandate(mandat.getMandatePK().getProjectId(), mandat.getMandatePK().getResourceId(), mandat.getDebutMandat(),mandat.getFinMandat());
		return Response.status(Status.OK).entity("le mandate est afféctée ").build();
		}
		return Response.status(Status.NOT_FOUND).entity("aucune mandat trouvé ").build();
		
		
		}
	


		@GET
		@Path("listMandate")
		@Produces(MediaType.APPLICATION_JSON)
		public Response GetallMandate(@QueryParam(value="type")String type)
		{
			String a="archive";
			if(type.equals(a))
				return Response.status(Status.OK).entity(mandateservice.GetMandateArchivee()).build();
			else
			return Response.status(Status.OK).entity(mandateservice.GetallMandate()).build();	
		}


		@PUT
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/{pr}/{rs}")
	public Response archiverMandate(@PathParam(value="pr") int p,@PathParam(value="rs")int r){
			//idProject, idRessource, true
			if(mandateservice.FindMandate(p, r)!=null){
			Mandate m=mandateservice.FindMandate(p, r);
			mandateservice.deleteMandate(m);
			return Response.status(Status.OK).entity(mandateservice.FindMandate(p,r)).build();

			}
			return Response.status(Status.OK).entity("mandat non trouvée").build();
	}
	
	
	
}
