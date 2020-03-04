package Services;

import java.util.List;

import javax.ejb.Remote;

import Entities.Candidate;
import Entities.Client;
import Entities.Resource;
import Entities.User;

@Remote
public interface UserServiceRemote {
	public int ajouterCandidate(Candidate candidate);
	public Candidate getCandidateByEmailAndPassword(String email  , String password);
	public void deleteCandidate(int userId);
	public int ajouterClient(Client client);
	public void deleteClient(int userId);
	public Client getClientByEmailAndPassword(String email, String password);
	public List<Candidate> candidates();
	public List<Client> clients();
	public List<User> users();
	public User getUserByEmailAndPassword(String email, String password);
	public void update(Candidate candidat);
	public void updateClient(Client client);
	public void deleteResource(int userId);
	public List<Resource> resources();
	public Resource getResourceByEmailAndPassword(String email, String password);
	public Candidate getCandidateById(int id);

	


}
