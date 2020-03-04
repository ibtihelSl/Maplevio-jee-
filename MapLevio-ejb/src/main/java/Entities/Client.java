package Entities;
import Enumerates.*;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Client extends User implements Serializable {

	
	@Enumerated(EnumType.STRING)
	private ClientType clientType ;
	
	@Enumerated(EnumType.STRING)
	private ClientCategory clientCategory ;
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
	private List<Project> listeProject ;

	private Double longitude;
	private Double latitude;
	
	
	
	
	
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public ClientType getClientType() {
		return clientType;
	}

	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}

	public ClientCategory getClientCategory() {
		return clientCategory;
	}

	public void setClientCategory(ClientCategory clientCategory) {
		this.clientCategory = clientCategory;
	}
	public Client() {
		super();
	}

	public Client(int userId, String nom, String email, String password, String image, ClientType clientType,
			ClientCategory clientCategory, List<Project> listeProject) {
		super(userId, nom, email, password, image);
		this.clientType = clientType;
		this.clientCategory = clientCategory;
		this.listeProject = listeProject;
		}

	public Client(String nom, String email, String password, ClientType clientType,
			ClientCategory clientCategory) {
		super(nom, email, password);
		this.clientType = clientType;
		this.clientCategory = clientCategory;
	}

	@Override
	public String toString() {
		return "Client [clientType=" + clientType + ", clientCategory=" + clientCategory + ", listeProject="
				+ listeProject + "]";
	}
	

	
}
