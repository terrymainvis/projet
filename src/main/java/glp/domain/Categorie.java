package glp.domain;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categorie {
	
	@Id
	@GeneratedValue
	@Column(name="cat_id")
	private int id;
	
	@Column(name="cat_lib")
	private String lib;
	
	@Column(name="cat_desc")
	private String desc;
	
	@OneToMany(mappedBy="cat")
	private List<Champ> champs;
	
	public Categorie(){
		
	}
	
	public Categorie(String lib, String desc) {
		super();
		this.lib = lib;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLib() {
		return lib;
	}

	public void setLib(String lib) {
		this.lib = lib;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String toString(){
		return lib;
	}

	public List<Champ> getChamps() {
		return champs;
	}

	public void setChamps(List<Champ> champs) {
		this.champs = champs;
	}
	
	
	

}
