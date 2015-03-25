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
	
	//le libelle en anglais
	@Column(name="cat_lib_en")
	private String lib_en;
	
	@Column(name="cat_desc")
	private String desc;
	
	@OneToMany(mappedBy="cat")
	private List<Champ> champs;
	
	public Categorie(){
		
	}
	
	public Categorie(String lib, String lib_en, String desc) {
		super();
		this.lib = lib;
		this.lib_en = lib_en;
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
	
	public void addChamp(Champ champ) {
		this.champs.add(champ);
	}

	public String getLib_en() {
		return lib_en;
	}

	public void setLib_en(String lib_en) {
		this.lib_en = lib_en;
	}
	

}
