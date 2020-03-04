package Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Contracts.ResourceServiceRemote;
import Entities.Resource;
import Enumerates.Competance;
import Enumerates.Role;

@Stateful
@LocalBean
public class ResourceService implements ResourceServiceRemote{
	
	
	@PersistenceContext(unitName="MapLevio-ejb")
	EntityManager em;

	@Override
	public void AjouterResource(Resource resource) {
		em.persist(resource);
		
	}

	@Override
	public void updateResource(Resource resource) {
		em.merge(resource);		
	}

	@Override
	public void deleteResource(int id,boolean arch) {
		  Query query=em.createQuery("update Resource r set r.archivé=:arch where r.userId=:id ");
		  query.setParameter("id", id);
		  query.setParameter("arch", arch)	  ;
		  int modified =query.executeUpdate();
	        if(modified==1)
	        {
	        	System.out.println("succ update");
	        }else{
	        	System.out.println("Failed");

	        }

	}

	@Override
	public List<Resource> findAllResources() {
		boolean arch=false;
		TypedQuery<Resource> query= em.createQuery("select r from Resource r where r.archivé=:arch",Resource.class);
		query.setParameter("arch", arch);
		
		return  query.getResultList();
	}
	
	@Override
	public long NbrRessource() {
		boolean arch=false;

		TypedQuery<Long> query= em.createQuery("select count(r) from Resource r where r.archivé=:arch",Long.class);
		query.setParameter("arch", arch);
		Long nbr= query.getSingleResult();
		return nbr;
	}
	
	@Override
	public long NbrRessourcejava() {
		Competance comp=Competance.JAVA;
		boolean arch=false;
		TypedQuery<Long> query= em.createQuery("select count(r) from Resource r where r.competance=:comp and r.archivé=:arch",Long.class);
		query.setParameter("comp", comp);
		query.setParameter("arch", arch);
		Long nbr= query.getSingleResult();
		return nbr;
	}
	@Override
	public long NbrRessourceIos() {
		Competance comp=Competance.IOS;
		boolean arch=false;
		TypedQuery<Long> query= em.createQuery("select count(r) from Resource r where r.competance=:comp and r.archivé=:arch",Long.class);
		query.setParameter("comp", comp);
		query.setParameter("arch", arch);
		Long nbr= query.getSingleResult();
		return nbr;
	}
	@Override
	public long NbrRessourcejee() {
		Competance comp=Competance.JEE;
		boolean arch=false;
		TypedQuery<Long> query= em.createQuery("select count(r) from Resource r where r.competance=:comp and r.archivé=:arch",Long.class);
		query.setParameter("comp", comp);
		query.setParameter("arch", arch);
		Long nbr= query.getSingleResult();
		return nbr;
	}
	
	@Override
	public long NbrRessourceandroid() {
		Competance comp=Competance.Android;
		boolean arch=false;
		TypedQuery<Long> query= em.createQuery("select count(r) from Resource r where r.competance=:comp and r.archivé=:arch",Long.class);
		query.setParameter("comp", comp);
		query.setParameter("arch", arch);
		Long nbr= query.getSingleResult();
		return nbr;
	}

	@Override
	public long NbrRessourceSYMFONY() {
		Competance comp=Competance.SYMFONY;
		boolean arch=false;
		TypedQuery<Long> query= em.createQuery("select count(r) from Resource r where r.competance=:comp and r.archivé=:arch",Long.class);
		query.setParameter("comp", comp);
		query.setParameter("arch", arch);
		Long nbr= query.getSingleResult();
		return nbr;
	}
	@Override
	public long NbrRessourcephp() {
		Competance comp=Competance.PHP;
		boolean arch=false;
		TypedQuery<Long> query= em.createQuery("select count(r) from Resource r where r.competance=:comp and r.archivé=:arch",Long.class);
		query.setParameter("comp", comp);
		query.setParameter("arch", arch);
		Long nbr= query.getSingleResult();
		return nbr;
	}
	@Override
	public Resource findResourceById(int id) {
		Resource resource=em.find(Resource.class, id);
		return resource;
	}

	@Override
	public List<Resource> findResoureJee() {
		Competance comp=Competance.JEE;
		boolean arch=false;
		TypedQuery<Resource> query= em.createQuery("select r from Resource r where r.competance=:comp and r.archivé=:arch",Resource.class);
		query.setParameter("comp", comp);
		query.setParameter("arch", arch);
		return  query.getResultList();
	}
	@Override
	public List<Resource> findResoureios() {
		Competance comp=Competance.IOS;
		boolean arch=false;
		TypedQuery<Resource> query= em.createQuery("select r from Resource r where r.competance=:comp and r.archivé=:arch",Resource.class);
		query.setParameter("comp", comp);
		query.setParameter("arch", arch);
		return  query.getResultList();
	}
	@Override
	public List<Resource> findResoureandroid() {
		Competance comp=Competance.Android;
		boolean arch=false;
		TypedQuery<Resource> query= em.createQuery("select r from Resource r where r.competance=:comp and r.archivé=:arch",Resource.class);
		query.setParameter("comp", comp);
		query.setParameter("arch", arch);
		return  query.getResultList();
	}
	@Override
	public List<Resource> findResourephp() {
		Competance comp=Competance.PHP;
		boolean arch=false;
		TypedQuery<Resource> query= em.createQuery("select r from Resource r where r.competance=:comp and r.archivé=:arch",Resource.class);
		query.setParameter("comp", comp);
		query.setParameter("arch", arch);
		return  query.getResultList();
	}
	@Override
	public List<Resource> findResoureSymfony() {
		Competance comp=Competance.SYMFONY;
		boolean arch=false;
		TypedQuery<Resource> query= em.createQuery("select r from Resource r where r.competance=:comp and r.archivé=:arch",Resource.class);
		query.setParameter("comp", comp);
		query.setParameter("arch", arch);
		return  query.getResultList();
	}
	@Override
	public List<Resource> findResoureJava() {
		Competance comp=Competance.JAVA;
		boolean arch=false;
		TypedQuery<Resource> query= em.createQuery("select r from Resource r where r.competance=:comp and r.archivé=:arch",Resource.class);
		query.setParameter("comp", comp);
		query.setParameter("arch", arch);
		return  query.getResultList();
	}
	
	
	@Override
	public List<Resource> ResourcesDispo() {
		boolean arch=false;
		TypedQuery<Resource> query= em.createQuery("select DISTINCT r from Resource r join r.conge c where c.resource=r.userId and r.archivé=:arch",Resource.class);
		query.setParameter("arch", arch);
		return query.getResultList();
		
	}
	@Override
	public List<Resource> Resourcesarchive() {
		Role arch=null;
		TypedQuery<Resource> query= em.createQuery("select r from Resource r where r.role=:arch",Resource.class);
		query.setParameter("arch", arch);
		return query.getResultList();
		
	}
	@Override
	public List<Resource> GetAllResources() {
		 TypedQuery<Resource> query= em.createQuery("select e from Resource e",Resource.class);
		    
		    
			return  query.getResultList();
	}
}
