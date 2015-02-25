package glp.services;

import java.util.List;

import javax.transaction.Transactional;

import glp.dao.SignalisationDao;
import glp.domain.Forum;
import glp.domain.Signalisation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignalisationServiceImpl implements SignalisationService{

	@Autowired
	SignalisationDao signalDao;
	
	@Override
	@Transactional
	public int insertRow(Signalisation signal) {
		// TODO Auto-generated method stub
		return signalDao.insertRow(signal);
	}

	@Override
	@Transactional
	public int deleteRow(int id) {
		// TODO Auto-generated method stub
		return signalDao.deleteRow(id);
	}
	
	@Override
	@Transactional
	public List<Signalisation> getListRecent() {
		// TODO Auto-generated method stub
		return signalDao.getListRecent();
	}

	@Override
	@Transactional
	public List<Signalisation> getListSignalements(Forum forum) {
		// TODO Auto-generated method stub
		return signalDao.getListSignalements(forum);
	}



}
