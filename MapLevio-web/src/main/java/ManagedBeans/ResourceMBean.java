package ManagedBeans;



import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import Entities.Resource;

import Services.MonitoringServices;


@ManagedBean
@ViewScoped
public class ResourceMBean {
	
	@EJB
	MonitoringServices ms; 

	
   private float pourcentagefreelancer;
   private float pourcentageemploye;
   private int nbrfreelancers;
   private int nbremployee;
   private int nbrresources;
   
   
public int getNbrresources() {
	nbrresources = ms.getNumberResourcess();
	return nbrresources;
}
public MonitoringServices getMs() {
	return ms;
}
public float getPourcentagefreelancer() {
	int a = ms.getNumberFreelancers();
	int b = ms.getNumberResourcess();
	pourcentagefreelancer=(a*100)/b ;
	return pourcentagefreelancer;
}
public float getPourcentageemploye() {
	int a = ms.getNumberemployeess();
	int b = ms.getNumberResourcess();
	pourcentageemploye=(a*100)/b ;
	return pourcentageemploye;
}
public int getNbrfreelancers() {
	nbrfreelancers = ms.getNumberFreelancers();
	return nbrfreelancers;
}
public int getNbremployee() {
	nbremployee = ms.getNumberemployeess();
	return nbremployee;
}
   
}
