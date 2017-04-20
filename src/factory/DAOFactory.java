package factory;

import dao.UsersDAO;
import dao.UsersHibDAO;


public class DAOFactory {

	static UsersDAO usersDAO;
	
	public static UsersDAO getUsersDAO() {
		if(usersDAO == null) {
			usersDAO = new UsersHibDAO();
		}
		return usersDAO;
	}
}
