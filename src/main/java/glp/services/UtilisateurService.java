package glp.services;

import glp.domain.Utilisateur;

import java.util.List;

public interface UtilisateurService {
	
	public Integer insertRow(Utilisateur utilisateur);
	
	public List<Utilisateur> getList();
	
	public Utilisateur getRowByMailLille1(Integer id);
	
	public Integer updateRow(Utilisateur utilisateur);
	
	public Integer deleteRow(Integer id);
	
	public Utilisateur getUserInSession();
	
	public void updateContactAutreMail(Utilisateur u, boolean contactAutreMail);

}
