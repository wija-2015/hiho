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
import bilan.entities.Projet;
import bilan.entities.Theme;
import bilan.service.IBapService;
import bilan.service.IThemeService;

@RestController
@RequestMapping("themes")
public class ThemeController {

@Autowired
private IThemeService themeService;

@RequestMapping(value="findAll", method = RequestMethod.GET)
public List<Theme> getBaps(){
return themeService.toutsThemes();
}
@RequestMapping(value="save", method = RequestMethod.POST,consumes={"application/json"},produces ={"application/json"})
public Theme saveTheme(@RequestBody Theme t, HttpServletResponse response){
return themeService.ajouterTheme(t);
}
@RequestMapping(value="/{id}", method = RequestMethod.GET)
public Theme findAdmin(@PathVariable("id") int id){
	return themeService.trouverTheme(id);
}
@RequestMapping(value="/update/{id}/{nom}", method = RequestMethod.GET)
public int updateAdmin(@PathVariable("nom") String nom, @PathVariable("id") int id){
	 return themeService.modifierTheme(nom, id);
}
@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
public int deleteManager(@PathVariable("id") int id){
   return themeService.supprimerTheme(id);
}
public IThemeService getThemeService() {
	return themeService;
}
public void setThemeService(IThemeService themeService) {
	this.themeService = themeService;
}

}
