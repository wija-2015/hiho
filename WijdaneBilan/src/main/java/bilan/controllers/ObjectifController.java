package bilan.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bilan.dtos.FeedbackDTO;
import bilan.dtos.ObjectifDTO;
import bilan.entities.Categorie;
import bilan.entities.Collaborateur;
import bilan.entities.Encadrant;
import bilan.entities.EvaluationObjectif;
import bilan.entities.Feedback;
import bilan.entities.Objectif;
import bilan.entities.Projet;
import bilan.entities.Qualification;
import bilan.entities.Theme;
import bilan.service.ICategorieService;
import bilan.service.ICollabService;
import bilan.service.IEncadrantService;
import bilan.service.IEvaluationObjectifService;
import bilan.service.IObjectifService;

@RestController
@RequestMapping("objectifs")
public class ObjectifController {

@Autowired
private IObjectifService objectifService;
@Autowired
private ICategorieService categorieService;
@Autowired
private IEncadrantService encadrantService;
@Autowired
private IEvaluationObjectifService evaluationObjectifService;
@Autowired
private ICollabService collaborateurService;

@RequestMapping(value="findAll", method = RequestMethod.GET)
public List<Objectif> getObjectifs(){
return objectifService.toutsObjectifs();
}
@RequestMapping(value="save", method = RequestMethod.POST,consumes={"application/json"},produces ={"application/json"})
public boolean saveObjectif(@RequestBody ObjectifDTO o,HttpServletResponse response){	
	Objectif obj = new Objectif() ;
	//Feedback feed = new Feedback() ;
	Categorie cat = new Categorie() ;
	cat=categorieService.trouverCategorie(o.getIdCategorie()) ;
	obj.setCategorie(cat);
	obj.setDescription(o.getDescription());
	obj.setDiffBapBip(o.getDiffBapBip());
	obj.setMoyenObj(o.getMoyenObj());
	 
      List<EvaluationObjectif> ev=new ArrayList<EvaluationObjectif>() ;
      List<Encadrant> encadrants= new ArrayList<Encadrant>() ;
     for(int i=0 ; i<=2 ; i++)
      {
    	  Encadrant e=new Encadrant();
    	  e=encadrantService.trouverEncadrant(o.getEvaluations().get(i).getIdEncadrant());
    	  encadrants.add(e);
      }
     
      Collaborateur col=new Collaborateur();
      col=collaborateurService.trouverCollab(1);
      String mesure="hhhhhhhhhhhh";
      System.out.println(mesure);
      for(int i=0 ; i<=2 ; i++)
      {
    	 ev.add(new EvaluationObjectif());
    	 //ev.get(i).setMesureObj(mesure);
    	 //ev.get(i).setPoidsObj(o.getEvaluations().get(i).getPoidsObj());
    	 //ev.get(i).setResultatObj(o.getEvaluations().get(i).getResultatObj());
    	 //ev.get(i).setNoteFinaleObj(o.getEvaluations().get(i).getNoteFinaleObj());
    	 ev.get(i).setEncadrant(encadrants.get(i));
    	 ev.get(i).setCollaborateur(col);
      }
      obj.setEvaluationobjectifs(ev);
      
      obj=objectifService.ajouterObjectif(obj);
      
      for(int i=0 ; i<=2 ; i++)
      {ev.get(i).setObjectif(obj);
      evaluationObjectifService.ajouterEvaluationObjectif(ev.get(i)) ;
      }
      
	 return true;
      }


public IObjectifService getObjectifService() {
	return objectifService;
}
public void setObjectifService(IObjectifService objectifService) {
	this.objectifService = objectifService;
}

}
