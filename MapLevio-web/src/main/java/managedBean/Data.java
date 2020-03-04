package managedBean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import Enumerates.ClientCategory;
import Enumerates.ClientType;
import Enumerates.Competance;
import Enumerates.MessageCible;
import Enumerates.MessageType;
import Enumerates.ProjectType;
import Enumerates.ResourceState;
import Enumerates.ResourceType;
import Enumerates.Role;

@ManagedBean(name="data")
@ApplicationScoped
public class Data {
	public Role[] getRoles(){
		return Role.values();
		}
	public ProjectType[] getProjectType(){
		return ProjectType.values();
	}
	
	public ClientCategory[] getClientCategory(){
		return ClientCategory.values();
	}
	
	public ClientType[] getClientType(){
		return ClientType.values();
	}
	public MessageCible[] getMessageCibles(){
		
		return MessageCible.values();
	}

	public MessageType[] getMessageType(){
		
		return MessageType.values();
	}
	public ResourceState[] getResourcestate(){
		return ResourceState.values();
	}
	
	public ResourceType[] getResourcetype(){
		return ResourceType.values();
	}
	
	public Competance[] getCompetances(){
		return Competance.values();
	}



}
