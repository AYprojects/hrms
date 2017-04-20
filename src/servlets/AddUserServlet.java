package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.UsersDAO;
import factory.DAOFactory;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UsersDAO usersDAO;

	
	public AddUserServlet() {
		super();
        usersDAO = DAOFactory.getUsersDAO();
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("username").trim();
		String pass=request.getParameter("password").trim();
		int rid=Integer.parseInt(request.getParameter("rid").trim());
		int uid=usersDAO.addUser(new User(0,userName, pass, rid));
		out.println("User "+userName+" added with User ID "+uid);
		out.flush();
		out.close();
	}

}
