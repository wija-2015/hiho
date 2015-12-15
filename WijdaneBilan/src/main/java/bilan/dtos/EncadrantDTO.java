package bilan.dtos;

public class EncadrantDTO {
	
	private int idEncadrant;
	private String mailUser;
	private String matriculeUser;
	private String nomUser;
	private String prenomUser;
	private String password;
	private int idProfil;
	public int getIdEncadrant() {
		return idEncadrant;
	}
	public void setIdEncadrant(int idEncadrant) {
		this.idEncadrant = idEncadrant;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIdProfil() {
		return idProfil;
	}
	public void setIdProfil(int idProfil) {
		this.idProfil = idProfil;
	}
	
	

}
