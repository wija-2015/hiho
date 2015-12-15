package bilan.service;

import java.util.List;

import bilan.entities.Categorie;


public interface ICategorieService {
	
	public List<Categorie> toutsCategories();

	public Categorie ajouterCategorie(Categorie a);
	
	public Categorie trouverCategorie(int id);
	
	public int supprimerCategorie(int id);
	
	public int modifierCategorie(String mode, int id);

}
