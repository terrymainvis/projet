package glp.dao;

import glp.domain.ChampComplete;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ChampCompleteDaoImpl  implements ChampCompleteDao {

	@Autowired  
	 private SessionFactory sessionFactory; 
	
	@Override
	public void insertRow(ChampComplete cc) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cc);
	}

	@Override
	public ChampComplete getRowById(int id) {
		Session session = sessionFactory.getCurrentSession();
		ChampComplete cc = (ChampComplete) session.load(ChampComplete.class, id);
		return cc;
	}

	@Override
	public void updateRow(ChampComplete cc) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cc);
	}

	@Override
	public void deleteRow(int id) {
		Session session = sessionFactory.getCurrentSession();
		ChampComplete cc = (ChampComplete) session.load(ChampComplete.class, id);
		session.delete(cc);
	}

	@Override
	public List<ChampComplete> getListByAnn(int idann) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ChampComplete> ccList = session.createQuery("from ChampComplete where ann_id= :annID").setParameter("annID", idann).list();
		return ccList;
	}

}
