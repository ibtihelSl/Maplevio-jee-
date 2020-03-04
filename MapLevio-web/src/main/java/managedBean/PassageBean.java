package managedBean;

import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Candidate;
import Entities.Passage;
import ManagedBeans.LoginBean;
import ServicesRecrutement.CandidateServices;
import ServicesRecrutement.PassageService;

@ManagedBean(name="passageBean")
@SessionScoped
public class PassageBean {
	@EJB
	PassageService ps = new PassageService();
	CandidateServices cs =new CandidateServices();
     public int id;
     private Date date ;
     private int idcand =6; //LoginBean.getCandidate().getUserId();
     private Passage p;
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
	public PassageBean() {
		super();
	}
	


	public Passage getP() {
		p = ps.getPassage(idcand);
		return p;
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



	public void setP(Passage p) {
		this.p = p;
	}



	public int getIdcand() {
		return idcand;
	}

	public void setIdcand(int idcand) {
		this.idcand = idcand;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
    public String affecter(){
    	//Date d = date;
    	//Candidate c = cs.findByid(id);
    	//Passage p = new Passage();
    	//p.setDateOfPassing(d);
    	//p.setCandidate(c);
    	ps.affecterDateTech(id, date);
    	return "/Pages/listesCandidateEntretien?faces-redirect=true";
    }
   public String affecterdFr(){
	   ps.affecterDateFR(id, date);
   	return "/Pages/listesCandidateFr?faces-redirect=true";
   }
	public String ajoutPassage(Integer userId){
		id = userId;
		return "/Pages/affectDate?faces-redirect=true";
	}
	public String affecterFr(int userId){
		id = userId;
		return "/Pages/affectDateFr?faces-redirect=true";
	}
	public String passerTest(){
		p.setAnswer1(answer1);
		p.setAnswer1(answer2);
		p.setAnswer1(answer3);
		p.setAnswer1(answer4);
		p.setAnswer1(answer5);
		p.setAnswer1(answer6);
		p.setAnswer1(answer7);
		p.setAnswer1(answer8);
		p.setAnswer1(answer9);
		p.setAnswer1(answer10);
	
		ps.passgeTest(p);
		
		return "/template/layout?faces-redirect=true";
	}
	
}
