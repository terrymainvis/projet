package glp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Champ {

	@Id
	@GeneratedValue
	@Column(name="champ_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="cat_id")
	private Categorie cat;
}
