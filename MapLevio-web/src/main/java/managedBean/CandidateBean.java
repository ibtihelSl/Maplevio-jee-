package managedBean;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.Adresse;
import Entities.Candidate;
import Entities.Message;
import Entities.Passage;
import Enumerates.EtatCandidate;
import Enumerates.Role;
import ServicesRecrutement.CandidateServices;

@ManagedBean(name="candidateBean")
@SessionScoped
public class CandidateBean {
	
	private Candidate candidate ;
	private List<Candidate> listesCandidatesEntrevu;
	private List<Candidate> listesCandidateEntretien;
	private List<Candidate> listesCandidateFr;
	private List<Candidate> listesCandidateAccepter;
	private String cv;
	private EtatCandidate etat ;
	private List<Passage> listePassage;
	private String nom ;
	private String prenom ;
	private String email ;
	private String password ; 
	private String image ;
	private  Role role ;
	private Adresse adresse ;
	private Date dateNaissance ;
	private List<Message> listeMessagesended;
	private List<Message> listeMessagereceived;
    private String pays;
    private String ville;
    private String rue;
    private String codepostal;
    
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodepostal() {
		return codepostal;
	}
	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}
	@EJB
	CandidateServices cs= new CandidateServices();
	
	public Candidate getCandidate() {
		return candidate;
	}
	public String RefuserCondidature(Integer userId){
		cs.refuserCandidate(userId);
		return "/Pages/listesCandidatesEntrevu?faces-redirect=true";
	}
	public String ApproverCondidature(Integer userId){
		
		cs.approuverCandidate(userId);
		return "/Pages/listesCandidatesEntrevu?faces-redirect=true";

	}
	public String AddCandidate(){
		Adresse a =new Adresse(pays,ville,rue,codepostal);
		cs.createCandidate(new Candidate(nom, prenom, email, password, "fff", Role.Candidate,
				 a, dateNaissance,"cvvv",EtatCandidate.Attente_entrevu));
		return "/Pages/listesCandidatesEntrevu?faces-redirect=true";
	}
	public List<Candidate> getListesCandidatesEntrevu() {
		System.out.println("*******************************************************khaled");
		listesCandidatesEntrevu = cs.afficherCandidateEntrevu();
		System.out.println(listesCandidatesEntrevu);
		return listesCandidatesEntrevu;
	}
	
	public List<Candidate> getListesCandidateEntretien() {
		listesCandidateEntretien = cs.afficherCandidateEntretien();
		return listesCandidateEntretien;
	}
	public List<Candidate> getListesCandidateFr() {
		listesCandidateFr = cs.afficherCandidateFr();
		return listesCandidateFr;
	}
	public List<Candidate> getListesCandidateAccepter() {
		listesCandidateAccepter = cs.afficherCandidateFr();
		return listesCandidateAccepter;
	}
	public void setListesCandidateEntretien(List<Candidate> listesCandidateEntretien) {
		this.listesCandidateEntretien = listesCandidateEntretien;
	}

	public void setListesCandidateFr(List<Candidate> listesCandidateFr) {
		this.listesCandidateFr = listesCandidateFr;
	}
	public void setListesCandidateAccepter(List<Candidate> listesCandidateAccepter) {
		this.listesCandidateAccepter = listesCandidateAccepter;
	}
	public void setListesCandidatesEntrevu(List<Candidate> listesCandidatesEntrevu) {
		this.listesCandidatesEntrevu = listesCandidatesEntrevu;
	}
	public CandidateServices getCs() {
		return cs;
	}
	public void setCs(CandidateServices cs) {
		this.cs = cs;
	}


	public CandidateBean() {
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	public EtatCandidate getEtat() {
		return etat;
	}
	public void setEtat(EtatCandidate etat) {
		this.etat = etat;
	}
	public List<Passage> getListePassage() {
		return listePassage;
	}
	public void setListePassage(List<Passage> listePassage) {
		this.listePassage = listePassage;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public List<Message> getListeMessagesended() {
		return listeMessagesended;
	}
	public void setListeMessagesended(List<Message> listeMessagesended) {
		this.listeMessagesended = listeMessagesended;
	}
	public List<Message> getListeMessagereceived() {
		return listeMessagereceived;
	}
	public void setListeMessagereceived(List<Message> listeMessagereceived) {
		this.listeMessagereceived = listeMessagereceived;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	
}
