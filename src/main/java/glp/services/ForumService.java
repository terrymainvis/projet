package glp.services;



import glp.domain.Forum;

import java.util.List;

public interface ForumService {
	
public int insertRow(Forum forum);
	
	public List<Forum> getList();
	
	public Forum getRowById(int id);
	
	public int updateRow(Forum forum);
	
	public List<Forum> getListRecent();
	
	public int deleteRow(int id);

}
