package Beans;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;



import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.validator.FacesValidator;
import javax.servlet.http.Part;

import Entities.Adresse;
import Entities.Client;
import Entities.Project;
import Enumerates.ClientCategory;
import Enumerates.ClientType;

import Service.ClientServiceLocal;




@ManagedBean(name="clientBean")
@SessionScoped
public class ClientBean {
	private String nom ;
    
	private ClientType clientType;
	private ClientCategory clientCategory ;
	private Adresse adresse ;
	private String email ;
	private String image ;
	private String password ;
	
	private int  ClientIdToBeUpdate;
	
	private Part file;
	private String projectName;
	private String description;
	
	@EJB
	ClientServiceLocal clientservice;


	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	public void uploadD() throws IOException {

		InputStream in = file.getInputStream();
		File f = new File("C:\\wamp64\\www\\images\\"+file.getSubmittedFileName());
        
		f.createNewFile();
		FileOutputStream out = new FileOutputStream(f);
		byte[] buffer = new byte[1024];
		int length;
		while ((length = in.read(buffer)) > 0) {
			out.write(buffer, 0, length);
		}
		out.close();
		in.close();
		System.out.println(f.getPath());
	}
	
	public String addClient() throws IOException  {
		
		//Client client = new Client();
		
		//client.setNom(nom);
		
		//client.setEmail(email);
		//client.setImage(file.getSubmittedFileName());
		
		//client.setPassword(password);;
		//client.setClientType(clientType.New);
		//client.setClientCategory(clientCategory);
		
		//client.setAdresse(adresse.setCodePostal(codePostal));
		
		
		clientservice.ajouterClient(new Client( nom, email, password, clientType.New, clientCategory));
		
		
		return "/pages/AffClient?faces-redirect=true";

		
		
	}
	
	public void Delete(Integer EmpId){
		clientservice.DeleteClientById(EmpId);;
		
	}
	
	
	
	
	
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Integer getClientIdToBeUpdate() {
		return ClientIdToBeUpdate;
	}
	public void setClientIdToBeUpdate(Integer clientIdToBeUpdate) {
		ClientIdToBeUpdate = clientIdToBeUpdate;
	}
	public void ModifierCl(Client client){
		this.setNom(client.getNom());
		this.setEmail(client.getEmail());
		
		this.setPassword(client.getPassword());
		this.setClientCategory(client.getClientCategory());
		this.setClientType(client.getClientType());
		
        this.setClientIdToBeUpdate(client.getUserId());
	}
	public String mettreaAjourClient(){
	      Client client = new Client();
	      client.setUserId(ClientIdToBeUpdate);
			client.setNom(nom);
			
			client.setEmail(email);
			
			client.setPassword(password);;
			client.setClientType(clientType);
			client.setClientCategory(clientCategory);
			clientservice.Update(client);
			
			return "/pages/AffClient?faces-redirect=true";

	}
	public Part getFile() {
		return file;
	}
	public void setFile(Part file) {
		this.file = file;
	}
	
	
	
	
	
	

   

	
	
	
	
	
	
	
	
	
}
