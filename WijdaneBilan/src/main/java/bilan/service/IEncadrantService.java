package bilan.service;

import java.util.List;

import bilan.entities.Collaborateur;
import bilan.entities.Encadrant;

public interface IEncadrantService {
	
	public List<Encadrant> toutsEncadrants();

	public Encadrant ajouterEncadrant(Encadrant c);
	
	public Encadrant trouverEncadrant(int id);
	
	public int supprimerEncadrant(int id);
	
	public int modifierEncadrant(String nom, String prenom,int id);
	
	public List<Collaborateur> trouverEncadrantCollabs(int id);
	

}
