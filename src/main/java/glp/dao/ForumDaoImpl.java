package glp.dao;

import glp.domain.Forum;
import glp.domain.Utilisateur;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class ForumDaoImpl implements ForumDao{

	
	@Autowired  
	 private SessionFactory sessionFactory;  
	
	@Override
	public int insertRow(Forum forum) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(forum);
		Serializable id = session.getIdentifier(forum);
		return (Integer) id;
		
	}

	@Override
	public List<Forum> getList() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Forum> forumList = session.createQuery("from Forum").list();
		return forumList;
	}

	@Override
	public Forum getRowById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Forum forum = (Forum) session.createCriteria(Forum.class).add(Restrictions.idEq(id)).uniqueResult();
		return forum;
		
	}

	@Override
	public int updateRow(Forum forum) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(forum);
		Serializable id = session.getIdentifier(forum);
		return (Integer) id;
		
	}

	@Override
	public int deleteRow(int id) {
		// TODO Auto-generated method stub
		return 0;
	}//SELECT * FROM `forum` order by `forum_date_pub` DESC

	@Override
	public List<Forum> getListRecent() {
		Session session =sessionFactory.getCurrentSession();
		String sql = "FROM Forum ORDER BY forum_date_pub DESC";// ORDER BY ann_date_debut
		Query q = session.createQuery(sql);
		q.setFirstResult(0);
		q.setMaxResults(3); // on obtient les 10 dernières annonces
		@SuppressWarnings("unchecked")
		List<Forum> forumListRecent = q.list();
		System.out.println("taille " + forumListRecent.size() );
		return forumListRecent;
	}

	@Override
	public void supprimerForumUtilisateur(Utilisateur u) {
		List<Forum> listeForum = getListByUtilisateur(u);
		if(listeForum!=null)
			for(Forum f : listeForum)
				deleteRow(f.getId());
	}

	@Override
	public List<Forum> getListByUtilisateur(Utilisateur u) {
		Session session =sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Forum> forumList = session.createCriteria(Forum.class)
		        .add(Restrictions.eq("auteur", u))
		        .list();
		return forumList;
	}

}
