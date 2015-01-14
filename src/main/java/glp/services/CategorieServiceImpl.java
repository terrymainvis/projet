package glp.services;

import glp.dao.CategorieDao;
import glp.domain.Categorie;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	CategorieDao categorieDao;
	
	@Override
	@Transactional
	public int insertRow(Categorie cat) {
		return categorieDao.insertRow(cat);
	}

	@Override
	@Transactional
	public List<Categorie> getList() {
		return categorieDao.getList();
	}

	@Override
	@Transactional
	public Categorie getRowById(int id) {
		return categorieDao.getRowById(id);
	}

	@Override
	@Transactional
	public int updateRow(Categorie cat) {
		return categorieDao.updateRow(cat);
	}

	@Override
	@Transactional
	public int deleteRow(int id) {
		return categorieDao.deleteRow(id);
	}
	
	@Override
	@Transactional
	public int getIdByLib(String lib) {
		return categorieDao.getIdByLib(lib);
	}
}
