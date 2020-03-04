package ServicesRecrutement;

import java.util.Date;

import javax.ejb.Local;

import Entities.Passage;

@Local
public interface PassageServicesLocal {
	void affecterDateTech(int c, Date d);
	void affecterDateFR(int c, Date d);
	void envoyerMail();
	Passage getPassage(int id);
	void passgeTest(Passage p);
	void affecterDateee(Passage p);

}
