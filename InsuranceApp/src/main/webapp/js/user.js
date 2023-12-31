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
        let fileUpload = $("#file")[0]; // Get the file input element
		
		
		
		
		console.log(fileUpload)
		
		if (fileUpload && fileUpload.files.length > 0) {
		
			let file = fileUpload.files.length > 0 ? fileUpload.files[0] : null;
			let document = null;
			console.log(file)
			if(file) {
				console.log("here")
				var reader = new FileReader();
				
				reader.onload = function(event) {
					const fileContent = event.target.result;
					const byteArray = new Uint8Array(fileContent);
					
					var b64encoded = btoa(byteArray.reduce(function(data,byte) {
						return data + String.fromCharCode(byte);
					}, ''));
					
				
					document = {
						fileName: file.name,
						driverLicense: b64encoded,
					}
					
					console.log(document)	
			
					$.ajax({
						type:"POST",
						contentType:"application/json",
						url: "http://localhost:8282/saveDocument",
						data: JSON.stringify(document),
						dataType: 'json',
						success: function(result){
							console.log("document:" ,result)
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
								},
								document: result
								
							}
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
									console.log("insured error", e)
								}
							})
						},
						error: function(e) {
							console.log("Document error: ", e)
						}
					})
				}
				
				reader.readAsArrayBuffer(file);
				
				
			
			}
		
		}
		
		
	})
	
})