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
		response.sendRedirect("HomePage");
%>
<body>
	<jsp:include page="/Navbar.jsp" />
	<div class="container">
		<form action="PurchasingServlet" method="POST">

			<div class="panel-group">
				<div class="panel panel-info">
					<div class="panel-heading">Shipping Address</div>
					<div class="panel-body">
						<div class="form-group">
							<label for="fullname" style="color: #141452"></label> <input
								type="Text" class="form-control" name="fullname"
								placeholder="Full Name">
						</div>

						<div class="form-group">
							<label for="addressln1" style="color: #141452"></label> <input
								type="Text" class="form-control" name="addressln1"
								placeholder="Address Line 1">
						</div>
						<div class="form-group">
							<label for="addressln2" style="color: #141452"></label> <input
								type="Text" class="form-control" name="addressln2"
								placeholder="Address Line 2">
						</div>
						<div class="form-group">
							<label for="city" style="color: #141452"></label> <input
								type="Text" class="form-control" name="city" placeholder="City">
						</div>
						<div class="form-group">
							<label for="state" style="color: #141452"></label> <input
								type="Text" class="form-control" name="state"
								placeholder="State">
						</div>
						<br>
						<div class="form-group">
							<label for="zip" style="color: #141452"></label> <input
								type="Text" class="form-control" name="zip"
								placeholder="Zip Code">
						</div>
					</div>
				</div>
			</div>
			<div class="panel-group">
				<div class="panel panel-info">
					<div class="panel-heading">Credit Card Information</div>
					<div class="panel-body">
						<div class="form-group">

							<span class="payment-errors"></span>

							<div class="form-row">
								<label> <span>Card Number</span> <input type="text"
									size="20" data-stripe="number" />
								</label>
							</div>

							<div class="form-row">
								<label> <span>CVC</span> <input type="text" size="4"
									data-stripe="cvc" />
								</label>
							</div>

							<div class="form-row">
								<label> <span>Expiration (MM/YYYY)</span> <input
									type="text" size="2" data-stripe="exp-month" />
								</label> <span> / </span> <input type="text" size="4"
									data-stripe="exp-year" />
							</div>
						</div>
					</div>
				</div>
			</div>

			<button class="btn btn-primary btn-sm">Submit</button>
		</form>

		<br> <br>
	</div>
	<jsp:include page="/Footer.jsp" />


</body>
</html>