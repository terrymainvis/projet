package glp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Parametre {
	

	@Id
	@GeneratedValue
	@Column(name="ann_id")
	private int id;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="date_limite")
	private Date date_limite;
	
	@Column(name="total_annonce")
	private String total_annonce;

	public Date getDate_limite() {
		return date_limite;
	}

	public void setDate_limite(Date date_limite) {
		this.date_limite = date_limite;
	}

	public String getTotal_annonce() {
		return total_annonce;
	}

	public void setTotal_annonce(String total_annonce) {
		this.total_annonce = total_annonce;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Parametre() {
		super();
	}

}
