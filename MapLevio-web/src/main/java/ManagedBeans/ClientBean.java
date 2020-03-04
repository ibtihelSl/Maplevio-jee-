package ManagedBeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Adresse;
import Entities.Candidate;
import Entities.Client;
import Enumerates.ClientCategory;
import Enumerates.ClientType;
import Enumerates.Role;
import Services.UserService;


@ManagedBean(name="clientBean")
@SessionScoped
public class ClientBean {
	
	private Integer id;
	
	private String prenom  ;
	private String nom  ;
	private String email  ;
	private String password;
	
	private String pays;
	private String ville;
	private String rue;
	private String codePostal;
	private Date dateNaissance;
	private ClientType clientType ;
	private ClientCategory clientCategory ;
	
	private List<Client> clients;
	
	@EJB
	UserService userService ; 
	
	
	
	////////////////////////////////////////////////////////
	
	public Integer getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}



	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
	public ClientType getClientType() {
		return clientType;
	}

	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}

	public ClientCategory getClientCategory() {
		return clientCategory;
	}

	public void setClientCategory(ClientCategory clientCategory) {
		this.clientCategory = clientCategory;
	}

	
	
	///////////////////////////////////////////////////////////
	public void supprimer(Integer id){
		System.out.println("kjhjljlkmkl");
		userService.deleteClient(id);
	}
	
	
	
	public List<Client>  getClients() {
		clients=userService.clients();
		return clients;
	}
	
	
	
	public void modifier(Client client) {
		this.setId(client.getUserId());
		this.setEmail(client.getEmail());
		this.setPrenom(client.getPrenom());
		this.setNom(client.getNom());
		this.setPassword(client.getPassword());
		this.setDateNaissance(client.getDateNaissance());
		this.setPays(client.getAdresse().getPays());
		this.setCodePostal(client.getAdresse().getCodePostal());
		this.setVille(client.getAdresse().getVille());
		this.setClientType(client.getClientType());
		this.setClientCategory(client.getClientCategory());
		
					
		
		
	}
	
	

     public void refresh(){
    	 Client client = new Client();
    	 Adresse adress = new Adresse();
			adress.setCodePostal(codePostal);
			adress.setPays(pays);
			adress.setVille(ville);
			adress.setRue(rue);
			client.setUserId(id);
			client.setNom(nom);
			
			client.setPrenom(prenom);
			client.setEmail(email);
			client.setPassword(password);
			
			client.setAdresse(adress);
			client.setRole(Role.Client);
			client.setClientCategory(clientCategory);
			client.setClientType(clientType);
			
			
			
    	    userService.updateClient(client);

}
     
     
     
}
