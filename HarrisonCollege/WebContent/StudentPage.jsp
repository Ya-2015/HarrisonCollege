<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">
</head>
<%//HttpSession session = request.getSession();
	String uName = (String) session.getAttribute("netid");
	if (uName != null)
	response.sendRedirect("HomePage"); %>
<body>
	<jsp:include page="/Navbar.jsp" />
	<div class="container">
		<h2 style="color: white">Welcome Student</h2>
		<div class="panel-group">
			<div class="panel panel-info">
				<div class="panel-heading">Course Manager</div>
				<div class="panel-body">
					<a href="EnrollClassServlet">Add Courses</a><br>
					<a href="">Drop Courses</a><br>
					<a href="">Current Schedule</a><br>
					<a href="CourseExplorerMainServlet">Go To Course Explorer</a><br>
				</div>
			</div>
			<div class="panel panel-info">
				<div class="panel-heading">Transcript Manager</div>
				<div class="panel-body">
					<a href="">View Unofficial Transcript</a><br>
					 <a href="">Buy Official Transcript</a><br>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/Footer.jsp" />

	

</body>
</html>