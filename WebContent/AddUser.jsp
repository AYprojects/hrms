<%@page import="factory.DAOFactory"%>
<%@page import="beans.Role"%>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/css/bootstrap.min.css">
  <script src="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/css/jquery.min.js"></script>
  <script src="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>

<body>
  <form class="form-horizontal" action="./AddUserServlet">
  <div class="form-group">
    <label class="control-label"">User Name:</label>
    <input type="text" class="form-control" id="username" name="username">
    <label class="control-label"">Password:</label>
    <input type="text" class="form-control" id="password" name="password">
    <label class="control-label"">Role ID:</label>
    <select class="form-control" id="rid" name="rid">
     <%
 		dao.UsersDAO udao = factory.DAOFactory.getUsersDAO();
 		java.util.List list = udao.roleListing();
 		java.util.Iterator i=list.iterator();
 		// System.out.println(list.size());
 		while(i.hasNext()) {
 			Role r=(Role)i.next();
	 %>
	 <option value="<%=r.getRid()%>"><%=r.getRname()%></option>
	 <%
 		}
	 %>  
 		</select>
  </div>
  <button type="submit" class="btn btn-success">Submit</button></form>
</body>
</html>
