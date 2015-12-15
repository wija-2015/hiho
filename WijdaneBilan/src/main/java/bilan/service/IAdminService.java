package bilan.service;

import java.util.List;

import bilan.entities.Managerrh;
import bilan.entities.Admin; 

public interface IAdminService {
	
	public List<Admin> toutsAdmins();

	public Admin ajouterAdmin(Admin a);
	
	public Admin trouverAdmin(int id);
	
	public int supprimerAdmin(int id);
	
	public int modifierAdmin(String nom, String prenom,int id);
	
	public List<Managerrh> trouverManagers();
	
	public long verify(String mail, String matriculeUser) ;
	public long getIdAdmin(String mail, String matriculeUser);

}
