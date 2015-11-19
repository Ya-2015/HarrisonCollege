<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Course Status</title>
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

	

			<div class="panel panel-default">

				<div class="panel-body">
					<form action="ChangeStatusCourse" method="post">
                      <label>Course Number:</label><input type="text"
							name="Coursecode" size="20"
							value="<%=request.getParameter("Coursecode")%>" /> <br>
						<label>Course Current Status:</label><input type="text"
							name="courseStatus" size="20"
							value="<%=request.getParameter("Coursestatus")%>" /> <br>
						<label>Subject Code:</label><input type="text"
							name="subjectCode" size="20"
							value="<%=request.getParameter("subjectCode")%>" /> <br>
						<label>Course Name:</label><input type="text"
							name="courseName" size="20"
							value="<%=request.getParameter("courseName")%>" /> <br>	
						<label>Department Name:</label><input type="text"
							name="departmentName" size="20"
							value="<%=request.getParameter("departmentName")%>" /> <br>		
						<label>Description:</label><input type="text"
							name="Description1" size="20"
							value="<%=request.getParameter("description")%>" /> <br>	
						<label>Credit:</label><input type="text"
							name="credit" size="20"
							value="<%=request.getParameter("credit")%>" /> <br>				
							
						<label>Update the Course:</label>	
							<br><div class="dropdown">
  
  
				  Change Status:
				 
				   <select name = "status">
				   
				<option value="1">1 (Enable)</option>
				  <option value="0">0 (Disable)</option>
				 
				 
				 

										
										<br>
										
         
		   <input type="Text" class="form-control" name="subjectcode" placeholder="subjectcode" required>	
		   <br>		
           <input type="Text" class="form-control" name="coursename" placeholder="coursename" required>
           <br>
            <input type="Text" class="form-control" name="description" placeholder="description" required>
            <br>
             <input type="Text" class="form-control" name="credits" placeholder="credits" required>
             <br>
				   </div>
				   
				   
						 <br>
						<button type="submit" class="btn btn-info">Submit</button>
					</form>
						

				</div>
			</div>

	<a href="UserClassRedirectorServlet" class="btn btn-info" role="button">Back To Home</a>
</body>
</html>