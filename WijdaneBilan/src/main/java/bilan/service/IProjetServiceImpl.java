package bilan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bilan.dao.IProjetRepository;
import bilan.entities.Projet;

@Service
@Transactional
public class IProjetServiceImpl implements IProjetService{
	
	@Autowired
	private IProjetRepository projetRepository;


	@Override
	public List<Projet> toutsProjets() {
		// TODO Auto-generated method stub
		return projetRepository.findAllProjets();
	}

	@Override
	public Projet ajouterProjet(Projet a) {
		// TODO Auto-generated method stub
		return projetRepository.save(a);
	}

	@Override
	public Projet trouverProjet(int id) {
		// TODO Auto-generated method stub
		return projetRepository.findProjet(id);
	}

	@Override
	public int supprimerProjet(int id) {
		// TODO Auto-generated method stub
		return projetRepository.deleteProjet(id);
	}

	@Override
	public int modifierProjet(String nom, int id) {
		// TODO Auto-generated method stub
		return projetRepository.updateProjet(nom, id);
	}

	public IProjetRepository getProjetRepository() {
		return projetRepository;
	}

	public void setProjetRepository(IProjetRepository projetRepository) {
		this.projetRepository = projetRepository;
	}

}
