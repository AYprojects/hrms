package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import beans.Leave;
import beans.Role;
import beans.Task;
import beans.User;
import beans.UserLeaves;

public interface UsersDAO {
	public int addRole(String rname);
	
	public List roleListing();
	
	public int addUser(User user);
	
    public List userListing();
    
	public boolean applyLeave(int usrid, String leaveType, int noOfDays);
	
	public List myLeaveList(int usrid) ;
	
	public List leaveListing() ;

	public int addTask(int usrid, String tdetail) ;
	
	public List myTaskListing(int usrid) ;
	
	public List allTaskListing() ;

}
