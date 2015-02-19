package glp.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
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
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch (FetchMode.SELECT)
	private Map<String,Role> roles;
	
	public Utilisateur(){}
	
	public Utilisateur(String prenom, String nom, String mailLille1) {
		this.prenom=prenom;
		this.nom=nom;
		this.mailLille1=mailLille1;
	}
	
	public Utilisateur(String prenom, String nom, String mailLille1, Map<String,Role> roles) {
		this.prenom=prenom;
		this.nom=nom;
		this.mailLille1=mailLille1;
		this.roles.putAll(roles);
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

	public Map<String,Role> getRoles() {
		if(roles!=null)
			return roles;
		return new HashMap<String,Role>();
	}

	public void setRoles(Map<String,Role> roles) {
		this.roles = roles;
	}
	
	public void setRoles(Role r) {
		roles = new HashMap<String,Role>();
		if(r!=null)
			roles.put(r.getNom().toUpperCase(),r);
	}
	
	public void addRole(Role role) {
		if(roles==null)
			roles = new HashMap<String,Role>();
		if(!roles.containsKey(role.getNom()))
			roles.put(role.getNom().toUpperCase(),role);
	}
	
	public void removeRole(Role role) {
		roles.remove(role.getNom());
	}
	
	public void removeRole(String role) {
		roles.remove(role);
	}
	
	
	
}
