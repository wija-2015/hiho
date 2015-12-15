package bilan.service;

import bilan.entities.EvaluationObjectif;

public interface IEvaluationObjectifService {
	
	public EvaluationObjectif trouverEvaluationObjectif(int idC,int idE,int idO);
	public EvaluationObjectif ajouterEvaluationObjectif(EvaluationObjectif eval);
	
}
