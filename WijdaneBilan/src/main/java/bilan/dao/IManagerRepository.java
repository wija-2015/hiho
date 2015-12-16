package bilan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import bilan.entities.Collaborateur;
import bilan.entities.Managerrh;

public interface IManagerRepository extends JpaRepository<Managerrh, Long>{
	
	
	@Query("select c from Managerrh c where c.idManagerrh like :x")
	public Managerrh findManager(@Param("x")int id);
	
	@Modifying
	@Transactional
	@Query("delete Managerrh c where c.idManagerrh = ?1")
	public int deleteManager(int id);
	
	@Query("select count(c) from Managerrh c where c.mailUser like :x and c.matriculeUser like :y")
	public long verify(@Param("x")String mail,@Param("y")String matricule);
	@Query("select m.idManagerrh from Managerrh m where m.mailUser like :x and m.matriculeUser like :y")
	public long getIdManager(@Param("x")String mail,@Param("y")String matricule);
	
	@Modifying
	@Transactional
	@Query("update Managerrh c set c.nomUser= :nom, c.prenomUser= :prenom, c.mailUser= :email,c.matriculeUser= :matricule where c.idManagerrh = :x")
	public int updateManager(@Param("nom")String nom,@Param("prenom")String prenom,@Param("email") String email,@Param("matricule") String matricule,@Param("x")int id);
	
	@Query("select c from Collaborateur c where c.managerrh.idManagerrh like :x")
	public List<Collaborateur> findManagerCollabs(@Param("x")int id);
	
	public List<Managerrh> findAll();
	
}
