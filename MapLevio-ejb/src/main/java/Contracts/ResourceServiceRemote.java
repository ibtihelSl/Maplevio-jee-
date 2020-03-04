package Contracts;

import java.util.List;

import javax.ejb.Remote;

import Entities.Resource;

@Remote
public interface ResourceServiceRemote {
	void AjouterResource(Resource resource) ;
	 public void updateResource(Resource resource);
	 public void deleteResource(int id,boolean arch) ;
	 public List<Resource> findAllResources() ;
	 public Resource findResourceById(int id);
	 public long NbrRessource();
	 public long NbrRessourcejava();
	 public long NbrRessourcejee();
	 public long NbrRessourceandroid();
	 public List<Resource> ResourcesDispo();
	 public long NbrRessourceSYMFONY();
	 public long NbrRessourceIos() ;
	 public long NbrRessourcephp() ;
	 public List<Resource> findResoureJee();
	 public List<Resource> findResoureios();
	 public List<Resource> findResoureandroid();
	 public List<Resource> findResourephp();
	 public List<Resource> findResoureSymfony();
	 public List<Resource> findResoureJava() ;
	 public List<Resource> Resourcesarchive();
	 public List<Resource> GetAllResources();
	 
}
