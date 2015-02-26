package glp.services;

import glp.domain.Annonce;
import glp.domain.Utilisateur;

import java.util.List;
import java.util.Map;

public interface AnnonceService {
	public int insertRow(Annonce ann);
	
	public List<Annonce> getList();
	
	public Annonce getRowById(int id);
	
	public int updateRow(Annonce annonce);
	
	public int deleteRow(int id);
	
	public List <Annonce> getListByCat(int catId);
		
	public List<Annonce> getListRecent(int catId);
	
	public int getIdByLib(String lib);

	public List<Annonce> getListByMot(String searchText);

	public List<Annonce> getListByCatEtMot(String cat, String motcle );
	
	public List<Annonce> getListAModerer();
	
	public List<Annonce> getListValides();
	
	public void supprimerAnnoncesUtilisateur(Utilisateur u);
	
	public void supprimerAnnoncesCategorie(int catId);
	public int nbAnnonceEnLigne();
	public Map<String, Integer> getNbByCategorie();
	
	public int updateDateAnnonce(int id, String date);
	
	public List<Annonce> getListByUtilisateur(Utilisateur u);
	
	public int nbAnnCrees();
}
