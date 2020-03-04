package Services;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Candidate;
import Entities.Client;
import Entities.Mandate;
import Entities.Project;
import Entities.Resource;
import Entities.Test;
import Entities.User;
import Enumerates.ClientCategory;
import Enumerates.ProjectType;
import Enumerates.ResourceType;

@Stateless
@LocalBean
public class MonitoringServices implements MonitoringServicesRemote {
	@PersistenceContext(unitName="MapLevio-ejb")
	EntityManager mm ; 
	
	
	//Get all
	
	@Override
	public List<User> getAllUsers() {
		TypedQuery<User> query=mm.createQuery("SELECT u from User u ",User.class);
	    return query.getResultList();
		
	}

	@Override
	public List<Candidate> getAllCandidates() {
		TypedQuery<Candidate> query=mm.createQuery("SELECT u from Candidate u ",Candidate.class);
		
		return  query.getResultList();
	}

	@Override
	public List<Client> getAllClients() {
		TypedQuery<Client> query=mm.createQuery("SELECT u from Client u ",Client.class);
		return query.getResultList();
		
	}

	@Override
	public List<Mandate> getAllMandates() {
		TypedQuery<Mandate> query=mm.createQuery("SELECT u from Mandate u ",Mandate.class);
		return query.getResultList();
		
	}

	@Override
	public List<Project> getAllProjects() {
		TypedQuery<Project> query=mm.createQuery("SELECT u from Project u  ",Project.class);
		return query.getResultList();
		
	}

	@Override
	public List<Resource> getAllResources() {
		TypedQuery<Resource> query=mm.createQuery("SELECT u from Resource u ",Resource.class);
		return query.getResultList();
		
	}

	@Override
	public List<Test> getAllTests() {
		TypedQuery<Test> query=mm.createQuery("SELECT u from Test u ",Test.class);
		return query.getResultList();
		
	}
	
	
	//Project Services
	
	@Override
	public List<Project> getAllNewProjects() {
		TypedQuery<Project> q = mm.createQuery("Select p from Project p  where p.ProjectType =:type" , Project.class);
    	q.setParameter("type", ProjectType.New);
    	return q.getResultList();
	}

	@Override
	public List<Project> getAllInProgressProjects() {
		TypedQuery<Project> q = mm.createQuery("Select p from Project p  where p.ProjectType =:type" , Project.class);
    	q.setParameter("type", ProjectType.InProgress);
    	return q.getResultList();
	}
	
	  
    @Override
	public int getNumberAllInProgressProjects() {
		TypedQuery<Project> q = mm.createQuery("Select p from Project p  where p.ProjectType = :type " , Project.class);
    	q.setParameter("type", Enumerates.ProjectType.InProgress);
		List <Project> l= q.getResultList();
    	return l.size();
	}
	
        @Override
		public List <Project> getMostResourceConsumingProjects() {
	    	TypedQuery<Project> q = mm.createQuery("Select p from Project p  order by count (p.listeMandate) Desc" , Project.class);
	    	q.setMaxResults(10);
			return q.getResultList();
		}
	    
	    @Override
		public List <Project> getMostResourceConsumingInProgressProjects() {
	    	TypedQuery<Project> q = mm.createQuery("Select  p from Project p where p.projectType=:type  order by count (p.listeMandate) Desc" , Project.class);
	    	q.setParameter("type", ProjectType.InProgress);
	    	q.setMaxResults(10);
			return q.getResultList();
		}
	    
	    @Override
		public List <Project> getMostResourceConsumingNewProjects() {
	    	TypedQuery<Project> q = mm.createQuery("Select Distinct p from Project p where p.projectType=:type  order by count (p.listeMandate) Desc" , Project.class);
	    	q.setParameter("type", ProjectType.New);
	    	q.setMaxResults(10);
			return q.getResultList();
		}
	    
	    @Override
		public List <Project> getLeastAffectedNewProjects() {
	    	TypedQuery<Project> q = mm.createQuery("Select p from Project p where p.projectType=:type order by count (p.listeMandate) Asc" , Project.class);
	    	q.setParameter("type", ProjectType.New);
	    	q.setMaxResults(10);
			return q.getResultList();
		}
	    
	    @Override
	  	public List <Project> getLeastAffectedProjects() {
	      	TypedQuery<Project> q = mm.createQuery("Select p from Project p  order by count (p.listeMandate) Asc" , Project.class);
	  		return q.getResultList();
	  	}
	    
	  
		
		@Override
		public int getNumberAllNewProjects() {
			TypedQuery<Project> q = mm.createQuery("Select p from Project p  where p.ProjectType =:type" , Project.class);
	    	q.setParameter("type", ProjectType.New );
	    	List <Project> l= q.getResultList();
	    	return l.size();
	    	}
		
