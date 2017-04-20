package test;

import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import beans.Role;
import beans.Task;
import beans.User;
import beans.UserLeaves;
import dao.UsersDAO;
import dao.UsersJDBCDAO;

public class UsersDAOTestCase extends TestCase {

	UsersDAO usersDAO;
	@Before
	public void setUp() throws Exception {
		usersDAO=new UsersJDBCDAO();		
	}

	@After
	public void tearDown() throws Exception {
		usersDAO=null;
	}

	@Test
	public void testUsersDAO() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddRole() {
		int i=usersDAO.addRole("Marketing");
		System.out.println(i);
	}

	@Test
	public void testRoleListing() {
		List<Role> list=usersDAO.roleListing();
		for(Role r:list) {
			System.out.println(r);
		}
	}

	@Test
	public void testAddUser() {
		int i=usersDAO.addUser(new User(0, "mno", "uvw", 4));
		System.out.println(i);
	}

	@Test
	public void testUserListing() {
		List<User> list=usersDAO.userListing();
		for(User u:list) {
			System.out.println(u);
		}
	}

	@Test
	public void testApplyLeave() {
		boolean b=usersDAO.applyLeave(1, "cl", 5);
		System.out.println(b);		
	}

	@Test
	public void testMyLeaveList() {
		List<UserLeaves> list=usersDAO.myLeaveList(1);
		for(UserLeaves ul:list) {
			System.out.println(ul);
		}
	}

	@Test
	public void testLeaveListing() {
		List<UserLeaves> list=usersDAO.leaveListing();
		for(UserLeaves ul:list) {
			System.out.println(ul);
		}
	}

	@Test
	public void testAddTask() {
		int i=usersDAO.addTask(4, "Clean Your System");
		System.out.println(i);			
	}

	@Test
	public void testMyTaskListing() {
		List<Task> list=usersDAO.myTaskListing(1);
		for(Task task:list) {
			System.out.println(task);
		}		
	}

	@Test
	public void testAllTaskListing() {
		List<Task> list=usersDAO.allTaskListing();
		for(Task task:list) {
			System.out.println(task);
		}
	}
}
