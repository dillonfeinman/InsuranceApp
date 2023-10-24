$(document).ready(function(){
	$("#carSubmit").on('click', {}, function(e) {
		e.preventDefault();
		
		let vin = $("#vin").val();
		let year = $("#year").val();
		let make = $("#make").val();
		let model = $("#model").val();
		
		let userId = $("#userId").val();
		
		console.log(userId)
		
		let car = {
			vinNumber:vin,
			make:make,
			model:model,
			year:year,
			
		}
		
		console.log(car)
		
		 $.ajax({
				type:"POST",
				contentType:"application/json",
				url: "http://localhost:8282/saveCar",
				data: JSON.stringify(car),
				dataType: 'json',
				success: function(result){
					console.log(result)
					window.location.href = "http://localhost:8282/planForm?userId="+userId+"&carId="+result.id;

				},
				error: function(e) {
					console.log(e)
				}
			})
	})
	
})