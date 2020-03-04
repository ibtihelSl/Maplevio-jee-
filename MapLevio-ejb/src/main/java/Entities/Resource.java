package Entities;
import Enumerates.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Resource  extends User implements Serializable{

	
	private String cv;
	private int seniority;
	private float note;
	private boolean accepted;
	@Enumerated(EnumType.STRING)
	private Competance competance;
	private boolean archivé;
	
	


	@Enumerated(EnumType.STRING)
	private ResourceType resourceType ;
	
	@Enumerated(EnumType.STRING)
	private ResourceState resourceState ;
	
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Mandate> listeMandate;
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Conge> listeConge;
	
	
	public List<Conge> getListeConge() {
		return listeConge;
	}

	public void setListeConge(List<Conge> listeConge) {
		this.listeConge = listeConge;
	}

	public List<Mandate> getListeMandate() {
		return listeMandate;
	}

	public void setListeMandate(List<Mandate> listeMandate) {
		this.listeMandate = listeMandate;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public int getSeniority() {
		return seniority;
	}

	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}

	public float getNote() {
		return note;
	}

	public void setNote(float note) {
		this.note = note;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public ResourceType getResourceType() {
		return resourceType;
	}

	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}

	public ResourceState getResourceState() {
		return resourceState;
	}

	public void setResourceState(ResourceState resourceState) {
		this.resourceState = resourceState;
	}
	public boolean isArchivé() {
		return archivé;
	}

	public void setArchivé(boolean archivé) {
		this.archivé = archivé;
	}
	

	public Competance getCompetance() {
		return competance;
	}

	public void setCompetance(Competance competance) {
		this.competance = competance;
	}
	public Resource(){
		
	}
}

