$(document).ready(function(){
	let userId = $("#userId").val();
	let planId = $("#planId").val();
	let carId = $("#carId").val();
	let paid = $("#paid").val();
	
	let total = 0
	
	let car,insured,plan = undefined;
	
	console.log(planId)
	$.ajax({
			type:"GET",
			contentType:"application/json",
			url: "http://localhost:8282/getPlanById/"+planId,
			data: {},
			dataType: 'json',
			success: function(result){
				console.log("result",result)
				$("#planContainer").append("<h2>" + result.planName + "</h2>" +
				"<h3>"+result.premium + "</h3>")
				
				total += result.premium
				
				plan = result;
				
				console.log(plan)
				
				$.ajax({
					type:"GET",
					contentType:"application/json",
					url: "http://localhost:8282/getInsuredById/"+userId,
					data: {},
					dataType: 'json',
					success: function(result){
						console.log("result",result)
												
						
												
						var x = (result.document.driverLicense);
						
						
			
						
						//var u8 = x.split(",")
						
						console.log(x)
												
						
						var dataUrl = 'data:image/jpeg;base64,' + x;				
						
						
						console.log(dataUrl)
						
						$("#userContainer").append("<h2>"+result.firstName + " " + result.lastName + "</h2>" + "<h2>" + result.email + "</h2>" + 
							"<h2>" + result.mobile + "</h2>" + 
							"<img src='" + dataUrl + "'/>"
						);
						
						switch(result.educationLevel){
							case "High school diploma/GED":
								break;
							default:
								total = total * .98;
						}
						
						insured = result;
						
						$.ajax({
							type:"GET",
							contentType:"application/json",
							url: "http://localhost:8282/getCarById/"+carId,
							data: {},
							dataType: 'json',
							success: function(result){
								console.log("result",result)
								$("#carContainer").append("<h2>" + result.make + " " + result.model +", " + result.year + "</h2>" +
								"<h3>"+result.vinNumber + "</h3>")
								
								total = total + 100 * result.accidentHistory.length
								
								$("#totalContainer").append("<h2>" + total + "</h2>")
								car = result;
					
							},
							error: function(e) {
								console.log("e",e)
							}
						})
						
					

						
						
			
					},
					error: function(e) {
						console.log("e",e)
					}
				})
				
	
			},
			error: function(e) {
				console.log("e",e)
			}
		})
		$("#confirmPolicy").on('click', {}, function(e){
			
			if(insured && car && plan && paid == ("false")) {
				console.log(insured, car, plan)
				window.location.href = "http://localhost:8282/paymentForm?userId=" + userId + "&carId="+carId + "&planId="+planId + "&amount="+plan.premium				//window.location.href = "http://localhost:8282/paymentForm?userId=" + userId + "&carId="+carId + "&planId="+result.id;


				
			} else if(insured && car && plan && paid == ("true")) {
				$.ajax({
					type:"POST",
					contentType:"application/json",
					url: "http://localhost:8282/savePolicy",
					data: JSON.stringify({
						insured: insured,
						car: car,
						plans: [plan]
					}),
					dataType: 'json',
					success: function(result){
						console.log(result)
						console.log($("#password").val())
						$.ajax({
							type:"POST",
							contentType:"application/json",
							url: "http://localhost:8282/signup",
							data: JSON.stringify({
								email: insured.email,
								userName: result.policyNumber,
								userPassword: $("#password").val(),
								policyNumber: result.policyNumber,
								mobile: 0,
								
							}),
							dataType: 'json',
							success: function(result){
								console.log(result)
								window.location.href = "http://localhost:8282/login?userName="+result.policyNumber

			
							},
							error: function(e) {
								console.log(e)
							}
						})
	
					},
					error: function(e) {
						console.log(e)
					}
				})
			}
		})
		
	
		
		
	
})