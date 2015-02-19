package glp.dao;

import glp.domain.Role;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleDaoImpl implements RoleDao {
	
	@Autowired  
	SessionFactory sessionFactory;

	@Override
	public int insertRow(Role role) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(role);
		Serializable id = session.getIdentifier(role);
		return (Integer) id;
	}

	@Override
	public List<Role> getList() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Role> roleList = session.createCriteria(Role.class).addOrder(Order.asc("nom")).list();
		return roleList;
	}

	@Override
	public Role getRowById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Role role = (Role) session.createCriteria(Role.class).add(Restrictions.idEq(id)).uniqueResult();
		return role;
	}

	@Override
	public int updateRow(Role role) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(role);
		Serializable id = session.getIdentifier(role);
		return (Integer) id;
	}

	@Override
	public int deleteRow(int id) {
		Session session = sessionFactory.getCurrentSession();
		Role role = (Role) session.load(Role.class, id);
		session.delete(role);
		Serializable idRole = session.getIdentifier(role);
		return (Integer) idRole;
	}

	@Override
	public Role getRowByNom(String nom) {
		Session session =sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Role> listRoles = session.createCriteria(Role.class)
        .add(Restrictions.eq("nom", nom))
        .list();
		return listRoles.get(0);
	}

}
