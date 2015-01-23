package glp.dao;

import glp.domain.ChampComplete;

import java.util.List;

public interface ChampCompleteDao {

public int insertRow(ChampComplete cc);
	
	public ChampComplete getRowById(int id);
	
	public int updateRow(ChampComplete cc);
	
	public int deleteRow(int id);
	
	public List<ChampComplete> getListByAnn(int idann);
}

