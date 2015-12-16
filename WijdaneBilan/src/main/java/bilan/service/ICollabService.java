package bilan.service;

import java.util.List;

import bilan.dtos.CollaborateurDTO;
import bilan.entities.Collaborateur;


public interface ICollabService {

	
	public List<Collaborateur> toutsCollabs();

	public Collaborateur ajouterCollab(Collaborateur c);
	
	public Collaborateur trouverCollab(int id);
	
	public int supprimerCollab(int id);
	
	public long verify(String mail, String matriculeUser);
	
	public long getIdCollab(String mail, String matriculeUser);

	public int modifierCollab(String nom, String prenom, String email,String matricule, int id);

}