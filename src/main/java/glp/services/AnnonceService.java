package glp.services;

import glp.domain.Annonce;

import java.util.List;

public interface AnnonceService {
	public int insertRow(Annonce cat);
	
	public List<Annonce> getList();
	
	public Annonce getRowById(int id);
	
	public int updateRow(Annonce cat);
	
	public int deleteRow(int id);
	
	public List <Annonce> getListByCat(int catId);
	
	public List<Annonce> getListRecent(int catId);
	
	public int getIdByLib(String lib);

}
