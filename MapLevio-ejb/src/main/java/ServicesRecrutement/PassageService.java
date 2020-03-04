package ServicesRecrutement;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entities.Candidate;
import Entities.Passage;
import Entities.PassagePK;
import Entities.Test;
import Enumerates.EtatCandidate;
import Enumerates.TestType;
@Stateless
@LocalBean
public class PassageService implements PassageServicesLocal{
	@PersistenceContext(unitName="MapLevio-ejb")
	EntityManager em;
	
	@Override
	public void affecterDateTech(int c, Date d){
		/*TypedQuery<Candidate> query= em.createQuery("select c from Candidat c where c.id="+c,Candidate.class);
		Candidate cc=query.getSingleResult();*/
		Candidate cc = em.find(Candidate.class, c);
		TypedQuery<Test> query1= em.createQuery("select t from Test t where t.type='Technic'",Test.class);
		Test tt=query1.getSingleResult();
		PassagePK passagePK=new PassagePK(cc.getUserId(), tt.getTestId());
		Passage p = new Passage(passagePK, cc, tt, d);
		em.persist(p);
	}
		@Override
		public void affecterDateFR(int c, Date d){
			//TypedQuery<Candidate> query= em.createQuery("select c from Candidat c where c.id="+c,Candidate.class);
			//Candidate cc=query.getSingleResult();
			Candidate cc = em.find(Candidate.class, c);

			TypedQuery<Test> query2= em.createQuery("select t from Test t where t.type!='Technic'",Test.class);
			Test tt=query2.getSingleResult();
			PassagePK passagePK=new PassagePK(cc.getUserId(), tt.getTestId());
			Passage p = new Passage(passagePK, cc, tt, d);
			em.persist(p);
	}
		@Override
		public void envoyerMail(){
			
		}
		public void passgeTest(Passage p){
			
			
			em.merge(p);
			TypedQuery<Test> query= em.createQuery("select t from Test t where t.testId='"+p.getTest().getTestId()+"'",Test.class);
			Test t = query.getSingleResult();
			int x =0;
			if (t.getAnswer1()==p.getAnswer1())
			{
				x=x+2;
			}
			else{
				x=x-1;
			}
			if (t.getAnswer2()==p.getAnswer2())
			{
				x=x+2;
			}
			else{
				x=x-1;
			}
			if (t.getAnswer3()==p.getAnswer3())
			{
				x=x+2;
			}
			else{
				x=x-1;
			}
			if (t.getAnswer4()==p.getAnswer4())
			{
				x=x+2;
			}
			else{
				x=x-1;
			}
			if (t.getAnswer5()==p.getAnswer5())
			{
				x=x+2;
			}
			else{
				x=x-1;
			}
			if (t.getAnswer6()==p.getAnswer6())
			{
				x=x+2;
			}
			else{
				x=x-1;
			}
			if (t.getAnswer7()==p.getAnswer7())
			{
				x=x+2;
			}
			else{
				x=x-1;
			}
			if (t.getAnswer8()==p.getAnswer8())
			{
				x=x+2;
			}
			else{
				x=x-1;
			}
			if (t.getAnswer9()==p.getAnswer9())
			{
				x=x+2;
			}
			else{
				x=x-1;
			}if (t.getAnswer10()==p.getAnswer10())
			{
				x=x+2;
			}
			else{
				x=x-1;
			}
			
			Query query1=em.createQuery("update Passage p set mark=:x where p.test.testId=:id and p.candidate.userId=:id1");
	        query1.setParameter("x", x);
	        query1.setParameter("id", t.getTestId());
	        query1.setParameter("id1", p.getCandidate().getUserId());
	        query1.executeUpdate();
	        if (x<10)
	        {
	        	Query query2=em.createQuery("update Candidate c set etat=:etat where c.userId=:id");
		        query2.setParameter("etat", EtatCandidate.Refuse);
		        query2.setParameter("id", p.getCandidate().getUserId());
		        query2.executeUpdate();
	        }
	        else if ((p.getCandidate().getEtat()==EtatCandidate.Attente_tech) && (!(p.getCandidate().getAdresse().getPays().equals("Canada")))) {
	        	Query query3=em.createQuery("update Candidate c set etat=:etat where c.userId=:id");
		        query3.setParameter("etat", EtatCandidate.Attente_fr);
		        query3.setParameter("id", p.getCandidate().getUserId());
		        query3.executeUpdate();
			}
	        else{
	        	Query query2=em.createQuery("update Candidate c set etat=:etat where c.userId=:id");
		        query.setParameter("etat", EtatCandidate.Accepte);
		        query.setParameter("id", p.getCandidate().getUserId());
		        query.executeUpdate();
	        }
			
		}
		
		@Override
		public Passage getPassage(int id)
		{
			
			TypedQuery<Passage> query= em.createQuery("select p from Passage p where p.candidate.userId='"+id+"'",Passage.class);
		    
			return  query.getSingleResult();
		}
		@Override
		public void affecterDateee(Passage p){
			em.persist(p);
		}

}
