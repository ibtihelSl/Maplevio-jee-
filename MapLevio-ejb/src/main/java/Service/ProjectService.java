package Service;

import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Client;
import Entities.Project;
/**
 * Session Bean implementation class ProjectService
 */
@Stateless
@LocalBean
public class ProjectService implements ProjectServiceRemote, ProjectServiceLocal {
	@PersistenceContext(unitName="MapLevio-ejb")
	EntityManager em;
    
	
	
	@Override
	public int  ajouterProjet(Project pr) {
			em.persist(pr);
			return pr.getProjectId();
		
			}
	
	
	@Override
	public void Update(Project pr) {
		em.merge(pr);
		
	}
	
	
	@Override
	public List<Client> GetAllClient(){

		 TypedQuery<Client> query= em.createQuery("select e from Client e",Client.class);
	    
	    
			return  query.getResultList();
	}
	
	@Override
	public List<Project> GetAllProjet(){

		 TypedQuery<Project> query= em.createQuery("select e from Project e",Project.class);
	    
	    
			return  query.getResultList();
	}
	

   @Override
	public Project  findProjectById(int projectId) {
	   Project  pr=em.find(Project.class, projectId);
		return pr;
	}
	
	@Override
	public void DeleteProjetById(int projectId) {
        em.remove(em.find(Project.class, projectId));
		
	}

	
}
