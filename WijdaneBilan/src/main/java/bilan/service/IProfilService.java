package bilan.service;

import java.util.List;

//import bilan.entities.Managerrh;
import bilan.entities.Profil;

public interface IProfilService {
	
	public List<Profil> toutsProfils();

	public Profil ajouterProfil(Profil a);
	
	public Profil trouverProfil(int id);
	
	public int supprimerProfil(int id);
	
	public int modifierProfil(String nom,int id);
	
	//public List<Managerrh> trouverManagers();
	

}
