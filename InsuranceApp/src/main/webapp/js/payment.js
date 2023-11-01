$(document).ready(function(){
	let userId = $("#userId").val();
	let planId = $("#planId").val();
	let carId = $("#carId").val();
	
	$("#submitPayment").on("click", {}, function(e){
		e.preventDefault();
		
		stripe.confirmCardPayment("${clientSecret}", {
			payment_method: {
				card: card
			}
			
		}).then(function(result) {
			if(result.error) {
				
			} else {
				window.location.href = "http://localhost:8282/policyForm?userId=" + userId + "&carId="+carId + "&planId="+result.id+"&success=true";
			}
		})
		
		/*$.ajax({
			type:"POST",
			contentType:"application/json",
			url: "http://localhost:8282/processPayment",
			data: {},
			dataType: 'json',
			success: function(result){
				console.log("result",result)
			
	
			},
			error: function(e) {
				console.log("e",e)
			}
		})*/
		
	})
		
	
		
		
	
})