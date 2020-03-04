package Contracts;

import java.util.List;

import javax.ejb.Remote;

import Entities.Conge;

@Remote
public interface CongeServiceRemote {
	
	void AjouterConge(Conge conge);
	 void UpdateConge(Conge conge);
	 void DeleteConge(int id);
	 List<Conge> findAllConge();
	 Conge FindCongeById(int id);
	 Conge FindCongeByIdRessources(int id);
	

}
