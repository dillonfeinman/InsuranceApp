$(document).ready(function(){
	let userId = $("#userId").val();
	let planId = $("#planId").val();
	let carId = $("#carId").val();
	
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
				
				$.ajax({
					type:"GET",
					contentType:"application/json",
					url: "http://localhost:8282/getInsuredById/"+userId,
					data: {},
					dataType: 'json',
					success: function(result){
						console.log("result",result)
						$("#userContainer").append("<h2>"+result.firstName + " " + result.lastName + "</h2>" + "<h2>" + result.email + "</h2>" + 
						"<h2>" + result.mobile + "</h2>")
						
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
			if(insured && car && plan) {
				$.ajax({
					type:"POST",
					contentType:"application/json",
					url: "http://localhost:8282/savePolicy",
					data: {
						insured: insured,
						car: car,
						plans: [plan]
					},
					dataType: 'json',
					success: function(result){
						console.log(result)
	
					},
					error: function(e) {
						console.log(e)
					}
				})
			}
		})
		
	
		
		
	
})