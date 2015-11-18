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
<link rel="stylesheet"
	href="https://raw.githubusercontent.com/behigh/bootstrap_dropdowns_enhancement/master/dist/css/dropdowns-enhancement.css"
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
	<div class="container" style="overflow-y: scroll">
		<div class="container" style="background-color: white">
			<form action="Test.jsp" method="GET">
				<table class="table table-striped">

					<tr>
						<th><div class="dropdown">
								<button class="btn btn-primary dropdown-toggle" type="button"
									data-toggle="dropdown">
									Department <span class="caret"></span>
								</button>
								<ul class="dropdown-menu noclose">${departmentDropdown}
								</ul>
							</div></th>

						<th><div class="dropdown">
								<button class="btn btn-primary dropdown-toggle" type="button"
									data-toggle="dropdown">
									Subject <span class="caret"></span>
								</button>
								<ul class="dropdown-menu">${subjectDropdown}
								</ul>
							</div></th>
						<th><div class="dropdown">
								<button class="btn btn-primary dropdown-toggle" type="button"
									data-toggle="dropdown">
									Description <span class="caret"></span>
								</button>

							</div></th>
						<th><div class="dropdown">
								<button class="btn btn-primary dropdown-toggle" type="button"
									data-toggle="dropdown">Credits</button>
							</div></th>

						<th><a href="SortManagerServlet" class="btn btn-info"
							role="button">Sort</a></th>
						<th></th>
					</tr>

					${courseTable}
				</table>
			</form>
			<a href="UserClassRedirectorServlet" class="btn btn-info"
				role="button">Back To Home</a>
		</div>
	</div>
	<jsp:include page="/Footer.jsp" />



</body>
</html>