package bilan.dtos;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


public class FeedbackDTO {

	private int idFeedback;
	private String role;
	private int nbJours;
	private Date dateDebut;
	private Date dateFin;
	private String commentaire;
	private int nbThemes;
	private int totalPoints;
	private float noteGlobale;
	private int idCollaborateur;
	private int idProjet;
	private int idEncadrant;
	private List<QualificationDTO> qualification  = new ArrayList<QualificationDTO>() ; 
	
	public List<QualificationDTO> getQualification() {
		return qualification;
	}
	public void setQualification(List<QualificationDTO> qualification) {
		this.qualification = qualification;
	}
	public int getIdFeedback() {
		return idFeedback;
	}
	public void setIdFeedback(int idFeedback) {
		this.idFeedback = idFeedback;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getNbJours() {
		return nbJours;
	}
	public void setNbJours(int nbJours) {
		this.nbJours = nbJours;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public int getNbThemes() {
		return nbThemes;
	}
	public void setNbThemes(int nbThemes) {
		this.nbThemes = nbThemes;
	}
	public int getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}
	public float getNoteGlobale() {
		return noteGlobale;
	}
	public void setNoteGlobale(float noteGlobale) {
		this.noteGlobale = noteGlobale;
	}
	public int getIdCollaborateur() {
		return idCollaborateur;
	}
	public void setIdCollaborateur(int idCollaborateur) {
		this.idCollaborateur = idCollaborateur;
	}
	public int getIdProjet() {
		return idProjet;
	}
	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}
	public int getIdEncadrant() {
		return idEncadrant;
	}
	public void setIdEncadrant(int idEncadrant) {
		this.idEncadrant = idEncadrant;
	}
	
	

}