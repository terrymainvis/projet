package glp.services;

import glp.dao.RoleDao;
import glp.domain.Role;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleDao roleDao;
	
	@Override
	@Transactional
	public int insertRow(Role role) {
		return roleDao.insertRow(role);
	}

	@Override
	@Transactional
	public List<Role> getList() {
		return roleDao.getList();
	}

	@Override
	@Transactional
	public Role getRowById(int id) {
		return roleDao.getRowById(id);
	}

	@Override
	@Transactional
	public int updateRow(Role role) {
		return roleDao.updateRow(role);
	}

	@Override
	@Transactional
	public int deleteRow(int id) {
		return roleDao.deleteRow(id);
	}

	@Override
	@Transactional
	public Role getRowByNom(String nom) {
		return roleDao.getRowByNom(nom);
	}

}
