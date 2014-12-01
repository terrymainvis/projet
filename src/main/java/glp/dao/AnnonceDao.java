package glp.dao;

import glp.domain.Annonce;

import java.util.List;

public interface AnnonceDao {
	public int insertRow(Annonce cat);
	
	public List<Annonce> getList();
	
	public Annonce getRowById(int id);
	
	public int updateRow(Annonce cat);
	
	public int deleteRow(int id);

}
