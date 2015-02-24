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
public class Forum {
	
	@Id
	@GeneratedValue
	@Column(name="forum_id")
	private int id;
	
	
	@Size(min=4, max=30)
	@Column(name="forum_titre")
	private String titre;
	
	@Size(min=5, max=500)
	@Column(name="forum_desc")
	private String desc;
	
	@Column(name="forum_date_pub")//date de publication
	private Date date_pub;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="forum_date_fin")
	private Date date_fin;
	
	@ManyToOne
	@JoinColumn(name="uti_id")
	private Utilisateur auteur;
	
	@Column(name="forum_valide")
	private Boolean valide;
	
	@Column(name="signalements")
	private int signalements;
	
	public Forum(){
		
	}
	
	public Forum(String titre, String desc, Date date_pub,Utilisateur uti ){
		this.titre= titre;
		this.desc= desc;
		this.date_pub = new Date();
		this.auteur=uti;
	}
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public String getTitre(){
		return titre;
	}
	public void setTitre(String titre){
		this.titre=titre;
	}
	public String getDesc(){
		return desc;
	}
	public void setDesc(String desc){
		this.desc= desc;
	}
	public Date getDate_pub() {
		return date_pub;
	}

	public void setDate_deb(Date date_pub) {
		this.date_pub = date_pub;
	}
	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public Utilisateur getAuteur() {
		return auteur;
	}
	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}
	public Boolean getValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public int getSignalements() {
		return signalements;
	}

	public void setSignalements(int signalements) {
		this.signalements = signalements;
	}
	
	
	
}
