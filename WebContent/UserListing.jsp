<%@page import="factory.DAOFactory"%>
<%@page import="beans.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="./bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/css/bootstrap.css">
  <script src="./bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/css/jquery.min.js"></script>
  <script src="./bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

		<div class="container">
		<table class="table table-hover">
		 <tr>
		  <th>User ID</th>
		  <th>User Name</th>
		  <th>Password</th>
		  <th>Role ID</th>
		 </tr>
		 
		<%
		dao.UsersDAO usersDAO = DAOFactory.getUsersDAO();
		java.util.List<User> list = usersDAO.userListing();
		for(User user:list) {
		%>	
		<TR class="">
		<TD><%=user.getUsrid()%></TD>
		<TD><%=user.getUname()%></TD>
		<TD><%=user.getPass()%></TD>
		<TD><%=user.getRid()%></TD>
		</TR>
		<%			
		}
		%>
		 
		 <tr class="error">
		  <td><button class="btn-sm btn-success">Success</button></td>
		  <td><button class="btn-md btn-warning">Warning</button></td>
		  <td><button class="btn-lg btn-info">info</button></td>
		  <td><button class="btn-lg btn-primary">Primary</button></td>
		 </tr>
		</table>
		</div>


</body>
</html>