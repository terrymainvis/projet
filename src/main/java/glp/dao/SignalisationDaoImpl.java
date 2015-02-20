package glp.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import glp.domain.Forum;
import glp.domain.Signalisation;

public class SignalisationDaoImpl implements SignalisationDao{

	
	
	@Autowired  
	 private SessionFactory sessionFactory;  
	
	
	@Override
	public int insertRow(Signalisation signal) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(signal);
		Serializable id = session.getIdentifier(signal);
		return (Integer) id;
	}


	@Override
	public List<Signalisation> getListRecent() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Signalisation> signalList = session.createQuery("from Forum ORDER BY forum_id DESC").list();
		return signalList;
	}

}
