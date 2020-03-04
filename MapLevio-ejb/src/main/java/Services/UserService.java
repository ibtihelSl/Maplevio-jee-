package Services;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Candidate;
import Entities.Client;
import Entities.Resource;
import Entities.User;




@Stateless
@LocalBean
public class UserService implements UserServiceRemote {
	
	@PersistenceContext(unitName = "MapLevio-ejb")
	EntityManager em ;

	
	

	
	
	
	
	/////////////////////////////////////Candidat
	@Override
	public int ajouterCandidate(Candidate candidate) {
		em.persist(candidate);
		return candidate.getUserId();
	}

	@Override
	public Candidate getCandidateByEmailAndPassword(String email, String password) {
		TypedQuery<Candidate> query = em.createQuery("Select e from Candidate e "
				+"where e.email=:email and "
				+"e.password=:password"
				, Candidate.class);
		
		query.setParameter("email",email);
		query.setParameter("password",password);
		
		Candidate candidate = null ; 
		
		try {
			candidate = query.getSingleResult();
		} catch (NoResultException e ) {
			Logger.getAnonymousLogger().info("Aucun candidate trouvé avec email :" + email);
		}
		return candidate;
	}

	@Override
	public void deleteCandidate(int userId) {
		em.remove(em.find(Candidate.class, userId));
		
		
	}
	
	

	
	@Override
	public List<Candidate> candidates() {
		List<Candidate> candidates=null;
		TypedQuery<Candidate> query = em.createQuery("Select e from Candidate e "
				, Candidate.class);	
		try {
			candidates = query.getResultList();
		} catch (NoResultException e ) {
			
		}
		return candidates;
	}
	
	
	
	
	
	@Override
	public void update(Candidate candidat) {
        em.merge(candidat);		
	}
/////////////////////////////////////////////////////// client
	@Override
	public int ajouterClient(Client client) {
		em.persist(client);
		return client.getUserId();
	}

	@Override
	public void deleteClient(int userId) {
		em.remove(em.find(Client.class, userId));
		
	}

	@Override
	public Client getClientByEmailAndPassword(String email, String password) {
		TypedQuery<Client> query = em.createQuery("Select e from Client e "
				+"where e.email=:email and "
				+"e.password=:password"
				, Client.class);
		
		query.setParameter("email",email);
		query.setParameter("password",password);
		
		Client client = null ; 
		
		try {
			client = query.getSingleResult();
		} catch (NoResultException e ) {
			Logger.getAnonymousLogger().info("Aucun candidate trouvé avec email :" + email);
		}
		return client;
	}



	@Override
	public List<Client> clients() {
		List<Client> clients=null;
		TypedQuery<Client> query = em.createQuery("Select e from Client e "
				, Client.class);	
		try {
			clients = query.getResultList();
		} catch (NoResultException e ) {
			
		}
		return clients;
	
	}
	
	
	@Override
	public void updateClient(Client client) {
		 em.merge(client);	
		
	}
	

	
	

/////////////////////////////////////////////////////////User

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		TypedQuery<User> query = em.createQuery("Select e from User e "
				+"where e.email=:email and "
				+"e.password=:password"
				, User.class);
		
		query.setParameter("email",email);
		query.setParameter("password",password);
		
		User user = null ; 
		
		try {
			user = query.getSingleResult();
		} catch (NoResultException e ) {
			Logger.getAnonymousLogger().info("Aucun user trouvé avec email :" + email);
		}
		return user;
	}

	



	@Override
	public List<User> users() {
		List<User> users=null;
		TypedQuery<User> query = em.createQuery("Select e from User e "
				, User.class);	
		try {
			users = query.getResultList();
		} catch (NoResultException e ) {
			
		}
		return users;
	}
	////////////////////////////////////////////////////////Resource

	@Override
	public void deleteResource(int userId) {
		em.remove(em.find(Resource.class, userId));
	}

	@Override
	public List<Resource> resources() {
		List<Resource> resources=null;
		TypedQuery<Resource> query = em.createQuery("Select e from Resource e "
				, Resource.class);	
		try {
			resources = query.getResultList();
		} catch (NoResultException e ) {
			
		}
		return resources;
	
		
	}
	
	////////////////////////////////////////////////// Resource

	@Override
	public Resource getResourceByEmailAndPassword(String email, String password) {
		TypedQuery<Resource> query = em.createQuery("Select e from Resource e "
				+"where e.email=:email and "
				+"e.password=:password"
				, Resource.class);
		
		query.setParameter("email",email);
		query.setParameter("password",password);
		
		Resource resource = null ; 
		
		try {
			resource = query.getSingleResult();
		} catch (NoResultException e ) {
			Logger.getAnonymousLogger().info("Aucun resource trouvé avec email :" + email);
		}
		return resource;
	}

	@Override
	public Candidate getCandidateById(int id) {
		TypedQuery<Candidate> query = em.createQuery("Select e from Candidate e "
				+"where e.userId=:id"
				
				, Candidate.class);
		
		query.setParameter("id",id);
		
		Candidate candidate = null ; 
		
		try {
			candidate = query.getSingleResult();
		} catch (NoResultException e ) {
			Logger.getAnonymousLogger().info("Aucun candidate trouvé avec id :" + id);
		}
		return candidate;
	}


	
	
	
	
	
}
