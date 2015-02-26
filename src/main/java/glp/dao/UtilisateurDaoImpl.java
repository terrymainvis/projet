package glp.dao;

import glp.domain.Annonce;
import glp.domain.Role;
import glp.domain.Utilisateur;
import glp.services.UtilisateurService;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class UtilisateurDaoImpl implements UtilisateurDao {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	UtilisateurService utilisateurService;


	@Override
	public Integer insertRow(Utilisateur u) {
		Session session = sessionFactory.getCurrentSession();
		if(u.getRoles().isEmpty()) {
			Role r = (Role) session.createCriteria(Role.class)
					.add(Restrictions.eq("nom", "UTILISATEUR"))
					.uniqueResult();
			u.addRole(r);
		}
		session.saveOrUpdate(u);
		Serializable id = session.getIdentifier(u);
		return (Integer) id;
	}

	@Override
	public List<Utilisateur> getList() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Utilisateur> utilisateursList = session.createCriteria(Utilisateur.class).addOrder(Order.asc("nom")).list();
		return utilisateursList;
	}

	@Override
	public Utilisateur getRowById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Utilisateur uti = (Utilisateur) session.createCriteria(Utilisateur.class).add(Restrictions.idEq(id)).uniqueResult();
		return uti;
	}

	@Override
	public Integer updateRow(Utilisateur u) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(u);
		Serializable id = session.getIdentifier(u);
		return (Integer) id;
	}

	@Override
	public Integer deleteRow(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Utilisateur u = (Utilisateur) session.load(Utilisateur.class, id);
		session.delete(u);
		Serializable iduti = session.getIdentifier(u);
		return (Integer) iduti;
	}

	@Override
	public void updateContactAutreMail(Utilisateur u, boolean contactAutreMail) {
		Session session = sessionFactory.getCurrentSession();
		u.setContactAutreMail(contactAutreMail);
		session.saveOrUpdate(u);
	}

	@Override
	public List<Utilisateur> getListByRole(String role) {
		Session session =sessionFactory.getCurrentSession();
		
		
		
		@SuppressWarnings("unchecked")
		List<Utilisateur> utilisateurList = session.createCriteria(Utilisateur.class)
		 .createAlias( "roles", "r" )
         .add( Restrictions.eq( "r.nom", role )).addOrder(Order.asc("nom")).list();
		return utilisateurList;
	}

	@Override
	public boolean isModerateur(Utilisateur utilisateur) {
		if(utilisateur.getRoles()!=null)
			if(utilisateur.getRoles().containsKey("MODERATEUR"))
				return true;
		return false;
	}

	@Override
	public boolean isAdministrateur(Utilisateur utilisateur) {
		if(utilisateur.getRoles()!=null)
			if(utilisateur.getRoles().containsKey("ADMINISTRATEUR"))
				return true;
		return false;
	}
	
	@Override
	public boolean isRepresentant(Utilisateur utilisateur) {
		if(utilisateur.getRoles()!=null)
			if(utilisateur.getRoles().containsKey("REPRESENTANT"))
				return true;
		return false;
	}
	
	@Transactional
	@Override
	public List<Annonce> listAnnoncePublie(Utilisateur utilisateur) {
		Session session = sessionFactory.getCurrentSession();
		Date d=new Date(); 
		@SuppressWarnings("unchecked")
		List<Annonce> annonceList = session.createCriteria(Annonce.class)
        .add(Restrictions.eq( "auteur", utilisateur )).add(Restrictions.ge("date_fin", d)).add(Restrictions.le("date_deb", d)).addOrder(Order.asc("date_fin")).list();
		return annonceList;
	}
	
	@Transactional
	@Override
	public List<Annonce> listAnnonceEnCourModeration(Utilisateur utilisateur) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Annonce> annonceList = session.createCriteria(Annonce.class)
        .add(Restrictions.eq("auteur", utilisateur )).add(Restrictions.isNull("valide")).addOrder(Order.asc("date_fin")).list();
		return annonceList;
	}
	
	@Transactional
	@Override
	public List<Annonce> listAnnoncePerimees(Utilisateur utilisateur) {
		Session session = sessionFactory.getCurrentSession();
		Date d=new Date(); 
		@SuppressWarnings("unchecked")
		List<Annonce> annonceList = session.createCriteria(Annonce.class)
        .add(Restrictions.eq( "auteur", utilisateur )).add(Restrictions.le("date_fin", d)).addOrder(Order.desc("date_fin")).list();
		return annonceList;
	}
	
	@Transactional
	@Override
	public Utilisateur updateUser(int id, String nom, String prenom, String tel,
			String mail, String mailAutre) {
		
			Session session = sessionFactory.getCurrentSession();
			         Utilisateur user =  (Utilisateur)session.get(Utilisateur.class, id); 
			         user.setNom(nom);
			         user.setPrenom(prenom);
			         user.setMailLille1(mail);
			         user.setMailAutre(mailAutre);
			         user.setTelephone(tel);
					 session.update(user); 
			      
			         return user;
			
	}
	@Transactional
	@Override
	public void supprimerAnnonce(int id) {
		Session session = sessionFactory.getCurrentSession();
	 session.createQuery("delete from Annonce where ann_id =:id")

				.setParameter("id", id).executeUpdate();
		
		
	}
	
	@Transactional
	@Override
	public Utilisateur getRowByMailLille1(String mail) {
		Session session = sessionFactory.getCurrentSession();
		Utilisateur uti = (Utilisateur) session.createCriteria(Utilisateur.class).add(Restrictions.eq("mailLille1", mail)).uniqueResult();
		return uti;
	}
	
	
	@Transactional
	@Override
	public void updateDate(int id, Date d ) {
		Session session = sessionFactory.getCurrentSession();
		Annonce annonce = (Annonce)session.get(Annonce.class, id);
		annonce.setDate_fin(d);
		System.out.println("la date fin est "+annonce.getDate_fin());
		
	}
	@Transactional
	@Override
	public int nbUtilisateur() {
		Session session = sessionFactory.getCurrentSession();
//		Criteria crit = session.createCriteria(Utilisateur.class);
//		
//		List<Utilisateur> utilisateur = crit.list();
//		Integer count = utilisateur.size();
	
		int nbuser = ((Long) session.createCriteria(Utilisateur.class).setProjection(Projections.rowCount()).uniqueResult()).intValue();
		
//		  int count = (int) session.createCriteria("Utilisateur").setProjection(Projections.rowCount()).uniqueResult();
			System.out.println("Nombre d'utlisateur "+nbuser);	
		  return nbuser;
		//return count;
	}

	
		
	}

	


