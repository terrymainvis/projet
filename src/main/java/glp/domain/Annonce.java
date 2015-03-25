package glp.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Annonce {
	
	@Id
	@GeneratedValue
	@Column(name="ann_id")
	private int id;
	
	@Column(name="ann_titre")
	private String titre;
	
	@Column(name="ann_desc")
	private String desc;
	
	@Column(name="ann_date_debut")
	private Date date_deb;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="ann_date_fin")
	private Date date_fin;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="cat_id")
	private Categorie categorie;
	
	@Column(name="ann_type")
	private String type; // l'user "propose" ou "demande"
	
	@ManyToOne
	@JoinColumn(name="uti_id")
	private Utilisateur auteur;
	
	@OneToMany(mappedBy="ann")
	private List<ChampComplete> champscompletes;
	
	@Column(name="ann_valide")
	private Boolean valide;
	
	public Annonce(){
		
	}
	
	public Annonce(String titre, String desc, Date date, Categorie cat, Utilisateur uti){
		this.titre = titre;
		this.desc = desc;
		this.date_fin = date;
		this.categorie = cat;
		this.date_deb = new Date();
		this.auteur = uti;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String description) {
		this.desc = description;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDate_deb() {
		return date_deb;
	}

	public void setDate_deb(Date date_deb) {
		this.date_deb = date_deb;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Utilisateur getAuteur() {
		return auteur;
	}

	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}

	public List<ChampComplete> getChampscompletes() {
		return champscompletes;
	}

	public void setChampscompletes(List<ChampComplete> champscompletes) {
		this.champscompletes = champscompletes;
	}

	public Boolean getValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

}
