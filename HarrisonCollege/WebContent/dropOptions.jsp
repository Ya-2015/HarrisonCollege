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


		<div class="panel panel-default">

			<div class="panel-body">
				<h4>
					StudentNumber: ${studentInfo.studentnum} <br> <small>Name:
						${studentInfo.studentname}</small><br> <br> <small>Year
						of Entry: ${studentInfo.yearofentry }</small><br> <br> <small>Department:
						${studentInfo.hmajor.hdepartment.departname }</small><br> <br> <small>Major:
						${studentInfo.hmajor.majorname }</small><br>
				</h4>

				<table class="table table-striped">
					<thead>

						<tr>

							<th>CRN Number</th>
							<th>DOW</th>
							<th>Specific Time</th>
							<th>Instructor</th>
							<th>BLDG</th>
							<th>Classroom#</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="d" items="${studentCurrentClass}">
							<tr>
								<td>${d.crn}</td>
								<td>${d.hschedule.dow1}${d.hschedule.dow2}</td>
								<td>${d.hschedule.hour12}:${d.hschedule.minutes60}${d.hschedule.ampm}</td>
								<td>${d.hinstructor.instructorname}</td>
								<td>${d.hclassroom.bldgname}</td>
								<td>${d.hclassroom.roomnumber}</td>
								<td><a
									href="http://localhost:8080/HarrisonCollege/realDrop?studentNUM=${studentInfo.studentnum}&classNUM=${d.classnum}">Drop</a></td>
							</tr>

						</c:forEach>


					</tbody>
				</table>
				<a href="UserClassRedirectorServlet" class="btn btn-info"
					role="button">Back To Home</a>
</body>
</html>