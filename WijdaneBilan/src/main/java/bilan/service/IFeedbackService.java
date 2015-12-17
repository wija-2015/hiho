package bilan.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import bilan.dtos.FeedbackDTO;
import bilan.entities.Feedback;

public interface IFeedbackService {
	
	
	public Feedback ajouterFeedback(Feedback f);
	public Page<Feedback> encadrantFeedbacks(int idCollab,int idEncadrant,Pageable p);
	public Page<Feedback> adminFeedbacks(int idCollab,Pageable p);
	public Page<Feedback> managerFeedbacks(int idCollab,Pageable p);
	public Page<Feedback> collabFeedbacks(int idCollab,Pageable p);
	public List<Feedback> collabFeedback2();
}
