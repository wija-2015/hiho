package bilan.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


@Entity
public class Bap implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idBap;

	private Date dateBap;

	private int mode;

	private float noteFinaleBap;

	private String poste;

	private String status;

	//bi-directional many-to-one association to Collaborateur
	@ManyToOne
	@JoinColumn(name="id_collaborateur")
	private Collaborateur collaborateur;

	public Bap() {
	}
	

	public Bap(int idBap, Date dateBap, int mode, float noteFinaleBap,
			String poste, String status, Collaborateur collaborateur) {
		super();
		this.idBap = idBap;
		this.dateBap = dateBap;
		this.mode = mode;
		this.noteFinaleBap = noteFinaleBap;
		this.poste = poste;
		this.status = status;
		this.collaborateur = collaborateur;
	}


	public int getIdBap() {
		return this.idBap;
	}

	public void setIdBap(int idBap) {
		this.idBap = idBap;
	}

	public Date getDateBap() {
		return this.dateBap;
	}

	public void setDateBap(Date dateBap) {
		this.dateBap = dateBap;
	}

	public int getMode() {
		return this.mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public float getNoteFinaleBap() {
		return this.noteFinaleBap;
	}

	public void setNoteFinaleBap(float noteFinaleBap) {
		this.noteFinaleBap = noteFinaleBap;
	}

	public String getPoste() {
		return this.poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Collaborateur getCollaborateur() {
		return this.collaborateur;
	}

	public void setCollaborateur(Collaborateur collaborateur) {
		this.collaborateur = collaborateur;
	}

}