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
	
	@Column(name="nb_jours_fin_annonce")
	private int nb_jours_fin_annonce;
	
	@Column(name="stats_nb_jobs_crees")
	private int stats_nb_jobs_crees;
	
	@Column(name="stats_nb_forums_crees")
	private int stats_nb_forums_crees;

	public Stats() {
		super();
	}

	
	public Stats(int stats_id, Date stats_date, int stats_nb_ann_crees,
			int nb_jours_fin_annonce, int stats_nb_jobs_crees,
			int stats_nb_forums_crees) {
		super();
		this.stats_id = stats_id;
		this.stats_date = stats_date;
		this.stats_nb_ann_crees = stats_nb_ann_crees;
		this.nb_jours_fin_annonce = nb_jours_fin_annonce;
		this.stats_nb_jobs_crees = stats_nb_jobs_crees;
		this.stats_nb_forums_crees = stats_nb_forums_crees;
	}


	public int getStats_id() {
		return stats_id;
	}


	public void setStats_id(int stats_id) {
		this.stats_id = stats_id;
	}


	public Date getStats_date() {
		return stats_date;
	}


	public void setStats_date(Date stats_date) {
		this.stats_date = stats_date;
	}


	public int getStats_nb_ann_crees() {
		return stats_nb_ann_crees;
	}


	public void setStats_nb_ann_crees(int stats_nb_ann_crees) {
		this.stats_nb_ann_crees = stats_nb_ann_crees;
	}


	public int getNb_jours_fin_annonce() {
		return nb_jours_fin_annonce;
	}


	public void setNb_jours_fin_annonce(int nb_jours_fin_annonce) {
		this.nb_jours_fin_annonce = nb_jours_fin_annonce;
	}


	public int getStats_nb_jobs_crees() {
		return stats_nb_jobs_crees;
	}


	public void setStats_nb_jobs_crees(int stats_nb_jobs_crees) {
		this.stats_nb_jobs_crees = stats_nb_jobs_crees;
	}


	public int getStats_nb_forums_crees() {
		return stats_nb_forums_crees;
	}


	public void setStats_nb_forums_crees(int stats_nb_forums_crees) {
		this.stats_nb_forums_crees = stats_nb_forums_crees;
	}
	
	

}