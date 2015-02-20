package glp.services;

import glp.dao.AnnonceDao;
import glp.dao.CategorieDao;
import glp.domain.Annonce;
import glp.domain.Utilisateur;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnonceServiceImpl implements AnnonceService {

	@Autowired
	AnnonceDao annonceDao;
	
	@Autowired
	CategorieDao categorieDao;
	
	@Override
	@Transactional
	public int insertRow(Annonce ann) {
		return annonceDao.insertRow(ann);
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
	public int updateRow(Annonce annonce) {
		return annonceDao.updateRow(annonce);
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
	public List<Annonce> getListByCatName(String catName) {
		return annonceDao.getListByCatName(catName);
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
	
	@Override
	@Transactional
	public List<Annonce> getListByMot(String searchText) { 
		return annonceDao.getListByMot(searchText);
	}

	@Override
	@Transactional
	public List<Annonce> getListByCatEtMot(String cat, String motcle) {
		return annonceDao.getListByCatEtMot(categorieDao.getIdByLib(cat), motcle);
	}
	
	@Override
	@Transactional
	public List<Annonce> getListAModerer() {
		return annonceDao.getListAModerer();
	}
	
	@Override
	@Transactional
	public List<Annonce> getListValides() {
		return annonceDao.getListValides();
	}

	@Override
	@Transactional
	public void supprimerAnnoncesUtilisateur(Utilisateur u) {
		annonceDao.supprimerAnnoncesUtilisateur(u);
	}

	@Override
	@Transactional
	public void supprimerAnnoncesCategorie(int catId) {
		annonceDao.supprimerAnnoncesCategorie(catId);
	}
	@Override
	public int nbAnnonceEnLigne() {
		return annonceDao.nbAnnonceEnLigne();
	}

	@Override
	public Map<String, Integer> getNbByCategorie() {
		return annonceDao.getNbByCategorie();
	}

}
