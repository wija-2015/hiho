package bilan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import bilan.entities.EvaluationObjectif;


public interface IEvaluationObjectifRepository extends JpaRepository<EvaluationObjectif, Long>{
	
	
	@Query("select a from EvaluationObjectif a where a.collaborateur.idCollaborateur like :x and a.encadrant.idEncadrant like :y "
			+ "and a.objectif.idObjectif like :z")
	public EvaluationObjectif findEvaluationObjectif(@Param("x")int idC, @Param("y")int idE, @Param("z")int idO);
	
	
}
