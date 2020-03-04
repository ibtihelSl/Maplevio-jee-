package Service;

import java.util.List;


import javax.ejb.Remote;

import Entities.Client;
import Entities.Project;


@Remote
public interface ClientServiceRemote {
	int ajouterClient(Client client);
	void Update(Client client);
	int AjouterProjet(Project projet);
	List<Client> GetAllClientById(int userId);
	
	
	
	
	void DeleteClientById(int userId);
	Client GetClientById(int userId);
	List<Client> GetAllClient();
	Client findClientById(int userId);

}
