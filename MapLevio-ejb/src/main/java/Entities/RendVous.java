package Entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class RendVous {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int rdId;
	
	private String ClientNom ;
	
	private String email ;
	private String description ;
	
	private boolean arch ;
	private int etat;
	@Temporal(TemporalType.DATE)
	private Date dateRdv;
	@Temporal(TemporalType.DATE)
	private Date dateInsert;
	public int getRdId() {
		return rdId;
	}
	public void setRdId(int rdId) {
		this.rdId = rdId;
	}
	public String getClientNom() {
		return ClientNom;
	}
	public void setClientNom(String clientNom) {
		ClientNom = clientNom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isArch() {
		return arch;
	}
	public void setArch(boolean arch) {
		this.arch = arch;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public Date getDateRdv() {
		return dateRdv;
	}
	public void setDateRdv(Date dateRdv) {
		this.dateRdv = dateRdv;
	}
	public Date getDateInsert() {
		return dateInsert;
	}
	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}
	
	
	
	
	
	
	
	
	
	
}
