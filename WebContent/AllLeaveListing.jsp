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
dao.UsersDAO usersDAO=DAOFactory.getUsersDAO();
java.util.List<beans.UserLeaves> list=usersDAO.leaveListing();
%>
<table>
  <tr>   
  <th>User ID</th>
   <th>Casual Leaves</th>
   <th>Earned Leaves</th>
  </tr>
  <%
  	for (beans.UserLeaves ul:list) {
  %>
  <tr>
   <td><%=ul.getUsrid()%></td>
   <td><%=ul.getClleft()%></td>
   <td><%=ul.getElleft()%></td>
  </tr>
  <%
  }
  %>
</table>

</body>
</html>