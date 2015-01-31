package glp.dao;

import glp.domain.ChampComplete;

import java.util.List;

public interface ChampCompleteDao {

	public void insertRow(ChampComplete cc);
	
	public ChampComplete getRowById(int id);
	
	public void updateRow(ChampComplete cc);
	
	public void deleteRow(int id);
	
	public List<ChampComplete> getListByAnn(int idann);
}

