package glp.dao;

import glp.domain.Utilisateur;

import java.util.List;

public interface UtilisateurDao {
	
	public Integer insertRow(Utilisateur utilisateur);	
	public List<Utilisateur> getList();
	
	public Utilisateur getRowById(Integer id);
	
	public Integer updateRow(Utilisateur utilisateur);
	
	public Integer deleteRow(Integer id);
	
	public void updateContactAutreMail(Utilisateur u, boolean contactAutreMail);

}
