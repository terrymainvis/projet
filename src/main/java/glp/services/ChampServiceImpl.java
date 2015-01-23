package glp.services;

import glp.dao.ChampDao;
import glp.domain.Categorie;
import glp.domain.Champ;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChampServiceImpl implements ChampService {

	@Autowired
	ChampDao champDao;
	
	@Override
	@Transactional
	public int insertRow(Champ champ) {
		return champDao.insertRow(champ);
	}


	@Override
	@Transactional
	public Champ getRowById(int id) {
		return champDao.getRowById(id);
	}

	@Override
	@Transactional
	public int updateRow(Champ champ) {
		return champDao.updateRow(champ);
	}

	@Override
	@Transactional
	public int deleteRow(int id) {
		return champDao.deleteRow(id);
	}


	@Override
	@Transactional
	public List<Champ> getListByCat(Categorie cat) {
		return champDao.getListByCat(cat.getId());
	}

	
}
