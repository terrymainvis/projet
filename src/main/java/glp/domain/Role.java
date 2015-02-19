package glp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {
	
	@Id
	@GeneratedValue
	@Column(name="role_id")
	private int id;
	
	@Column(name="role_nom")
	private String nom;
	
	public Role(){}
	
	public Role(String nom) {
		this.nom=nom;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public boolean equals(Object o) {
		if(o==null)
			return false;
		Role r = (Role) o;
		if(this.getId()==r.getId() && this.getNom().equalsIgnoreCase(r.getNom()))
			return true;
		return false;
	}
	
	@Override
	public String toString() {
		return this.getNom();
	}
}
