package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leave")
public class Leave {

	@Id
	@Column(name="ltid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ltid;
	@Column(name="ltname")
	private String ltname;
	@Column(name="lduration")
	private int lduration;
	
	public Leave() {
		// TODO Auto-generated constructor stub
	}

	public Leave(int ltid, String ltname, int lduration) {
		super();
		this.ltid = ltid;
		this.ltname = ltname;
		this.lduration = lduration;
	}

	public int getLtid() {
		return ltid;
	}

	public void setLtid(int ltid) {
		this.ltid = ltid;
	}

	public String getLtname() {
		return ltname;
	}

	public void setLtname(String ltname) {
		this.ltname = ltname;
	}

	public int getLduration() {
		return lduration;
	}

	public void setLduration(int lduration) {
		this.lduration = lduration;
	}

	@Override
	public String toString() {
		return "Leave [ltid=" + ltid + ", ltname=" + ltname + ", lduration="
				+ lduration + "]";
	}

	
}
