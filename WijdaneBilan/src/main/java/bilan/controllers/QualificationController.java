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
import bilan.dtos.FeedbackDTO;
import bilan.dtos.QualificationDTO;
import bilan.entities.Feedback;
import bilan.entities.Managerrh;
import bilan.entities.Qualification;
import bilan.service.IBapService;
import bilan.service.IQualificationService;

@RestController
@RequestMapping("qualifications")
public class QualificationController {

@Autowired
private IQualificationService qualificationService;

@RequestMapping(value="findAll", method = RequestMethod.GET)
public List<Qualification> getBaps(){
return qualificationService.toutsQualifications();
}
@RequestMapping(value="/update/{id}/{nom}", method = RequestMethod.GET)
public int updateAdmin(@PathVariable("nom") String nom, @PathVariable("id") int id){
	 return qualificationService.modifierQualification(nom, id);
}
@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
public int deleteManager(@PathVariable("id") int id){
   return qualificationService.supprimerQualification(id);
}
public IQualificationService getQualificationService() {
	return qualificationService;
}
public void setQualificationService(IQualificationService qualificationService) {
	this.qualificationService = qualificationService;
}



}
