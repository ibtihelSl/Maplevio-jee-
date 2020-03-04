package ServicesRecrutement;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Entities.Candidate;
import Entities.Test;



@Stateless
@LocalBean
public class TestServices implements TestServicesLocal{
	
	@PersistenceContext(unitName="MapLevio-ejb")
	EntityManager em;
	
	@Override
	public int createTest (Test t){
		em.persist(t);
		return t.getTestId();		
	}
	
	@Override
	public Test afficheTest(int id){
		return em.find(Test.class,id);
	}
	@Override
	public List<Test> afficherTest() {

		 TypedQuery<Test> query= em.createQuery("select c from Test c ", Test.class);
	 
			return  query.getResultList();
	}
	
	
	
	@Override
	public void deletTest(int id){
		em.remove(em.find(Test.class,id));
	}
}
