package glp.dao;

import glp.domain.Utilisateur;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UtilisateurDaoImpl implements UtilisateurDao {
	
	@Autowired  
	SessionFactory sessionFactory;  

	@Override
	public String insertRow(Utilisateur u) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(u);
		Serializable mail = session.getIdentifier(u);
		return (String) mail;
	}

	@Override
	public List<Utilisateur> getList() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Utilisateur> utilisateursList = session.createQuery("from Utilisateur").list();
		return utilisateursList;
	}

	@Override
	public Utilisateur getRowByMailLille1(String mailLille1) {
		Session session = sessionFactory.getCurrentSession();
		Utilisateur u = (Utilisateur) session.load(Utilisateur.class, mailLille1);
		return u;
	}

	@Override
	public String updateRow(Utilisateur u) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(u);
		Serializable mail = session.getIdentifier(u);
		return (String) mail;
	}

	@Override
	public String deleteRow(String mailLille1) {
		Session session = sessionFactory.getCurrentSession();
		Utilisateur u = (Utilisateur) session.load(Utilisateur.class, mailLille1);
		session.delete(u);
		Serializable mail = session.getIdentifier(u);
		return (String) mail;
	}


}
