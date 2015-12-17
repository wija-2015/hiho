package bilan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import bilan.entities.Collaborateur;
import bilan.entities.Encadrant;
import bilan.entities.Managerrh;

public interface IEncadrantRepository extends JpaRepository<Encadrant, Long>{
	
	
	@Query("select e from Encadrant e where e.idEncadrant like :x")
	public Encadrant findEncadrant(@Param("x")int id);
	
	@Modifying
	@Transactional
	@Query("delete Encadrant c where c.idEncadrant = ?1")
	public int deleteEncadrant(int id);
	
	@Query("select count(c) from Encadrant c where c.mailUser like :x and c.matriculeUser like :y")
	public long verify(@Param("x")String mail,@Param("y")String matricule);	
	@Query("select c.idEncadrant from Encadrant c where c.mailUser like :x and c.matriculeUser like :y")
	public long getIdEncadrant(@Param("x")String mail,@Param("y")String matricule);
	
	@Modifying
	@Transactional
	@Query("update Encadrant c set c.nomUser= :nom, c.prenomUser= :prenom, c.mailUser= :email,c.matriculeUser= :matricule where c.idEncadrant = :x")
	public int updateEncadrant(@Param("nom")String nom,@Param("prenom")String prenom,@Param("email") String email,@Param("matricule") String matricule,@Param("x")int id);
	
	@Query("select c.nomUser,c.mailUser from Collaborateur c, EvaluationObjectif ev where ev.encadrant.idEncadrant like :x and c.idCollaborateur= ev.collaborateur.idCollaborateur")
	public List<Collaborateur> findEncadrantCollabs(@Param("x")int id);
	
	@Query("select e from Encadrant e")
	public List<Encadrant> findAllEncadrants();
	
}
