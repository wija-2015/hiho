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
	
	//@Query("select p from Admin p where p.nom like :x")
	//public Page<User> produitParMC(@Param("x")String mc,Pageable p);
	
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
	@Query("update Collaborateur c set c.nomUser= :nom, c.prenomUser= :prenom , c.mailUser= :email where c.idCollaborateur = :x")
	public int updateCollab(@Param("nom")String nom,@Param("prenom")String prenom,@Param("email") String email,@Param("x")int id);
	
	

	/*@Query("select c.nomUser, c.prenomUser, c.matriculeUser,c.dateRecrutement, c.mailUser, m.nomUser, m.prenomUser from Collaborateur c, Managerrh m where m.idManagerrh=c.managerrh.idManagerrh")
	public List<Collaborateur> findAllCollabs();*/
	
	//@Query("insert into User (id, name) select c.id, c.name from Customer c where ...")
	//public User updateUser(@Param("nom")String nom,@Param("prenom")String prenom);

	
	//public List<User> findByNomUser(String des);
	//public User findOne(String nom); 

}