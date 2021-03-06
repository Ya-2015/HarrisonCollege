<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Drop Classes</title>
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



<div class = "container">
	<div class="panel panel-default">

		<div class="panel-body">
			<form action="dropDelete" method="post">

				<h1>Want to drop classes? Please provide your student number</h1>
				<br> <br> <label>Student Number:</label> <input
					type="text" size=20 value="" name="studentNumber"
					, placeholder="Your student number"> <br> <br>
				<button type="submit" class="btn btn-info">Submit</button>
			</form>
			<br><br>
			<a href="UserClassRedirectorServlet" class="btn btn-info"
				role="button">Back To Home</a>
		</div>
	</div>
</div>


	<jsp:include page="/Footer.jsp" />



</body>
</html>