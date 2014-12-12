package glp.dao;

import glp.domain.Champ;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ChampDaoImpl implements ChampDao {

	@Autowired  
	 private SessionFactory sessionFactory; 
	
	@Override
	public int insertRow(Champ champ) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(champ);
		Serializable id = session.getIdentifier(champ);
		return (Integer) id;
	}

	@Override
	public Champ getRowById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Champ champ = (Champ) session.load(Champ.class, id);
		return champ;
	}

	@Override
	public int updateRow(Champ champ) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(champ);
		Serializable id = session.getIdentifier(champ);
		return (Integer) id;
	}

	@Override
	public int deleteRow(int id) {
		Session session = sessionFactory.getCurrentSession();
		Champ champ = (Champ) session.load(Champ.class, id);
		session.delete(champ);
		Serializable idch = session.getIdentifier(champ);
		return (Integer) idch;
	}

	@Override
	public List<Champ> getListByCat(int idcat) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Champ> champList = session.createQuery("from Champ where cat_id= :catID").setParameter("catID", idcat).list();
		return champList;
	}

}
