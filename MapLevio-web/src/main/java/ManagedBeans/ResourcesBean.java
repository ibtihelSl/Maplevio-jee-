package ManagedBeans;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.mail.Address;
import javax.servlet.http.Part;

import Entities.Adresse;
import Entities.Conge;
import Entities.Resource;
import Enumerates.Competance;
import Enumerates.ResourceState;
import Enumerates.ResourceType;
import Enumerates.Role;
import Services.CongeService;
import Services.ResourceService;

@ManagedBean(name="resourcesBean")
@SessionScoped
public class ResourcesBean {
	
	
	private String nom ;
	private String prenom ;
	private String email ;
	private String password ; 
	private  Role role ;
	private Adresse adresse ;
	private Date dateNaissance ;
	private int seniority;
	private float note;
	private Competance competance;
	private String pays;
	private String ville;
	private String rue;
	private String codePostal;
	private List<Resource> resource;
	private List<Conge> conge;
	private int idresource;
	private ResourceState resourcestate;
	private ResourceType resourcetype;
	private boolean archive;
	private Part file;
	private String cv;
	@EJB
	ResourceService resourcesservice;
	@EJB
	CongeService congservice;
	
	
	
	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}
	
	public boolean isArchive() {
		return archive;
	}
	public void setArchive(boolean archive) {
		this.archive = archive;
	}
	public ResourceState getResourcestate() {
		return resourcestate;
	}
	public void setResourcestate(ResourceState resourcestate) {
		this.resourcestate = resourcestate;
	}
	public ResourceType getResourcetype() {
		return resourcetype;
	}
	public void setResourcetype(ResourceType resourcetype) {
		this.resourcetype = resourcetype;
	}
	public List<Conge> getConge() {
		return conge;
	}
	public void setConge(List<Conge> conge) {
		this.conge = conge;
	}
	
	public CongeService getCongservice() {
		return congservice;
	}
	public void setCongservice(CongeService congservice) {
		this.congservice = congservice;
	}
	public int getIdresource() {
		return idresource;
	}
	public void setIdresource(int idresource) {
		this.idresource = idresource;
	}
	public List<Resource> getResource() {
		return resource;
	}
	public void setResource(List<Resource> resource) {
		this.resource = resource;
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
	public int getSeniority() {
		return seniority;
	}
	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}
	public float getNote() {
		return note;
	}
	public void setNote(float note) {
		this.note = note;
	}
	public Competance getCompetance() {
		return competance;
	}
	public void setCompetance(Competance competance) {
		this.competance = competance;
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
	@PostConstruct
	public void init(){
		dateNaissance=new Date();
		
	}
	
	public ResourceService getResourcesservice() {
		return resourcesservice;
	}
	public void setResourcesservice(ResourceService resourcesservice) {
		this.resourcesservice = resourcesservice;
	}
	
	public void addResources() throws IOException {
		adresse=new Adresse();
		adresse.setCodePostal(codePostal);
		adresse.setPays(pays);
		adresse.setRue(rue);
		adresse.setVille(ville);
		Resource resource=new Resource();
		resource.setNom(nom);
		resource.setPrenom(prenom);
		resource.setEmail(email);
		resource.setPassword(password);
		resource.setRole(role.Ressource);
		resource.setArchivé(false);
		resource.setAdresse(adresse);
		resource.setDateNaissance(dateNaissance);
		resource.setSeniority(seniority);
		resource.setResourceState(resourcestate.Available);
		resource.setResourceType(resourcetype);
		resource.setCompetance(competance);
		
		
		
		Scanner s = new Scanner(file.getInputStream());
		String fileContent = s.useDelimiter("\\A").next();
		s.close();
		
		System.out.println(fileContent);
		String fi=file.getSubmittedFileName();
		System.out.println(fi);

		Files.write(Paths.get("E:\\CV\\"+file.getSubmittedFileName()), fileContent.getBytes(), StandardOpenOption.CREATE);
		resource.setCv("E:\\CV\\"+file.getSubmittedFileName());
		resourcesservice.AjouterResource(resource);
	}
	
	public List<Resource> GetALLResources(){
		resource=resourcesservice.findAllResources();
		
		return resource;
	}
	

	public List<Resource> GetResourcesJee(){
		resource=resourcesservice.findResoureJee();
		return resource;
	}
	public List<Resource> GetResourcesJava(){
		resource=resourcesservice.findResoureJava();
		return resource;
	}
	public List<Resource> GetResourcessymfony(){
		resource=resourcesservice.findResoureSymfony();
		return resource;
	}
	public List<Resource> GetResourcesios(){
		resource=resourcesservice.findResoureios();
		return resource;
	}
	public List<Resource> GetResourcesAndroid(){
		resource=resourcesservice.findResoureandroid();
		return resource;
	}
	public List<Resource> GetResourcesphp(){
		resource=resourcesservice.findResourephp();
		
		return resource;
	}
	
	public Long count(){
		Long nbr=resourcesservice.NbrRessourcejee();
		return nbr;
	}
	
	public Long countphp(){
		Long nbr=resourcesservice.NbrRessourcephp();
		return nbr;
	}
	public Long countsymfony(){
		Long nbr=resourcesservice.NbrRessourceSYMFONY();
		return nbr;
	}
	public Long countjava(){
		Long nbr=resourcesservice.NbrRessourcejava();
		return nbr;
	}
	public Long countios(){
		Long nbr=resourcesservice.NbrRessourceIos();
		return nbr;
	}
	public Long countandroid(){
		Long nbr=resourcesservice.NbrRessourceandroid();
		return nbr;
	}
	public Long NBrRess(){
		Long nbr=resourcesservice.NbrRessource();
		return nbr;
	}
	
	
	public void DeleteResources(int id){
		resourcesservice.deleteResource(id,true);
	}
	
	public void MiseAJourRe(Resource resource){
		this.setVille(resource.getAdresse().getVille());
		this.setRue(resource.getAdresse().getRue());
		this.setCodePostal(resource.getAdresse().getCodePostal());
		this.setPays(resource.getAdresse().getPays());
		this.setEmail(resource.getEmail());
		this.setNom(resource.getNom());
		this.setPrenom(resource.getPrenom());
		this.setIdresource(resource.getUserId());
		this.setPassword(resource.getPassword());
		this.setDateNaissance(resource.getDateNaissance());
		this.setSeniority(resource.getSeniority());
		this.setResourcetype(resource.getResourceType());
		this.setCompetance(resource.getCompetance());
		this.setRole(resource.getRole());
		this.setResourcestate(resource.getResourceState());
		this.setArchive(resource.isArchivé());
		this.setCv(resource.getCv());
	}
	
	public void UpdateResource(){
		Resource resour=new Resource();
		adresse.setVille(ville);
		adresse.setRue(rue);
		adresse.setCodePostal(codePostal);
		adresse.setPays(pays);
		resour.setEmail(email);
		resour.setNom(nom);
		resour.setPrenom(prenom);
		resour.setUserId(idresource);
		resour.setAdresse(adresse);
		resour.setPassword(password);
		resour.setDateNaissance(dateNaissance);
		resour.setSeniority(seniority);
		resour.setResourceType(resourcetype);
		resour.setCompetance(competance);
		resour.setRole(role);
		resour.setResourceState(resourcestate);
		resour.setArchivé(archive);
		resour.setCv(cv);
		resourcesservice.updateResource(resour);
	}
	public List<Resource> GetResourcearchive(){
		
		resource=resourcesservice.Resourcesarchive();
		return resource;
		
	}
	public void upload() throws IOException {
		Scanner s = new Scanner(file.getInputStream());
		String fileContent = s.useDelimiter("\\A").next();
		s.close();
		
		System.out.println(fileContent);
		
		Files.write(Paths.get("E:\\"+file.getSubmittedFileName()), fileContent.getBytes(), StandardOpenOption.CREATE);
	}
	
	public void validate(FacesContext context, UIComponent component, Object value) {
		Part file = (Part) value;
		if (file.getSize() > 11) {
			throw new ValidatorException(new FacesMessage("File is too large"));
		}
		if (!file.getContentType().equals("text/plain")) 
			throw new ValidatorException(new FacesMessage("File is not a text file"));
	}
	

}
