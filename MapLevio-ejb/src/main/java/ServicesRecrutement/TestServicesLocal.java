package ServicesRecrutement;

import java.util.List;

import javax.ejb.Local;

import Entities.Test;

@Local
public interface TestServicesLocal {

	int createTest (Test t);
	Test afficheTest(int id);
	
	void deletTest(int id);
	List<Test> afficherTest();
	
}
