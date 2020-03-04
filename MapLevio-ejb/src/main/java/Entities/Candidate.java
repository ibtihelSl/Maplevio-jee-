package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import Enumerates.*;
@Entity
public class Candidate extends User implements Serializable{
	
	private String cv;
	@Enumerated(EnumType.STRING)
	private EtatCandidate etat ;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Passage> listePassage;
	
	
	public List<Passage> getListePassage() {
		return listePassage;
	}
	public void setListePassage(List<Passage> listePassage) {
		this.listePassage = listePassage;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	public EtatCandidate getEtat() {
		return etat;
	}
	public void setEtat(EtatCandidate etat) {
		this.etat = etat;
	}
	public Candidate() {
		
	}
	public Candidate(String nom, String prenom, String email, String password, String image, Role role,
			Adresse adresse, Date dateNaissance, String cv, EtatCandidate etat) {
		super(nom, prenom, email, password, image, role, adresse, dateNaissance);
		this.cv = cv;
		this.etat = etat;
	}

	
	
	
	
	

}
