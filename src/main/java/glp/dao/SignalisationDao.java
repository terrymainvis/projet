package glp.dao;

import java.util.List;

import glp.domain.Signalisation;

public interface SignalisationDao {
	
	public int insertRow(Signalisation signal);

	public List<Signalisation> getListRecent();
	

}
