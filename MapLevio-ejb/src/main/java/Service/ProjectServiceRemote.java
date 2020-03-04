package Service;

import java.util.List;

import javax.ejb.Remote;

import Entities.Client;
import Entities.Project;

@Remote
public interface ProjectServiceRemote {
	//void ajouterProjet(Project pr, int idClient);

		List<Client> GetAllClient();

		List<Project> GetAllProjet();

		int ajouterProjet(Project pr);
		void Update(Project pr);

		void DeleteProjetById(int projectId);
		Project findProjectById(int projectId);

}
