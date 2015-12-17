package bilan.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bilan.dao.IFeedbackRepository;
import bilan.dtos.CollaborateurDTO;
import bilan.dtos.FeedbackDTO;
import bilan.dtos.QualificationDTO;
import bilan.entities.Collaborateur;
import bilan.entities.Encadrant;
import bilan.entities.Feedback;
import bilan.entities.Managerrh;
import bilan.entities.Projet;
import bilan.entities.Qualification;
import bilan.entities.Theme;
import bilan.mailSender.SmtpMailSender;
import bilan.service.ICollabService;
import bilan.service.IEncadrantService;
import bilan.service.IFeedbackService;
import bilan.service.IProjetService;
import bilan.service.IQualificationService;
import bilan.service.IThemeService;

@RestController
@RequestMapping("feedbacks")
public class FeedbackController {

	@Autowired
	private IFeedbackService feedbackService;
	@Autowired
	private ICollabService collabService;
	@Autowired
	private IProjetService projetService;
	@Autowired
	private IQualificationService qualificatioService;
	@Autowired
	private IEncadrantService encadrantService;
	@Autowired
	private IThemeService themeService;
	@Autowired
	private SmtpMailSender smtpMailSender ; 

	@RequestMapping(value="save", method = RequestMethod.POST,consumes={"application/json"},produces ={"application/json"})
	public boolean saveFeedback(@RequestBody FeedbackDTO f,HttpServletResponse response) throws MessagingException{	
		Feedback feed = new Feedback() ;
		Collaborateur c = new Collaborateur() ;
		Encadrant e = new Encadrant() ;
		e=encadrantService.trouverEncadrant(f.getIdEncadrant()) ;
		 c=collabService.trouverCollab(f.getIdCollaborateur()) ;
		 feed.setCollaborateur(c);
		 feed.setEncadrant(e);
		 Projet p= new Projet() ;
		 p=projetService.trouverProjet(f.getIdProjet()) ;
		 feed.setProjet(p);
		 feed.setCommentaire(f.getCommentaire());
		 feed.setDateDebut(f.getDateDebut());
		 feed.setDateFin(f.getDateFin());
		 feed.setNbJours(f.getNbJours());
		 feed.setNoteGlobale(f.getNoteGlobale());
		 feed.setNbThemes(f.getNbThemes());
		 feed.setRole(f.getRole());
		 feed.setTotalPoints(f.getTotalPoints());
		 
	      List<Qualification> q=new ArrayList<Qualification>() ;
	      List<Theme> theme= new ArrayList<Theme>() ;
	      theme=themeService.toutsThemes() ;

	      for(int i=0 ; i<=7 ; i++)
	      {
	    	 q.add(new Qualification()) ;
	    	 q.get(i).setNomQualification(f.getQualification().get(i).getNomQualification());
	    	 q.get(i).setPoidsQualification(f.getQualification().get(i).getPoidsQualification());
	    	 q.get(i).setRemarque(f.getQualification().get(i).getRemarque()) ;
	    	 q.get(i).setTheme(theme.get(i)) ;
	    	// qualificatioService.ajouterQualification(q.get(i)) ;
	      }
	      feed.setQualifications(q);
	      
	      feed=feedbackService.ajouterFeedback(feed) ;
	      for(int i=0 ; i<=7 ; i++)
	      {q.get(i).setFeedback(feed);
	      qualificatioService.ajouterQualification(q.get(i)) ;
	    	  
	      }
	      smtpMailSender.send("wijdane.khattat@gmail.com", "Un feedback à été crée", "Un feedback est crée ");
	      //smtpMailSender.send(c.getManagerrh().getMailUser(), "Un feedback à été crée", "Un feedback est crée ");
			
	      return true;
}
	
	@RequestMapping(value="/encadrantFeedbacks/{idCollaborateur}/{idEncadrant}/{page}",method=RequestMethod.GET)
	public Page<Feedback> encadrantFeedbacks(@PathVariable("idCollaborateur") int idCollaborateur,
			                               @PathVariable("idEncadrant") int idEncadrant,
			                               @PathVariable("page") int page) {	
		return feedbackService.encadrantFeedbacks(idCollaborateur, idEncadrant, new PageRequest(page, 1));
	}
	@RequestMapping(value="/adminFeedbacks/{idCollaborateur}/{page}",method=RequestMethod.GET)
	public Page<Feedback> adminFeedbacks(@PathVariable("idCollaborateur") int idCollaborateur,	                           
			                               @PathVariable("page") int page) {
		return feedbackService.adminFeedbacks(idCollaborateur, new PageRequest(page, 1));
	}
	@RequestMapping(value="/managerFeedbacks/{idCollaborateur}/{page}",method=RequestMethod.GET)
	public Page<Feedback> managerFeedbacks(@PathVariable("idCollaborateur") int idCollaborateur,
			                               @PathVariable("page") int page) {	
		return feedbackService.managerFeedbacks(idCollaborateur, new PageRequest(page, 1));
	}
@RequestMapping(value="/collabFeedbacks2",method=RequestMethod.GET)
public List<Feedback> collabFeedbacks2() {
	return feedbackService.collabFeedback2();
}


public IFeedbackService getFeedbackService() {
	return feedbackService;
}


public void setFeedbackService(IFeedbackService feedbackService) {
	feedbackService = feedbackService;
}



}
