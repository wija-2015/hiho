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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bilan.dtos.CollaborateurDTO;
import bilan.dtos.EncadrantDTO;
import bilan.entities.Collaborateur;
import bilan.entities.Encadrant;
import bilan.entities.Managerrh;
import bilan.entities.Profil;
import bilan.service.IEncadrantService;
import bilan.service.IProfilService;

@RestController
@RequestMapping("encadrants")
public class EncadrantController {

@Autowired
private IEncadrantService encadrantService;
@Autowired
private IProfilService profilService;

@ResponseBody
@RequestMapping(value="findAll", method = RequestMethod.GET)
public List<Encadrant> getManagers(){
return encadrantService.toutsEncadrants();
}
@RequestMapping(value="save", method = RequestMethod.POST,consumes={"application/json"},produces ={"application/json"})
public Encadrant saveEncadrant(@RequestBody EncadrantDTO c,HttpServletResponse response){

	Encadrant enc=new Encadrant();
	enc.setNomUser(c.getNomUser());
	enc.setPrenomUser(c.getPrenomUser());
	enc.setMailUser(c.getMailUser());
	enc.setMatriculeUser(c.getMatriculeUser());
	enc.setPassword(c.getPassword());
	Profil p= new Profil();
	p=profilService.trouverProfil(c.getIdProfil());
	enc.setProfil(p);
	return encadrantService.ajouterEncadrant(enc) ;
}
@RequestMapping(value="/{id}", method = RequestMethod.GET)
public Encadrant findCollab(@PathVariable("id") int id){
	return encadrantService.trouverEncadrant(id);
}
@RequestMapping(value="/update/{id}/{nom}/{prenom}", method = RequestMethod.PUT)
public int updateManager(@PathVariable("nom") String nom,@PathVariable("prenom") String prenom,@PathVariable("id") int id){
	 return encadrantService.modifierEncadrant(nom, prenom, id);
}
@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
public int deleteManager(@PathVariable("id") int id){
   return encadrantService.supprimerEncadrant(id);
}
@RequestMapping(value="/collabs/{id}", method = RequestMethod.GET)
public List<Collaborateur> findManagerCollabs(@PathVariable("id") int id){
	return encadrantService.trouverEncadrantCollabs(id);
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
public IEncadrantService getEncadrantService() {
	return encadrantService;
}
public void setEncadrantService(IEncadrantService encadrantService) {
	this.encadrantService = encadrantService;
}
}

