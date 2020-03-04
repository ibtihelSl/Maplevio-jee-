package Service;

import java.util.ArrayList;
import java.util.List;




import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.xml.bind.DataBindingException;

import Entities.Client;
import Entities.Project;



@Stateless
@LocalBean
public class ClientService implements  ClientServiceLocal,ClientServiceRemote {
	@PersistenceContext(unitName="MapLevio-ejb")
	EntityManager em;
	@Override
	public int ajouterClient(Client client) {
		
		em.persist(client);
		return client.getUserId();
		
	}
	

	@Override
	public int AjouterProjet(Project projet) {
		em.persist(projet);
		return projet.getProjectId();
	}
	
	
	
	
	
	
	
	
	
	@Override
	public void Update(Client client) {
		em.merge(client);
		
	}
	
	

	

@Override
	public Client  findClientById(int userId) {
	Client c=em.find(Client.class, userId);
		return c;
	}
	
	
	
	@Override
	public void DeleteClientById(int userId) {
           em.remove(em.find(Client.class, userId));
	}


	@Override
	public Client GetClientById(int userId) {
		return em.find(Client.class, userId);
	}


	
	@Override
	public List<Client> GetAllClient(){

		 TypedQuery<Client> query= em.createQuery("select e from Client e ",Client.class);
	    
	    
			return  query.getResultList();
	}
	
	@Override
	public List<Client> GetAllClientById(int userId){

		 TypedQuery<Client> query= em.createQuery("Select project.projectName from client inner join project on (project.client=client.userId) group by client.userId",Client.class);
	    
	    
			return  query.getResultList();
	}
	

}
