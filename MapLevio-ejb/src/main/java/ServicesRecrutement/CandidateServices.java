package ServicesRecrutement;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entities.Candidate;
import Enumerates.EtatCandidate;

@Stateless
@LocalBean
public class CandidateServices implements CandidateServicesLocal{
	
	@PersistenceContext(unitName="MapLevio-ejb")
	EntityManager em;
	@Override
	public Candidate findByid(int id){
		Candidate candidate = em.find(Candidate.class, id);
		return candidate;
	}
	@Override
	public int createCandidate (Candidate c)
	{
		em.persist(c);
		return c.getUserId();
	}
	@Override
	public List<Candidate> afficherCandidateEntrevu() {

		 TypedQuery<Candidate> query= em.createQuery("select c from Candidate c where c.etat='Attente_entrevu'",Candidate.class);
	    
	    
			return  query.getResultList();
	}
	@Override
	public List<Candidate> afficherCandidateEntretien() {

		 TypedQuery<Candidate> query= em.createQuery("select c from Candidate c where c.etat='Attente_tech'",Candidate.class);
	    
	    
			return  query.getResultList();
	}
	@Override
	public List<Candidate> afficherCandidateFr() {

		 TypedQuery<Candidate> query= em.createQuery("select c from Candidate c where c.etat='Attente_fr'",Candidate.class);
	    
	    
			return  query.getResultList();
	}
	@Override
	public List<Candidate> afficherCandidateAccepter() {

		 TypedQuery<Candidate> query= em.createQuery("select c from Candidate c where c.etat='Accepte'",Candidate.class);
	    
	    
			return  query.getResultList();
	}
	@Override
	public void approuverCandidate(int id) {
		
        Query query=em.createQuery("update Candidate c set etat=:etat where c.id=:id ");
        query.setParameter("etat", EtatCandidate.Attente_tech);
        query.setParameter("id", id);
        query.executeUpdate();
	}
	@Override
	public void refuserCandidate(int id) {
		
        Query query=em.createQuery("update Candidate c set etat=:etat where c.id=:id ");
        query.setParameter("etat", EtatCandidate.Refuse);
        query.setParameter("id", id);
        query.executeUpdate();
	}
}
