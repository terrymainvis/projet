package glp.dao;

import glp.domain.Annonce;

import java.util.List;

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

	
	

}
