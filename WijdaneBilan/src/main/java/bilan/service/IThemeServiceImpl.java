package bilan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bilan.dao.IThemeRepository;
import bilan.entities.Theme;

@Service
@Transactional
public class IThemeServiceImpl implements IThemeService{
	
	@Autowired
	private IThemeRepository themeRepository;

	@Override
	public List<Theme> toutsThemes() {
		// TODO Auto-generated method stub
		return themeRepository.findAllThemes();
	}

	@Override
	public Theme ajouterTheme(Theme a) {
		// TODO Auto-generated method stub
		return themeRepository.save(a);
	}

	@Override
	public Theme trouverTheme(int id) {
		// TODO Auto-generated method stub
		return themeRepository.findTheme(id);
	}

	@Override
	public int supprimerTheme(int id) {
		// TODO Auto-generated method stub
		return themeRepository.deleteTheme(id);
	}

	@Override
	public int modifierTheme(String nom, int id) {
		// TODO Auto-generated method stub
		return themeRepository.updateTheme(nom, id);
	}

	public IThemeRepository getThemeRepository() {
		return themeRepository;
	}

	public void setThemeRepository(IThemeRepository themeRepository) {
		this.themeRepository = themeRepository;
	}
	



}
