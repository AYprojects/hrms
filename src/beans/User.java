package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	@Column(name="usrid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int usrid;
	
	@Column(name="uname")	
	private String uname;
	
	@Column(name="pass")	
	private String pass;
	
	@Column(name="rid")	
	private int rid;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int usrid, String uname, String pass, int rid) {
		super();
		this.usrid = usrid;
		this.uname = uname;
		this.pass = pass;
		this.rid = rid;
	}

	public int getUsrid() {
		return usrid;
	}

	public void setUsrid(int usrid) {
		this.usrid = usrid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	@Override
	public String toString() {
		return "User [usrid=" + usrid + ", uname=" + uname + ", pass=" + pass
				+ ", rid=" + rid + "]";
	}

	
}
