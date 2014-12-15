package glp.dao;

import glp.domain.Categorie;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CategorieDaoImpl implements CategorieDao {

	 @Autowired  
	 SessionFactory sessionFactory;  
	
	@Override
	public int insertRow(Categorie cat) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cat);
		Serializable id = session.getIdentifier(cat);
		return (Integer) id;
	}

	@Override
	public List<Categorie> getList() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Categorie> categorieList = session.createQuery("from Categorie").list();
		return categorieList;
	}

	@Override
	public Categorie getRowById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Categorie cat = (Categorie) session.load(Categorie.class, id);
		return cat;
	}

	@Override
	public int updateRow(Categorie cat) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cat);
		Serializable id = session.getIdentifier(cat);
		return (Integer) id;
	}

	@Override
	public int deleteRow(int id) {
		Session session = sessionFactory.getCurrentSession();
		Categorie cat = (Categorie) session.load(Categorie.class, id);
		session.delete(cat);
		Serializable idcat = session.getIdentifier(cat);
		return (Integer) idcat;
	}

	@Override
	public int getIdByLib(String lib) {
		System.out.println(lib);
		Session session =sessionFactory.getCurrentSession();
		String sql = "select id FROM Categorie where cat_lib LIKE :catLib";
		Query q = session.createQuery(sql).setParameter("catLib", lib);
		int id = (int) q.list().get(0);
		System.out.println(id);
		return id;
	}

}
