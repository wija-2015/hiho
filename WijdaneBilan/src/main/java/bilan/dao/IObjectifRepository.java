package bilan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import bilan.entities.Objectif;

public interface IObjectifRepository extends JpaRepository<Objectif, Long>{
	
	
	//@Query("select a from Objectif a where a.idObjectif like :x")
	//public Objectif findAdmin(@Param("x")int id);
	
	@Modifying
	@Transactional
	@Query("delete Objectif a where a.idObjectif = ?1")
	public int deleteObjectif(int id);
	
	@Modifying
	@Transactional
	@Query("update Objectif a set a.description= :desc where a.idObjectif = :x")
	public int updateAObjectif(@Param("desc")String desc, @Param("x")int id);
	
	//@Query("select m.nomUser,m.mailUser,m.matriculeUser from Managerrh m")
	//public List<Managerrh> findAllManagers();
	
	//@Query("select a.nomUser,a.prenomUser,a.mailUser from Objectif a")
	//public List<Objectif> findAllAdmins();

	public List<Objectif> findAll();
	
}

