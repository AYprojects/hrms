package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;
import factory.DAOFactory;

/**
 * Servlet implementation class AddRoleServlet
 */
@WebServlet("/AddRoleServlet")
public class AddRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	UsersDAO usersDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRoleServlet() {
        usersDAO = DAOFactory.getUsersDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String roleName=request.getParameter("roleName").trim();
		int rid=usersDAO.addRole(roleName);
		if(rid!=0) {
			// to print on server console
			System.out.println("Role Name "+roleName+" Role ID is "+rid);
			// to print on browser
			out.println("Role Name "+roleName+" Role ID is "+rid);
		}
		out.flush();
		out.close();
	}
	
	
}
