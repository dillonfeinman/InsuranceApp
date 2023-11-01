<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
 <%
 String userId = request.getParameter("userId");
 String carId = request.getParameter("carId");
 String planId = request.getParameter("planId");

 %>
<head>
<meta charset="ISO-8859-1">
<title>Home Page of Travel Gig</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<!--<script src='./js/payment.js'></script>!-->
<script src="https://js.stripe.com/v3/"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="home.css">
</head>
<body>
	<div class="container">
		<input type="hidden" id="userId" value=<%=userId%>>
		<input type="hidden" id="carId" value=<%=carId%>>
		<input type="hidden" id="planId" value=<%=planId%>>


		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h2 class="mt-4">Payment Information</h2>
				<form method="post">
					<input type="hidden" id="clientSecret" value="${clientSecret}">

					<div id="card-element">

						<!-- A Stripe Element will be inserted here. -->
					 </div>
				
					<script>
						var stripe = Stripe('pk_test_51NrTfQKqveMB4YN54b8fJn8TnilgeepM4sVslX6dusESWdmd7S9OXeMGxEVrqI58Thu1a9X61Uhox87JDKaEBvd800TOa75m4h');
						var elements = stripe.elements();
					 
						// Create an instance of the card Element.
						var card = elements.create('card');
					 
						// Add an instance of the card Element into the `card-element` div.
						card.mount('#card-element');
					 </script>
					<div class="form-group">
						<label for="name">Name</label>
						<input type="text" class="form-control" id="name" name="name" placeholder="John Doe" required>
					</div>
					<button type="submit" id="submitPayment" class="btn btn-primary">Submit Payment</button>
				</form>
			</div>
		</div>

		
		<script>
			$(document).ready(function(){
				let userId = $("#userId").val();
				let planId = $("#planId").val();
				let carId = $("#carId").val();

				let clientSecret = $("#clientSecret").val();
				console.log(clientSecret)
				
				$("#submitPayment").on("click", {}, function(e){
					e.preventDefault();
					
					stripe.confirmCardPayment(clientSecret, {
						payment_method: {
							card: card
						}
						
					}).then(function(result) {
						if(result.error) {
							console.log(result)
						} else {
							window.location.href = "http://localhost:8282/policyForm?userId=" + userId + "&carId="+carId + "&planId="+planId+"&success=true";
						}
					})
					
					
				})
					
				
					
					
				
			})
		</script>
		

	</div>


	

</body>
</html>