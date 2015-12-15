package bilan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bilan.dao.IEncadrantRepository;
import bilan.entities.Collaborateur;
import bilan.entities.Encadrant;

@Service
@Transactional
public class IEncadrantServiceImpl implements IEncadrantService {
	@Autowired
	private IEncadrantRepository encadrantRepository;

	@Override
	public List<Encadrant> toutsEncadrants() {
		// TODO Auto-generated method stub
		return encadrantRepository.findAllEncadrants();
	}

	@Override
	public Encadrant ajouterEncadrant(Encadrant c) {
		// TODO Auto-generated method stub
		return encadrantRepository.save(c);
	}

	@Override
	public Encadrant trouverEncadrant(int id) {
		// TODO Auto-generated method stub
		return encadrantRepository.findEncadrant(id);
	}

	@Override
	public int supprimerEncadrant(int id) {
		// TODO Auto-generated method stub
		return encadrantRepository.deleteEncadrant(id);
	}

	@Override
	public int modifierEncadrant(String nom, String prenom, int id) {
		
		return encadrantRepository.updateEncadrant(nom, prenom, id);
	}

	@Override
	public List<Collaborateur> trouverEncadrantCollabs(int id) {
		// TODO Auto-generated method stub
		return encadrantRepository.findEncadrantCollabs(id);
	}

	public IEncadrantRepository getEncadrantRepository() {
		return encadrantRepository;
	}

	public void setEncadrantRepository(IEncadrantRepository encadrantRepository) {
		this.encadrantRepository = encadrantRepository;
	}
	
	

}
