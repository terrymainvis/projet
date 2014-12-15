package glp.services;

import glp.dao.AnnonceDao;
import glp.domain.Annonce;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnonceServiceImpl implements AnnonceService {

	@Autowired
	AnnonceDao annonceDao;
	
	@Override
	@Transactional
	public int insertRow(Annonce cat) {
		return annonceDao.insertRow(cat);
	}

	@Override
	@Transactional
	public List<Annonce> getList() {
		return annonceDao.getList();
	}

	@Override
	@Transactional
	public Annonce getRowById(int id) {
		return annonceDao.getRowById(id);
	}

	@Override
	@Transactional
	public int updateRow(Annonce cat) {
		return annonceDao.updateRow(cat);
	}

	@Override
	@Transactional
	public int deleteRow(int id) {
		return annonceDao.deleteRow(id);
	}

	@Override
	@Transactional
	public List<Annonce> getListByCat(int catId) {
		return annonceDao.getListByCat(catId);
	}

	@Override
	@Transactional
	public List<Annonce> getListRecent(int catId) {
		return annonceDao.getListRecent(catId);
	}

	@Override
	@Transactional
	public int getIdByLib(String lib) {
		// TODO Auto-generated method stub
		return 0;
	}
}
