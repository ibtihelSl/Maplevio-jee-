package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Mandate implements Serializable{
	@EmbeddedId
	private MandatePK mandatePK;
	@Temporal(TemporalType.DATE)
	private Date debutMandat;
	@Temporal(TemporalType.DATE)
	

	private Date finMandat;
	private boolean isValid;
	private boolean archive; 
	
	
	
	
	public boolean isArchive() {
		return archive;
	}
	public void setArchive(boolean archive) {
		this.archive = archive;
	}
	public Date getDebutMandat() {
		return debutMandat;
	}
	public void setDebutMandat(Date debutMandat) {
		this.debutMandat = debutMandat;
	}
	public Date getFinMandat() {
		return finMandat;
	}
	public void setFinMandat(Date finMandat) {
		this.finMandat = finMandat;
	}
	
	@ManyToOne
	@JoinColumn(name="projectId" ,referencedColumnName="projectId",insertable=false,updatable=false)
	private Project project ;
	
	@ManyToOne
	@JoinColumn(name="resourceId" ,referencedColumnName="userId",insertable=false,updatable=false)
	private Resource resource ;
	public MandatePK getMandatePK() {
		return mandatePK;
	}
	public void setMandatePK(MandatePK mandatePK) {
		this.mandatePK = mandatePK;
	}

	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public Mandate() {
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public Mandate(MandatePK mandatePK, boolean isValid, Project project, Resource resource) {
		super();
		this.mandatePK = mandatePK;
		this.isValid = isValid;
		this.project = project;
		this.resource = resource;
	}
	public Mandate(Date debutMandat, Date finMandat, Project project, Resource resource) {
		super();
		this.debutMandat = debutMandat;
		this.finMandat = finMandat;
		this.mandatePK.setProjectId(project.getProjectId());
		this.mandatePK.setResourceId(resource.getUserId());
	}
	public Mandate(MandatePK mandatePK, Date debutMandat, Date finMandat, boolean archive, Project project,
			Resource resource) {
		super();
		this.mandatePK = mandatePK;
		this.debutMandat = debutMandat;
		this.finMandat = finMandat;
		this.archive = archive;
		this.project = project;
		this.resource = resource;
	}
	 
	
	
	
	

}
