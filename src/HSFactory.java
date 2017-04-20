
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HSFactory {

	public static Session getSession() throws Exception {
		Configuration c = new Configuration();
		c.configure("../hibernate.cfg.xml");
		SessionFactory sf = c.buildSessionFactory();
		Session s = sf.openSession(); // con=DM.getConnection(url,user,pass)
		return s;
	}

}
