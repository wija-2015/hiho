package bilan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bilan.dao.IFeedbackRepository;
import bilan.dao.IQualificationRepository;
import bilan.dao.IThemeRepository;
import bilan.dtos.QualificationDTO;
import bilan.entities.Collaborateur;
import bilan.entities.Feedback;
import bilan.entities.Projet;
import bilan.entities.Qualification;
import bilan.entities.Theme;

@Service
@Transactional
public class IQualificationServiceImpl implements IQualificationService{
	
	@Autowired
	private IQualificationRepository qualificationRepository;
	@Autowired
	private IThemeRepository themeRepository;
	@Autowired
	private IFeedbackRepository feedbackRepository;
	
	@Override
	public Qualification ajouterQualification(Qualification q) {
		return qualificationRepository.save(q) ;
	}

	@Override
	public List<Qualification> toutsQualifications() {
		// TODO Auto-generated method stub
		return qualificationRepository.findAll();
	}
	
	@Override
	public int supprimerQualification(int id) {
		// TODO Auto-generated method stub
		return qualificationRepository.deleteQualification(id);
	}

	@Override
	public int modifierQualification(String rem, int id) {
		// TODO Auto-generated method stub
		return qualificationRepository.updateQualification(rem, id);
	}

	public IQualificationRepository getQualificationRepository() {
		return qualificationRepository;
	}

	public void setQualificationRepository(
			IQualificationRepository qualificationRepository) {
		this.qualificationRepository = qualificationRepository;
	}

}
