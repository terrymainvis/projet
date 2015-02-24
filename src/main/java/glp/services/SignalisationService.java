package glp.services;

import java.util.List;

import glp.domain.Forum;
import glp.domain.Signalisation;

public interface SignalisationService {
	
	public int insertRow(Signalisation signal);

	public List<Signalisation> getListRecent();
	
	public List<Signalisation> getListSignalements(Forum forum);

}
