<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instructors</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">
</head>
<%//HttpSession session = request.getSession();
	String uName = (String) session.getAttribute("netid");
	if (uName == null)
	response.sendRedirect("Login.jsp"); %>
<body>
	<jsp:include page="/Navbar.jsp" />
	<div class="container">
		<h3 style="color: white">Welcome Instructor</h3>
		<div class="panel-group">
			<div class="panel panel-info">
				<div class="panel-heading">Instructor Action Suite</div>
				<div class="panel-body">
					<a href="InstructorCurrentClassesServlet">View All Classes Currently Instructed</a><br>
					<a href="RosterServlet?semesterID=1">View Current Class Rosters</a><br>
					<a href="RosterServlet?semesterID=1">Current Gradebook </a><br>
					<a href="SemesterSelection">Historic Gradebooks</a><br>
					<a href="CourseExplorerMainServlet">Go To Course Explorer</a><br>
					<a href="MajorExplorerServlet">Major Explorer</a><br>
					<a href="ClassExplorerMainServlet">View All Classes On Campus</a><br>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/Footer.jsp" />

	

</body>
</html>