package glp.dao;

import glp.domain.Role;
import glp.domain.Utilisateur;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UtilisateurDaoImpl implements UtilisateurDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Integer insertRow(Utilisateur u) /*throws HibernateException */{
		Session session = sessionFactory.getCurrentSession();
		/*try {*/
			String sql = "select id FROM Role where role_nom LIKE :rolenom";
			Query q = session.createQuery(sql).setParameter("rolenom", "UTILISATEUR");
			int idRole = (int) q.list().get(0);
			u.setRoleId(idRole);
			session.saveOrUpdate(u);
			Serializable id = session.getIdentifier(u);
			return (Integer) id;
		/*} catch (ConstraintViolationException e) {

		}*/

	}

	@Override
	public List<Utilisateur> getList() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Utilisateur> utilisateursList = session.createQuery(
				"from Utilisateur").list();
		return utilisateursList;
	}

	@Override
	public Utilisateur getRowById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Utilisateur u = (Utilisateur) session.load(Utilisateur.class, id);
		return u;
	}

	@Override
	public Integer updateRow(Utilisateur u) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(u);
		Serializable id = session.getIdentifier(u);
		return (Integer) id;
	}

	@Override
	public Integer deleteRow(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Utilisateur u = (Utilisateur) session.load(Utilisateur.class, id);
		session.delete(u);
		Serializable iduti = session.getIdentifier(u);
		return (Integer) iduti;
	}

	@Override
	public void updateContactAutreMail(Utilisateur u, boolean contactAutreMail) {
		Session session = sessionFactory.getCurrentSession();
		u.setContactAutreMail(contactAutreMail);
		session.saveOrUpdate(u);
	}

	@Override
	public List<Utilisateur> getListByRole(int roleId) {
		Session session =sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Utilisateur> utilisateurList = session.createQuery("from Utilisateur where role_id= :roleId").setParameter("roleId", roleId).list();
		return utilisateurList;
	}

	@Override
	public boolean isModerateur(Utilisateur utilisateur) {
		Session session = sessionFactory.getCurrentSession();
		Role r = (Role) session.load(Role.class, utilisateur.getRoleId());
		if(r.getNom().equals("MODERATEUR"))
			return true;
		return false;
	}

	@Override
	public boolean isAdministrateur(Utilisateur utilisateur) {
		Session session = sessionFactory.getCurrentSession();
		Role r = (Role) session.load(Role.class, utilisateur.getRoleId());
		if(r.getNom().equals("ADMINISTRATEUR"))
			return true;
		return false;
	}

}
