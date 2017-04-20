package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Role;
import beans.Task;
import beans.User;

public class UsersJDBCDAO implements UsersDAO{

	Connection con;
	Statement stmt;
	PreparedStatement pstmt1, pstmt2, pstmt3, pstmt4;
	ResultSet rs;
	
	public UsersJDBCDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "temp", "temp");
			stmt=con.createStatement();
			pstmt1=con.prepareStatement("INSERT INTO roles VALUES (?,?)");
			pstmt2=con.prepareStatement("INSERT INTO users VALUES (?,?,?,?)");
			pstmt3=con.prepareStatement("UPDATE user_leaves SET clleft=clleft-?, elleft=elleft-? WHERE usrid=?");
			pstmt4=con.prepareStatement("INSERT INTO tasks VALUES (?,?,?)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int addRole(String rname) {
		int rid=0;
		try {
			rs=stmt.executeQuery("SELECT max(rid) FROM roles");
			if(rs.next()) {
				rid=rs.getInt(1);
			}
			rid++;
			
			pstmt1.setInt(1, rid);
			pstmt1.setString(2, rname);
			pstmt1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rid;
	}
	
	public List<Role> roleListing() {
		List<Role> list=new ArrayList();
		try {
			rs=stmt.executeQuery("SELECT * FROM roles");
			while(rs.next()) {
				Role role=new Role(rs.getInt(1), rs.getString(2));
				list.add(role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int addUser(User user) {
		// pk generation
		int usrid=0;
		try {
			rs=stmt.executeQuery("SELECT max(usrid) FROM users");
			if(rs.next()) {
				usrid=rs.getInt(1);
			}
			usrid++;
			
			// record insertion
			pstmt2.setInt(1, usrid);
			pstmt2.setString(2, user.getUname());
			pstmt2.setString(3, user.getPass());
			pstmt2.setInt(4, user.getRid());
			pstmt2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usrid;
	}
	
    public List userListing() {
    	List list=new ArrayList();
    	try {
			rs=stmt.executeQuery("SELECT * FROM users");
			while(rs.next()) {
				User user=new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return list;
    }
    
	public boolean applyLeave(int usrid, String leaveType, int noOfDays) {
		boolean flag=false;
		try {
			if(leaveType.equalsIgnoreCase("cl")) {
				stmt.executeUpdate("UPDATE user_leaves SET clleft=clleft-"+noOfDays+" WHERE usrid="+usrid);
				flag=true;
			} else if(leaveType.equalsIgnoreCase("el")) {
				stmt.executeUpdate("UPDATE user_leaves SET elleft=elleft-"+noOfDays+" WHERE usrid="+usrid);				
				flag=true;
			} else {
				flag=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public List myLeaveList(int usrid) {
		List list=new ArrayList();
		try {
			rs=stmt.executeQuery("SELECT clleft, elleft FROM user_leaves WHERE usrid="+usrid);
			if(rs.next()) {
				list.add(rs.getInt(1));
				list.add(rs.getInt(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List leaveListing() {
		List list=new ArrayList();
		try {
			rs=stmt.executeQuery("SELECT * FROM user_leaves");
			while(rs.next()) {
				beans.UserLeaves leaves=new beans.UserLeaves(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
				list.add(leaves);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int addTask(int usrid, String tdetail) {
		int tid=0;
		try {
			rs=stmt.executeQuery("SELECT max(tid) FROM tasks");
			if(rs.next()) {
				tid=rs.getInt(1);
			}
			tid++;
			pstmt4.setInt(1, tid);
			pstmt4.setString(2, tdetail);
			pstmt4.setInt(3, usrid);
			pstmt4.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tid;
	}
	
	public List myTaskListing(int usrid) {
		List list=new ArrayList();
		try {
			rs=stmt.executeQuery("SELECT * FROM tasks WHERE usrid="+usrid);
			while(rs.next()) {
				Task task=new Task(rs.getInt(1), rs.getString(2), rs.getInt(3));
				list.add(task);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List allTaskListing() {
		List list=new ArrayList();
		try {
			rs=stmt.executeQuery("SELECT * FROM tasks");
			while(rs.next()) {
				Task task=new Task(rs.getInt(1), rs.getString(2), rs.getInt(3));
				list.add(task);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
