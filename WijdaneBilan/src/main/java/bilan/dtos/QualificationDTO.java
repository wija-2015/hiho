package bilan.dtos;

import java.io.Serializable;

import javax.persistence.*;


public class QualificationDTO{

	private int idQualification;
	private String remarque;
	private String nomQualification;
	private int poidsQualification;
	private int idFeedback;
	private int[] idTheme;
	
	public int getIdQualification() {
		return idQualification;
	}
	public void setIdQualification(int idQualification) {
		this.idQualification = idQualification;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
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
	public int getIdFeedback() {
		return idFeedback;
	}
	public void setIdFeedback(int idFeedback) {
		this.idFeedback = idFeedback;
	}
	public int[] getIdTheme() {
		return idTheme;
	}
	public void setIdTheme(int[] idTheme) {
		this.idTheme = idTheme;
	}
	
	

}