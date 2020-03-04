package ManagedBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.Part;

import Entities.Adresse;
import Entities.Candidate;
import Enumerates.Role;
import Services.UserService;




@ManagedBean(name="candidateBean1")
@SessionScoped
public class CandidateBean {
	private Integer id;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}




	private String prenom  ;
	private String nom  ;
	private String email  ;
	private String password  ;
	private Part cv  ;
	private Part file;
	private String img;
	private String CV;
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getCV() {
		return CV;
	}

	public void setCV(String cV) {
		CV = cV;
	}




	private String pays;
	private String ville;
	private String rue;
	private String codePostal;
	private Date dateNaissance;
	private boolean upladed;
	
	
	
    public boolean isUpladed() {
		return upladed;
	}

	public void setUpladed(boolean upladed) {
		this.upladed = upladed;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
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

	public Part getCv() {
		return cv;
	}

	public void setCv(Part cv) {
		this.cv = cv;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
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

		public Part getFile() {
			return file;
		}

		public void setFile(Part file) {
			this.file = file;
		}
		
		
		
		
		@EJB
		UserService userService ; 
		
		
		public void addEmploye(){
			System.out.println("what");
			String uniqueID = UUID.randomUUID().toString();
			uploadFile( uniqueID);
			Adresse adress = new Adresse();
			adress.setCodePostal(codePostal);
			adress.setPays(pays);
			adress.setVille(ville);
			adress.setRue(rue);
			Candidate candidat = new Candidate();
			candidat.setNom(nom);
			candidat.setImage(uniqueID);
			candidat.setPrenom(prenom);
			candidat.setEmail(email);
			candidat.setPassword(password);
			candidat.setDateNaissance(dateNaissance);
			candidat.setAdresse(adress);
			candidat.setRole(Role.Candidate);
			candidat.setCv(uniqueID);
			this.setCV(uniqueID);
			this.setImg(uniqueID);
			
			
			userService. ajouterCandidate(candidat);
			
			
		}
		
		public void modifier(Candidate candidate) {
			this.setId(candidate.getUserId());
			this.setEmail(candidate.getEmail());
			this.setPrenom(candidate.getPrenom());
			this.setNom(candidate.getNom());
			this.setPassword(candidate.getPassword());
			this.setDateNaissance(candidate.getDateNaissance());
			this.setPays(candidate.getAdresse().getPays());
			this.setCodePostal(candidate.getAdresse().getCodePostal());
			this.setVille(candidate.getAdresse().getVille());
			this.setCV(candidate.getCv());
			this.setImg(candidate.getImage());
						
			
			
		}
		
		

	     public void refresh(){
	    	 Candidate candidat = new Candidate();
	    	 Adresse adress = new Adresse();
				adress.setCodePostal(codePostal);
				adress.setPays(pays);
				adress.setVille(ville);
				adress.setRue(rue);
				candidat.setUserId(id);
				candidat.setNom(nom);
				candidat.setImage(img);
				candidat.setPrenom(prenom);
				candidat.setEmail(email);
				candidat.setPassword(password);
				candidat.setDateNaissance(dateNaissance);
				candidat.setAdresse(adress);
				candidat.setRole(Role.Candidate);
				candidat.setCv(CV);
				uploadFile(CV);
	    	 userService.update(candidat);

		
	       }
		
		
	      public void uploadFile(String uid){
		        try{
		            InputStream input=file.getInputStream();
		            File f=new File("D:/CV"+uid+".jpg");
		            if(!f.exists()){
		                f.createNewFile();
		            }
		            FileOutputStream output=new FileOutputStream(f);
		            byte[] buffer=new byte[1024];
		            int length;
		            while((length=input.read(buffer))>0){
		                output.write(buffer, 0, length);
		            }	
		            
		            input.close();
		            output.close();
		            
		            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", f.getAbsolutePath());
		            upladed=true;
		        }catch(Exception e){
		            e.printStackTrace(System.out);
		        }
		        
		        try{
		            InputStream input=file.getInputStream();
		            File f=new File("D:/CV/"+uid+".jpg");
		            if(!f.exists()){
		                f.createNewFile();
		            }
		            FileOutputStream output=new FileOutputStream(f);
		            byte[] buffer=new byte[1024];
		            int length;
		            while((length=input.read(buffer))>0){
		                output.write(buffer, 0, length);
		            }
		            
		            input.close();
		            output.close();
		            
		            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", f.getAbsolutePath());
		            upladed=true;
		        }catch(Exception e){
		            e.printStackTrace(System.out);
		        }
		    }
	
	

}
