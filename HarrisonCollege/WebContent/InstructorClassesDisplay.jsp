<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instructed Classes</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">
</head>
<%
	//HttpSession session = request.getSession();
	String uName = (String) session.getAttribute("netid");
	if (uName == null)
		response.sendRedirect("Login.jsp");
%>
<body>
	<jsp:include page="/Navbar.jsp" />
	<div class="container">
		<h2 style="color: white">Welcome Instructor San</h2>
		<div class="panel-group">
			<div class="panel panel-info">
				<div class="panel-heading">Your Classes</div>
				<div class="panel-body">
					<table class="table table-striped">
						<tr>
							<th>Building</th>
							<th>Room Number</th>
							<th>Course</th>
							<th>Days</th>
							<th>Time</th> 
							</tr>
							${scheduleDropdown}
					</table>
				</div>
			</div>
		</div>
		<a href="UserClassRedirectorServlet" class="btn btn-info" role="button">Back To Home</a>
	</div>
	<jsp:include page="/Footer.jsp" />



</body>
</html>