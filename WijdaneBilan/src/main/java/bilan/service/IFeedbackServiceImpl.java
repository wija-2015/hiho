package bilan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bilan.dao.ICollabRepository;
import bilan.dao.IEvaluationObjectifRepository;
import bilan.dao.IFeedbackRepository;
import bilan.dao.IProjetRepository;
import bilan.dtos.FeedbackDTO;
import bilan.entities.Collaborateur;
import bilan.entities.Feedback;
import bilan.entities.Projet;

@Service
@Transactional
public class IFeedbackServiceImpl implements IFeedbackService {
	
	@Autowired
	private IFeedbackRepository feedbackRepository;
	@Autowired
	private ICollabRepository collabRepository;
	@Autowired
	private IProjetRepository projetRepository;
	

	@Override
	public Feedback ajouterFeedback(Feedback feed) {
		
		return feedbackRepository.save(feed);
	}
	@Override
	public List<Feedback> collabFeedback2() {
		return feedbackRepository.collabFeedback2();
	}
	
	public IFeedbackRepository getFeedbackRepository() {
		return feedbackRepository;
	}
	public void setFeedbackRepository(IFeedbackRepository feedbackRepository) {
		this.feedbackRepository = feedbackRepository;
	}

	@Override
	public Page<Feedback> encadrantFeedbacks(int idCollab, int idEncadrant,Pageable p) {
		
		return feedbackRepository.encadrantFeedbacks(idCollab, idEncadrant,p);
	}
	@Override
	public Page<Feedback> adminFeedbacks(int idCollab,Pageable p) {
		
		return feedbackRepository.adminFeedbacks(idCollab,p);
	}
	@Override
	public Page<Feedback> managerFeedbacks(int idCollab,Pageable p) {
		return feedbackRepository.managerFeedbacks(idCollab, p);
	}
	@Override
	public Page<Feedback> collabFeedbacks(int idC, Pageable p) {
	    return feedbackRepository.collabFeedbacks(idC, p);
	}

}
