package glp.services;

import glp.dao.UtilisateurDao;
import glp.domain.Annonce;
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

	@Override
	@Transactional
	public Utilisateur getUserInSession() {
		return (Utilisateur) httpSession.getAttribute("current_user");
	}

	@Override
	@Transactional
	public void updateContactAutreMail(Utilisateur u, boolean contactAutreMail) {
		utilisateurDao.updateContactAutreMail(u, contactAutreMail);

	}

	@Override
	@Transactional
	public List<Utilisateur> getListByRole(int roleId) {
		return utilisateurDao.getListByRole(roleId);
	}

	@Override
	@Transactional
	public boolean isModerateur(Utilisateur utilisateur) {
		return utilisateurDao.isModerateur(utilisateur);
	}

	@Override
	@Transactional
	public boolean isAdministrateur(Utilisateur utilisateur) {
		return utilisateurDao.isAdministrateur(utilisateur);
	}

	@Override
	@Transactional
	public Utilisateur getRowById(int id) {
		return utilisateurDao.getRowById(id);
	}

	@Override
	public List<Annonce> listAnnoncePublie(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return utilisateurDao.listAnnoncePublie(utilisateur);
	}

	@Override
	public List<Annonce> listAnnonceEnCourModeration(Utilisateur utilisateur) {
		return utilisateurDao.listAnnonceEnCourModeration(utilisateur);
	}

	@Override
	public List<Annonce> listAnnonceEnciennes(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur updateUser(int id,String nom, String prenom, String tel, String mail,
			String mailAutre) {
		return utilisateurDao.updateUser(id, nom, prenom, tel, mail, mailAutre);

	}

	@Override
	public void supprimerAnnonce(int id) {
		 utilisateurDao.supprimerAnnonce(id);
		
	}

}
