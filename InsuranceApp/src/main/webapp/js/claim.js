$(document).ready(function(){
	$("#claimForm").on("submit", {}, function(e){
		e.preventDefault();
		
		console.log("here")
		
		var policyNumber = $("#policy_number").val()
		var description = $("#claim_description").val();
		var incidentDate = $("#incidentDate").val();
		var amount = $("#claim_amount").val();
		var policeReport = $("#police_report").serialize();
		var photos = $("#photos");
		
		$.ajax({
			type:"POST",
			contentType:"application/json",
			url: "http://localhost:8282/getPolicy",
			data: JSON.stringify(policyNumber),
			dataType: 'json',
			success: function(result){
				console.log("RESULT",result)
				//window.location.href = "http://localhost:8282/planForm?userId="+userId+"&carId="+result.id;
				var claim = {
					policy: result,
					description: description,
					accidentDate: incidentDate,
					repairPrice: amount,
					/*policeReport: policeReport,
					photos: photos,*/
					status: "AWAITING"
				}
				
				 $.ajax({
						type:"POST",
						contentType:"application/json",
						url: "http://localhost:8282/createClaim",
						data: JSON.stringify(claim),
						dataType: 'json',
						success: function(result){
							console.log(result)
							//window.location.href = "http://localhost:8282/planForm?userId="+userId+"&carId="+result.id;
		
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
		
		
		
	})
})