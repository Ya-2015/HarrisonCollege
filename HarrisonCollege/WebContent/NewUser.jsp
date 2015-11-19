<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">
</head>
<%
	//HttpSession session = request.getSession();
	String uName = (String) session.getAttribute("username");
	if (uName != null)
		response.sendRedirect("UserClassRedirectorServlet");
%>
<body>
	<jsp:include page="/Navbar.jsp" />

	<div style="color: orange" id="cont" class="container">
		<form action="AddUserServlet" method="POST">
			<div class="panel-group">
				<div class="panel panel-info">
					<div class="panel-heading">Provide NetID and select a Password</div>
					<div class="panel-body">
						<div class="form-group">
							<label for="username" style="color: #141452"></label> <input
								type="Text" class="form-control" name="username"
								placeholder="netid">
						</div>
						<br>

						<div class="form-group">
							<label for="password" style="color: #141452"></label> <input
								type="password" class="form-control" name="password"
								placeholder="Password">
						</div>
						<br>
						<!-- Single button -->
						<button class="btn btn-primary btn-sm">Sign Up</button>
					</div>
				</div>
			</div>
		</form>
		<br> <br>
	</div>


	<jsp:include page="/Footer.jsp" />

</body>
</html>