package bilan.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bilan.dao.ICollabRepository;
import bilan.dtos.CollaborateurDTO;
import bilan.entities.Collaborateur;
import bilan.entities.Managerrh;
import bilan.service.ICollabService;
import bilan.service.IManagerService;

@RestController
@RequestMapping("collaborateurs")
public class CollabController {

@Autowired
private ICollabService collabService;
@Autowired
private IManagerService managerService ;


@RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
public int updateCollab(@PathVariable("id")  int id,@RequestBody Collaborateur c){
	 return collabService.modifierCollab(c.getNomUser(), c.getPrenomUser(),c.getMailUser(),c.getMatriculeUser(), id);
}
@RequestMapping(value="findAll", method = RequestMethod.GET)
public List<Collaborateur> getCollabs(){
return  collabService.toutsCollabs();
}
@RequestMapping(value="signin", method = RequestMethod.POST,consumes={"application/json"},produces ={"application/json"})
public long signinCollab(@RequestBody Collaborateur c, HttpServletResponse response){
	 if(collabService.verify(c.getMailUser(), c.getMatriculeUser())==0) {
		 return 0 ;
	 }
	 else 
		 return collabService.getIdCollab(c.getMailUser(), c.getMatriculeUser());
} 
@RequestMapping(value="save", method = RequestMethod.POST,consumes={"application/json"},produces ={"application/json"})
public Collaborateur saveCollab(@RequestBody CollaborateurDTO c,HttpServletResponse response){

	Collaborateur collab=new Collaborateur();
	collab.setNomUser(c.getNomUser());
	collab.setPrenomUser(c.getPrenomUser());
	collab.setMailUser(c.getMailUser());
	collab.setMatriculeUser(c.getMatriculeUser());
	collab.setDateRecrutement(c.getDateRecrutement());
	collab.setPassword(c.getPassword());
	Managerrh Manager = new Managerrh();
	Manager = managerService.trouverManager(c.getIdManagerrh()) ;
	collab.setManagerrh(Manager);
	return collabService.ajouterCollab(collab) ;
}
@RequestMapping(value="/collab/{id}", method = RequestMethod.GET)
public Collaborateur findCollab(@PathVariable("id") int id){
	return collabService.trouverCollab(id);
}
@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
public int deleteCollab(@PathVariable("id") int id){
   return collabService.supprimerCollab(id);
}

public ICollabService getCollabService() {
	return collabService;
}
public void setCollabService(ICollabService collabService) {
	this.collabService = collabService;
}

}

