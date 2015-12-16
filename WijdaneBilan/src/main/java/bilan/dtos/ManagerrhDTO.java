package bilan.dtos;

public class ManagerrhDTO {
	
	private int idManagerrh;
	private String mailUser;
	private String matriculeUser;
	private String nomUser;
	private String prenomUser;
	private String password;
	public int getIdManagerrh() {
		return idManagerrh;
	}
	public void setIdManagerrh(int idManagerrh) {
		this.idManagerrh = idManagerrh;
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

}
