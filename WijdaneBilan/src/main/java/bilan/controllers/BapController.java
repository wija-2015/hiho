package bilan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bilan.dao.IAdminRepository;
import bilan.entities.Managerrh;
import bilan.entities.Bap;
import bilan.service.IBapService;

@RestController
@RequestMapping("baps")
public class BapController {

@Autowired
private IBapService bapService;

@RequestMapping(value="findAll", method = RequestMethod.GET)
public List<Bap> getBaps(){
return bapService.toutsBaps();
}
@RequestMapping(value="save", method = RequestMethod.GET)
public Bap saveBap(Bap c){
return bapService.ajouterBap(c);
}
@RequestMapping(value="/{id}", method = RequestMethod.GET)
public Bap findAdmin(@PathVariable("id") int id){
	return bapService.trouverBap(id);
}
@RequestMapping(value="/update/{id}/{mode}", method = RequestMethod.GET)
public int updateAdmin(@PathVariable("nom") String mode, @PathVariable("id") int id){
	 return bapService.modifierBap(mode, id);
}
@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
public int deleteManager(@PathVariable("id") int id){
 return bapService.supprimerBap(id);
}

public IBapService getBapService() {
	return bapService;
}
public void setBapService(IBapService bapService) {
	this.bapService = bapService;
}
}
