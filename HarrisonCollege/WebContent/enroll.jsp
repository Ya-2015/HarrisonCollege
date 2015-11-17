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
	if (uName != null)
		response.sendRedirect("HomePage");
%>
<body>
	<jsp:include page="/Navbar.jsp" />

	<c:choose>
		<c:when test="${sessionScope.usertype.equals("advisor")}">
			<div class="panel panel-default">

				<div class="panel-body">
					<form action="enrollInsert" method="post">

						<label>Enrolled Class:</label><input type="text"
							name="enrolledclass" size="20"
							value="<%=request.getParameter("Enrolledclass")%>" /> <br>
						<br> <label>Student Number:</label> <input type="text"
							size=20 value="" name="studentNumber"
							, placeholder="Your student number"> <br> <br>
						<button type="submit" class="btn btn-info">Submit</button>
					</form>

				</div>
			</div>
		</c:when>
		<c:when test="${sessionScope.usertype.equals("student")}">
			<div class="panel panel-default">

				<div class="panel-body">
					<form action="enrollInsert" method="post">

						<label>Enrolled Class:</label><input type="text"
							name="enrolledclass" size="20"
							value="<%=request.getParameter("Enrolledclass")%>" /> <br>
						<br> <label>Student Number:</label> <input type="text"
							size=20
							value="<%=(Integer) session.getAttribute("studentNumber")%>"
							name="studentNumber" , placeholder="Your student number">
						<br> <br>
						<button type="submit" class="btn btn-info">Submit</button>
					</form>

				</div>
			</div>

			<jsp:include page="/Footer.jsp" />
		</c:when>
	</c:choose>
</body>
</html>