package bilan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bilan.dao.IBapRepository;
import bilan.entities.Bap;

/**
 * @author WIJDANE
 *
 */
@Service
@Transactional
public class IBapServiceImpl implements IBapService{
	
	@Autowired
	private IBapRepository bapRepository;

	@Override
	public List<Bap> toutsBaps() {
		// TODO Auto-generated method stub
		return bapRepository.findAllBaps();
	}

	@Override
	public Bap ajouterBap(Bap a) {
		// TODO Auto-generated method stub
		return bapRepository.save(a);
	}

	@Override
	public Bap trouverBap(int id) {
		return bapRepository.findBap(id);
	}

	@Override
	public int supprimerBap(int id) {
		// TODO Auto-generated methBap(id);
		return bapRepository.deleteBap(id);
	}

	@Override
	public int modifierBap(String mode, int id) {
		// TODO Auto-generated method stub
		return bapRepository.updateBap(mode, id);
	}

	public IBapRepository getBapRepository() {
		return bapRepository;
	}

	public void setBapRepository(IBapRepository bapRepository) {
		this.bapRepository = bapRepository;
	}
	
	
}
