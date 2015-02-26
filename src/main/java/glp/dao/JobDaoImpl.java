package glp.dao;

import glp.domain.Job;
import glp.domain.Utilisateur;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class JobDaoImpl implements JobDao{

	 @Autowired  
	 private SessionFactory sessionFactory;  
	 
	@Override
	public int insertRow(Job job) {
		Session session = sessionFactory.getCurrentSession();
		//session.beginTransaction();
		session.saveOrUpdate(job);
		Serializable id = session.getIdentifier(job);
		return (Integer) id;
		
	}

	@Override
	public List<Job> getList() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Job> jobList = session.createQuery("from Job").list();
		return jobList;
	}

	@Override
	public Job getRowById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Job job = (Job) session.createCriteria(Job.class).add(Restrictions.idEq(id)).uniqueResult();
		System.out.println(job.getDesc());
		return job;
	}

	@Override
	public int deleteRow(int id) {
		Session session = sessionFactory.getCurrentSession();
		Job job = (Job) session.load(Job.class, id);
		session.delete(job);
		Serializable idjob = session.getIdentifier(job);
		return (Integer) idjob;

	}

	@Override
	public List<Job> getListRecent() {
		Session session =sessionFactory.getCurrentSession();
		String sql = "FROM Job ORDER BY Job_date_debut";
		Query q = session.createQuery(sql);
		q.setFirstResult(0);
		q.setMaxResults(5);
		@SuppressWarnings("unchecked")
		List<Job> jobList = q.list();
		return jobList;
	}

	@Transactional
	@Override
	public void supprimerJobUtilisateur(Utilisateur u) {
		List<Job> listeJob = getListByUtilisateur(u);
		if(listeJob!=null)
			for(Job f : listeJob)
				deleteRow(f.getId());
	}

	@Transactional
	@Override
	public List<Job> getListByUtilisateur(Utilisateur u) {
		Session session =sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Job> jobList = session.createCriteria(Job.class)
		        .add(Restrictions.eq("auteur", u))
		        .list();
		return jobList;
	}

	@Override
	public void incrementNbJobsCrees() {		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session
					.createQuery(
							"UPDATE Stats SET stats_nb_jobs_crees=stats_nb_jobs_crees+1");
			query.executeUpdate();
	}
}
