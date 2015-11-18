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
<%
	//HttpSession session = request.getSession();
	String uName = (String) session.getAttribute("netid");
	if (uName == null)
		response.sendRedirect("HomePage");
%>
<body>
	<jsp:include page="/Navbar.jsp" />
	<div class="container">
		<h2 style="color: white">Welcome Administrator</h2>
		<div class="panel-group">
			<div class="panel panel-info">
				<div class="panel-heading">
					<font size="4">Course Manager</font>
				</div>
				<div class="panel-body">
					<a href="">Create Courses</a><br>
					 <a href="">Update Courses</a><br>
					  <a href="CourseExplorerMainServlet">List Courses</a><br>
					   <a href="">Disable Courses</a><br>
				</div>
			</div>

			<div class="panel panel-info">
				<div class="panel-heading">
					<font size="4">Class Manager</font>
				</div>
				<div class="panel-body">
					<a href="">Override Maximum Enrollment Hold </a><br>
				</div>
			</div>
			<div class="panel panel-info">
				<div class="panel-heading">
					<font size="4">Classroom Manager</font>
				</div>
				<div class="panel-body">
					<a href="">Create Classrooms</a><br>
					<a href="">Update Classrooms</a><br>
					<a href="">List Classrooms</a><br>
					<a href="">Disable Classrooms</a><br>
					<a href="">View Classrooms used by course</a><br>
					<a href="">View Classrooms used by instructor</a><br>
					<a href="">View Classrooms used by student</a><br>
					
				</div>
			</div>

			<div class="panel panel-info">
				<div class="panel-heading">
					<font size="4">Department Manager</font>
				</div>
				<div class="panel-body">
					<a href="">Create Departments</a><br> <a href="">Update
						Departments</a><br> <a href="">List Departments</a><br> <a
						href="">Disable Departments</a><br>
				</div>
			</div>

			<div class="panel panel-info">
				<div class="panel-heading">
					<font size="4">Major Manager</font>
				</div>
				<div class="panel-body">
					<a href="">Create Major</a><br> <a href="">Update Major</a><br>
					<a href="">List Major</a><br> <a href="">Disable Major</a><br>
				</div>

			</div>

			<div class="panel panel-info">
				<div class="panel-heading">
					<font size="4">Major Manager</font>
				</div>
				<div class="panel-body">
					<a href="">Create Major</a><br> <a href="">Update Major</a><br>
					<a href="">List Major</a><br> <a href="">Disable Major</a><br>
				</div>

			</div>

			<div class="panel panel-info">
				<div class="panel-heading">
					<font size="4">Schedule Manager</font>
				</div>
				<div class="panel-body">
					<a href="">Add Class To Schedule</a><br> <a href="">Remove
						Class From Schedule</a><br>
				</div>

			</div>

			<div class="panel panel-info">
				<div class="panel-heading">
					<font size="4">User Manager</font>
				</div>
				<div class="panel-body">
					<a href="">Change User Class</a><br>
				</div>
			</div>

			<div class="panel panel-info">
				<div class="panel-heading">
					<font size="4">Course and Class Explorer</font>
				</div>
				<div class="panel-body">
					<a href="">Go To Course Explorer</a><br>
					<a href="">View All Classes</a><br>
					<a href="">Students By Instructor</a><br>
					<a href="">Instructors by Course</a><br>
					<a href="">Classes by Student</a><br>

				</div>
			</div>
		</div>
	</div>


	<jsp:include page="/Footer.jsp" />



</body>
</html>