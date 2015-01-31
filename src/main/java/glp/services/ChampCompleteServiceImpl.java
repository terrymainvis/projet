package glp.services;

import glp.dao.ChampCompleteDao;
import glp.dao.ChampDao;
import glp.domain.Annonce;
import glp.domain.Champ;
import glp.domain.ChampComplete;
import glp.form.AnnonceForm;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChampCompleteServiceImpl implements ChampCompleteService {

	@Autowired
	ChampCompleteDao ccDao;
	
	@Autowired
	ChampDao champDao;
	
	@Override
	@Transactional
	public void insertRow(ChampComplete cc) {
		ccDao.insertRow(cc); 
	}

	@Override
	@Transactional
	public List<ChampComplete> getListByAnn(Annonce ann) {
		return ccDao.getListByAnn(ann.getId());
	}

	@Override
	@Transactional
	public ChampComplete getRowById(int id) {
		return ccDao.getRowById(id);
	}

	@Override
	@Transactional
	public void updateRow(ChampComplete cc) {
		ccDao.updateRow(cc);
	}

	@Override
	@Transactional
	public void deleteRow(int id) {
		ccDao.deleteRow(id);
	}

	@Override
	@Transactional
	public AnnonceForm generateForAnnForm(AnnonceForm annform) {
		List<Champ> champs = champDao.getListByCat(annform.getCat_choisie().getId());
		ArrayList<ChampComplete> ccs = new ArrayList<ChampComplete>();
		
		if(annform.getAnnonce()==null)
			annform.setAnnonce(new Annonce());
		
		for(Champ c : champs) {
			ccs.add(new ChampComplete(annform.getAnnonce(), c, ""));
		}
		
		annform.getAnnonce().setChampscompletes(ccs);
		
		return annform;
	}
	

}
