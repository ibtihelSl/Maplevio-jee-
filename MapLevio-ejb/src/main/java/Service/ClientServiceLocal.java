package Service;

import java.util.List;


import javax.ejb.Local;
import javax.ejb.LocalBean;

import Entities.Client;
import Entities.Project;
@Local
@LocalBean
public interface ClientServiceLocal {
	int ajouterClient(Client client);
	void Update(Client client);
	int AjouterProjet(Project projet);
	
	
	
	void DeleteClientById(int userId);
	Client GetClientById(int userId);
	List<Client> GetAllClient();
	List<Client> GetAllClientById(int userId);
	Client findClientById(int userId);
	


}
