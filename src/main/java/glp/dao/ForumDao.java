package glp.dao;

import glp.domain.Forum;

import java.util.List;

public interface ForumDao {
	
public int insertRow(Forum forum);
	
	public List<Forum> getList();
	
	public Forum getRowById(int id);
	
	public int updateRow(Forum forum);
	
	public int deleteRow(int id);

	public List<Forum> getListRecent();

}
