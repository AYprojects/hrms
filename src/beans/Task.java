package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Task {

	@Id
	@Column(name="tid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tid;

	@Column(name="tdetail")
	private String tdetail;
	@Column(name="usrid")
	private int usrid;
	
	public Task() {
		// TODO Auto-generated constructor stub
	}

	public Task(int tid, String tdetail, int usrid) {
		super();
		this.tid = tid;
		this.tdetail = tdetail;
		this.usrid = usrid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTdetail() {
		return tdetail;
	}

	public void setTdetail(String tdetail) {
		this.tdetail = tdetail;
	}

	public int getUsrid() {
		return usrid;
	}

	public void setUsrid(int usrid) {
		this.usrid = usrid;
	}

	@Override
	public String toString() {
		return "Task [tid=" + tid + ", tdetail=" + tdetail + ", usrid=" + usrid
				+ "]";
	}

	
}
