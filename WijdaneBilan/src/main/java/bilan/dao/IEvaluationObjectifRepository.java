package bilan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import bilan.entities.EvaluationObjectif;
//import bilan.entities.Managerrh;

public interface IEvaluationObjectifRepository extends JpaRepository<EvaluationObjectif, Long>{
	
	
	@Query("select a from EvaluationObjectif a where a.collaborateur.idCollaborateur like :x and a.encadrant.idEncadrant like :y "
			+ "and a.objectif.idObjectif like :z")
	public EvaluationObjectif findEvaluationObjectif(@Param("x")int idC, @Param("y")int idE, @Param("z")int idO);
	
	//@Modifying
	//@Transactional
	//@Query("delete Profil a where a.idProfil = ?1")
	//public int deleteProfil(int id);
	
	//@Modifying
	//@Transactional
	//@Query("update Profil a set a.nomProfil= :nom where a.idProfil = :x")
	//public int updateProfil(@Param("nom")String nom,@Param("x")int id);
	
	//@Query("select m.nomProfil from Profil m")
	//public List<Profil> findAllProfils();
	
	//public List<Admin> findAll();
	
}
