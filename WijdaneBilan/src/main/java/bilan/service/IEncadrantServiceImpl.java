package bilan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bilan.dao.IEncadrantRepository;
import bilan.dao.IProfilRepository;
import bilan.dtos.EncadrantDTO;
import bilan.dtos.ManagerrhDTO;
import bilan.entities.Collaborateur;
import bilan.entities.Encadrant;
import bilan.entities.Managerrh;
import bilan.entities.Profil;

@Service
@Transactional
public class IEncadrantServiceImpl implements IEncadrantService {
	@Autowired
	private IEncadrantRepository encadrantRepository;
	@Autowired
	private IProfilRepository profilRepository;

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
		return encadrantRepository.deleteEncadrant(id);
	}

	@Override
	public int modifierEncadrant(String nom, String prenom,String mail,String matricule, int id) {
		return encadrantRepository.updateEncadrant(nom, prenom,mail, matricule, id);
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

	@Override
	public long verify(String mail, String matriculeUser) {
		// TODO Auto-generated method stub
		return	encadrantRepository.verify(mail, matriculeUser) ;
	}

	@Override
	public long getIdEncadrant(String mail, String matriculeUser) {
		// TODO Auto-generated method stub
		return encadrantRepository.getIdEncadrant(mail, matriculeUser);
	}
	}
