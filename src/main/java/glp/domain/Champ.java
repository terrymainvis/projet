package glp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Champ {

	@Id
	@GeneratedValue
	@Column(name="champ_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="cat_id")
	private Categorie cat;
	
	/**
	 * type du champ (du texte, une description (gros bloc de texte), ou une valeur)
	 */
	@Column(name="type")
	private TypeChampEnum type;

	public Champ() {
		super();
	}

	public Champ(int id, Categorie cat, TypeChampEnum type) {
		super();
		this.id = id;
		this.cat = cat;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Categorie getCat() {
		return cat;
	}

	public void setCat(Categorie cat) {
		this.cat = cat;
	}

	public TypeChampEnum getType() {
		return type;
	}

	public void setType(TypeChampEnum type) {
		this.type = type;
	}
	
	
}
