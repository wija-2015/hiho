package bilan.entities;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;


@Entity
public class Theme implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTheme;
	private String nomTheme;

	//bi-directional many-to-one association to Qualification
	@JsonIgnore
	@OneToMany(mappedBy="theme")
	private Collection<Qualification> qualifications;

	public Theme() {
	}
	

	/*public Theme(int idTheme, String nomTheme,
			Collection<Qualification> qualifications) {
		super();
		this.idTheme = idTheme;
		this.nomTheme = nomTheme;
		this.qualifications = qualifications;
	}*/


	public int getIdTheme() {
		return this.idTheme;
	}

	public void setIdTheme(int idTheme) {
		this.idTheme = idTheme;
	}

	public String getNomTheme() {
		return this.nomTheme;
	}

	public void setNomTheme(String nomTheme) {
		this.nomTheme = nomTheme;
	}

	public Collection<Qualification> getQualifications() {
		return this.qualifications;
	}

	public void setQualifications(Collection<Qualification> qualifications) {
		this.qualifications = qualifications;
	}
}