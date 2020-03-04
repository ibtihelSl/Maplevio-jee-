package Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Conge implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idConge;
	private Date congeDebut;
	private Date congeFin;
	private boolean accepter;
	@ManyToOne
	@JoinColumn(name="resourceId" ,referencedColumnName="userId",insertable=false,updatable=false)
	private Resource resource ;
	
	
	public boolean isAccepter() {
		return accepter;
	}
	public void setAccepter(boolean accepter) {
		this.accepter = accepter;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public int getIdConge() {
		return idConge;
	}
	public void setIdConge(int idConge) {
		this.idConge = idConge;
	}
	public Date getCongeDebut() {
		return congeDebut;
	}
	public void setCongeDebut(Date congeDebut) {
		this.congeDebut = congeDebut;
	}
	public Date getCongeFin() {
		return congeFin;
	}
	public void setCongeFin(Date congeFin) {
		this.congeFin = congeFin;
	}
	public Conge(){}
	
	

}
