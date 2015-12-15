package bilan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bilan.dao.IAdminRepository;
import bilan.entities.Managerrh;
import bilan.entities.EvaluationObjectif;
import bilan.service.IBapService;
import bilan.service.IEvaluationObjectifService;

@RestController
@RequestMapping("evaluationObjectifs")
public class EvaluationObjectifController {

@Autowired
private IEvaluationObjectifService evaluationObjectifService;


@RequestMapping(value="/{idC}/{idE}/{idO}", method = RequestMethod.GET)
public EvaluationObjectif findEvaluationObjectif(@PathVariable("idC") int idC,@PathVariable("idE") int idE,@PathVariable("idO") int idO){
	return evaluationObjectifService.trouverEvaluationObjectif(idC, idE, idO);
}


public IEvaluationObjectifService getEvaluationObjectifService() {
	return evaluationObjectifService;
}


public void setEvaluationObjectifService(
		IEvaluationObjectifService evaluationObjectifService) {
	this.evaluationObjectifService = evaluationObjectifService;
}



}
