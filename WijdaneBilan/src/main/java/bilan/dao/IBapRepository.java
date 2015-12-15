package bilan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import bilan.entities.Bap;

public interface IBapRepository extends JpaRepository<Bap, Long>{
	
	
	@Query("select a from Bap a where a.idBap like :x")
	public Bap findBap(@Param("x")int id);
	
	@Modifying
	@Transactional
	@Query("delete Bap a where a.idBap = ?1")
	public int deleteBap(int id);
	
	@Modifying
	@Transactional
	@Query("update Bap a set a.mode= :mode where a.idBap = :x")
	public int updateBap(@Param("mode")String mode, @Param("x")int id);
	
	@Query("select m.dateBap,m.status,m.mode,m.poste,m.noteFinaleBap from Bap m")
	public List<Bap> findAllBaps();
	
}
