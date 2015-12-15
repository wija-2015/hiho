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

import bilan.entities.Profil;
import bilan.entities.Projet;
import bilan.service.IProfilService;

@RestController
@RequestMapping("profils")
public class ProfilController {

@Autowired
private IProfilService profilService;

@RequestMapping(value="findAll", method = RequestMethod.GET)
public List<Profil> getProfils(){
return profilService.toutsProfils();
}
@RequestMapping(value="save", method = RequestMethod.POST,consumes={"application/json"},produces ={"application/json"})
public Profil saveProfil(@RequestBody Profil p, HttpServletResponse response){
	return	profilService.ajouterProfil(p);
}
@RequestMapping(value="/{id}", method = RequestMethod.GET)
public Profil findProfil(@PathVariable("id") int id){
	return profilService.trouverProfil(id);
}
@RequestMapping(value="/update/{id}/{nom}/{prenom}", method = RequestMethod.GET)
public int updateProfil(@PathVariable("nom") String nom,@PathVariable("id") int id){
	 return profilService.modifierProfil(nom, id);
}
@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
public int deleteProfil(@PathVariable("id") int id){
   return profilService.supprimerProfil(id);
}

public IProfilService getProfilService() {
	return profilService;
}
public void setProfilService(IProfilService profilService) {
	this.profilService = profilService;
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

}

