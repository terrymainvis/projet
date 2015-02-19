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
		Date d=new Date(); 

		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")


		List<Annonce> annonceList = session.createQuery("from Annonce where uti_id =:utiID"+ " and (ann_valide =1)")

		.setParameter("utiID", 1)

		.list(); 

		//		List<Annonce> annonceList = session.createQuery("from Annonce where uti_id =:utiID"
		//				+ " and (ann_valide =:valide)"+"and (ann_date_fin >:d >)")
		//				.setParameter("valide",1)
		//				.setParameter("utiID", utilisateurService.getUserInSession().getId())
		//				.setParameter("d", d)
		//				.list(); 

		return annonceList;
	}
	@Transactional
	@Override
	public List<Annonce> listAnnonceEnCourModeration(Utilisateur utilisateur) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")


		List<Annonce> annonceListAmoderer = session.createQuery("from Annonce where uti_id =:utiID"
				+ " and (ann_valide is null)")

				.setParameter("utiID", 1)
				.list(); 
		System.out.println(annonceListAmoderer.size()+" la taille de la liste");
		return annonceListAmoderer;

	}
	@Transactional
	@Override
	public List<Annonce> listAnnonceEnciennes(Utilisateur utilisateur) {
		Date d=new Date(); 

		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")


		List<Annonce> annonceList = session.createQuery("from Annonce where uti_id =:utiID"+ " and (ann_valide =:1)")

		.setParameter("utiID", 1)


		.list(); 

		//		List<Annonce> annonceList = session.createQuery("from Annonce where uti_id =:utiID"
		//				+ " and (ann_valide =:valide)"+"and (ann_date_fin >:d >)")
		//				.setParameter("valide",1)
		//				.setParameter("utiID", utilisateurService.getUserInSession().getId())
		//				.setParameter("d", d)
		//				.list(); 

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
	
		
	}

	


