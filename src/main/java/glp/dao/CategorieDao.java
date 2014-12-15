package glp.dao;

import java.util.List;

import glp.domain.Categorie;

public interface CategorieDao {
	
	public int insertRow(Categorie cat);
	
	public List<Categorie> getList();
	
	public Categorie getRowById(int id);
	
	public int updateRow(Categorie cat);
	
	public int deleteRow(int id);
	
	public int getIdByLib(String lib);
}
