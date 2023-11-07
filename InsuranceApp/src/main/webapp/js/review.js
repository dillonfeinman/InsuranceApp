$(document).ready(function(){
	let policyNumber = $("#policyNumber").val();
	
	
	let total = 0
	
	let car,insured,plan = undefined;
	
	
	
	$.ajax({
			type:"POST",
			contentType:"application/json",
			url: "http://localhost:8282/getPolicy",
			data: policyNumber,
			dataType: 'json',
			success: function(result){
				console.log("result",result)
				
				var x = (result.insured.document.driverLicense);
										
				
				var dataUrl = 'data:image/jpeg;base64,' + x;	
				
				
				$("#userContainer").append("<h2>"+result.insured.firstName + " " + result.insured.lastName + "</h2>" + "<h2>" + result.insured.email + "</h2>" + 
							"<h2>" + result.insured.mobile + "</h2>" + 
							"<img src='" + dataUrl + "'/>"
						);
				$("#carContainer").append("<h2>" + result.car.make + " " + result.car.model +", " + result.car.year + "</h2>" +
								"<h3>"+result.car.vinNumber + "</h3>")
				$("#planContainer").append("<h2>" + result.plans[0].planName + "</h2>" +
					"<h3>"+result.plans[0].premium + "</h3>")
			}
		})
		
	
		
		
	
})