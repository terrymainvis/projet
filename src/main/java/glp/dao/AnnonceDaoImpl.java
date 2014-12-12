package glp.dao;

import glp.domain.Annonce;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
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

	@Override
	public List<Annonce> getListOfLastTen() {
		Session session =sessionFactory.openSession();
		String sql = "FROM Annonce ORDER BY ann_date_debut";
		Query q = session.createQuery(sql);
//		q.setFirstResult(0);
//		q.setMaxResults(10); // on obtient les 10 dernières annonces
		@SuppressWarnings("unchecked")
		List<Annonce> annonceList = q.list();
		System.out.println("taille " + annonceList.size() );
		return annonceList;
	}
	
	

}
