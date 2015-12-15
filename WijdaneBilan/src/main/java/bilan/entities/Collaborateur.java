package bilan.entities;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Collection;
import java.util.Date;


@Entity
public class Collaborateur implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCollaborateur;
	private Date dateRecrutement;
	private String mailUser;
	private String matriculeUser;
	private String nomUser;
	private String prenomUser;
	private String password;

	//bi-directional many-to-one association to Bap
	@OneToMany(mappedBy="collaborateur")
	private Collection<Bap> baps;

	//bi-directional many-to-one association to Managerrh
	//@JsonBackReference
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_managerrh")
	private Managerrh managerrh;

	//bi-directional many-to-one association to Evaluationobjectif
	@JsonIgnore
	@OneToMany(mappedBy="collaborateur")
	private Collection<EvaluationObjectif> evaluationobjectifs;

	//bi-directional many-to-one association to Feedback
	@JsonIgnore
	@OneToMany(mappedBy="collaborateur")
	private Collection<Feedback> feedbacks;

	public Collaborateur() {
	}
	/*public Collaborateur(int idCollaborateur, Date dateRecrutement,
			String mailUser, String matriculeUser, String nomUser,
			String prenomUser, Collection<Bap> baps, Managerrh managerrh,
			Collection<EvaluationObjectif> evaluationobjectifs,
			Collection<Feedback> feedbacks) {
		super();
		this.idCollaborateur = idCollaborateur;
		this.dateRecrutement = dateRecrutement;
		this.mailUser = mailUser;
		this.matriculeUser = matriculeUser;
		this.nomUser = nomUser;
		this.prenomUser = prenomUser;
		this.baps = baps;
		this.managerrh = managerrh;
		this.evaluationobjectifs = evaluationobjectifs;
		this.feedbacks = feedbacks;
	}*/


	public int getIdCollaborateur() {
		return idCollaborateur;
	}


	public void setIdCollaborateur(int idCollaborateur) {
		this.idCollaborateur = idCollaborateur;
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
	public Date getDateRecrutement() {
		return this.dateRecrutement;
	}

	public void setDateRecrutement(Date dateRecrutement) {
		this.dateRecrutement = dateRecrutement;
	}
	@JsonIgnore
	public Collection<Bap> getBaps() {
		return this.baps;
	}

	public void setBaps(Collection<Bap> baps) {
		this.baps = baps;
	}
	
	public Managerrh getManagerrh() {
		return this.managerrh;
	}
	@JsonSetter
	public void setManagerrh(Managerrh managerrh) {
		this.managerrh = managerrh;
	}

	public Collection<EvaluationObjectif> getEvaluationobjectifs() {
		return this.evaluationobjectifs;
	}

	public void setEvaluationobjectifs(Collection<EvaluationObjectif> evaluationobjectifs) {
		this.evaluationobjectifs = evaluationobjectifs;
	}
	public Collection<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(Collection<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}