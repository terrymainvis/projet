package glp.dao;

import java.util.List;

import glp.domain.Champ;

public interface ChampDao {
	
	public int insertRow(Champ champ);
	
	public Champ getRowById(int id);
	
	public int updateRow(Champ champ);
	
	public int deleteRow(int id);
	
	public List<Champ> getListByCat(int idcat);

	public void supprimerChampCategorie(int catId);
}
