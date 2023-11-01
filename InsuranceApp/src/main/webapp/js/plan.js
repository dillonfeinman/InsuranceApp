$(document).ready(function(){
	 $.ajax({
		type:"GET",
		contentType:"application/json",
		url: "http://localhost:8282/getPlans",
		data: {},
		dataType: 'json',
		success: function(result){
			console.log(result)
			$.each(result, function(index, item) {
				var row  = `<tr><td>${item.planName}</td><td>${item.coverageType}</td><td>${item.coverageAmount}</td>`
				$("#planTable").find("tbody").append(row)
			})
			

		},
		error: function(e) {
			console.log(e)
		}
	})
	$("#planTable").on('click', 'tr', function(e){
		e.preventDefault();
		var name = $(this).find("td").eq(0).text()
		var userId = $("#userId").val();
		var carId = $("#carId").val();
		
		console.log(userId)
		
		$.ajax({
			type:"GET",
			contentType:"application/json",
			url: "http://localhost:8282/getPlanByName/"+name,
			data: {},
			dataType: 'json',
			success: function(result){
				console.log(result)
				//window.location.href = "http://localhost:8282/paymentForm?userId=" + userId + "&carId="+carId + "&planId="+result.id;
				window.location.href = "http://localhost:8282/policyForm?userId=" + userId + "&carId="+carId + "&planId="+result.id;
				
	
			},
			error: function(e) {
				console.log(e)
			}
		})
		
		
		
	})
	
})