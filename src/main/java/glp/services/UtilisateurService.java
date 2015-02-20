package glp.services;

import glp.domain.Annonce;
import glp.domain.Utilisateur;

import java.util.Date;
import java.util.List;

public interface UtilisateurService {
	
	public Integer insertRow(Utilisateur utilisateur);
	
	public List<Utilisateur> getList();
	
	public Utilisateur getRowByMailLille1(String mail);
	
	public Integer updateRow(Utilisateur utilisateur);
	
	public Integer deleteRow(Integer id);
	
	public Utilisateur getUserInSession();
	
	public void updateContactAutreMail(Utilisateur u, boolean contactAutreMail);
	
	public List<Utilisateur> getListByRole(String role);
	
	public boolean isModerateur(Utilisateur utilisateur);
	
	public boolean isAdministrateur(Utilisateur utilisateur);
	
	public boolean isRepresentant(Utilisateur utilisateur);
	
	public Utilisateur getRowById(int id);
	
	public List<Annonce> listAnnoncePublie(Utilisateur utilisateur);
	public List<Annonce> listAnnonceEnCourModeration(Utilisateur utilisateur);
	public List<Annonce> listAnnonceEnciennes(Utilisateur utilisateur);
	public Utilisateur updateUser(int id,String nom, String prenom,String tel,String mail,String mailAutre);
	public void supprimerAnnonce(int id);
	public void updateDate(int id,Date d);
	public int nbUtilisateur();

}
