package glp.services;

import glp.dao.ForumDao;
import glp.domain.Forum;
import glp.domain.Utilisateur;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForumServiceImpl implements ForumService{
	
	
	@Autowired
	ForumDao forumDao;

	@Override
	@Transactional
	public int insertRow(Forum forum) {
		// TODO Auto-generated method stub
		return forumDao.insertRow(forum);
	}

	@Override
	@Transactional
	public List<Forum> getList() {
		// TODO Auto-generated method stub
		return forumDao.getList();
	}
	@Override
	@Transactional
	public List<Forum> getListRecent() {
		return forumDao.getListRecent();
	}

	@Override
	@Transactional
	public Forum getRowById(int id) {
		// TODO Auto-generated method stub
		return forumDao.getRowById(id);
	}

	@Override
	@Transactional
	public int updateRow(Forum forum) {
		// TODO Auto-generated method stub
		return forumDao.updateRow(forum);
	}

	@Override
	@Transactional
	public int deleteRow(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void supprimerForumUtilisateur(Utilisateur u) {
		forumDao.supprimerForumUtilisateur(u);
	}

	@Override
	public List<Forum> getListByUtilisateur(Utilisateur u) {
		return forumDao.getListByUtilisateur(u);
	}

	

}
