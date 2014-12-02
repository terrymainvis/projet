package glp.services;

import glp.dao.AnnonceDao;
import glp.dao.UtilisateurDao;
import glp.domain.Utilisateur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class UtilisateurServiceImpl implements UtilisateurService{
	
	@Autowired
	UtilisateurDao utilisateurDao;

	@Override
	public String insertRow(Utilisateur utilisateur) {
		return utilisateurDao.insertRow(utilisateur);
	}

	@Override
	public List<Utilisateur> getList() {
		return utilisateurDao.getList();
	}

	@Override
	public Utilisateur getRowByMailLille1(String mailLille1) {
		return utilisateurDao.getRowByMailLille1(mailLille1);
	}

	@Override
	public String updateRow(Utilisateur utilisateur) {
		return utilisateurDao.updateRow(utilisateur);
	}

	@Override
	public String deleteRow(String mailLille1) {
		return utilisateurDao.deleteRow(mailLille1);
	}

}
