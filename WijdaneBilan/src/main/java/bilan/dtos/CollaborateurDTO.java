package bilan.dtos;

import java.util.Date;

public class CollaborateurDTO {
	private int idCollaborateur;
	private Date dateRecrutement;
	private String mailUser;
	private String matriculeUser;
	private String nomUser;
	private String prenomUser;
	private String password;
	private int idManagerrh ;
	
	public int getIdCollaborateur() {
		return idCollaborateur;
	}
	public void setIdCollaborateur(int idCollaborateur) {
		this.idCollaborateur = idCollaborateur;
	}
	public Date getDateRecrutement() {
		return dateRecrutement;
	}
	public void setDateRecrutement(Date dateRecrutement) {
		this.dateRecrutement = dateRecrutement;
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
	public int getIdManagerrh() {
		return idManagerrh;
	}
	public void setIdManagerrh(int idManagerrh) {
		this.idManagerrh = idManagerrh;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
