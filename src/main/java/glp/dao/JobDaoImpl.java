package glp.dao;

import glp.domain.Annonce;
import glp.domain.Job;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class JobDaoImpl implements JobDao{

	 @Autowired  
	 private SessionFactory sessionFactory;  
	
	@Override
	public int insertRow(Job job) {
		Session session = sessionFactory.getCurrentSession();
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
		Job job = (Job) session.load(Job.class, new Integer(id));
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
		String sql = "FROM job ORDER BY job_date_debut";
		Query q = session.createQuery(sql);
		q.setFirstResult(0);
		q.setMaxResults(5);
		@SuppressWarnings("unchecked")
		List<Job> jobList = q.list();
		return jobList;
	}

}
