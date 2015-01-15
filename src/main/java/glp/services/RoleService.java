package glp.services;

import glp.domain.Role;

import java.util.List;

public interface RoleService {
	
	public int insertRow(Role role);
	
	public List<Role> getList();
	
	public Role getRowById(int id);
	
	public int updateRow(Role role);
	
	public int deleteRow(int id);

}
