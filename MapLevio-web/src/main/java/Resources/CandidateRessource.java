package Resources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import Entities.Candidate;
import ServicesRecrutement.CandidateServicesLocal;

@Path("candidate")
@RequestScoped
public class CandidateRessource {
@EJB
CandidateServicesLocal metier;

@GET
@Path("/CandidateEntrevu")
@Produces(MediaType.APPLICATION_JSON)
public Response afficherCandidateEntrevu(){
	
	return Response.ok(metier.afficherCandidateEntrevu()).build();
}
@GET
@Path("/CandidateEntretien")
@Produces(MediaType.APPLICATION_JSON)
public Response afficherCandidateEntretien(){
	
	return Response.ok(metier.afficherCandidateEntretien()).build();
}
@GET
@Path("/CandidateFr")
@Produces(MediaType.APPLICATION_JSON)
public Response afficherCandidateFr(){
	
	return Response.ok(metier.afficherCandidateFr()).build();
}
@GET
@Path("/CandidateAccepter")
@Produces(MediaType.APPLICATION_JSON)
public Response afficherCandidateAccepter(){
	
	return Response.ok(metier.afficherCandidateAccepter()).build();
}
@POST
@Path("/createCandidate")
@Consumes(MediaType.APPLICATION_JSON)
public Response createCandidate(Candidate c ,@Context UriInfo uriInfo){
	UriBuilder builder = uriInfo.getAbsolutePathBuilder();
	metier.createCandidate(c);
	builder.path(Integer.toString(c.getUserId())).build();
	return Response.created(builder.build()).entity(c).build();
}
@PUT
@Path("/approuverCandidate/{id}")
public Response approuverCandidate(@PathParam(value="id")int id){
	metier.approuverCandidate(id);
	return Response.status(Status.NO_CONTENT).entity("le Condidate approuver avec succes").build();
}
@PUT
@Path("/refuserCandidate/{id}")
public Response refuserCandidate(@PathParam(value="id")int id){
	metier.refuserCandidate(id);
	return Response.status(Status.NO_CONTENT).entity("le Condidate refuser avec succes").build();
}
@GET
@Path("/findByid/{id}")
@Produces(MediaType.APPLICATION_JSON)
public Response findByid(@PathParam(value="id")int id){
	Candidate c = metier.findByid(id);
	if(c !=null){
		return Response.ok(c).build();
	}else{
		return Response.status(Status.NO_CONTENT).entity("No Candidate Found").build();

	}
}
}
