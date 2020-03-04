package ManagedBeans;




import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entities.Candidate;
import Entities.Client;
import Entities.Resource;
import Entities.User;
import Enumerates.Role;
import Services.UserService;





@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {
	private String login  ;
	private String password ; 
	private Candidate candidate;
	private Client client;
	private User user;
	
	
	
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


	private Resource resource;
	private boolean  loggedIn ; 
	private Role role;
	
	
	@EJB
	UserService userService ; 
	
	
	
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String doLogin(){
		String navigateTo = "null";
		if (role == Role.Candidate)
		{  
			System.out.println("aaaa");
			candidate = userService.getCandidateByEmailAndPassword(login, password );
				
			if (candidate!=null) {
				//System.out.println("logged in");
				navigateTo = "/pages/welcome?faces-redirect=true";
				loggedIn = true;
				//return navigateTo;
			}else{
				FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credentials"));
			}
			
		}
			
			
		
		else if (role == Role.Client)
		{
			client = userService.getClientByEmailAndPassword(login, password );
			
				if (client!=null) {
				//System.out.println("logged in");
				navigateTo = "/pages/admin/welcome?faces-redirect=true";
				loggedIn = true;
				//return navigateTo;
			}else{
				FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credentials"));
			}
			
			
		}
		else if (role == Role.Ressource)
		{
		System.out.println("logged in");
			resource = userService.getResourceByEmailAndPassword(login, password);
			
			if (resource!=null) {
			System.out.println("lon");
			navigateTo = "/pages/FirstResource?faces-redirect=true";
			System.out.println("logged insdfzfezdzefdez");
			loggedIn = true;
			//return navigateTo;
		}else{
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credentials"));
		}
		
			
		}  
		else if (role == Role.Manager)
		{
			user = userService.getUserByEmailAndPassword(login, password );
			
				if (user!=null) {
				//System.out.println("logged in");
				navigateTo = "/pages/FirstManager?faces-redirect=true";
				loggedIn = true;
				//return navigateTo;
			}else{
				FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credentials"));
			}
			
			
		}
		
		return navigateTo;
		
	}
	public String doLogout(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/pages/login?faces-redirect=true";
	}
}
