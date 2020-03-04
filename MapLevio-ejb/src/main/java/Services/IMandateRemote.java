package Services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import Entities.Mandate;
import Entities.Project;
import Entities.Resource;

@Remote
public interface IMandateRemote {

	void ajouterMandate(int idProject, int idRessource, Date datedebut, Date datefin);
	void validerMandate(int idProject, int idRessource, Date datedebut, Date datefin,int validateurid);
	
	List<Mandate> GetallMandate();
	//public void deleteMandate(int idProject,int idRessource,boolean archivee);
	public void updateMandate(Mandate m); 
	public List<Mandate> GetMandateArchivee();
	
	
	Mandate FindMandate(int p, int r);
	void deleteMandate(Mandate md);
}
