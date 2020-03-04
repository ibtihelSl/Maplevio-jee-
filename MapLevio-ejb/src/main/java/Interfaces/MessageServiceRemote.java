package Interfaces;

import java.util.List;

import javax.ejb.Remote;

import Entities.Client;
import Entities.Message;
import Entities.Resource;
import Enumerates.MessageCible;
import Enumerates.MessageType;

@Remote
public interface MessageServiceRemote {

	void EnvoyerMessage(Message m);
	String GetMessageBody(Message msg);
	String GetMessageSenderNom(Message msg);
	String GetMessageSenderPenom(Message msg);
	MessageCible GetMessageCible(Message msg);
	MessageType GetMessageType(Message msg);
	void ArchiveMessage(Message msg);
	
	void MiseAjourClassificationClient(Integer id);
	void MiseAjourClassificationRessource(Integer id);
	List<Resource> ListRessourceAProb();
	List<Client> ListClientExigent();
	
	Integer GetNbrResAProb();
	Integer GetNbrClientExigent();
	
	Integer NbreMessageReclamation();
	Integer NbreMessageProbleme();
	Integer NbreMessageSatisfaction();
	Integer NbreMessageNonLu();

	
	List<Message> getAllMessage();
	List<Message> getAllMessageRec();
	List<Message> getAllMessageProb();
	List<Message> getAllMessageSati();
	List<Message> getAllMessageArchiver();
	List<Message> getAllMessageNonLu();
	
	//***********
	Message FindMessageById(Integer id);
	

	

	

}
