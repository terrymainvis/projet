package glp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Utilisateur {
	
	@Id
	@Column(name="uti_mail_lille1")
	private String mailLille1;
	
	@Column(name="uti_prenom")
	private String prenom;
	
	@Column(name="uti_nom")
	private String nom;
	
	@Column(name="uti_mail_autre")
	private String mailAutre;
	
	@Column(name="uti_telephone")
	private String telephone;
	
	public Utilisateur(){}
	
	public Utilisateur(String prenom, String nom, String mailLille1) {
		this.prenom=prenom;
		this.nom=nom;
		this.mailLille1=mailLille1;
	}

	public String getMailEtudiant() {
		return mailLille1;
	}

	public void setMailEtudiant(String mailLille1) {
		this.mailLille1 = mailLille1;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMailAutre() {
		return mailAutre;
	}

	public void setMailAutre(String mailAutre) {
		this.mailAutre = mailAutre;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
