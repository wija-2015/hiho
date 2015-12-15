package bilan.service;

import java.util.List;

import bilan.entities.Theme;

public interface IThemeService {
	
	public List<Theme> toutsThemes();

	public Theme ajouterTheme(Theme a);
	
	public Theme trouverTheme(int id);
	
	public int supprimerTheme(int id);
	
	public int modifierTheme(String nom,int id);
	
	//public List<Managerrh> trouverManagers();
	

}
