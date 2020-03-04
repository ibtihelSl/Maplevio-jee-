package Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entities.Client;
import Entities.Message;
import Entities.Resource;
import Enumerates.ClassificationType;
import Enumerates.MessageCible;
import Enumerates.MessageType;
import Interfaces.MessageServiceRemote;

@Stateful
@LocalBean
public class MessageService implements MessageServiceRemote {

	@PersistenceContext(unitName="MapLevio-ejb")
	EntityManager em;
	
	@Override
	public void EnvoyerMessage(Message m) {
		m.setLu(0);
		//m.getSender().setUserId(2);
		em.persist(m);		
	}

	@Override
	public List<Message> getAllMessage() {
		Integer i=0;
	    javax.persistence.TypedQuery<Message> query=em.createQuery("select e from Message e where e.isArchive=:archive", Message.class);
	    query.setParameter("archive", i);
		return  query.getResultList();
		
	}

	@Override
	public String GetMessageBody(Message msg) {
		
		int it=1;
		int idM=msg.getIdMessage();
		System.out.println("avant archivage : "+msg.getLu()); 		
		Query query=em.createQuery("UPDATE Message m set m.lu=:a WHERE m.idMessage=:id ");
	    query.setParameter("id",idM);	    
	    query.setParameter("a",it);	 
	    int modified =query.executeUpdate();
		
		return msg.getBody();
	}
	
	@Override
	public String GetMessageSenderNom(Message msg) {
		
		return msg.getSender().getNom();
	}

	@Override
	public String GetMessageSenderPenom(Message msg) {
		
		return msg.getSender().getPrenom();
	}
	
	@Override
	public MessageCible GetMessageCible(Message msg) {
		
		return msg.getMessageCible();
	}
	
	@Override
	public MessageType GetMessageType(Message msg) {
		
		return msg.getMessageType();
	}

	@Override
	public void ArchiveMessage(Message msg) {
		//1=>archivé
		int it=1;
		int idM=msg.getIdMessage();
		System.out.println("avant archivage : "+msg.getIsArchive()); 		
		Query query=em.createQuery("UPDATE Message m set m.isArchive=:a WHERE m.idMessage=:id ");
	    query.setParameter("id",idM);	    
	    query.setParameter("a",it);	 
	    int modified =query.executeUpdate();
        if(modified==1)
        {
        	System.out.println("succ update");
        }else{
        	System.out.println("Failed");

        }
	   // int update=query.setParameter(it,idM).executeUpdate();
		System.out.println("apres archivage by query : "+msg.getIsArchive()); 
	//	System.out.println(update);
	}

	

	@Override
	public void MiseAjourClassificationClient(Integer id) {
	   
		javax.persistence.TypedQuery<Message> query=em.createQuery(
				"select e from Message e where e.sender.userId=:idUser and e.messageType=:type", Message.class);
		query.setParameter("idUser", id);
		query.setParameter("type", MessageType.Reclamation);
		
		List<Message> list=query.getResultList();
		Integer nbr=list.size();
		
		if (nbr>2){
					for (Message c : list) 
						{c.getSender().setClassType(ClassificationType.Exigent); }
			
				 }else{
					for (Message c : list) 
						{ c.getSender().setClassType(ClassificationType.satisfait); }
				 	}
		}

	    @Override
		public List<Client> ListClientExigent(){
		
		javax.persistence.TypedQuery<Client> query0=em.createQuery("select e from Client e", Client.class);
		List<Client> list0=query0.getResultList();
		
		for (Client client : list0) {
			this.MiseAjourClassificationClient(client.getUserId());
		}
	
		ClassificationType type=ClassificationType.Exigent;
		javax.persistence.TypedQuery<Client> query=em.createQuery("select e from Client e where e.classType=:type", Client.class);
	    query.setParameter("type", type);
		
		return  query.getResultList();
		
	}

	@Override
	public void MiseAjourClassificationRessource(Integer id) {
	   
		javax.persistence.TypedQuery<Message> query=em.createQuery(
				"select e from Message e where e.sender.userId=:idUser and e.messageType=:type", Message.class);
		query.setParameter("idUser", id);
		query.setParameter("type", MessageType.Probleme_technique);
		
		List<Message> list=query.getResultList();
		Integer nbr=list.size();
		System.out.println(nbr);
		if (nbr>1){
			System.out.println(" cc from if "+nbr);

					for (Message c : list) 
						{c.getSender().setClassType(ClassificationType.Aprobleme); }
					System.out.println(" cc from for "+nbr);

				 }else{
					for (Message c : list) 
						{ c.getSender().setClassType(ClassificationType.Competent); }
				 	}
		}
	
