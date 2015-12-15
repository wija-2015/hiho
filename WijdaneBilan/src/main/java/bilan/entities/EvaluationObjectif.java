package bilan.entities;

import java.io.Serializable;

import javax.persistence.*;


@Entity
public class EvaluationObjectif implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idEvaluationObj;
	private String mesureObj;
	private float noteFinaleObj;
	private float poidsObj;
	private float resultatObj;

	//bi-directional many-to-one association to Collaborateur
	@ManyToOne
	@JoinColumn(name="idCollaborateur")
	private Collaborateur collaborateur;

	//bi-directional many-to-one association to Encadrant
	@ManyToOne
	@JoinColumn(name="idEncadrant")
	private Encadrant encadrant;

	//bi-directional many-to-one association to Objectif
	@ManyToOne
	@JoinColumn(name="idObjectif")
	private Objectif objectif;

	public EvaluationObjectif() {
		
	}
	
	public EvaluationObjectif(int idEvaluationObj, String mesureObj,
			float noteFinaleObj, float poidsObj, float resultatObj,
			Collaborateur collaborateur, Encadrant encadrant, Objectif objectif) {
		super();
		this.idEvaluationObj = idEvaluationObj;
		this.mesureObj = mesureObj;
		this.noteFinaleObj = noteFinaleObj;
		this.poidsObj = poidsObj;
		this.resultatObj = resultatObj;
		this.collaborateur = collaborateur;
		this.encadrant = encadrant;
		this.objectif = objectif;
	}

	public int getIdEvaluationObj() {
		return idEvaluationObj;
	}
	public void setIdEvaluationObj(int idEvaluationObj) {
		this.idEvaluationObj = idEvaluationObj;
	}

	public String getMesureObj() {
		return this.mesureObj;
	}

	public void setMesureObj(String mesureObj) {
		this.mesureObj = mesureObj;
	}

	public float getNoteFinaleObj() {
		return this.noteFinaleObj;
	}

	public void setNoteFinaleObj(float noteFinaleObj) {
		this.noteFinaleObj = noteFinaleObj;
	}

	public float getPoidsObj() {
		return this.poidsObj;
	}

	public void setPoidsObj(float poidsObj) {
		this.poidsObj = poidsObj;
	}

	public float getResultatObj() {
		return this.resultatObj;
	}

	public void setResultatObj(float resultatObj) {
		this.resultatObj = resultatObj;
	}

	public Collaborateur getCollaborateur() {
		return this.collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

	public Encadrant getEncadrant() {
		return this.encadrant;
	}

	public void setEncadrant(Encadrant encadrant) {
		this.encadrant = encadrant;
	}

	public Objectif getObjectif() {
		return this.objectif;
	}

	public void setObjectif(Objectif objectif) {
		this.objectif = objectif;
	}

}