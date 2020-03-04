package Entities;

import Enumerates.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class User  implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;
	
private String nom ;
private String prenom ;
private String email ;
private String password ; 
private String image ;

@Enumerated(EnumType.STRING)
private  Role role ;
@Embedded
private Adresse adresse ;
@Temporal(TemporalType.DATE)
private Date dateNaissance ;

@Enumerated(EnumType.STRING)
private ClassificationType classType;

//@OneToMany(mappedBy = "sender", cascade = CascadeType.REMOVE)
@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
private List<Message> listeMessagesended;
//@OneToMany(mappedBy = "receiver", cascade = CascadeType.REMOVE)
@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
private List<Message> listeMessagereceived;


/*public List<Message> getListeMessagesended() {
	return listeMessagesended;
}
public void setListeMessagesended(List<Message> listeMessagesended) {
	this.listeMessagesended = listeMessagesended;
}
public List<Message> getListeMessagereceived() {
	return listeMessagereceived;
}
public void setListeMessagereceived(List<Message> listeMessagereceived) {
	this.listeMessagereceived = listeMessagereceived;
}*/
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
public Adresse getAdresse() {
	return adresse;
}
public void setAdresse(Adresse adresse) {
	this.adresse = adresse;
}
public Date getDateNaissance() {
	return dateNaissance;
}
public void setDateNaissance(Date dateNaissance) {
	this.dateNaissance = dateNaissance;
}

public ClassificationType getClassType() {
	return classType;
}
public void setClassType(ClassificationType classType) {
	this.classType = classType;
}
public User() {
	super();
}
public User( String nom, String prenom, String email, String password, String image, Role role,
		Adresse adresse, Date dateNaissance) {

	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.password = password;
	this.image = image;
	this.role = role;
	this.adresse = adresse;
	this.dateNaissance = dateNaissance;
	
}
public User(String nom, String prenom, String email, String password, String image) {
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.password = password;
	this.image = image;
}
public User(String nom, String email, String password) {
	this.nom = nom;
	this.email = email;
	this.password = password;
	
}
public User(int userId, String nom, String email, String password, String image) {
	this.userId = userId;
	this.nom = nom;
	this.email = email;
	this.password = password;
	this.image = image;
}


}
