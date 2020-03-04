package Beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Client;
import Entities.Project;
import Enumerates.ProjectType;
import Service.ProjectServiceLocal;

@ManagedBean(name="projetBean")
@SessionScoped
public class ProjectBean {
	private int  ClientIdToBeUpdate;
	private int projetIdToBeUpdate;
	private Client client;
	private List<Client> clis;
	 private String description;
	private int SelectedEmployeId;
	private List<Project>cln;
	private String projectName;
	private Date dateDebut;
	private Date dateFin;
	private String competence;
	
	private ProjectType  projectType;
	


	@EJB
	ProjectServiceLocal projetservice;
	
	
	  public int getClientIdToBeUpdate() {
		return ClientIdToBeUpdate;
	}

	public void setClientIdToBeUpdate(int clientIdToBeUpdate) {
		ClientIdToBeUpdate = clientIdToBeUpdate;
	}

	public int getProjetIdToBeUpdate() {
		return projetIdToBeUpdate;
	}

	public void setProjetIdToBeUpdate(int projetIdToBeUpdate) {
		this.projetIdToBeUpdate = projetIdToBeUpdate;
	}

	//public void selectC (Client client )
     // { 
		//// System.out.println("test client -----:"+client.getUserId());
 		// this.setClientIdToBeUpdate(client.getUserId());
 		
      //}

      //public void selectPr (Project projet)
      //{
    	  //System.out.println("test projet -----:"+projet.getProjectId());
   	  // this.setProjetIdToBeUpdate(projet.getProjectId());
   	  
 		
      //}
      
    
      
  
      
      public List<Client> getClis() {
		return clis;
	}

	public void setClis(List<Client> clis) {
		this.clis = clis;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSelectedEmployeId() {
		return SelectedEmployeId;
	}

	public void setSelectedEmployeId(int selectedEmployeId) {
		SelectedEmployeId = selectedEmployeId;
	}

	public List<Project> getCln() {
		return cln;
	}

	public void setCln(List<Project> cln) {
		this.cln = cln;
	}

	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@PostConstruct
  	public void init(){
  		  
    	  clis=projetservice.GetAllClient();
  		
  	}
  	
	
	
  	
  	public String ajouterProjet()throws ParseException{
  		//SimpleDateFormat simpledate=new SimpleDateFormat("dd-MM-yyyy");
  		//System.out.println("Date Debut :"+simpledate.format(date));
  		System.out.println(" SelectedEmployeId:"+SelectedEmployeId);
  		
  		Project pr=new Project(ProjectType.New,projectName,  description,  competence,
  				 dateDebut,dateFin);
  		
  		
  		Client selectedEmploye=new Client();
  		selectedEmploye.setUserId(SelectedEmployeId);
  		pr.setClient(selectedEmploye);
  		projetservice.ajouterProjet(pr);
  		
  		 return "/pages/affPRO?faces-redirect=true";
  		
  	}
  	
        
	
    
    public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getCompetence() {
		return competence;
	}

	public void setCompetence(String competence) {
		this.competence = competence;
	}

	public ProjectType getProjectType() {
		return projectType;
	}

	public void setProjectType(ProjectType projectType) {
		this.projectType = projectType;
	}

	public List<Project> GetAllProjet(){
		cln=projetservice.GetAllProjet();
		
		return cln;
		
	}
    public List<Client> GetAllClient(){
  	  clis=projetservice.GetAllClient();
  		
  		return clis;
  		
  	}
    
    
    
    public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void ModifierCl(Project pr){
	
		this.setProjectName(pr.getProjectName());
		this.setCompetence(pr.getCompetence());	
		this.setDescription(pr.getDescription());
		this.setDateDebut(pr.getDateDebut());
		this.setDateFin(pr.getDateFin());
		this.setClient(pr.getClient());
		
        this.setClientIdToBeUpdate(pr.getProjectId());
	}
	  public String mettreaAjourProject(){
	       
			
			projetservice.Update(new Project(ClientIdToBeUpdate,  projectType, projectName,  description,
					 competence,  dateDebut,  dateFin));
			
			return "/pages/affPRO?faces-redirect=true";

	}
	
	  public void Delete(Integer EmpId){
			projetservice.DeleteProjetById(EmpId);
		}
		
	
	  
    
}
