<%@page import="beans.Task"%>
<%@page import="java.util.List"%>
<%@page import="factory.DAOFactory"%>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/css/bootstrap.min.css">
  <script src="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/css/jquery.min.js"></script>
  <script src="bootstrap-3.3.7-dist/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>

<body>
<!-- navbar -->
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="http://www.">HRMS</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown">
	     <a class="dropdown-toogle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" href="#">Role<span class="caret"></span></a>
		 <ul class="dropdown-menu">
		     <li class="dropdown">
			    <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" href="AddRole.html">Add</a>
			 </li>
		     <li class="dropdown">
			    <a class="dropdown-toggle" href="RoleListing.html">Listing</a>
			 </li>
		 </ul>
	  </li>
      <li><a href="#">User</a></li>
      <li><a href="#">Leave</a></li>
      <li><a href="#">Task</a></li>
    </ul>
  </div>
</nav>


<%
dao.UsersDAO usersDAO=DAOFactory.getUsersDAO();
List<Task> list=usersDAO.allTaskListing();
/*
<Task> called as appling generics, generic will tell 
collection to spcify which type of objects are stored in List
*/
%>
<TABLE align='center' class="table table-hover">
 <TR>
  <TH>Task ID</TH>
  <TH>Task Detail</TH>
  <TH>User ID</TH>
 </TR>

<%for(Task task:list) {
%>
 <TR>
  <TD><%=task.getTid()%></TD>
  <TD><%=task.getTdetail()%></TD>
  <TD><%=task.getUsrid()%></TD>
 </TR>	
<%
}
%>
</TABLE>
</body>
</html>