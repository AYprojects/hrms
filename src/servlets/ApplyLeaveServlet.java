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
@WebServlet("/ApplyLeaveServlet")
public class ApplyLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UsersDAO usersDAO;

	
	public ApplyLeaveServlet() {
		super();
        usersDAO = DAOFactory.getUsersDAO();
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int usrid=Integer.parseInt(request.getParameter("usrid").trim());
		String leaveType=request.getParameter("leaveType").trim();
		int noOfDays=Integer.parseInt(request.getParameter("noOfDays").trim());
		boolean flag=usersDAO.applyLeave(usrid, leaveType, noOfDays);
		if(flag) {
			// to print on browser
			out.println("Congrats leave applied to usrid "+usrid+" leave type "+leaveType+" for "+noOfDays+" is granted");
		} else {
			out.println("Sorry you have to come every day");
		}
		out.flush();
		out.close();
	}

}
