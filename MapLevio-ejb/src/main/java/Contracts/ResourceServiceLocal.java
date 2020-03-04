package Contracts;

import java.util.List;

import javax.ejb.Local;

import Entities.Resource;

@Local
public interface ResourceServiceLocal {
	

	 void AjouterResource(Resource resource) ;
	 public void updateResource(Resource resource);
	 public void deleteResource(int id) ;
	 public List<Resource> findAllResources() ;
	 public Resource findResourceById(int id);

}
