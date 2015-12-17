package bilan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import bilan.entities.Categorie;

public interface ICategorieRepository extends JpaRepository<Categorie, Long>{
	
	
	@Query("select a from Categorie a where a.idCategorie like :x")
	public Categorie findCategorie(@Param("x")int id);
	
	@Modifying
	@Transactional
	@Query("delete Categorie a where a.idCategorie = ?1")
	public int deleteCategorie(int id);
	
	@Modifying
	@Transactional
	@Query("update Categorie a set a.nomCategorie= :nom where a.idCategorie = :x")
	public int updateCategorie(@Param("nom")String nom,@Param("x")int id);
	
	@Query("select m from Categorie m")
	public List<Categorie> findAllCategories();
	
}
