package Services;

import java.util.List;

import javax.ejb.Remote;
import Entities.Candidate;
import Entities.Client;
import Entities.Mandate;
import Entities.Project;
import Entities.Resource;
import Entities.Test;
import Entities.User;

@Remote
public interface MonitoringServicesRemote {
	List<User> getAllUsers();
	List<Candidate> getAllCandidates();
	List<Client> getAllClients();
	List<Mandate> getAllMandates();
	List<Project> getAllProjects();
	List<Resource> getAllResources();
	List<Test> getAllTests();
	
	//User-resource
	List<Resource> getAllUnaffectedResources();
	List<Resource> getAllAffectedResources();
	List<Resource> getMostAffectedResources();
	List<Resource> getAllUnaffectedFreelancers();
	List<Resource> getAllAffectedFreelancers();
	List<Resource> getAllUnaffectedEmployees();
	List<Resource> getAllAffectedEmployees();
	List<Resource> getNumberAllAffectedResources();
	List<Resource> getUnaffectedEmployeesbyCompetance(String competance);

	
	//User-client
	List<Client> getMostActiveClients();
	List<Client> getLeastActiveClients();
	List<Client> getLeastActivePublicClients();
	List<Client> getLeastActivePrivateClients();
	List<Client> getMostActivePrivateClients();
	List<Client> getMostActivePublicClients();
	int getNumberPrivateClients();
	int getNumberPublicClients();
	int getNumberAllActiveClients();
	List<Client> getPrivateClients();
	List<Client> getPublicClients();
	
	//Projects
	
	List<Project> getMostResourceConsumingProjects();
	List<Project> getMostResourceConsumingInProgressProjects();
	List<Project> getMostResourceConsumingNewProjects();
	int getNumberAllInProgressProjects();
	int getNumberAllNewProjects();
	int getNumberAllFinishedProjects();
	int getNumberAllProjects();
	List<Project> getLeastAffectedNewProjects();
	List<Project> getLeastAffectedProjects();
	List<Project> getAllNewProjects();
	List<Project> getAllInProgressProjects();
	
	
	
	//Mandate
	int getNumberActiveMandates();
	
	
	//Tests
	Test getMostPassedTest();
	List<Test> getHighFailureTests();
	List<Test> getLowFailureTests();
	List<String> getAllSkills();
	
	  public int getNumberFreelancers();
		public int getNumberemployeess();
		public int getNumberResourcess();
		

	
}
