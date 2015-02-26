package glp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stats {

	@Id
	@Column(name = "stats_id")
	private int stats_id;

	@Column(name = "stats_date")
	private Date stats_date;

	@Column(name = "stats_nb_ann_crees")
	private int stats_nb_ann_crees;
	
	

	public Stats() {
		super();
	}

	public Stats(int id, Date date, int nb_ann_crees) {
		super();
		this.stats_date = date;
		this.stats_nb_ann_crees = nb_ann_crees;
		this.stats_id = id;
	}

	public Date getDate() {
		return stats_date;
	}

	public void setDate(Date date) {
		this.stats_date = date;
	}

	public int getNb_ann_crees() {
		return stats_nb_ann_crees;
	}

	public void setNb_ann_crees(int nb_ann_crees) {
		this.stats_nb_ann_crees = nb_ann_crees;
	}

	public int getId() {
		return stats_id;
	}

	public void setId(int id) {
		this.stats_id = id;
	}

}
