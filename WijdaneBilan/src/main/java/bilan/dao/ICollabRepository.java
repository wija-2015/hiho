package bilan.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import bilan.entities.Collaborateur;


public interface ICollabRepository extends JpaRepository<Collaborateur, Long> {
	
	
	@Query("select c from Collaborateur c where c.idCollaborateur like :x")
	public Collaborateur findCollab(@Param("x")int id);
	
	@Query("select count(c) from Collaborateur c where c.mailUser like :x and c.matriculeUser like :y")
	public long verify(@Param("x")String mail,@Param("y")String matricule);	
	@Query("select c.idCollaborateur from Collaborateur c where c.mailUser like :x and c.matriculeUser like :y")
	public long getIdCollab(@Param("x")String mail,@Param("y")String matricule);
	
	@Modifying
	@Transactional
	@Query("delete Collaborateur c where c.idCollaborateur = ?1")
	public int deleteCollab(int id);

	@Modifying
	@Transactional
	@Query("update Collaborateur c set c.nomUser= :nom, c.prenomUser= :prenom , c.mailUser= :email,c.matriculeUser= :matricule where c.idCollaborateur = :x")
	public int updateCollab(@Param("nom")String nom,@Param("prenom")String prenom,@Param("email") String email,@Param("matricule") String matricule,@Param("x")int id);

}