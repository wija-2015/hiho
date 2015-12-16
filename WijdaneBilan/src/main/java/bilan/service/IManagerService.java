package bilan.service;

import java.util.List;

import bilan.dtos.CollaborateurDTO;
import bilan.dtos.ManagerrhDTO;
import bilan.entities.Collaborateur;
import bilan.entities.Managerrh;

public interface IManagerService {
	
	public List<Managerrh> toutsManagers();

	public Managerrh ajouterManager(Managerrh c);
	
	public Managerrh trouverManager(int id);
	
	public int supprimerManager(int id);
	
	public int modifierManager(String nom, String prenom,String mail,String matricule, int id);
	
	public List<Collaborateur> trouverManagerCollabs(int id);
	
	public long verify(String mail, String matriculeUser);
	public long getIdManager(String mail, String matriculeUser);

}
