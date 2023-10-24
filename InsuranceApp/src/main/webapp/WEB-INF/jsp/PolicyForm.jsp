<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
 <%
 String userId = request.getParameter("userId");
 String planId = request.getParameter("planId");
 String carId = request.getParameter("carId");

 %>
<head>
<meta charset="ISO-8859-1">
<title>Home Page of Travel Gig</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src='./js/policy.js'></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="home.css">
</head>
<body>
	<div class="container">
		<h1>Review Policy Information</h1>
		<input type="hidden" id="userId" value=<%=userId %>>
		<input type="hidden" id="planId" value=<%=planId %>>
		<input type="hidden" id="carId" value=<%=carId %>>


		<div class = "container" id="userContainer">
			<h2>User:</h2>
		</div>
		<br/>

		<div class= "container" id="carContainer">
			<h2>Car:</h2>
		</div>
		<br/>

		<div class = "container" id="planContainer">
			<h2>Plan:</h2>
		</div>

		<div class = "container" id="totalContainer">
			<h2>Total cost:</h2>

		</div>
		<div class="container">
			<button id="confirmPolicy">Confirm</button>
		</div>

	</div>

</body>
</html>