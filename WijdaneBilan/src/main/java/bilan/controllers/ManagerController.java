package bilan.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bilan.dao.ICollabRepository;
import bilan.entities.Collaborateur;
import bilan.entities.Managerrh;
import bilan.service.IManagerService;

@RestController
@RequestMapping("managers")
public class ManagerController {

@Autowired
private IManagerService managerService;

@RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
public int updateManager(@PathVariable("id")  int id,@RequestBody Managerrh c){
	 return managerService.modifierManager(c.getNomUser(), c.getPrenomUser(),c.getMailUser(),c.getMatriculeUser(), id);
}
@RequestMapping(value="findAll", method = RequestMethod.GET)
public List<Managerrh> getManagers(){
return managerService.toutsManagers();
}
@RequestMapping(value="save", method = RequestMethod.POST,consumes={"application/json"},produces ={"application/json"})
public Managerrh saveManager(@RequestBody Managerrh m, HttpServletResponse response){
	return managerService.ajouterManager(m) ;
}
@RequestMapping(value="/{id}", method = RequestMethod.GET)
public Managerrh findCollab(@PathVariable("id") int id){
	return managerService.trouverManager(id);
}
@RequestMapping(value="signin", method = RequestMethod.POST,consumes={"application/json"},produces ={"application/json"})
public long signinManager(@RequestBody Managerrh m, HttpServletResponse response){
	 if(managerService.verify(m.getMailUser(), m.getMatriculeUser())==0) {
		 return 0 ;
	 }
	 else 
		 return managerService.getIdManager(m.getMailUser(), m.getMatriculeUser());
}
@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
public int deleteManager(@PathVariable("id") int id){
   return managerService.supprimerManager(id);
}
@RequestMapping(value="/collabs/{id}", method = RequestMethod.GET)
public List<Collaborateur> findManagerCollabs(@PathVariable("id") int id){
	return managerService.trouverManagerCollabs(id);
}
public IManagerService getCollabService() {
	return managerService;
}
public void setCollabService(IManagerService managerService) {
	this.managerService = managerService;
}

}