		@Override
		public int getNumberAllFinishedProjects() {
			TypedQuery<Project> q = mm.createQuery("Select p from Project p  where p.ProjectType =:type" , Project.class);
	    	q.setParameter("type", ProjectType.Finished);
	    	List <Project> l= q.getResultList();
	    	return l.size();
		}
		
		@Override
		public int getNumberAllProjects() {
			TypedQuery<Project> q = mm.createQuery("Select p from Project p " , Project.class);
			List <Project> l= q.getResultList();
	    	return l.size();
		}

 
		//Resources Services
		
	@Override
	public List<Resource> getAllUnaffectedResources() {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
		String d1 = df.format(d);
		TypedQuery<Resource> q = mm.createQuery("Select r from Ressource r join r.listeMandate m where Not (:date >m.debutMandat and :date <m.finMandat)  " , Resource.class);
		q.setParameter("date", d1);
		q.setMaxResults(30);
		return q.getResultList();
	}

	@Override
	public List<Resource> getAllAffectedResources() {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
		String d1 = df.format(d);
		TypedQuery<Resource> q = mm.createQuery("Select Distinct r from Ressource r join r.listeMandate m where (:date > m.debutMandat and :date <m.finMandat )" , Resource.class);
		q.setParameter("date", d1);
		q.setMaxResults(30);
		return q.getResultList();
	}
	
	@Override
	public List<Resource> getNumberAllAffectedResources() {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
		String d1 = df.format(d);
		TypedQuery<Resource> q = mm.createQuery("Select Distinct r from Ressource r join r.listeMandate m where (:date > m.debutMandat and :date <m.finMandat )" , Resource.class);
		q.setParameter("date", d1);
		return q.getResultList();
	}
	
	@Override
	public List<Resource> getAllAffectedEmployees() {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
		String d1 = df.format(d);
		TypedQuery<Resource> q = mm.createQuery("Select Distinct r from Ressource r join r.listeMandate m where r.resourceType = :type and (:date > m.debutMandat and :date <m.finMandat )" , Resource.class);
		q.setParameter("date", d1);
		q.setParameter("type", ResourceType.Employee);
		q.setMaxResults(30);
		return q.getResultList();
	}
	
	@Override
	public List<Resource> getAllUnaffectedEmployees() {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
		String d1 = df.format(d);
		TypedQuery<Resource> q = mm.createQuery("Select Distinct r from Ressource r join r.listeMandate m where r.resourceType = :type and  NOT (:date > m.debutMandat and :date <m.finMandat )" , Resource.class);
		q.setParameter("date", d1);
		q.setParameter("type", ResourceType.Employee);
		q.setMaxResults(30);
		return q.getResultList();
	}
	
	
	@Override
	public List<Resource> getUnaffectedEmployeesbyCompetance(String competance) {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
		String d1 = df.format(d);
		TypedQuery<Resource> q = mm.createQuery("Select Distinct r from Ressource r join r.listeMandate m where r.resourceType = :type and  NOT (:date > m.debutMandat and :date <m.finMandat ) and r.competance = :Competance " , Resource.class);
		q.setParameter("date", d1);
		q.setParameter("type", ResourceType.Employee);
		q.setMaxResults(30);
		return q.getResultList();
	}
	
	@Override
	public List<Resource> getAllAffectedFreelancers() {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
		String d1 = df.format(d);
		TypedQuery<Resource> q = mm.createQuery("Select Distinct r from Ressource r join r.listeMandate m where r.resourceType = :type and (:date > m.debutMandat and :date <m.finMandat )" , Resource.class);
		q.setParameter("date", d1);
		q.setParameter("type", ResourceType.Freelancer);
		q.setMaxResults(30);
		return q.getResultList();
	}
	
	@Override
	public List<Resource> getAllUnaffectedFreelancers() {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
		String d1 = df.format(d);
		TypedQuery<Resource> q = mm.createQuery("Select Distinct r from Ressource r join r.listeMandate m where r.resourceType = :type and  NOT (:date > m.debutMandat and :date <m.finMandat )" , Resource.class);
		q.setParameter("date", d1);
		q.setParameter("type", ResourceType.Freelancer);
		q.setMaxResults(30);
		return q.getResultList();
	}

	@Override
	public List<Resource> getMostAffectedResources() {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
		String d1 = df.format(d);
		TypedQuery<Resource> q = mm.createQuery("Select Distinct r from Ressource r join r.listeMandate m where (:date >m.debutMandat and :date <m.finMandat ) order by size(r.listeMandate) " , Resource.class);
		q.setParameter("date", d1);
		q.setMaxResults(30);
		return q.getResultList();
	}
	
	@Override
	public int getNumberFreelancers() {
		TypedQuery<Resource> q = mm.createQuery("Select r from Resource r where r.resourceType = :type " , Resource.class);
		List <Resource> l = q.setParameter("type", ResourceType.Freelancer).getResultList();
		return l.size();
	}
	
