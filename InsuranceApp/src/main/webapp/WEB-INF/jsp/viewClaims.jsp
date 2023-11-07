<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<head>
<meta charset="ISO-8859-1">
<title>Home Page of Travel Gig</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src='js/policies.js'></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="home.css">

<style>
	input[type="number"]::-webkit-inner-spin-button,
	input[type="number"]::-webkit-outer-spin-button {
		-webkit-appearance: none;
		appearance: none;
	}
</style>

</head>
<body>

	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container">
				<a class="navbar-brand" href="home">Dillon Auto Insurance</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item">
							<a class="nav-link" href="home">Home</a>
						</li>
						

						<c:if test="${principal != null && !role.equals('ADMIN')}">
							<li class="nav-item">
								<a class="nav-link" href="viewClaims">Claims</a>
							</li>
						</c:if>
					
						<li class="nav-item">
							<a class="nav-link" href="login?logout">Logout</a>
						</li>
						
					</ul>
				</div>
			</div>
		</nav>
	</header>

	<div class="container">
	

		<div class="text-center">
			<h1 class="mt-5">Dillon's Auto Insurance</h1>
			<h1 class="mt-5">Open Claims</h1>

			<table class="table text-center">
				<tr>
					<th>Claim ID</th>
					<th>Policy Number</th>
					<th>Insured</th>
					<th>Car</th>
					<th>Claim Images</th>
					<th>Status</th>
				</tr>
				
				<c:forEach items="${claims}" var="c">
					<tr><td>${c.id}</td><td>${c.policy.policyNumber}</td><td> ${c.policy.insured.firstName} ${c.policy.insured.lastName}</td><td>${c.policy.car.vinNumber} - ${c.policy.car.model} ${c.policy.car.make}, ${c.policy.car.year}</td>
					<td>
						<c:forEach items="${c.photos}" var="photo">
							<img width="100px" height="auto" src="data:image/jpeg;base64,${photo.binaryData}" />	
						</c:forEach>
					</td>	
					<td>${c.status}</td></tr>
				</c:forEach>
			</table>

		</div>
	
	</div>

</body>
</html>