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
import dao.UsersDAO;
import factory.DAOFactory;

/**
 * Servlet implementation class RoleListingServlet
 */
@WebServlet("/RoleListingServlet")
public class RoleListingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UsersDAO usersDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleListingServlet() {
        super();
        usersDAO = DAOFactory.getUsersDAO();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<Role> list = usersDAO.roleListing();
/*		
		<div class="container">
		<table class="table">
		 <tr>
		  <th>UID</th>
		  <th>Leaves</th>
		  <th>Tasks</th>
		  <th>Role</th>
		 </tr>
		 <tr class="success">
		  <td>1</td>
		  <td>25</td>
		  <td>System Clean</td>
		  <td>Development</td>
		 </tr>
		 <tr class="warning">
		  <td>1</td>
		  <td>25</td>
		  <td>System Clean</td>
		  <td>Development</td>
		 </tr>
		 <tr class="info">
		  <td>1</td>
		  <td>25</td>
		  <td>System Clean</td>
		  <td>Development</td>
		 </tr>
		 <tr class="error">
		  <td><button class="btn-sm btn-success">Success</button></td>
		  <td><button class="btn-md btn-warning">Warning</button></td>
		  <td><button class="btn-lg btn-info">info</button></td>
		  <td><button class="btn-lg btn-primary">Primary</button></td>
		 </tr>
		</table>
		</div>
*/
		
		out.println("<TABLE>");
		out.println("<TR>");
		out.println("<TH>Role ID </TH>");
		out.println("<TH>Role Name </TH>");
		out.println("</TR>");
		for(Role role:list) {
			out.println("<TR>");
			out.println("<TD>"+role.getRid()+"</TD>");
			out.println("<TD>"+role.getRname()+"</TD>");
			out.println("</TR>");			
		}
		out.println("</TABLE>");
	}
}
