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
	
	@font-face { 
		font-family: 'MyCustomFont'; 
		src: 
			url('WEB-INF/fonts/Eurostile-Bold-Font.otf')  
			format('opentype'); 
		font-weight: normal; 
		font-style: normal; 
	} 
	h1 {
		font-family: "MyCustomFont", sans-serif;
	}
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

		<c:if test="${principal == null}">
			
			<div class="form-group mt-4">


				<div class="row justify-content-center">
					<h2>Get a free quote today!</h2>
				</div>

				<div class = "row">
					<p>
				</div>


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
					<c:if test="${principal != null}">
						<button type="button" id="userFormBtn">Submit</button>
					</c:if>		
						
					<c:if test="${principal == null}">
						<button type="button" id="nullUserFormBtn">Submit</button>
					</c:if>	
					</div>
				</div>
			</div>

		</c:if>

		<c:if test="${principal != null}">
			<a href="/claim">Create a claim.</a>
			<a href="/review">Review policy.</a>
		</c:if>

		
	</form>
	</div>

</body>
</html>