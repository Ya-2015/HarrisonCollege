<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Unofficial Transcript</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous" rel="stylesheet">
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"
	integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX"
	crossorigin="anonymous">
</head>
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
                             <th>Class Number</th>
                             <th>Subject Code</th>
							<th>Course Name</th>
							<th>Name</th>
							<th>Credits</th>
							<th>Grade</th>
							<th>Semester</th>
							<th>Year</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="t" items="${TheStudentTranscript}">
							<tr>
							   <td>${t.hclass.classnum}</td>
							   <td>${t.hclass.hcourse.subjectcode}</td>
								<td>${t.hclass.hcourse.coursename}</td>
								<td>${t.hstudent.studentname}</td>
								<td>${t.hclass.hcourse.credits}</td>
								<td>${t.grade}</td>
								<td>${t.hclass.hsemester.semester}</td>
								<td>${t.hclass.hsemester.hyear}</td>
							</tr>

						</c:forEach>


					</tbody>
				</table>



				<a href="UserClassRedirectorServlet" class="btn btn-info"
					role="button">Back To Home</a>

			</div>
		</div>
	</div>



	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"
		integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ=="
		crossorigin="anonymous"></script>

</body>
</html>