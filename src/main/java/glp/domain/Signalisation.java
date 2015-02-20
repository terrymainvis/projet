package glp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Signalisation {
	
	
	@Id
	@GeneratedValue
	@Column(name="signal_id")
	private int id;
	
	@Size(min=5, max=500)
	@Column(name="signal_desc")
	private String desc;
	
	@ManyToOne
	@JoinColumn(name="forum_id")
	private Forum forum;
	
	public Signalisation(){
		
	}
	public Signalisation(String desc){
		this.desc=desc;
		}
	
	public Signalisation(String desc,Forum forum){
		this.desc=desc;
		this.forum=forum;
	}
	
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getDesc(){
		return desc;
	}
	public void setDesc(String desc){
		this.desc= desc;
	}
	public Forum getforum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}

}
