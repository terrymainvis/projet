package glp.dao;

import glp.domain.Annonce;
import glp.domain.Categorie;
import glp.domain.Champ;
import glp.domain.TypeChampEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class CategorieDaoImpl implements CategorieDao {

	 @Autowired  
	 SessionFactory sessionFactory;  
	
	@Override
	public int insertRow(Categorie cat) {
//		List<Champ> listChamps = new ArrayList<Champ>();
//		listChamps.add(new Champ("Titre", cat, TypeChampEnum.TEXTE, true));
//		listChamps.add(new Champ("Description", cat, TypeChampEnum.DESCRIPTION, true));
//		listChamps.add(new Champ("Date fin", cat, TypeChampEnum.DATE, true));
//		listChamps.addAll(cat.getChamps());
//		cat.setChamps(listChamps);
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
		Categorie cat = (Categorie) session.createCriteria(Categorie.class).add(Restrictions.idEq(id)).uniqueResult();
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
		Session session = sessionFactory.getCurrentSession();
		Categorie c = (Categorie) session.createCriteria(Categorie.class).add(Restrictions.eq("lib",lib)).uniqueResult();
		return c.getId();
	}

	@Override
	public Map<Integer, Integer> getNbByCategorie() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Categorie> catList = session.createCriteria(Categorie.class).addOrder(Order.asc("id")).list();
		Map<Integer, Integer> mapCategorieNbAnnonces = new HashMap<Integer, Integer>();
		for(Categorie c : catList) {
			int nbAnnonces = ((Long) session.createCriteria(Annonce.class)
			        .add(Restrictions.eq("categorie", c)).setProjection(Projections.rowCount()).uniqueResult()).intValue();
			mapCategorieNbAnnonces.put(c.getId(), nbAnnonces);
		}
		return mapCategorieNbAnnonces;
	}

}
