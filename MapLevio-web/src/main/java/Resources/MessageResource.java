package Resources;

import java.awt.List;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import Entities.Client;
import Entities.Message;
import Entities.Resource;
import Services.MessageService;

@Path("/Message")
public class MessageResource {

	@EJB
	public static MessageService MessageMetier=new MessageService();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMessage(Message msg){
		
		if (msg!=null)
		{
			System.out.println("cc json");
			MessageMetier.EnvoyerMessage(msg);	
			
			return Response.status(Status.CREATED).entity("Success de l'envoi du message").build();
		}
		return Response.status(Status.NOT_FOUND).entity("Aucun message n'est envoyé").build();
		
	}
	
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response GetListMsg() {
		
		return Response.status(Status.OK).entity(MessageMetier.getAllMessage()).build();
	}*/
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessageByType(@QueryParam(value="typeMsg")String typeMessage) {
		String rec="reclamation";
		String Nbrrec="Nbrreclamation";

		String prob="probleme";
		String Nbrprob="Nbrprobleme";

		String sati="satisfaction";
		String Nbrsati="Nbrsatisfaction";

		String NbrNonlu="NbrMsgNonLu";

		
		String ClientExigent="CExigent";
		String RessourceAProblem="RAproblem";
		String NbrClientExigent="NbrCExigent";
		String NbrRessourceAProblem="NbrRAproblem";

		/******Nombre de mssages non lu******/

		if( typeMessage.equals(NbrNonlu))
			
			   return Response.status(Status.OK).entity(MessageMetier.NbreMessageNonLu()).build();
		
		/******Nombre des messages selon type******/

		if( typeMessage.equals(Nbrrec))
			
			   return Response.status(Status.OK).entity(MessageMetier.NbreMessageReclamation()).build();
		
		if( typeMessage.equals(Nbrprob))
			
			   return Response.status(Status.OK).entity(MessageMetier.NbreMessageProbleme()).build();
		
		if( typeMessage.equals(Nbrsati))
			
			   return Response.status(Status.OK).entity(MessageMetier.NbreMessageSatisfaction()).build();
		
		/******Nombre des client exigent******/

		if( typeMessage.equals(NbrClientExigent))
			
			   return Response.status(Status.OK).entity(MessageMetier.GetNbrClientExigent()).build();
		
		/******Nombre des Ressources à probleme******/

		if( typeMessage.equals(NbrRessourceAProblem))
			
			   return Response.status(Status.OK).entity(MessageMetier.GetNbrResAProb()).build();
		
		
		
		/******Lister les messages selon type******/
		if( typeMessage.equals(rec))
			
		   return Response.status(Status.OK).entity(MessageMetier.getAllMessageRec()).build();
		
			
		
		if (typeMessage.equals(prob)) 
			
			return Response.status(Status.OK).entity(MessageMetier.getAllMessageProb()).build();
		
		if (typeMessage.equals(sati)) 
			
			return Response.status(Status.OK).entity(MessageMetier.getAllMessageSati()).build();
			
		
		/******liste des clients exigent******/
		
		if (typeMessage.equals(ClientExigent))
		
			return Response.status(Status.OK).entity(MessageMetier.ListClientExigent()).build();

		/******Nombre des Ressources à probleme******/

		if (typeMessage.equals(RessourceAProblem))
			
			return Response.status(Status.OK).entity(MessageMetier.ListRessourceAProb()).build();

		
		
		else
		
			return Response.status(Status.OK).entity(MessageMetier.getAllMessage()).build();
		
			
			
		
		}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response archiverMsg(@PathParam(value="id") int id) {

	if (MessageMetier.FindMessageById(id)!=null) {
		System.out.println("teessssst");
		MessageMetier.ArchiveMessage(MessageMetier.FindMessageById(id));
		return Response.status(Status.OK).entity(MessageMetier.FindMessageById(id)).build();

	}
	
	return Response.status(Status.NOT_FOUND).entity("message not found").build();

}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response GetMsgBody(@PathParam(value="id") int id) {
		Message msg=MessageMetier.FindMessageById(id);
			return Response.status(Status.OK).entity(MessageMetier.GetMessageBody(msg)).build();
	}
	
	
	
}
