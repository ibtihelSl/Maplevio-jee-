package ManagedBeans;


import java.util.List;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import Entities.Client;
import Services.MonitoringServices;

@ManagedBean
@RequestScoped
public class ClientMBean {
	
private List<Client> clients ;
private List<Client> privateClients ;
private List<Client> publicClients ;

@EJB
MonitoringServices ms; 


public List<Client> getClients() {
	clients = ms.getAllClients();
	return clients;
}


public List<Client> getPrivateClients() {
	privateClients = ms.getPrivateClients();
	return privateClients;
}


public List<Client> getPublicClients() {
	publicClients = ms.getPublicClients();
	return publicClients;
}


}
