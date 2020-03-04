package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import Entities.Client;
import Entities.Message;
import Enumerates.MessageType;
import Interfaces.MessageServiceRemote;
import Services.MessageService;

@ManagedBean(name="statMessage")
@ViewScoped
public class StatMessage {

	private PieChartModel pieModel1;
    private List<Message> messages;
    
    
    @EJB
	MessageService msgService;
	
    
    
	
	@PostConstruct
	public void init(){
		messages = new ArrayList<Message>();
		messages = msgService.getAllMessage();
		this.graph(messages);
		
	}
	
	private void graph(List<Message> messages){
		pieModel1 = new PieChartModel();
		Integer n=msgService.NbreMessageReclamation();

		
			pieModel1.set(MessageType.Reclamation.toString(), n);
			
		
		pieModel1.setTitle("Message Classification");
		pieModel1.setLegendPosition("w");
		
		
	}

	public PieChartModel getPieModel1() {
		return pieModel1;
	}

	public void setPieModel1(PieChartModel pieModel1) {
		this.pieModel1 = pieModel1;
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
    
	
}
