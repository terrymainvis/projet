package glp.services;

import glp.domain.Categorie;
import glp.domain.Champ;

import java.util.List;

public interface ChampService {

public int insertRow(Champ champ);
	
	public List<Champ> getListByCat(Categorie cat);
	
	public Champ getRowById(int id);
	
	public int updateRow(Champ champ);
	
	public int deleteRow(int id);
	
	public void supprimerChampCategorie(int catId);

	public List<Champ> getList();
}
