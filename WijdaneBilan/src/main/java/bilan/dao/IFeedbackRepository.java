package bilan.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import bilan.entities.Feedback;
//import bilan.entities.Managerrh;
import bilan.entities.Theme;

public interface IFeedbackRepository extends JpaRepository<Feedback, Long>{
		
	@Query("select a from Feedback a where a.collaborateur.idCollaborateur like :x and a.encadrant.idEncadrant like :y")
	public Page<Feedback> encadrantFeedbacks(@Param("x")int idC, @Param("y")int idE,Pageable p);
	@Query("select a from Feedback a where a.collaborateur.idCollaborateur like :x")
	public Page<Feedback> adminFeedbacks(@Param("x")int idC,Pageable p);
	@Query("select a from Feedback a where a.collaborateur.managerrh.idManagerrh like :y and a.collaborateur.idCollaborateur like :x")
	public Page<Feedback> managerFeedbacks(@Param("x")int idC, @Param("y")int idM,Pageable p);
	@Query("select a from Feedback a where a.collaborateur.idCollaborateur like :x")
	public Page<Feedback> collabFeedbacks(@Param("x")int idC,Pageable p);
	
	@Query("select a from Feedback a where a.collaborateur.idCollaborateur like 3 and a.encadrant.idEncadrant like 1")
	public List<Feedback> collabFeedback2();
	
	@Query("select f from Feedback f where f.idFeedback like :x")
	public Feedback findFeedback(@Param("x")int id);
	
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
