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
<script type="text/javascript" src='js/welcome.js'></script>
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
	<form onsubmit="return false;">
		<div class="text-center">
			<h1 class="mt-5">Welcome to Dillon's Auto Insurance!</h1>
		
		</div>
		<div class="form-group mt-4">
			<div class="row justify-content-center">
				<h2>Enter your ZIP code to get started!</h2>
			</div>
			<div class="row justify-content-center mt-4">
				<div class="col-md-6">
					<input type="number" class="form-control text-center" id="zipcode" placeholder="Zip Code"/>
				</div>
			</div>
			<div class="row justify-content-center mt-2">
				<div class="col-md-6 text-center">			
				<button type="button" id="userFormBtn">Submit</button>
				</div>
			</div>
		</div>
	</form>
	</div>

</body>
</html>