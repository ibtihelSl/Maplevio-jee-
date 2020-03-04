package Resources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import Services.MonitoringServices;

@Path("Monitor")
@RequestScoped
public class MonitorResources {
@EJB
MonitoringServices service;


//Client Monitoring Resources

@GET
@Path("/Clients")
@Produces(MediaType.APPLICATION_JSON)
public Response ListClients(){
	
	return Response.ok(service.getAllClients()).build();
}


@GET
@Path("/Clients/Top")
@Produces(MediaType.APPLICATION_JSON)
public Response ListTopClients(){
	
	return Response.ok(service.getMostActiveClients()).build();
}

@GET
@Path("/Clients/Bottom")
@Produces(MediaType.APPLICATION_JSON)
public Response ListBottomClients(){
	
	return Response.ok(service.getLeastActiveClients()).build();
}

@GET
@Path("/Private")
@Produces(MediaType.APPLICATION_JSON)
public Response ListPrivateClients(){
	
	return Response.ok(service.getPrivateClients()).build();
}


@GET
@Path("/Private/Top")
@Produces(MediaType.APPLICATION_JSON)
public Response ListTopPrivateClients(){
	
	return Response.ok(service.getMostActivePrivateClients()).build();
}


@GET
@Path("/Private/Number")
@Produces(MediaType.APPLICATION_JSON)
public Response ListNumberPrivateClients(){
	
	return Response.ok(service.getNumberPrivateClients()).build();
}

@GET
@Path("/Private/Bottom")
@Produces(MediaType.APPLICATION_JSON)
public Response ListBottomPrivateClients(){
	
	return Response.ok(service.getLeastActivePrivateClients()).build();
}


@GET
@Path("/Public")
@Produces(MediaType.APPLICATION_JSON)
public Response ListPublicClients(){
	
	return Response.ok(service.getPublicClients()).build();
}

@GET
@Path("/Public/Number")
@Produces(MediaType.APPLICATION_JSON)
public Response ListNumberPublicClients(){
	
	return Response.ok(service.getNumberPublicClients()).build();
}

@GET
@Path("/Public/Top")
@Produces(MediaType.APPLICATION_JSON)
public Response ListTopPublicClients(){
	
	return Response.ok(service.getMostActivePublicClients()).build();
}

@GET
@Path("/Public/Bottom")
@Produces(MediaType.APPLICATION_JSON)
public Response ListBottomPublicClients(){
	
	return Response.ok(service.getLeastActivePublicClients()).build();
}


//Resource Monitoring Resources

@GET
@Path("/Resources")
@Produces(MediaType.APPLICATION_JSON)
public Response ListResources(){
	
	return Response.ok(service.getAllResources()).build();
}

@GET
@Path("/Resources/Number")
@Produces(MediaType.APPLICATION_JSON)
public Response ListNumberResources(){
	
	return Response.ok(service.getNumberResourcess()).build();
}

@GET
@Path("/Resources/Top")
@Produces(MediaType.APPLICATION_JSON)
public Response ListTopResources(){
	
	return Response.ok(service.getMostAffectedResources()).build();
}

@GET
@Path("/Freelancers/Number")
@Produces(MediaType.APPLICATION_JSON)
public Response ListNumberFreelancers(){
	
	return Response.ok(service.getNumberFreelancers()).build();
}

@GET
@Path("/Employees/Number")
@Produces(MediaType.APPLICATION_JSON)
public Response ListNumberEmployees(){
	
	return Response.ok(service.getNumberemployeess()).build();
}

//Projects Monitoring Resources 

@GET
@Path("/Projects")
@Produces(MediaType.APPLICATION_JSON)
public Response ListProjects(){
	
	return Response.ok(service.getAllProjects()).build();
}

@GET
@Path("/Projects/Number")
@Produces(MediaType.APPLICATION_JSON)
public Response ListNumberProjects(){
	
	return Response.ok(service.getNumberAllProjects()).build();
}

@GET
@Path("/Projects/New")
@Produces(MediaType.APPLICATION_JSON)
public Response ListNewProjects(){
	
	return Response.ok(service.getAllNewProjects()).build();
}

@GET
@Path("/Projects/New/Number")
@Produces(MediaType.APPLICATION_JSON)
public Response ListNumberNewProjects(){
	
	return Response.ok(service.getNumberAllNewProjects()).build();
}

@GET
@Path("/Projects/InProgress")
@Produces(MediaType.APPLICATION_JSON)
public Response ListInProgressProjects(){
	
	return Response.ok(service.getAllInProgressProjects()).build();
}

@GET
@Path("/Projects/InProgress/Number")
@Produces(MediaType.APPLICATION_JSON)
public Response ListNumberInProgressProjects(){
	
	return Response.ok(service.getNumberAllInProgressProjects()).build();
}

@GET
@Path("/Projects/Finished/Number")
@Produces(MediaType.APPLICATION_JSON)
public Response ListNumberFinishedProjects(){
	
	return Response.ok(service.getNumberAllFinishedProjects()).build();
}

}
