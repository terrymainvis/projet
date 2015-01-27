package glp.services;

import glp.dao.AnnonceDao;
import glp.dao.JobDao;
import glp.domain.Job;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

public class JobServiceImpl implements JobService{

	@Autowired
	JobDao jobDao;
	
	@Override
	@Transactional
	public List<Job> getList() {
		return jobDao.getList();
	}

	@Override
	@Transactional
	public Job getRowById(int id) {
		return jobDao.getRowById(id);
	}

	@Override
	@Transactional
	public int deleteRow(int id) {
		return jobDao.deleteRow(id);
	}

	@Override
	@Transactional
	public List<Job> getListRecent() {
		return jobDao.getListRecent();
	}

	@Override
	@Transactional
	public int insertRow(Job job) {
		return jobDao.insertRow(job);
		
	}

}