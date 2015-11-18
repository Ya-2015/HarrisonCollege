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
<%//HttpSession session = request.getSession();
	String uName = (String) session.getAttribute("netid");
	if (uName != null)
	response.sendRedirect("HomePage"); %>
<body>
<div class="container">
<nav class="navbar navbar-default">
      <div class="container">
	<div class="container">
		<div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          
           
          <a class="navbar-brand">Harrison College!</a> 
            
              
         
          <a class="navbar-brand" href="#">Transcript</a>
        
          <a class="navbar-brand" href="#">${myUser.username}</a>
       
				<a class="navbar-brand" href="LogoutServlet">Log Out</a>

        </div>

      </div>
      </div>
    </nav>
    </br >

<div class="panel panel-default">

  <div class="panel-body">
 	
  
		<table class="table table-striped">
<thead>

			<tr>
			  
				<th>Student Number</th>
				<th>Student Name</th>
		          
		            <th></th>
			</tr>
</thead>
<tbody>
<c:forEach var="s" items="${AllStudents}">
             <tr>
			    <td>${s.studentnum}</td>
				 <td>${s.studentname}</td>
			 
			  <td><a href="http://localhost:8080/HarrisonCollege/ViewStudentTranscript?studentNUM=${s.studentnum}">ViewTranscript</a></td>
			
  
			
</c:forEach>
              

</tbody>
		</table>
		
	
						
						

						</form>
					</div>
	</div>			
</body>
</html>