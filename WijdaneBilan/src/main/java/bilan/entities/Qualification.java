package bilan.entities;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Qualification implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idQualification;
	private String remarque;
	private String nomQualification;
	private int poidsQualification;

	//bi-directional many-to-one association to Feedback
	@ManyToOne
	@JoinColumn(name="idFeedback")
	private Feedback feedback;

	//bi-directional many-to-one association to Theme
	@ManyToOne
	@JoinColumn(name="idTheme")
	private Theme theme;

	public Qualification() {
	}

	public Qualification(int idQualification, String remarque,
			Feedback feedback, Theme theme) {
		super();
		this.idQualification = idQualification;
		this.remarque = remarque;
		this.feedback = feedback;
		this.theme = theme;
	}

	public int getIdQualification() {
		return idQualification;
	}

	public void setIdQualification(int idQualification) {
		this.idQualification = idQualification;
	}

	public String getRemarque() {
		return this.remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
    @JsonIgnore
	public Feedback getFeedback() {
		return this.feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
    //@JsonIgnore
	public Theme getTheme() {
		return this.theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public String getNomQualification() {
		return nomQualification;
	}

	public void setNomQualification(String nomQualification) {
		this.nomQualification = nomQualification;
	}

	public int getPoidsQualification() {
		return poidsQualification;
	}

	public void setPoidsQualification(int poidsQualification) {
		this.poidsQualification = poidsQualification;
	}
}