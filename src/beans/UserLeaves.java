package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_leaves")
public class UserLeaves {

	@Id
	@Column(name="ulid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ulid;
	@Column(name="usrid")
	private int usrid;
	@Column(name="clleft")
	private int clleft;
	@Column(name="elleft")
	private int elleft;
	
	public UserLeaves() {
		// TODO Auto-generated constructor stub
	}

	public UserLeaves(int ulid, int usrid, int clleft, int elleft) {
		super();
		this.ulid = ulid;
		this.usrid = usrid;
		this.clleft = clleft;
		this.elleft = elleft;
	}

	public int getUlid() {
		return ulid;
	}

	public void setUlid(int ulid) {
		this.ulid = ulid;
	}

	public int getUsrid() {
		return usrid;
	}

	public void setUsrid(int usrid) {
		this.usrid = usrid;
	}

	public int getClleft() {
		return clleft;
	}

	public void setClleft(int clleft) {
		this.clleft = clleft;
	}

	public int getElleft() {
		return elleft;
	}

	public void setElleft(int elleft) {
		this.elleft = elleft;
	}

	@Override
	public String toString() {
		return "UserLeaves [ulid=" + ulid + ", usrid=" + usrid + ", clleft="
				+ clleft + ", elleft=" + elleft + "]";
	}

	
}
