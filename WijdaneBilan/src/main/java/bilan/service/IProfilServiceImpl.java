package bilan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import bilan.dao.IManagerRepository;
import bilan.dao.IProfilRepository;
import bilan.entities.Profil;

@Service
@Transactional
public class IProfilServiceImpl implements IProfilService{
	@Autowired
	private IProfilRepository profilRepository;


	@Override
	public List<Profil> toutsProfils() {
		// TODO Auto-generated method stub
		return profilRepository.findAllProfils();
	}

	@Override
	public Profil ajouterProfil(Profil a) {
		// TODO Auto-generated method stub
		return profilRepository.save(a);
	}

	@Override
	public Profil trouverProfil(int id) {
		// TODO Auto-generated method stub
		return profilRepository.findProfil(id);
	}

	@Override
	public int supprimerProfil(int id) {
		// TODO Auto-generated method stub
		return profilRepository.deleteProfil(id);
	}

	@Override
	public int modifierProfil(String nom, int id) {
		// TODO Auto-generated method stub
		return profilRepository.updateProfil(nom, id);
	}

	public IProfilRepository getProfilRepository() {
		return profilRepository;
	}

	public void setProfilRepository(IProfilRepository profilRepository) {
		this.profilRepository = profilRepository;
	}
	
	

}
