package glp.services;

import glp.dao.ChampCompleteDao;
import glp.domain.Annonce;
import glp.domain.ChampComplete;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChampCompleteServiceImpl implements ChampCompleteService {

	@Autowired
	ChampCompleteDao ccDao;
	
	@Override
	@Transactional
	public int insertRow(ChampComplete cc) {
		return ccDao.insertRow(cc); 
	}

	@Override
	@Transactional
	public List<ChampComplete> getListByAnn(Annonce ann) {
		return ccDao.getListByAnn(ann.getId());
	}

	@Override
	@Transactional
	public ChampComplete getRowById(int id) {
		return ccDao.getRowById(id);
	}

	@Override
	@Transactional
	public int updateRow(ChampComplete cc) {
		return ccDao.updateRow(cc);
	}

	@Override
	@Transactional
	public int deleteRow(int id) {
		return ccDao.deleteRow(id);
	}
	

}
