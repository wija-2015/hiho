package bilan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bilan.dao.ICategorieRepository;
import bilan.entities.Categorie;

@Service
@Transactional
public class ICategorieServiceImpl implements ICategorieService{
	
	@Autowired
	private ICategorieRepository categorieRepository;

	@Override
	public List<Categorie> toutsCategories() {
		// TODO Auto-generated method stub
		return categorieRepository.findAllCategories();
	}

	@Override
	public Categorie ajouterCategorie(Categorie a) {
		// TODO Auto-generated method stub
		return categorieRepository.save(a);
	}

	@Override
	public Categorie trouverCategorie(int id) {
		return categorieRepository.findCategorie(id);
	}

	@Override
	public int supprimerCategorie(int id) {
		// TODO Auto-generated methBap(id);
		return categorieRepository.deleteCategorie(id);
	}

	@Override
	public int modifierCategorie(String mode, int id) {
		// TODO Auto-generated method stub
		return categorieRepository.updateCategorie(mode, id);
	}

	public ICategorieRepository getCategorieRepository() {
		return categorieRepository;
	}

	public void setCategorieRepository(ICategorieRepository categorieRepository) {
		this.categorieRepository = categorieRepository;
	}
	
	
}
