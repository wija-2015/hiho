package bilan.service;

import java.util.List;

import bilan.entities.Projet;

public interface IProjetService {
	
	public List<Projet> toutsProjets();

	public Projet ajouterProjet(Projet a);
	
	public Projet trouverProjet(int id);
	
	public int supprimerProjet(int id);
	
	public int modifierProjet(String nom,int id);
	
	//public List<Managerrh> trouverManagers();
	

}
