package ManagedBeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Client;
import Entities.Conge;
import Entities.Mandate;
import Entities.MandatePK;
import Entities.Project;
import Entities.Resource;
import Enumerates.ProjectType;
import Service.ProjectService;
import Services.MandateService;
import Services.ResourceService;

@ManagedBean(name="mandateBean")
@SessionScoped
public class MandateBean {
	private int SelectedProjectId;
	
	private int SelectedRessourceId;

	private Date dateDebut;
	private Date dateFin;
	private boolean archive;
	private int MandatIdTobeUpdated;
	
	@EJB
	MandateService mandatService;
	
	@EJB
	ProjectService projetService;
	
	@EJB
	ResourceService ressourceService;
	
	
	private List<Mandate>mandats;
	private List <Project>projects= new ArrayList<>();
	private List <Resource> Resources= new ArrayList<>();
	public Date getDateDebut() {
		return dateDebut;
	}
	public int getSelectedProjectId() {
		return SelectedProjectId;
	}
	public void setSelectedProjectId(int selectedProjectId) {
		SelectedProjectId = selectedProjectId;
	}
	public int getSelectedRessourceId() {
		return SelectedRessourceId;
	}
	public void setSelectedRessourceId(int selectedRessourceId) {
		SelectedRessourceId = selectedRessourceId;
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
	public boolean isArchive() {
		return archive;
	}
	public void setArchive(boolean archive) {
		this.archive = archive;
	}
	public int getMandatIdTobeUpdated() {
		return MandatIdTobeUpdated;
	}
	public void setMandatIdTobeUpdated(int mandatIdTobeUpdated) {
		MandatIdTobeUpdated = mandatIdTobeUpdated;
	}
	public MandateService getMandatService() {
		return mandatService;
	}
	public void setMandatService(MandateService mandatService) {
		this.mandatService = mandatService;
	}
	public ProjectService getProjetService() {
		return projetService;
	}
	public void setProjetService(ProjectService projetService) {
		this.projetService = projetService;
	}
	public ResourceService getRessourceService() {
		return ressourceService;
	}
	public void setRessourceService(ResourceService ressourceService) {
		this.ressourceService = ressourceService;
	}
	public List<Mandate> getMandats() {
		return mandats;
	}
	public void setMandats(List<Mandate> mandats) {
		this.mandats = mandats;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
 
    private Resource selectRessource = new Resource();
    public Resource getSelectRessource() {
		return selectRessource;
	}
	public void setSelectRessource(Resource selectRessource) {
		this.selectRessource = selectRessource;
	}
	
	public Project getSelectedProjet() {
		return selectedProjet;
	}
	public void setSelectedProjet(Project selectedProjet) {
		this.selectedProjet = selectedProjet;
	}
	private Project selectedProjet=new Project();

	public List <Resource> getResources() {
		return Resources;
	}
	public void setResources(List <Resource> resources) {
		Resources = resources;
	}
	
@PostConstruct
public void postInit() {
   
	
	projects = projetService.GetAllProjet();
	setResources(ressourceService.GetAllResources());
//  for (Project projet : prjts) {    	  	    	
  //prjts.add(projet);	    	  
//   }
//   
//   List<Resource> listRess = ressourceService.findAllResources();
//   for (Resource ressource : listRess) {
// 	  	  listRess.add(ressource); 
// 	  	  }
 }
  
	
	
		public void ajouterMandate() throws IOException{
			
//			if(dateDebut!=null && dateFin!=null && selectedProjet.getCompetance() ==selectRessource.getCompetance() )   {

				if(dateDebut!=null && dateFin!=null) {
					this.mandatService.ajouterMandate(SelectedProjectId,SelectedRessourceId,dateDebut, dateFin);
					;
				
				
				}
				//return "affichageMandate/?faces-redirect=true";
				}
				

		
		
		public List<Mandate> geMandates() {
			mandats = mandatService.GetallMandate();
			return mandats;
		}
	
	
		public void UpdateMandate(){
			Mandate mandate=new Mandate();
			mandate.setDebutMandat(dateDebut);
			mandate.setFinMandat(dateFin);

			mandatService.updateMandate(mandate);
		}
		  
		
		
		public void DeleteMandate(Mandate m){
			
			//Mandate m= mandatService.FindMandate(m.getMandatePK().getProjectId(),m.getMandatePK().getResourceId());
			mandatService.deleteMandate(m);
		}

		public List<Mandate> Getarchive(){
			
			mandats=mandatService.GetMandateArchivee();
			return mandats;
		
}
}