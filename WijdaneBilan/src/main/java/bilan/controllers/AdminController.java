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
import org.springframework.web.bind.annotation.RestController;

import bilan.dao.IAdminRepository;
import bilan.entities.Managerrh;
import bilan.entities.Admin;
import bilan.service.IAdminService;

@RestController
@RequestMapping("admins")
public class AdminController {

@Autowired
private IAdminService adminService;

@RequestMapping(value="findAll", method = RequestMethod.GET)
public List<Admin> getAdmins(){
return adminService.toutsAdmins();
}
@RequestMapping(value="save", method = RequestMethod.GET)
public Admin saveAdmin(Admin c){
	adminService.ajouterAdmin(c);
return c;
}
@RequestMapping(value="signin", method = RequestMethod.POST,consumes={"application/json"},produces ={"application/json"})
public long signinAdmin(@RequestBody Admin a, HttpServletResponse response){
	 if(adminService.verify(a.getMailUser(), a.getMatriculeUser())==0) {
		 return 0 ;
	 }
	 else 
		 return adminService.getIdAdmin(a.getMailUser(), a.getMatriculeUser());
}
@RequestMapping(value="/{id}", method = RequestMethod.GET)
public Admin findAdmin(@PathVariable("id") int id){
	return adminService.trouverAdmin(id);
}
@RequestMapping(value="/update/{id}/{nom}/{prenom}", method = RequestMethod.GET)
public int updateAdmin(@PathVariable("nom") String nom,@PathVariable("prenom") String prenom,@PathVariable("id") int id){
	 return adminService.modifierAdmin(nom, prenom, id);
}
@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
public int deleteManager(@PathVariable("id") int id){
   return adminService.supprimerAdmin(id);
}
@RequestMapping(value="/managers", method = RequestMethod.GET)
public List<Managerrh> findAllManagers(){
	return adminService.trouverManagers();
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
public IAdminService getAdminService() {
	return adminService;
}
public void setAdminService(IAdminService adminService) {
	this.adminService = adminService;
}

}

