package bilan.entities;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;


@Entity
public class Categorie implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCategorie;
	private String nomCategorie;
	
	@JsonIgnore
	@OneToMany(mappedBy="categorie")
	private Collection<Objectif> objectifs;

	public Categorie() {
	}

	/*public Categorie(int idCategorie, String nomCategorie,
			Collection<Objectif> objectifs) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.objectifs = objectifs;
	}
*/
	public int getIdCategorie() {
		return this.idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return this.nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public Collection<Objectif> getObjectifs() {
		return this.objectifs;
	}

	public void setObjectifs(Collection<Objectif> objectifs) {
		this.objectifs = objectifs;
	}

}