<%@page import="factory.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
int usrid=Integer.parseInt(request.getParameter("usrid").trim());
dao.UsersDAO usersDAO=DAOFactory.getUsersDAO();
java.util.List<Integer> list=usersDAO.myLeaveList(usrid);
%>
<table>
  <tr>
   <th>Casual Leaves</th>
   <th>Earned Leaves</th>
  </tr>
  <tr>
   <td><%=(Integer)list.get(0) %></td>
   <td><%=(Integer)list.get(1) %></td>
  </tr>
</table>

</body>
</html>