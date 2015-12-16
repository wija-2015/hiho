package bilan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import bilan.entities.Objectif;

public interface IObjectifRepository extends JpaRepository<Objectif, Long>{
	
	
	@Modifying
	@Transactional
	@Query("delete Objectif a where a.idObjectif = ?1")
	public int deleteObjectif(int id);
	
	@Modifying
	@Transactional
	@Query("update Objectif a set a.description= :desc where a.idObjectif = :x")
	public int updateAObjectif(@Param("desc")String desc, @Param("x")int id);
	
	@Query("select distinct o from Objectif o,EvaluationObjectif ev where o.idObjectif= ev.objectif.idObjectif and ev.collaborateur.idCollaborateur like :idC")
	public List<Objectif> ficheCollab(@Param("idC")int idC);

	public List<Objectif> findAll();
	
}

