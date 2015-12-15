package bilan.service;

import java.util.List;

import bilan.dtos.CollaborateurDTO;
import bilan.entities.Collaborateur;


public interface ICollabService {

	
	public List<Collaborateur> toutsCollabs();

	public Collaborateur ajouterCollab(Collaborateur c);
	
	public Collaborateur trouverCollab(int id);
	
	public int supprimerCollab(int id);
	
	public Collaborateur modifierCollab(CollaborateurDTO c,int id);
	
	public long verify(String mail, String matriculeUser);
	public long getIdCollab(String mail, String matriculeUser);

	int modifierCollab(String nom, String prenom, String email, int id);
	

	/*public User getUserById(Long id);

	void deleteUser(Long id);
	
	//List<User> findClientbyPromotion(Long id);
	
	void save (User client);*/
	
}