package bilan.dtos;

public class EvaluationObjectifDTO {
	
	private int idEvaluationObj;
	
	private float noteFinaleObj;
	private int poidsObj;
	private float resultatObj;
	private int idObjectif;
	private int idEncadrant;
	private String mesureObj;
	
	public int getIdEncadrant() {
		return idEncadrant;
	}
	public void setIdEncadrant(int idEncadrant) {
		this.idEncadrant = idEncadrant;
	}
	public String getMesureObj() {
		return mesureObj;
	}
	public void setMesureObj(String mesureObj) {
		this.mesureObj = mesureObj;
	}
	public int getIdEvaluationObj() {
		return idEvaluationObj;
	}
	public void setIdEvaluationObj(int idEvaluationObj) {
		this.idEvaluationObj = idEvaluationObj;
	}
	
	public float getNoteFinaleObj() {
		return noteFinaleObj;
	}
	public void setNoteFinaleObj(float noteFinaleObj) {
		this.noteFinaleObj = noteFinaleObj;
	}
	public int getPoidsObj() {
		return poidsObj;
	}
	public void setPoidsObj(int poidsObj) {
		this.poidsObj = poidsObj;
	}
	public float getResultatObj() {
		return resultatObj;
	}
	public void setResultatObj(float resultatObj) {
		this.resultatObj = resultatObj;
	}
	public int getIdObjectif() {
		return idObjectif;
	}
	public void setIdObjectif(int idObjectif) {
		this.idObjectif = idObjectif;
	}
	
}
