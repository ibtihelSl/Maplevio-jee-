package Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import Contracts.CongeServiceRemote;
import Entities.Conge;


@Stateful
@LocalBean
public class CongeService implements CongeServiceRemote {

	
	@PersistenceContext(unitName="MapLevio-ejb")
	EntityManager em;
	
	@Override
	public void AjouterConge(Conge conge) {
		em.persist(conge);			
		
	}
	

	@Override
	public void UpdateConge(Conge conge) {
		em.merge(conge);		
	}

	@Override
	public void DeleteConge(int id) {
		em.remove(FindCongeById(id));
		
	}

	@Override
	public List<Conge> findAllConge() {
		TypedQuery<Conge> query= em.createQuery("select c from Conge c",Conge.class);
		return  query.getResultList();
	}

	@Override
	public Conge FindCongeById(int id) {
		Conge conge=em.find(Conge.class,id);
		return conge;
	}

	@Override
	public Conge FindCongeByIdRessources(int id) {
		TypedQuery<Conge> query= em.createQuery("select c.congeDebut,c.congeFin from Conge c where c.resource=:resourceId",Conge.class);
		query.setParameter("resourceId", id);
				return query.getSingleResult();
	}

}
