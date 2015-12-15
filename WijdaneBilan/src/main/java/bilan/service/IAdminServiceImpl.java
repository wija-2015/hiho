package bilan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bilan.dao.IAdminRepository;
import bilan.entities.Admin;
import bilan.entities.Managerrh;

@Service
@Transactional
public class IAdminServiceImpl implements IAdminService{
	
	@Autowired
	private IAdminRepository adminRepository;

	@Override
	public List<Admin> toutsAdmins() {
		// TODO Auto-generated method stub
		return adminRepository.findAllAdmins();
	}

	@Override
	public Admin ajouterAdmin(Admin a) {
		// TODO Auto-generated method stub
		return adminRepository.save(a);
	}

	@Override
	public Admin trouverAdmin(int id) {
		return adminRepository.findAdmin(id);
	}

	@Override
	public int supprimerAdmin(int id) {
		// TODO Auto-generated method stub
		return adminRepository.deleteAdmin(id);
	}

	@Override
	public int modifierAdmin(String nom, String prenom, int id) {
		// TODO Auto-generated method stub
		return adminRepository.updateAdmin(nom, prenom, id);
	}

	@Override
	public List<Managerrh> trouverManagers() {
		// TODO Auto-generated method stub
		return adminRepository.findAllManagers();
	}
	
	

	public IAdminRepository getAdminRepository() {
		return adminRepository;
	}

	public void setAdminRepository(IAdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}
	public long verify(String mail, String matriculeUser) {
		// TODO Auto-generated method stub
		return	adminRepository.verify(mail, matriculeUser) ;
	} 
	@Override
	public long getIdAdmin(String mail, String matriculeUser) {
		// TODO Auto-generated method stub
		return adminRepository.getIdAdmin(mail, matriculeUser);
	}
}
