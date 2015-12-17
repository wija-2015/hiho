package bilan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import bilan.entities.Theme;

public interface IThemeRepository extends JpaRepository<Theme, Long>{
	
	@Query("select a from Theme a where a.idTheme like :x")
	public Theme findTheme(@Param("x")int id);
	
	@Modifying
	@Transactional
	@Query("delete Theme a where a.idTheme = ?1")
	public int deleteTheme(int id);
	
	@Modifying
	@Transactional
	@Query("update Theme a set a.nomTheme= :nom where a.idTheme = :x")
	public int updateTheme(@Param("nom")String nom,@Param("x")int id);
	
	@Query("select m from Theme m")
	public List<Theme> findAllThemes();
	
	
}