	@Override
	public int getNumberemployeess() {
		TypedQuery<Resource> q = mm.createQuery("Select r from Resource r where r.resourceType = :type " , Resource.class);
		List <Resource> l = q.setParameter("type", ResourceType.Employee).getResultList();
		return l.size();
	}
	
	@Override
	public int getNumberResourcess() {
		TypedQuery<Resource> q = mm.createQuery("Select r from Resource" , Resource.class);
		List <Resource> l = q.getResultList();
		return l.size();
	}

	// Clients Services 
	
	@Override
	public List<Client> getMostActiveClients() {
		TypedQuery<Client> q = mm.createQuery("Select Distinct c from Client c order by count (c.listeProject) Desc" , Client.class);
		q.setMaxResults(5);
		return q.getResultList();
	}
	

	@Override
	public List<Client> getLeastActiveClients() {
		TypedQuery<Client> q = mm.createQuery("Select Distinct c from Client c order by count (c.listeProject) Asc" , Client.class);
		q.setMaxResults(5);
		return q.getResultList();
	}
	
	@Override
	public List<Client> getLeastActivePublicClients() {
		TypedQuery<Client> q = mm.createQuery("Select Distinct c from Client c where c.clientCategory = :type order by count (c.listeProject) Asc" , Client.class);
		q.setParameter("type", ClientCategory.Public);
		q.setMaxResults(5);
		return q.getResultList();
	}
	
	@Override
	public List<Client> getLeastActivePrivateClients() {
		TypedQuery<Client> q = mm.createQuery("Select Distinct c from Client c where c.clientCategory = :type order by count (c.listeProject) Asc" , Client.class);
		q.setParameter("type", ClientCategory.Private);
		q.setMaxResults(5);
		return q.getResultList();
	}
	
	@Override
	public List<Client> getMostActivePublicClients() {
		TypedQuery<Client> q = mm.createQuery("Select Distinct c from Client c where c.clientCategory = :type order by count (c.listeProject) Desc" , Client.class);
		q.setParameter("type", ClientCategory.Public);
		q.setMaxResults(5);
		return q.getResultList();
	}
	
	
	@Override
	public int getNumberAllActiveClients() {
		TypedQuery<Client> q = mm.createQuery("Select c from Client c" ,Client.class);
		List <Client> l= q.getResultList();
    	return l.size();
	}
	
	@Override
	public int getNumberPublicClients() {
		TypedQuery<Client> q = mm.createQuery("Select c from Client c where c.clientCategory = :type " ,Client.class);
		q.setParameter("type", ClientCategory.Public);
		List <Client> l= q.getResultList();
    	return l.size();
	}
	
	@Override
	public int getNumberPrivateClients() {
		TypedQuery<Client> q = mm.createQuery("Select c from Client c where c.clientCategory = :type " , Client.class);
		q.setParameter("type", ClientCategory.Private);
		List <Client> l= q.getResultList();
    	return l.size();	}
	
	@Override
	public List<Client> getMostActivePrivateClients() {
		TypedQuery<Client> q = mm.createQuery("Select Distinct c from Client c where c.clientCategory = :type order by count (c.listeProject) Desc" , Client.class);
		q.setParameter("type", ClientCategory.Private);
		q.setMaxResults(5);
		return q.getResultList();
	}
	
	@Override
	public List<Client> getPrivateClients() {
		TypedQuery<Client> q = mm.createQuery("Select c from Client c where c.clientCategory = :type " , Client.class);
		q.setParameter("type", ClientCategory.Private);
		return q.getResultList();
	}

	@Override
	public List<Client> getPublicClients() {
		TypedQuery<Client> q = mm.createQuery("Select c from Client c where c.clientCategory = :type " , Client.class);
		q.setParameter("type", ClientCategory.Public);
		return q.getResultList();
	}

	
	//Mandates Services
	
	@Override
	public int getNumberActiveMandates() {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
		String d1 = df.format(d);
		TypedQuery<Integer> q = mm.createQuery("Select size (m) from Mandate m where :date betweeen m.debutMandate and m.finMandat" , Integer.class);
    	q.setParameter("date", d1);
    	
		return q.getSingleResult();
		}

	//Utility Services
	
	@Override
	public List<String> getAllSkills() {
		List<Object[]> results =mm.createQuery("SELECT r.competance , count(r) from Resource r group by r.competance HAVING COUNT(r) > 1").getResultList();
		ArrayList <String> l = new ArrayList<String>();
		for (Object[] result : results) {
			
		String c = (String) result[0] + " " + ((Number) result[1]).intValue();
		l.add(c);
		}
		return l;
	}
	
	@Override
	public Test getMostPassedTest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Test> getHighFailureTests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Test> getLowFailureTests() {
		// TODO Auto-generated method stub
		return null;
	}



	
	

	

	

	
}
