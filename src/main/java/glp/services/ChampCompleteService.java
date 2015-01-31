package glp.services;

import glp.domain.Annonce;
import glp.domain.ChampComplete;
import glp.form.AnnonceForm;

import java.util.List;

public interface ChampCompleteService {

	public void insertRow(ChampComplete cc);
	
	public List<ChampComplete> getListByAnn(Annonce ann);
	
	public ChampComplete getRowById(int id);
	
	public void updateRow(ChampComplete cc);
	
	public void deleteRow(int id);
	
	public AnnonceForm generateForAnnForm(AnnonceForm annform);
}
