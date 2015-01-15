package glp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"uti_mail_lille1"}))
public class Utilisateur {
	
	@Id
	@GeneratedValue
	@Column(name="uti_id")
	private int id;
	
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
	
	@Column(name="uti_bool_contact")
	@Value("false")
	private boolean contactAutreMail;
	
	@Column(name="role_id")
	private int roleId;
	
	public Utilisateur(){}
	
	public Utilisateur(String prenom, String nom, String mailLille1) {
		this.prenom=prenom;
		this.nom=nom;
		this.mailLille1=mailLille1;
	}
	
	public Utilisateur(String prenom, String nom, String mailLille1, int roleId) {
		this.prenom=prenom;
		this.nom=nom;
		this.mailLille1=mailLille1;
		this.roleId=roleId;
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

	public String getMailLille1() {
		return mailLille1;
	}
	
	public void setMailLille1(String mailLille1){
		this.mailLille1 = mailLille1;
	}

	public boolean isContactAutreMail() {
		return contactAutreMail;
	}

	public void setContactAutreMail(boolean contactAutreMail) {
		this.contactAutreMail = contactAutreMail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	
	
	
}
