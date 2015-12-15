package bilan.entities;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Collection;


@Entity
public class Projet implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProjet;
	private String codeProjet;
	private String nomProjet;

	//bi-directional many-to-one association to Feedback
	@JsonIgnore
	@OneToMany(mappedBy="projet")
	private Collection<Feedback> feedbacks;

	public Projet() {
	}

	/*public Projet(int idProjet, String codeProjet, String nomProjet,
			Collection<Feedback> feedbacks) {
		super();
		this.idProjet = idProjet;
		this.codeProjet = codeProjet;
		this.nomProjet = nomProjet;
		this.feedbacks = feedbacks;
	}*/


	public int getIdProjet() {
		return this.idProjet;
	}

	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}

	public String getCodeProjet() {
		return this.codeProjet;
	}

	public void setCodeProjet(String codeProjet) {
		this.codeProjet = codeProjet;
	}

	public String getNomProjet() {
		return this.nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	public Collection<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(Collection<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

}