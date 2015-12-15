package bilan.service;

import java.util.List;

import bilan.entities.Admin;
import bilan.entities.Bap;
import bilan.entities.Managerrh;

public interface IBapService {
	
	public List<Bap> toutsBaps();

	public Bap ajouterBap(Bap a);
	
	public Bap trouverBap(int id);
	
	public int supprimerBap(int id);
	
	public int modifierBap(String mode, int id);
	

}
