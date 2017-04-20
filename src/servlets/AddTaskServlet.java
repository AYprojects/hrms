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
@WebServlet("/AddTaskServlet")
public class AddTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	UsersDAO usersDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTaskServlet() {
        usersDAO = DAOFactory.getUsersDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int usrid=Integer.parseInt(request.getParameter("usrid").trim());
		String taskDetail=request.getParameter("taskDetail").trim();
		int tid=usersDAO.addTask(usrid, taskDetail);
		if(tid!=0) {
			out.println("Task "+tid+" added. ");
		}
		out.flush();
		out.close();
	}
}
