package Entities;

import javax.persistence.Entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import Enumerates.Bac;
import Enumerates.Competance;
import Enumerates.Diplome;

@Entity
public class Demande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDemande;
	
	@Enumerated(EnumType.STRING)
	private Bac bac ;
	@Enumerated(EnumType.STRING)
	private Diplome diplome ;
	
	private Integer anneeExp;
	
	
	@Enumerated(EnumType.STRING)
	private Competance competance;
	
	private String directeur;
	private String nomProjet;
	private String description;
	private String dateDepot;
	private String heureDepot;
	private String dateDebutMandat;
	private String dateFinMandat;
	private float cout;
	private Integer duree;//null
	private String TestString;
	private String TestInteger;
	
	
	
	
	public int getIdDemande() {
		return idDemande;
	}
	public void setIdDemande(int idDemande) {
		this.idDemande = idDemande;
	}
	public Bac getBac() {
		return bac;
	}
	public void setBac(Bac bac) {
		this.bac = bac;
	}
	public Diplome getDiplome() {
		return diplome;
	}
	public void setDiplome(Diplome diplome) {
		this.diplome = diplome;
	}
	public Integer getAnneeExp() {
		return anneeExp;
	}
	public void setAnneeExp(Integer anneeExp) {
		this.anneeExp = anneeExp;
	}
	public String getDirecteur() {
		return directeur;
	}
	public void setDirecteur(String directeur) {
		this.directeur = directeur;
	}
	public String getNomProjet() {
		return nomProjet;
	}
	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDateDepot() {
		return dateDepot;
	}
	public void setDateDepot(String dateDepot) {
		this.dateDepot = dateDepot;
	}
	public String getHeureDepot() {
		return heureDepot;
	}
	public void setHeureDepot(String heureDepot) {
		this.heureDepot = heureDepot;
	}
	public String getDateDebutMandat() {
		return dateDebutMandat;
	}
	public void setDateDebutMandat(String dateDebutMandat) {
		this.dateDebutMandat = dateDebutMandat;
	}
	public String getDateFinMandat() {
		return dateFinMandat;
	}
	public void setDateFinMandat(String dateFinMandat) {
		this.dateFinMandat = dateFinMandat;
	}
	public float getCout() {
		return cout;
	}
	public void setCout(float cout) {
		this.cout = cout;
	}
	public Integer getDuree() {
		return duree;
	}
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	public String getTestString() {
		return TestString;
	}
	public void setTestString(String testString) {
		TestString = testString;
	}
	public String getTestInteger() {
		return TestInteger;
	}
	public void setTestInteger(String testInteger) {
		TestInteger = testInteger;
	}
	
	public Competance getCompetance() {
		return competance;
	}
	public void setCompetance(Competance competance) {
		this.competance = competance;
	}
	
	

	
	
	
	public Demande() {
		super();
	}



	
	






	
}
