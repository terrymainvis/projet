package glp.dao;

import glp.domain.Annonce;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AnnonceDaoImpl implements AnnonceDao {

	 @Autowired  
	 private SessionFactory sessionFactory;  
	
	@Override
	public int insertRow(Annonce ann) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(ann);
		Serializable id = session.getIdentifier(ann);
		return (Integer) id;
	}

	@Override
	public List<Annonce> getList() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Annonce> annonceList = session.createQuery("from Annonce").list();
		return annonceList;
	}

	@Override
	public Annonce getRowById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Annonce ann = (Annonce) session.load(Annonce.class, id);
		return ann;
	}

	@Override
	public int updateRow(Annonce ann) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(ann);
		Serializable id = session.getIdentifier(ann);
		return (Integer) id;
	}

	@Override
	public int deleteRow(int id) {
		Session session = sessionFactory.getCurrentSession();
		Annonce ann = (Annonce) session.load(Annonce.class, id);
		session.delete(ann);
		Serializable idann = session.getIdentifier(ann);
		return (Integer) idann;
	}

	@Override
	public List<Annonce> getListByCat(int catId) {
		Session session =sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Annonce> annonceList = session.createQuery("from Annonce where cat_id= :catID").setParameter("catID", catId).list();
		return annonceList;
	}

}
