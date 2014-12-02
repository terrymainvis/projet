package glp.dao;

import glp.domain.Utilisateur;

import java.util.List;

public interface UtilisateurDao {
	
	public String insertRow(Utilisateur utilisateur);
	
	public List<Utilisateur> getList();
	
	public Utilisateur getRowByMailLille1(String mailLille1);
	
	public String updateRow(Utilisateur utilisateur);
	
	public String deleteRow(String mailLille1);

}
