package glp.services;

import glp.domain.Annonce;
import glp.domain.ChampComplete;

import java.util.List;

public interface ChampCompleteService {

	public int insertRow(ChampComplete cc);
	
	public List<ChampComplete> getListByAnn(Annonce ann);
	
	public ChampComplete getRowById(int id);
	
	public int updateRow(ChampComplete cc);
	
	public int deleteRow(int id);
}
