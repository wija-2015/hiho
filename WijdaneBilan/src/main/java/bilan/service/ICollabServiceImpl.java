package bilan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bilan.dao.ICollabRepository;
import bilan.dao.IManagerRepository;
import bilan.dtos.CollaborateurDTO;
import bilan.entities.Collaborateur;
import bilan.entities.Managerrh;

@Service
@Transactional
public class ICollabServiceImpl implements ICollabService {
	
    @Autowired
	private ICollabRepository collabRepository;
    @Autowired
	private IManagerRepository managerRepository;

	@Override
	public List<Collaborateur> toutsCollabs() {
		return collabRepository.findAll();
		//return collabRepository.findAll();
	}

	@Override
	public Collaborateur ajouterCollab(Collaborateur c) {
		return collabRepository.save(c);
	}

	@Override
	public Collaborateur trouverCollab(int id) {
		return collabRepository.findCollab(id);
	}
	
	@Override
	public int supprimerCollab(int id) {
		return collabRepository.deleteCollab(id);
		
	}
	@Override
	public int modifierCollab(String nom, String prenom ,String email,String matricule ,int id) {
		return collabRepository.updateCollab(nom, prenom,email, matricule, id);
	}

	@Override
	public long verify(String mail, String matriculeUser) {
		return	collabRepository.verify(mail, matriculeUser) ;
		 
	}

	public ICollabRepository getCollabRepository() {
		return collabRepository;
	}

	public void setCollabRepository(ICollabRepository collabRepository) {
		this.collabRepository = collabRepository;
	}

	@Override
	public long getIdCollab(String mail, String matriculeUser) {
		return collabRepository.getIdCollab(mail, matriculeUser);
	}

}
