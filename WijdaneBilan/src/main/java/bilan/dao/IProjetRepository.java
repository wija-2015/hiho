package bilan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import bilan.entities.Projet;
//import bilan.entities.Managerrh;

public interface IProjetRepository extends JpaRepository<Projet, Long>{
	
	@Query("select a from Projet a where a.idProjet like :x")
	public Projet findProjet(@Param("x")int id);
	
	@Modifying
	@Transactional
	@Query("delete Projet a where a.idProjet = ?1")
	public int deleteProjet(int id);
	
	@Modifying
	@Transactional
	@Query("update Projet a set a.nomProjet= :nom where a.idProjet = :x")
	public int updateProjet(@Param("nom")String nom,@Param("x")int id);
	
	@Query("select m from Projet m")
	public List<Projet> findAllProjets();
	
	//public List<Admin> findAll();
	
}

