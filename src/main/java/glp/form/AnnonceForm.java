package glp.form;

import glp.domain.Annonce;
import glp.domain.Categorie;

public class AnnonceForm {

	private Categorie cat_choisie;
	private Annonce annonce;
	
	public AnnonceForm() {
		
	}
	
	

	public AnnonceForm(Categorie cat_choisie, Annonce annonce) {
		super();
		this.cat_choisie = cat_choisie;
		this.annonce = annonce;
	}



	public Categorie getCat_choisie() {
		return cat_choisie;
	}

	public void setCat_choisie(Categorie cat_choisie) {
		this.cat_choisie = cat_choisie;
	}

	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
	
	
}
