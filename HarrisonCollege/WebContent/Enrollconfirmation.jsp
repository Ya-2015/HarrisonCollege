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
	if (uName == null)
	response.sendRedirect("Login.jsp"); %>
<body>
 <div class="container">

 <c:if test="${EnrollFlag==true}">
  <h4>StudentNumber: ${studentInfo.studentnum }
					<br> <small>Name: ${ studentInfo.studentname}</small><br>
					
				</h4>
  
      <div class="starter-template">
        <h1>Congratulation! You have enrolled successfully.</h1>
        
        
       <label>Enrolled Class:</label>
         <p>${Enrolledclass.crn} ${Enrolledclass.hschedule.dow1} ${Enrolledclass.hschedule.dow2}  ${Enrolledclass.hschedule.hour12}:${Enrolledclass.hschedule.minutes60}${Enrolledclass.hschedule.ampm} 
         
          ${Enrolledclass.hinstructor.instructorname}  ${Enrolledclass.hclassroom.bldgname} ${Enrolledclass.hclassroom.roomnumber}</p>
       
      </div>
      </c:if>
<c:if test="${EnrollFlag==false}">      
<p>Failed</p>
</c:if>

      </div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"
		integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ=="
		crossorigin="anonymous"></script>
   

</body>
</html>