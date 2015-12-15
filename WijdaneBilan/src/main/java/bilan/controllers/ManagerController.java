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
@RequestMapping(value="/update/{id}/{nom}/{prenom}", method = RequestMethod.PUT)
public int updateManager(@PathVariable("nom") String nom,@PathVariable("prenom") String prenom,@PathVariable("id") int id){
	 return managerService.modifierManager(nom, prenom, id);
}
@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
public int deleteManager(@PathVariable("id") int id){
   return managerService.supprimerManager(id);
}
@RequestMapping(value="/collabs/{id}", method = RequestMethod.GET)
public List<Collaborateur> findManagerCollabs(@PathVariable("id") int id){
	return managerService.trouverManagerCollabs(id);
}

/*@RequestMapping(value="/add")
public Client addClient(ClientDTO clientDTO)
{
	Client c  = new Client();
	c.setNomClient(clientDTO.getNom());
	c.setPrenomClient(clientDTO.getPrenom());

	//c = clientService.save(c);
	return c;
	
}*/

/*
@RequestMapping("/produits")
public Page<Produit> getProduits(int page){
return produitRepository.findAll(new PageRequest(page, 5));
}
@RequestMapping("/produitsParMC")
public Page<Produit> getProduits(String mc,int page){
return produitRepository.produitParMC("%"+mc+"%", new PageRequest(page, 5));
}
@RequestMapping("/get")
public Produit getProduit(Long ref){
return produitRepository.findOne(ref);
}
@RequestMapping("/delete")
public boolean delete(Long ref){
produitRepository.delete(ref);
return true;
}
@RequestMapping("/update")
public Produit update(Produit p){
produitRepository.saveAndFlush(p);
return p;
}*/
public IManagerService getCollabService() {
	return managerService;
}
public void setCollabService(IManagerService managerService) {
	this.managerService = managerService;
}

}

