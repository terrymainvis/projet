package glp.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Champ {

	@Id
	@GeneratedValue
	@Column(name="champ_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="cat_id")
	private Categorie cat;
	
	@OneToMany(mappedBy="champ")
	private Set<ChampComplete> champscompletes;
	
	/**
	 * type du champ (du texte, une description (gros bloc de texte), ou une valeur)
	 */
	@Column(name="type")
	private TypeChampEnum type;
	
	@Column(name="nom")
	private String nom;
	
	//le nom du chap en anglais
	@Column(name="nom_en")
	private String nom_en;
	
	@Column(name="requis")
	private boolean requis;

	public Champ() {
		super();
	}

	public Champ(int id, String nom, String nom_en, Categorie cat, TypeChampEnum type, boolean requis) {
		super();
		this.id = id;
		this.nom = nom;
		this.nom_en = nom_en;
		this.cat = cat;
		this.type = type;
		this.requis = requis;
	}
	public Champ( String nom, String nom_en, Categorie cat, TypeChampEnum type, boolean requis) {
		super();
		this.nom = nom;
		this.nom_en = nom_en;
		this.cat = cat;
		this.type = type;
		this.requis = requis;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<ChampComplete> getChampscompletes() {
		return champscompletes;
	}

	public void setChampscompletes(Set<ChampComplete> champscompletes) {
		this.champscompletes = champscompletes;
	}

	public boolean isRequis() {
		return requis;
	}

	public void setRequis(boolean requis) {
		this.requis = requis;
	}

	public String getNom_en() {
		return nom_en;
	}

	public void setNom_en(String nom_en) {
		this.nom_en = nom_en;
	}
	
	
}
