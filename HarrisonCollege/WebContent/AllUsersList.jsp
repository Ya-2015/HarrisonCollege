<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users</title>
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
	<div class="container">
		<nav class="navbar navbar-default">
		<div class="container">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>


					<a class="navbar-brand">Harrison College!</a> <a
						class="navbar-brand" href="#">Transcript</a> <a
						class="navbar-brand" href="#">${myUser.username}</a> <a
						class="navbar-brand" href="LogoutServlet">Log Out</a>

				</div>

			</div>
		</div>
		</nav>
		</br>

		<div class="panel panel-default">

			<div class="panel-body">
				<form action="ChangeType" method="post">

					<table class="table table-striped">
						<thead>

							<tr>

								<th>User NetId</th>
								<th>User Type</th>

								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="u" items="${AllUsers}">
								<tr>
									<td>${u.netid}</td>
									<td>${u.usertype}</td>

									<td>
										<div class="dropdown">


											Change Type : <select name="type">

												<option value="1">1 (Student)</option>
												<option value="2">2 (Instructor)</option>
												<option value="3">3 (Advisor)</option>
												<option value="4">4 (Administrator)</option>


											</select>

										</div> <input type="hidden" value="${u.netid}" name="netId">
										<br>
										<button type="submit" class="btn btn-default">Submit</button>

									</td>
								</tr>

							</c:forEach>


						</tbody>
					</table>





				</form>
				<a href="UserClassRedirectorServlet" class="btn btn-info"
					role="button">Back To Home</a>
			</div>
		</div>
	</div>
</body>
</html>