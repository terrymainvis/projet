package glp.dao;

import glp.domain.Annonce;
import glp.domain.Job;

import java.util.List;

public interface JobDao {

	public int insertRow(Job job);

	public List<Job> getList();

	public Job getRowById(int id);

	public int deleteRow(int id);

	public List<Job> getListRecent();


}
