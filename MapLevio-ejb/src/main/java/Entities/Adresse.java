package Entities;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	private String pays;
	private String ville;
	private String rue;
	private String codePostal;
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public Adresse(String pays, String ville, String rue, String codePostal) {
		
		this.pays = pays;
		this.ville = ville;
		this.rue = rue;
		this.codePostal = codePostal;
	}
	public Adresse() {
	}
	
	
	
	
}
