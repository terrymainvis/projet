package glp.dao;

import glp.domain.Annonce;
import glp.domain.Stats;
import glp.domain.Utilisateur;

import java.util.List;
import java.util.Map;

public interface AnnonceDao {
	public int insertRow(Annonce ann);
	
	public List<Annonce> getList();
	
	public Annonce getRowById(int id);
	
	public int updateRow(Annonce ann);
	
	public int deleteRow(int id);

	public List<Annonce> getListByCat(int catId);
		
	public List<Annonce> getListRecent(int catId);

	public List<Annonce> getListByCatEtMot(int idCat, String motcle);

	public List<Annonce> getListByMot(String searchText);

	public List<Annonce> getListAModerer();

	public List<Annonce> getListValides();

	public void supprimerAnnoncesUtilisateur(Utilisateur u);

	public void supprimerAnnoncesCategorie(int catId);

	public List<Annonce> getListByUtilisateur(Utilisateur u);
	public int nbAnnonceEnLigne();
	public Map<String, Integer> getNbByCategorie();

	public void incrementNbAnnCrees();
	
	public int getNbAnnCrees();
	
	public Stats getStats();
}
