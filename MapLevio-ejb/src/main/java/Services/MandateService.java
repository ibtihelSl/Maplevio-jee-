package Services;

import java.util.Date;
import java.util.List;

import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entities.Mandate;
import Entities.MandatePK;
import Entities.Project;
import Entities.Resource;
@Stateful
@LocalBean
public class MandateService implements IMandateRemote {
 
	
	
	@PersistenceContext(unitName="MapLevio-ejb")
	EntityManager em;

	@Override
	public void ajouterMandate(int idProject, int idRessource, Date datedebut, Date datefin) {
//		Project projetEntity = em.find(Project.class, idProject);
//    	Resource resourceEntity = em.find(Resource.class, idRessource);
    	
    	Mandate mand=new Mandate();
    	MandatePK mandatepk=new MandatePK();
    	mandatepk.setProjectId(idProject);
    	mandatepk.setResourceId(idRessource);
       	 
 
    	mand.setDebutMandat(datedebut);
    	mand.setFinMandat(datefin);
    	mand.setMandatePK(mandatepk);
    
    	

//    	mand.setProject(projetEntity);
//    	mand.setResource(resourceEntity);
    	em.persist(mand);
         }
					

	@Override
	public void validerMandate(int idProject, int idRessource, Date datedebut, Date datefin, int mandateid) {
		 
		
		
	}



	@Override
	public List<Mandate> GetallMandate() {
		boolean arch=false;
		TypedQuery<Mandate> query = em.createQuery("SELECT m FROM Mandate m where m.archive=:arch", Mandate.class);
		query.setParameter("arch", arch);

		List<Mandate> results = query.getResultList();

		return results;
		
	}



	@Override
	public void updateMandate(Mandate m) {
		em.merge(m);		
	}


/*	@Override
	public void deleteMandate(int idProject, int idRessource, boolean archivee) {

		
		 Query query=em.createQuery("update Mandate m set m.archive=:archivee where m.mandatePK.resourceId=:idRessource and m.mandatePK.projectId=:idProject ");
		  query.setParameter("idProject", idProject);
		  query.setParameter("idRessource", idRessource);
		  query.setParameter("archivee", archivee);
		  int modified =query.executeUpdate();
	        if(modified==1)
	        {
	        	System.out.println("succ update");
	        }else{
	        	System.out.println("Failed");

	        }
	}*/


	@Override
	public void deleteMandate(Mandate md) {
		MandatePK mpK=new MandatePK(md.getMandatePK().getProjectId(),md.getMandatePK().getResourceId());
		Boolean archivee=true;
		Query query=em.createQuery("update Mandate m set m.archive=:archivee where m.mandatePK=:mandatPk ");
		  query.setParameter("mandatPk", mpK);
		  query.setParameter("archivee", archivee);
		
		  int modified =query.executeUpdate();
	        if(modified==1)
	        {
	        	System.out.println("succ update");
	        }else{
	        	System.out.println("Failed");

	        }
	}
	
	
	
	@Override
	public List<Mandate> GetMandateArchivee() {
		
		boolean archivee=true;
		TypedQuery<Mandate> query= em.createQuery("select m from Mandate m where m.archive=:archivee",Mandate.class);
		query.setParameter("archivee", archivee);
		return query.getResultList();
		
	}
	
	@Override
	public Mandate FindMandate(int p,int r){
		MandatePK mp=new MandatePK(p,r);
		Mandate m=em.find(Mandate.class, mp);
		return m;
	}


	



}
