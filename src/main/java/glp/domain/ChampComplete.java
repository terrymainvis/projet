package glp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ChampComplete implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name="ann_id")
	private Annonce ann;
	
	@Id
	@ManyToOne
	@JoinColumn(name="champ_id")
	private Champ champ;
	
	@Column(name="valeur")
	private String valeur;

	public ChampComplete() {
		super();
	}

	public ChampComplete(Annonce ann, Champ champ, String valeur) {
		super();
		this.ann = ann;
		this.champ = champ;
		this.valeur = valeur;
	}

	public Annonce getAnn() {
		return ann;
	}

	public void setAnn(Annonce ann) {
		this.ann = ann;
	}

	public Champ getChamp() {
		return champ;
	}

	public void setChamp(Champ champ) {
		this.champ = champ;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
	
	
}
