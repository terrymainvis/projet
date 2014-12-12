package glp.services;

import glp.dao.UtilisateurDao;
import glp.domain.Utilisateur;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	UtilisateurDao utilisateurDao;
	@Autowired
	HttpSession httpSession;

	@Override
	@Transactional
	public Integer insertRow(Utilisateur utilisateur) {
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
	public Utilisateur getRowByMailLille1(Integer id) {
		return utilisateurDao.getRowById(id);
	}

	@Override
	@Transactional
	public Integer updateRow(Utilisateur utilisateur) {
		return utilisateurDao.updateRow(utilisateur);
	}

	@Override
	@Transactional
	public Integer deleteRow(Integer id) {
		return utilisateurDao.deleteRow(id);
	}

	public Utilisateur getUserInSession() {
		return (Utilisateur) httpSession.getAttribute("current_user");
	}

	@Override
	public void updateContactAutreMail(Utilisateur u, boolean contactAutreMail) {
		utilisateurDao.updateContactAutreMail(u, contactAutreMail);

	}

}
