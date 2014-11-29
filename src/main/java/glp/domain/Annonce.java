package glp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Annonce {
	
	@Id
	@GeneratedValue
	@Column(name="ann_id")
	private int id;
	
	@Column(name="ann_desc")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="cat_id")
	private Categorie categorie;
	
	public Annonce(){
		
	}
	
	public Annonce(String desc, Categorie cat){
		this.description = desc;
		this.categorie = cat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
}
