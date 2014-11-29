package glp.services;

import glp.domain.Categorie;

import java.util.List;

public interface CategorieService {
	public int insertRow(Categorie cat);
	
	public List<Categorie> getList();
	
	public Categorie getRowById(int id);
	
	public int updateRow(Categorie cat);
	
	public int deleteRow(int id);
}
