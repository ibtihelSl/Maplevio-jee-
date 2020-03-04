package ManagedBeans;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import Entities.Conge;
import Entities.Resource;
import Services.CongeService;
import Services.ResourceService;

@ManagedBean(name="congeBean")
@SessionScoped
public class CongeBean {
	
	
	private Date datedebut;
	private Date datefin;
	private int resid;
	private List<Resource> resources;
	private List<Conge> conges;
	private Resource resource;
	private int idresource;
	
	
	@EJB
	CongeService congeservice;

	@EJB
	ResourceService resourceservise;


	public int getIdresource() {
		return idresource;
	}



	public void setIdresource(int idresource) {
		this.idresource = idresource;
	}



	public ResourceService getResourceservise() {
		return resourceservise;
	}



	public void setResourceservise(ResourceService resourceservise) {
		this.resourceservise = resourceservise;
	}



	public Date getDatedebut() {
		return datedebut;
	}



	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}



	public Date getDatefin() {
		return datefin;
	}



	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}



	public int getResid() {
		return resid;
	}



	public void setResid(int resid) {
		this.resid = resid;
	}



	public List<Resource> getResources() {
		return resources;
	}



	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}



	public List<Conge> getConges() {
		return conges;
	}



	public void setConges(List<Conge> conges) {
		this.conges = conges;
	}



	public CongeService getCongeservice() {
		return congeservice;
	}



	public void setCongeservice(CongeService congeservice) {
		this.congeservice = congeservice;
	}
	
	
	

	public Resource getResource() {
		return resource;
	}



	public void setResource(Resource resource) {
		this.resource = resource;
	}

	
	
	@PostConstruct
	public void init(){
		datedebut=new Date();
		datefin=new Date();
		
	}
	
	
	
	public String congeajout(int id){
		
		//resource=new Resource();
	//	System.out.println(id);
		//resource.setUserId(id);
		//this.setResource(resource);
	    //conge.setResource(resourceservise.findResourceById(id));
		setResid(id);
		return "/pages/conge?id="+id+"faces-redirect=true";
	}
	
	public void congee(Resource resource){
		
		this.setIdresource(resource.getUserId());
		
		
	}


	
	


	public void addconge(){
		Conge conge=new Conge();
		
		conge.setCongeDebut(datedebut);
		conge.setCongeFin(datefin);	
		System.out.println(idresource);
		Resource res=resourceservise.findResourceById(idresource);
		conge.setResource(res);
		
		System.out.println(res.getNom());
		
		congeservice.AjouterConge(conge);
		
		
	}
	
	
	
	
	
	
	
	
}
