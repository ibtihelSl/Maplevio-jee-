package ManagedBeans;



import java.util.List;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import Entities.Project;
import Services.MonitoringServices;

@ManagedBean
@RequestScoped
public class ProjectBean {
	
private List<Project> projects ;
private List<Project> inProgressProjects ;
private List<Project> newProjects ;
private List<Project> lap ;

@EJB
MonitoringServices ms;

public List<Project> getProjects() {
	projects = ms.getAllProjects();
	return projects;
}

public List<Project> getInProgressProjects() {
	inProgressProjects = ms.getAllInProgressProjects();
	return inProgressProjects;
}

public List<Project> getNewProjects() {
	newProjects = ms.getAllNewProjects();

	return newProjects;
}

public List<Project> getLap(){

	  lap = ms.getLeastAffectedProjects();
	  return lap ;
		
}

} 






