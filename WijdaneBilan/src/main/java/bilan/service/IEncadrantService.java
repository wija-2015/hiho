package bilan.service;

import java.util.List;

import bilan.dtos.CollaborateurDTO;
import bilan.dtos.EncadrantDTO;
import bilan.entities.Collaborateur;
import bilan.entities.Encadrant;

public interface IEncadrantService {
	
	public List<Encadrant> toutsEncadrants();

	public Encadrant ajouterEncadrant(Encadrant c);
	
	public Encadrant trouverEncadrant(int id);
	
	public int supprimerEncadrant(int id);
	public long verify(String mail, String matriculeUser);
	public long getIdEncadrant(String mail, String matriculeUser) ;
	
	public int modifierEncadrant(String nom, String prenom,String mail,String matricule, int id);
	
	public List<Collaborateur> trouverEncadrantCollabs(int id);
	

}
