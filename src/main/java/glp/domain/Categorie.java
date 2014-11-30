package glp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
	
	

}
