package Entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PassagePK implements Serializable{
	private int candidateId;
	private int TestId;
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public int getTestId() {
		return TestId;
	}
	public void setTestId(int testId) {
		TestId = testId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + TestId;
		result = prime * result + candidateId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassagePK other = (PassagePK) obj;
		if (TestId != other.TestId)
			return false;
		if (candidateId != other.candidateId)
			return false;
		return true;
	}
	public PassagePK() {
		
	}
	public PassagePK(int candidateId, int testId) {
		
		this.candidateId = candidateId;
		this.TestId = testId;
	}
	
	

}