    	@Override
		public List<Resource> ListRessourceAProb(){
		
		javax.persistence.TypedQuery<Resource> query0=em.createQuery("select e from Resource e", Resource.class);
		List<Resource> list0=query0.getResultList();
		
		for (Resource rs : list0) {
			System.out.println("cccc1 "+rs.getNom());
			
			this.MiseAjourClassificationRessource(rs.getUserId());
			
			System.out.println("2 "+rs.getNom());

		}
	
		ClassificationType type=ClassificationType.Aprobleme;
		javax.persistence.TypedQuery<Resource> query=em.createQuery("select e from Resource e where e.classType=:type", Resource.class);
	    query.setParameter("type", type);
		
		return  query.getResultList();
		
	}
    	@Override
    	public Integer GetNbrResAProb(){
    	
    		System.out.println(this.ListRessourceAProb().size());
    		return (this.ListRessourceAProb().size());
    	}
    	
    	@Override
    	public Integer GetNbrClientExigent(){
    		
    		System.out.println(this.ListClientExigent().size());
    		return (this.ListClientExigent().size());
    	
    	}
    	
	
	
	@Override
	public List<Message> getAllMessageArchiver() {
		javax.persistence.TypedQuery<Message> query=em.createQuery("select e from Message e where e.isArchive=:a", Message.class);
	    query.setParameter("a", 1);	    
		return  query.getResultList();
	}
	
	@Override
	public List<Message> getAllMessageNonLu() {
		javax.persistence.TypedQuery<Message> query=em.createQuery("select e from Message e where e.lu=:a", Message.class);
	    query.setParameter("a", 0);	    
		return  query.getResultList();
	}


	@Override
	public List<Message> getAllMessageRec() {

		javax.persistence.TypedQuery<Message> query=em.createQuery("select e from Message e where e.messageType=:type", Message.class);
	    query.setParameter("type", MessageType.Reclamation);	    
		return  query.getResultList();
		
	}
	
	@Override
	public List<Message> getAllMessageProb() {

		javax.persistence.TypedQuery<Message> query=em.createQuery("select e from Message e where e.messageType=:type", Message.class);
	    query.setParameter("type", MessageType.Probleme_technique);	    
		return  query.getResultList();
		
	}

	@Override
	public List<Message> getAllMessageSati() {

		javax.persistence.TypedQuery<Message> query=em.createQuery("select e from Message e where e.messageType=:type", Message.class);
	    query.setParameter("type", MessageType.Satisfaction);	    
		return  query.getResultList();
		
	}
	
	@Override
	public Integer NbreMessageReclamation() {

		 javax.persistence.TypedQuery<Message> query=em.createQuery("select e from Message e where e.messageType=:type", Message.class);
		    query.setParameter("type", MessageType.Reclamation);
			List<Message> l=  query.getResultList();
		
		return l.size();
	}

	@Override
	public Integer NbreMessageProbleme() {
		 javax.persistence.TypedQuery<Message> query=em.createQuery("select e from Message e where e.messageType=:type", Message.class);
		    query.setParameter("type", MessageType.Probleme_technique);
			List<Message> l=  query.getResultList();
		
		return l.size();	}

	@Override
	public Integer NbreMessageSatisfaction() {
		 javax.persistence.TypedQuery<Message> query=em.createQuery("select e from Message e where e.messageType=:type", Message.class);
		    query.setParameter("type", MessageType.Satisfaction);
			List<Message> l=  query.getResultList();
		
		return l.size();
	
	}

	@Override
	public Integer NbreMessageNonLu() {
		int i=1;
		 javax.persistence.TypedQuery<Message> query=em.createQuery("select e from Message e where e.lu=:l", Message.class);
		    query.setParameter("l", 0);
			List<Message> l=  query.getResultList();
		
		return l.size();
	
	}

	
	//*************
	@Override
	public Message FindMessageById(Integer id){
		Message msg=em.find(Message.class, id);
		return msg;
		
	}

	
	
	

	
	
}

