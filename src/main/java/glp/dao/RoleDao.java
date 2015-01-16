package glp.dao;

import glp.domain.Role;

import java.util.List;

public interface RoleDao {
	
	public int insertRow(Role role);
	
	public List<Role> getList();
	
	public Role getRowById(int id);
	
	public int updateRow(Role role);
	
	public int deleteRow(int id);
	
	public Role getRowByNom(String nom);
	
}
