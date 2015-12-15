package bilan.entities;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;


/**
 * The persistent class for the profil database table.
 * 
 */
@Entity
public class Profil implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProfil;
	private String nomProfil;

	//bi-directional many-to-one association to Encadrant
	@JsonIgnore
	@OneToMany(mappedBy="profil")
	private Collection<Encadrant> encadrants;

	public Profil() {
	}

	/*public Profil(int idProfil, String nomProfil,
			Collection<Encadrant> encadrants) {
		super();
		this.idProfil = idProfil;
		this.nomProfil = nomProfil;
		this.encadrants = encadrants;
	}*/

	public int getIdProfil() {
		return this.idProfil;
	}

	public void setIdProfil(int idProfil) {
		this.idProfil = idProfil;
	}

	public String getNomProfil() {
		return this.nomProfil;
	}

	public void setNomProfil(String nomProfil) {
		this.nomProfil = nomProfil;
	}

	public Collection<Encadrant> getEncadrants() {
		return this.encadrants;
	}

	public void setEncadrants(Collection<Encadrant> encadrants) {
		this.encadrants = encadrants;
	}

}