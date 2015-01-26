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
	public List<Annonce> getListValides() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		//FALSE = refusée - NULL = en attente - TRUE = validée
		List<Annonce> annonceList = session.createQuery("FROM Annonce WHERE ann_valide=TRUE").list();
		return annonceList;
	}

	@Override
	public Annonce getRowById(int id) {
				
		Session session = sessionFactory.getCurrentSession();
		Annonce ann = (Annonce) session.load(Annonce.class, new Integer(id));
		System.out.println(ann.getTitre()); // VIRER CE CODE, NE PAS OUBLIER /!\
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
	public List<Annonce> getListRecent(int catId) {
		Session session =sessionFactory.getCurrentSession();
		String sql = "FROM Annonce where cat_id= :catID ORDER BY ann_date_debut";
		Query q = session.createQuery(sql).setParameter("catID", catId);
		q.setFirstResult(0);
		q.setMaxResults(5); // on obtient les 10 derniÃ¨res annonces
		@SuppressWarnings("unchecked")
		List<Annonce> annonceList = q.list();
		System.out.println("taille " + annonceList.size() );
		return annonceList;
	}

	@Override

	public List<Annonce> getListByMot(String searchText) { 
		
	Session session =sessionFactory.getCurrentSession(); 
	@SuppressWarnings("unchecked")
	List<Annonce> annonceList = session.createQuery("from Annonce"
			+ " where ann_desc like :searchText or ann_titre like:searchText")
			.setParameter("searchText","%"+searchText+"%").list();
	return annonceList;


	}
	
	@Override
	public List<Annonce> getListByCat(int catId) {
		Session session =sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Annonce> annonceList = session.createQuery("from Annonce where cat_id= :catID").setParameter("catID", catId).list();
		return annonceList;
	}

	@Override
	public List<Annonce> getListByCatEtMot(int idCat, String motcle) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Annonce> annonceList = session.createQuery("from Annonce where cat_id= :catID"
				+ " and (ann_desc like :searchText or ann_titre like:searchText )")
				.setParameter("searchText","%"+motcle+"%")
				.setParameter("catID", idCat)
				.list();
		return annonceList;
	}
	
	@Override
	public List<Annonce> getListAModerer() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		//FALSE = refusée - NULL = en attente - TRUE = validée
		List<Annonce> annonceList = session.createQuery("FROM Annonce WHERE ann_valide=NULL").list();
		return annonceList;
	}

	
}
