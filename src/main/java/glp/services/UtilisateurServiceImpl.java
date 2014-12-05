package glp.services;

import glp.dao.UtilisateurDao;
import glp.domain.Utilisateur;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{
	
	@Autowired
	UtilisateurDao utilisateurDao;
	@Autowired
	HttpSession httpSession;
	
	@Override
	@Transactional
	public String insertRow(Utilisateur utilisateur) {
		System.out.println("Service" + utilisateur.getMailLille1());
		httpSession.setAttribute("current_user", utilisateur);
		return utilisateurDao.insertRow(utilisateur);
	}

	@Override
	@Transactional
	public List<Utilisateur> getList() {
		return utilisateurDao.getList();
	}

	@Override
	@Transactional
	public Utilisateur getRowByMailLille1(String mailLille1) {
		return utilisateurDao.getRowByMailLille1(mailLille1);
	}

	@Override
	@Transactional
	public String updateRow(Utilisateur utilisateur) {
		return utilisateurDao.updateRow(utilisateur);
	}

	@Override
	@Transactional
	public String deleteRow(String mailLille1) {
		return utilisateurDao.deleteRow(mailLille1);
	}
	
	public Utilisateur getUserInSession(){
		return (Utilisateur) httpSession.getAttribute("current_user");
	}

}
