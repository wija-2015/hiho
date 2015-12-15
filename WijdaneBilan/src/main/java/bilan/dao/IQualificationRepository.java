  package bilan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import bilan.entities.Qualification;

public interface IQualificationRepository extends JpaRepository<Qualification, Long>{
	
	
	//@Query("select a from Objectif a where a.idObjectif like :x")
	//public Objectif findAdmin(@Param("x")int id);
	
	@Modifying
	@Transactional
	@Query("delete Qualification a where a.idQualification = ?1")
	public int deleteQualification(int id);
	
	@Modifying
	@Transactional
	@Query("update Qualification a set a.remarque= :rem where a.idQualification = :x")
	public int updateQualification(@Param("rem")String rem,@Param("x")int id);
	
}

