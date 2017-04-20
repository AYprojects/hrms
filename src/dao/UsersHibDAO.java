package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Role;
import beans.Task;
import beans.User;
import beans.UserLeaves;
import factory.HSFactory;

public class UsersHibDAO implements UsersDAO {

	Session s;
	public UsersHibDAO() {
		try {
			s=HSFactory.getSession();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int addRole(String rname) {
		int rid=0;
		
		try {
			Transaction t =s.beginTransaction();
			Role r=new Role(0,rname);
			s.save(r);
			s.flush();
			t.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rid;
	}
	
	public List roleListing() {
		List list=new ArrayList();
		try {
				Query q=s.createQuery("FROM Role");
				list=q.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int addUser(User user) {
		// pk generation
		int usrid=0;
		try {
			Transaction t =s.beginTransaction();
			s.save(user);
			s.flush();
			t.commit();	
			usrid=user.getUsrid();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usrid;
	}
	
    public List userListing() {
    	List<User> list=new ArrayList();
    	try {
   			Query q = s.createQuery("FROM User");
   			list = q.list();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return list;
    }
    
	public boolean applyLeave(int usrid, String leaveType, int noOfDays) {
		boolean flag=false;
		try {
			Transaction t=s.beginTransaction();
			Query q=s.createQuery("FROM UserLeaves WHERE usrid="+usrid);
			UserLeaves ul=(UserLeaves)q.uniqueResult();
			if(leaveType.equalsIgnoreCase("cl")) {
				ul.setClleft(ul.getClleft()-noOfDays);
			} else {
				ul.setElleft(ul.getElleft()-noOfDays);
			}
			s.update(ul);
			s.flush();
			t.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public List myLeaveList(int usrid) {
		List list=new ArrayList();
		try {
			Query q=s.createQuery("SELECT ul.clleft, ul.elleft FROM UserLeaves ul WHERE usrid="+usrid);
			Object o[]=(Object[])q.uniqueResult();
			System.out.println(o.getClass().getName());
			list.add(o[0]);
			list.add(o[1]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List leaveListing() {
		List<UserLeaves> list=new ArrayList();
		try {
			Query q=s.createQuery("FROM UserLeaves");
			list=q.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int addTask(int usrid, String tdetail) {
		int tid=0;
		try {
			Transaction t=s.beginTransaction();
			Task t1=new Task(0, tdetail, usrid);
			s.save(t1);
			s.flush();
			t.commit();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tid;
	}
	
	public List myTaskListing(int usrid) {
		List<Task> list=new ArrayList();
		try {
			Query q=s.createQuery("FROM Task WHERE usrid="+usrid);
			list=q.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List allTaskListing() {
		List<Task> list=new ArrayList();
		try {
			Query q=s.createQuery("FROM Task");
			list=q.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
