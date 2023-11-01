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
	<div class="container">
	
		<div class="row">
			<div class="col text-center">
				<a href="/policies"><h2>Accept/Deny Policies</h2></a>
			</div>
			<div class="col text-center">
				<h2>Accept/Deny Claims</h2>
				
			</div>
		</div>

		<div class="text-center">
			<h1 class="mt-5">Admin: Dillon's Auto Insurance</h1>
			<h1 class="mt-5">Policy Accepter/Rejecter</h1>
		
			

			<table>
				<tr><th>Claim ID</th><th>Policy Number</th><th>Insured</th><th>Car</th><th>Action</th></tr>
				<c:forEach items="${claims}" var="c">
					<tr>${c}</tr>
					<tr><td>${c.id}</td><td>${c.policy.policyNumber}</td><td> ${c.policy.insured.firstName} ${c.policy.insured.lastName}</td><td>${c.car.vin} - ${c.car.model} ${c.car.make}, ${c.car.year}</td><td><a href="http://localhost:8282/acceptClaim?id=${c.id}">Accept</a> | <a href="http://localhost:8282/rejectClaim?id=${c.id}">Reject</a></td></tr>
				</c:forEach>
			</table>

		</div>
	
	</div>

</body>
</html>