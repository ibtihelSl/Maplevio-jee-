package managedBean;

import java.lang.ProcessBuilder.Redirect;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.swing.plaf.synth.SynthSliderUI;

import Entities.Client;
import Entities.Message;
import Entities.Resource;
import Entities.User;
import Enumerates.MessageCible;
import Enumerates.MessageType;
import ManagedBeans.LoginBean;
import Services.MessageService;

@ManagedBean(name="messageBean")
@SessionScoped
public class MessageBean {

	private MessageType selectedType;
	private MessageCible selectedCible;
	private String body;
	private String nomSender;
	private String prenomSender;
	
	private List<Message> messages;
	private List<Client> clients;
	private List<Resource> Resources;

	
	private String nom;
	private String prenom;
	
	@EJB
	MessageService msgService;
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public MessageType getSelectedType() {
		return selectedType;
	}
	public void setSelectedType(MessageType selectedType) {
		this.selectedType = selectedType;
	}
	
	public MessageCible getSelectedCible() {
		return selectedCible;
	}
	public void setSelectedCible(MessageCible selectedCible) {
		this.selectedCible = selectedCible;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
			
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public MessageService getMsgService() {
		return msgService;
	}
	public void setMsgService(MessageService msgService) {
		this.msgService = msgService;
	}
	
	public String getPrenomSender() {
		return prenomSender;
	}
	public void setPrenomSender(String prenomSender) {
		this.prenomSender = prenomSender;
	}
	
	public String getNomSender() {
		return nomSender;
	}
	public void setNomSender(String nomSender) {
		this.nomSender = nomSender;
	}
	
	
	public String EnvoyerMsg(){
		Date date=new Date();
		SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println("date msg : "+simpleDate.format(date));
			
	Message msg=new Message();
	msg.setMessageCible(selectedCible);
	msg.setMessageType(selectedType);
	msg.setBody(body);
	msg.setDateEnvoi(simpleDate.format(date));
	msg.setIsArchive(0);
	//msg.setSender(LoginBean.getUser());
	//msg.getSender().setUserId(LoginBean.getUser().getUserId());
	msgService.EnvoyerMessage(msg);
	
	// Rq lezm sender yekhou id du user connecté
	String navigateTo=null;
	
	if (msg != null)
	{	navigateTo="/pages/MsgSent";}
	else
		{FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credentials"));}
	
	return navigateTo;
	}
	
	
	
	public List<Message> GetAllMsgs(){
		
		messages=msgService.getAllMessage();
		
		return messages;
		}
	
	public String GetBodyByIdMessage(Message msg){
	
		System.out.println("test "+msg.getBody());
		System.out.println("test "+msg.getMessageType());
			
		body=msgService.GetMessageBody(msg);
		nomSender=msgService.GetMessageSenderNom(msg);
		prenomSender=msgService.GetMessageSenderPenom(msg);
		selectedCible=msgService.GetMessageCible(msg);
		selectedType=msgService.GetMessageType(msg);
		
		return "/pages/DetailBody?faces-redirect=true";
			}
	
	public String ArchiveMessage(Message msg){
		msgService.ArchiveMessage(msg);
		
		return "/pages/listMessage";
	}
	
		public List<Client> GetClientExigent(){
		
		clients=msgService.ListClientExigent();
		return clients;
		} 
		
		public List<Resource> GetResourceAProb(){
			
			Resources=msgService.ListRessourceAProb();
			return Resources;
			} 
		
		
		public Integer countExigentClient(){
			
			return msgService.GetNbrClientExigent();
			
		}
		
		public Integer countRessourceAProb(){
			
			return msgService.GetNbrResAProb();
			
		}
		
		public Integer countMsgReclamation(){
			
			return msgService.NbreMessageReclamation();
			
		}
		
		public Integer countMsgProbleme(){
			
			return msgService.NbreMessageProbleme();
			
		}
		
		public Integer countMsgSatisfaction(){
			
			return msgService.NbreMessageSatisfaction();
			
		}
		public Integer countMsgNonLu(){
			
			return msgService.NbreMessageNonLu();
			
		}
		
		
		public List<Message> GetAllMsgRec(){
			
			messages=msgService.getAllMessageRec();
			
			return messages;
			}
	
	public List<Message> GetAllMsgProb(){
			
			messages=msgService.getAllMessageProb();
			
			return messages;
			}

	
	public List<Message> GetAllMsgSati(){
		
		messages=msgService.getAllMessageSati();
		
		return messages;
		}
	
	public List<Message> GetAllMsgArchiver(){
		
		messages=msgService.getAllMessageArchiver();
		
		return messages;
		}
	
	public List<Message> GetAllMsgNoLu(){
		
		messages=msgService.getAllMessageNonLu();
		
		return messages;
		}
	
}

