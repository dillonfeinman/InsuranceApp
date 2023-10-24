$(document).ready(function(){
	$("#userSubmit").on('click', {}, function(e) {
		e.preventDefault();
		
		let fname = $("#fname").val();
		let lname = $("#lname").val();
		let gender = $("#gender").val();
		let dob = $("#dob").val();
		let email = $("#email").val();
		let mobile = $("#mobile").val();
		let street = $("#street").val();
		let city = $("#city").val();
		let state = $("#state").val();
		let zipcode = $("#zipcode").val();
		let education = $("#education").val();
		let employment = $("#employment").val();
		let industry = $("#industry").val();
		
		let insured = {
			firstName: fname,
			lastName: lname,
			gender: gender,
			dob: dob,
			email: email,
			mobile: mobile,
			educationLevel: education,
			employmentStatus: employment,
			industry: industry,
			address: {
				
				addressLine2:"",
				addressLine1: street,
				city: city,
				state: state,
				zipCode: zipcode
			}
			
		}
		
		console.log(insured)
		
		 $.ajax({
				type:"POST",
				contentType:"application/json",
				url: "http://localhost:8282/saveInsured",
				data: JSON.stringify(insured),
				dataType: 'json',
				success: function(result){
					console.log(result)
					window.location.href = "http://localhost:8282/carForm?userId=" + result.id;

				},
				error: function(e) {
					console.log(e)
				}
			})
	})
	
})