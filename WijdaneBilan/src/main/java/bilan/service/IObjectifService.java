package bilan.service;

import java.util.List;

import bilan.entities.Objectif;

public interface IObjectifService {
	
	public List<Objectif> ficheCollab(int idC);
	
	public Objectif ajouterObjectif(Objectif o);
	public List<Objectif> toutsObjectifs();
	public int supprimerObjectif(int id);
	public int modifierObjectif(String desc, int id);
	
	
	
}
