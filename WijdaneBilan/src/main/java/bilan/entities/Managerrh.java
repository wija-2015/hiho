package bilan.entities;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Collection;


@Entity
public class Managerrh implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idManagerrh;
	private String mailUser;
	private String matriculeUser;
	private String nomUser;
	private String prenomUser;
	private String password;

	//bi-directional many-to-one association to Collaborateur
	@JsonIgnore
	@OneToMany(mappedBy="managerrh")
	private Collection<Collaborateur> collaborateurs;
	
	@JsonIgnore
	@OneToMany(mappedBy="managerrh")
	private Collection<Objectif> objectifs;

	public Managerrh() {
	}


	/*public Managerrh(int idManagerrh, String mailUser, String matriculeUser,
			String nomUser, String prenomUser,
			Collection<Collaborateur> collaborateurs) {
		super();
		this.idManagerrh = idManagerrh;
		this.mailUser = mailUser;
		this.matriculeUser = matriculeUser;
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		//this.collaborateurs = collaborateurs;
	}
*/

	public int getIdManagerrh() {
		return idManagerrh;
	}

	public void setIdManagerrh(int idManagerrh) {
		this.idManagerrh = idManagerrh;
	}

	public String getMailUser() {
		return mailUser;
	}

	public void setMailUser(String mailUser) {
		this.mailUser = mailUser;
	}

	public String getMatriculeUser() {
		return matriculeUser;
	}

	public void setMatriculeUser(String matriculeUser) {
		this.matriculeUser = matriculeUser;
	}

	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public String getPrenomUser() {
		return prenomUser;
	}

	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}

	public Collection<Collaborateur> getCollaborateurs() {
		return this.collaborateurs;
	}

	public void setCollaborateurs(Collection<Collaborateur> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Objectif> getObjectifs() {
		return objectifs;
	}

	public void setObjectifs(Collection<Objectif> objectifs) {
		this.objectifs = objectifs;
	}
}