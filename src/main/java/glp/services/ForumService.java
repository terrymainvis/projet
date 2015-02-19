package glp.services;



import glp.domain.Forum;
import glp.domain.Utilisateur;

import java.util.List;

public interface ForumService {
	
public int insertRow(Forum forum);
	
	public List<Forum> getList();
	
	public Forum getRowById(int id);
	
	public int updateRow(Forum forum);
	
	public List<Forum> getListRecent();
	
	public int deleteRow(int id);
	
	public void supprimerForumUtilisateur(Utilisateur u);
	
	public List<Forum> getListByUtilisateur(Utilisateur u);

}
