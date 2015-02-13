package glp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Job {
	
	@Id
	@GeneratedValue
	@Column(name="job_id")
	private int id;
	
	@Size(min=4, max=30)
	@Column(name="job_titre")
	private String titre;
	
	@Size(min=5, max=300)
	@Column(name="job_desc")
	private String desc;
	
	@Column(name="job_date_debut")
	private Date date_deb;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="job_date_fin")
	private Date date_fin;
	
	@ManyToOne
	@JoinColumn(name="uti_id")
	private Utilisateur auteur;
	
	@Size(min=4, max=30)
	@Column(name="job_prix")
	private String prix;
	
	@Size(min=4, max=30)
	@Column(name="job_mail")
	private String mail;
	
	public Job(){
		
	}
	
	
	public Job(String titre, String desc, Date date, String prix,String mail){
		this.titre = titre;
		this.desc = desc;
		this.date_fin = date;
		this.prix=prix;
		this.mail=mail;
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



	public Utilisateur getAuteur() {
		return auteur;
	}

	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}


	public String getPrix() {
		return prix;
	}


	public void setPrix(String prix) {
		this.prix = prix;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	
	



}
