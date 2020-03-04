package Entities;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import Enumerates.TestType;

@Entity
public class Test implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int testId;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Passage> listePassage;
	
	private TestType type;
	private String q1;
	private String q2;
	private String q3;
	private String q4;
	private String q5;
	private String q6;
	private String q7;
	private String q8;
	private String q9;
	private String q10;

	
	private Boolean answer1;
	private Boolean answer2;
	private Boolean answer3;
	private Boolean answer4;
	private Boolean answer5;
	private Boolean answer6;
	private Boolean answer7;
	private Boolean answer8;
	private Boolean answer9;
	private Boolean answer10;
	
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	
	public List<Passage> getListePassage() {
		return listePassage;
	}
	public void setListePassage(List<Passage> listePassage) {
		this.listePassage = listePassage;
	}

	
	public TestType getType() {
		return type;
	}
	public void setType(TestType type) {
		this.type = type;
	}
	public String getQ1() {
		return q1;
	}
	public void setQ1(String q1) {
		this.q1 = q1;
	}
	public String getQ2() {
		return q2;
	}
	public void setQ2(String q2) {
		this.q2 = q2;
	}
	public String getQ3() {
		return q3;
	}
	public void setQ3(String q3) {
		this.q3 = q3;
	}
	public String getQ4() {
		return q4;
	}
	public void setQ4(String q4) {
		this.q4 = q4;
	}
	public String getQ5() {
		return q5;
	}
	public void setQ5(String q5) {
		this.q5 = q5;
	}
	public String getQ6() {
		return q6;
	}
	public void setQ6(String q6) {
		this.q6 = q6;
	}
	public String getQ7() {
		return q7;
	}
	public void setQ7(String q7) {
		this.q7 = q7;
	}
	public String getQ8() {
		return q8;
	}
	public void setQ8(String q8) {
		this.q8 = q8;
	}
	public String getQ9() {
		return q9;
	}
	public void setQ9(String q9) {
		this.q9 = q9;
	}
	public String getQ10() {
		return q10;
	}
	public void setQ10(String q10) {
		this.q10 = q10;
	}
	public Boolean getAnswer1() {
		return answer1;
	}
	public void setAnswer1(Boolean answer1) {
		this.answer1 = answer1;
	}
	public Boolean getAnswer2() {
		return answer2;
	}
	public void setAnswer2(Boolean answer2) {
		this.answer2 = answer2;
	}
	public Boolean getAnswer3() {
		return answer3;
	}
	public void setAnswer3(Boolean answer3) {
		this.answer3 = answer3;
	}
	public Boolean getAnswer4() {
		return answer4;
	}
	public void setAnswer4(Boolean answer4) {
		this.answer4 = answer4;
	}
	public Boolean getAnswer5() {
		return answer5;
	}
	public void setAnswer5(Boolean answer5) {
		this.answer5 = answer5;
	}
	public Boolean getAnswer6() {
		return answer6;
	}
	public void setAnswer6(Boolean answer6) {
		this.answer6 = answer6;
	}
	public Boolean getAnswer7() {
		return answer7;
	}
	public void setAnswer7(Boolean answer7) {
		this.answer7 = answer7;
	}
	public Boolean getAnswer8() {
		return answer8;
	}
	public void setAnswer8(Boolean answer8) {
		this.answer8 = answer8;
	}
	public Boolean getAnswer9() {
		return answer9;
	}
	public void setAnswer9(Boolean answer9) {
		this.answer9 = answer9;
	}
	public Boolean getAnswer10() {
		return answer10;
	}
	public void setAnswer10(Boolean answer10) {
		this.answer10 = answer10;
	}
	public Test() {
	
	}
	public Test(TestType type, String q1, String q2, String q3, String q4,
			String q5, String q6, String q7, String q8, String q9, String q10, Boolean answer1, Boolean answer2,
			Boolean answer3, Boolean answer4, Boolean answer5, Boolean answer6, Boolean answer7, Boolean answer8,
			Boolean answer9, Boolean answer10) {
		super();
		
		this.type = type;
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
		this.q4 = q4;
		this.q5 = q5;
		this.q6 = q6;
		this.q7 = q7;
		this.q8 = q8;
		this.q9 = q9;
		this.q10 = q10;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.answer5 = answer5;
		this.answer6 = answer6;
		this.answer7 = answer7;
		this.answer8 = answer8;
		this.answer9 = answer9;
		this.answer10 = answer10;
	}
	public Test( String q1, String q2, String q3, String q4, String q5, String q6, String q7,
			String q8, String q9, String q10, Boolean answer1, Boolean answer2, Boolean answer3, Boolean answer4,
			Boolean answer5, Boolean answer6, Boolean answer7, Boolean answer8, Boolean answer9, Boolean answer10) {
		
		
		
		this.q1 = q1;
		this.q2 = q2;
		this.q3 = q3;
		this.q4 = q4;
		this.q5 = q5;
		this.q6 = q6;
		this.q7 = q7;
		this.q8 = q8;
		this.q9 = q9;
		this.q10 = q10;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.answer5 = answer5;
		this.answer6 = answer6;
		this.answer7 = answer7;
		this.answer8 = answer8;
		this.answer9 = answer9;
		this.answer10 = answer10;
	}
	
	
	

}
