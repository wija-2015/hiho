package bilan.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Collection;


@Entity
public class Objectif implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idObjectif;
	private String description;
	private String diffBapBip;
	private String moyenObj;
	private int autoriser;
	
	//bi-directional many-to-one association to Evaluationobjectif
	@OneToMany(mappedBy="objectif")
	private Collection<EvaluationObjectif> evaluationobjectifs;
	
	@ManyToOne
	@JoinColumn(name="idCategorie")
	private Categorie categorie;
	
	public Managerrh getManagerrh() {
		return managerrh;
	}

	public void setManagerrh(Managerrh managerrh) {
		this.managerrh = managerrh;
	}

	@ManyToOne
	@JoinColumn(name="id_managerrh")
	private Managerrh managerrh;


	public Objectif() {
	}

	public Objectif(int idObjectif, String description, String diffBapBip,
			String moyenObj,
			Collection<EvaluationObjectif> evaluationobjectifs,
			Categorie categorie) {
		super();
		this.idObjectif = idObjectif;
		this.description = description;
		this.diffBapBip = diffBapBip;
		this.moyenObj = moyenObj;
		this.evaluationobjectifs = evaluationobjectifs;
		this.categorie = categorie;
	}

	public int getIdObjectif() {
		return this.idObjectif;
	}

	public void setIdObjectif(int idObjectif) {
		this.idObjectif = idObjectif;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDiffBapBip() {
		return this.diffBapBip;
	}

	public void setDiffBapBip(String diffBapBip) {
		this.diffBapBip = diffBapBip;
	}

	public String getMoyenObj() {
		return this.moyenObj;
	}

	public void setMoyenObj(String moyenObj) {
		this.moyenObj = moyenObj;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Collection<EvaluationObjectif> getEvaluationobjectifs() {
		return evaluationobjectifs;
	}

	public void setEvaluationobjectifs(Collection<EvaluationObjectif> evaluationobjectifs) {
		this.evaluationobjectifs = evaluationobjectifs;
	}

	public int getAutoriser() {
		return autoriser;
	}

	public void setAutoriser(int autoriser) {
		this.autoriser = autoriser;
	}
	

}