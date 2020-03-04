package Contracts;

import java.util.List;

import javax.ejb.Local;

import Entities.Conge;

@Local
public interface CongeServiceLocal {
	void AjouterConge(Conge conge);
	 void UpdateConge(Conge conge);
	 void DeleteConge(int id);
	 List<Conge> findAllConge();
	 Conge FindCongeById(int id);
	 Conge FindCongeByIdRessources(int id);

}
