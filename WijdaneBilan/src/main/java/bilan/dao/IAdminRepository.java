package bilan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import bilan.entities.Admin;
import bilan.entities.Managerrh;

public interface IAdminRepository extends JpaRepository<Admin, Long>{
	
	
	@Query("select a from Admin a where a.idAdmin like :x")
	public Admin findAdmin(@Param("x")int id);
	
	@Modifying
	@Transactional
	@Query("delete Admin a where a.idAdmin = ?1")
	public int deleteAdmin(int id);
	
	@Query("select count(c) from Admin c where c.mailUser like :x and c.matriculeUser like :y")
	public long verify(@Param("x")String mail,@Param("y")String matricule);
	@Query("select a.idAdmin from Admin a where a.mailUser like :x and a.matriculeUser like :y")
	public long getIdAdmin(@Param("x")String mail,@Param("y")String matricule);
	
	@Modifying
	@Transactional
	@Query("update Admin a set a.nomUser= :nom, a.prenomUser= :prenom where a.idAdmin = :x")
	public int updateAdmin(@Param("nom")String nom,@Param("prenom")String prenom,@Param("x")int id);
	
	@Query("select m.nomUser,m.mailUser,m.matriculeUser from Managerrh m")
	public List<Managerrh> findAllManagers();
	
	@Query("select a.nomUser,a.prenomUser,a.mailUser from Admin a")
	public List<Admin> findAllAdmins();

	public List<Admin> findAll();
	
}
