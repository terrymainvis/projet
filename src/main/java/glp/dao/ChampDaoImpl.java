package glp.dao;

import glp.domain.Champ;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		Champ champ = (Champ) session.createCriteria(Champ.class).add(Restrictions.idEq(id)).uniqueResult();
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
		Session session =sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Champ> champList = session.createCriteria(Champ.class)
				.createAlias( "cat", "c" )
		         .add( Restrictions.eq( "c.id", idcat ))
		        .list();
		return champList;
	}

	@Transactional
	@Override
	public void supprimerChampCategorie(int catId) {
		List<Champ> listeChamp = getListByCat(catId);
		if(listeChamp!=null)
			for(Champ c : listeChamp)
				deleteRow(c.getId());
	}

}
