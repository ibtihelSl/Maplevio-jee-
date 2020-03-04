package ServicesRecrutement;

import java.util.List;

import javax.ejb.Local;

import Entities.Candidate;

@Local
public interface CandidateServicesLocal {
	int createCandidate (Candidate c);
	List<Candidate> afficherCandidateEntrevu();
	List<Candidate> afficherCandidateEntretien();
	List<Candidate> afficherCandidateFr();
	List<Candidate> afficherCandidateAccepter();
	void approuverCandidate(int id);
	void refuserCandidate(int id);
	Candidate findByid(int id);


}
