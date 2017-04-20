package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Role;
import beans.User;
import dao.UsersDAO;
import factory.DAOFactory;

/**
 * Servlet implementation class UserListingServlet
 */
@WebServlet("/UserListingServlet")
public class UserListingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	UsersDAO usersDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListingServlet() {
        super();
        usersDAO = DAOFactory.getUsersDAO();        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<User> list = usersDAO.userListing();
		out.println("<TABLE>");
		out.println("<TR>");
		out.println("<TH>User ID </TH>");
		out.println("<TH>User Name </TH>");
		out.println("<TH>Role ID </TH>");
		out.println("</TR>");
		for(User user:list) {
			out.println("<TR>");
			out.println("<TD>"+user.getUsrid()+"</TD>");
			out.println("<TD>"+user.getUname()+"</TD>");
			out.println("<TD>"+user.getRid()+"</TD>");
			out.println("</TR>");			
		}
		out.println("</TABLE>");		
	}
}
