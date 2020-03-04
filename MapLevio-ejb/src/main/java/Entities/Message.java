package Entities;
import Enumerates.*;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Message implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMessage;
	
	@Enumerated(EnumType.STRING)
	private MessageType messageType ;
	@Enumerated(EnumType.STRING)
	private MessageCible messageCible ;
	
	private String body;
	private String dateEnvoi;
	
	private Integer isArchive;
	
	private Integer lu;
	
	@ManyToOne
	@JoinColumn(name="sender" ,referencedColumnName="userId",insertable=false,updatable=false)
	private User sender;
	
	@ManyToOne
	@JoinColumn(name="receiver" ,referencedColumnName="userId",insertable=false,updatable=false)
	private User receiver;
	public int getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}
	public MessageType getMessageType() {
		return messageType;
	}
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
	public MessageCible getMessageCible() {
		return messageCible;
	}
	public void setMessageCible(MessageCible messageCible) {
		this.messageCible = messageCible;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getDateEnvoi() {
		return dateEnvoi;
	}
	public void setDateEnvoi(String dateEnvoi) {
		this.dateEnvoi = dateEnvoi;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	public Integer getIsArchive() {
		return isArchive;
	}
	public void setIsArchive(Integer isArchive) {
		this.isArchive = isArchive;
	}
	public Integer getLu() {
		return lu;
	}
	public void setLu(Integer lu) {
		this.lu = lu;
	}

	

}
