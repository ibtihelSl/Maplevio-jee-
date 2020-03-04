package ManagedBeans;



import java.util.List;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import Entities.Client;
import Entities.Project;
import Services.MonitoringServices;

@ManagedBean(name="managementBean")
@RequestScoped
public class ManagementBean {
	
private int numberAllInProgressProjects;
private int numberAllFinishedProjects;
private int numberAllProjects;
private int numberAllNewProjects;
private int numberAllClients;
private int numberAllPrivateClients;
private int numberAllPublicClients;
private List<Project> mrcp ;
private List<Client> mac ;

@EJB
MonitoringServices ms; 






public void setNumberAllInProgressProjects(int numberAllInProgressProjects) {
	this.numberAllInProgressProjects = numberAllInProgressProjects;
}

public void setNumberAllFinishedProjects(int numberAllFinishedProjects) {
	this.numberAllFinishedProjects = numberAllFinishedProjects;
}

public void setNumberAllProjects(int numberAllProjects) {
	this.numberAllProjects = numberAllProjects;
}

public void setNumberAllNewProjects(int numberAllNewProjects) {
	this.numberAllNewProjects = numberAllNewProjects;
}

public void setNumberAllClients(int numberAllClients) {
	this.numberAllClients = numberAllClients;
}

public void setNumberAllPrivateClients(int numberAllPrivateClients) {
	this.numberAllPrivateClients = numberAllPrivateClients;
}

public void setNumberAllPublicClients(int numberAllPublicClients) {
	this.numberAllPublicClients = numberAllPublicClients;
}

public void setMrcp(List<Project> mrcp) {
	this.mrcp = mrcp;
}

public void setMac(List<Client> mac) {
	this.mac = mac;
}

public void setMs(MonitoringServices ms) {
	this.ms = ms;
}

public int getNumberAllClients() {
	numberAllClients = ms.getNumberAllActiveClients();
	return numberAllClients;
}

public int getNumberAllPrivateClients() {
	numberAllPrivateClients= ms.getNumberPrivateClients();
	return numberAllPrivateClients;
}

public int getNumberAllPublicClients() {
	numberAllPublicClients = ms.getNumberPublicClients();
	return numberAllPublicClients;
}

public int getNumberAllInProgressProjects() {
	numberAllInProgressProjects = ms.getNumberAllInProgressProjects();
	return numberAllInProgressProjects;
}

public int getNumberAllFinishedProjects() {
	numberAllFinishedProjects = ms.getNumberAllFinishedProjects();
	return numberAllFinishedProjects;
}

public int getNumberAllProjects() {
	numberAllProjects = ms.getNumberAllProjects();
	return numberAllProjects;
}

public int getNumberAllNewProjects() {
	numberAllNewProjects = ms.getNumberAllNewProjects();
	return numberAllNewProjects;
}

public List<Project> getMrcp() {
	mrcp = ms.getMostResourceConsumingProjects();
	return mrcp;
}


public List<Client> getMac() {
	mac = ms.getMostActiveClients();
	return mac ;
}



public MonitoringServices getMs() {
	return ms;
}


}
