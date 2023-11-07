$(document).ready(function(){
	$("#claimForm").on("submit", {}, function(e){
		e.preventDefault();
		
		console.log("here")
		
		var policyNumber = $("#policy_number").val()
		var description = $("#claim_description").val();
		var incidentDate = $("#incidentDate").val();
		var amount = $("#claim_amount").val();
		var policeReport = $("#police_report");
		var photos = $("#photos")[0];
		
		var arrayOfBytesArray = [];
		
		var promises = [];
		if(photos.files){
			
			
			for(var file of photos.files){
				var reader = new FileReader();
				
				var promise = new Promise(function(resolve)  {
					reader.onload = function(event) {
						const fileContent = event.target.result;
						const byteArray = new Uint8Array(fileContent);
		
						var b64encoded = btoa(byteArray.reduce(function(data,byte) {
							return data + String.fromCharCode(byte);
						}, ''));
						arrayOfBytesArray.push(b64encoded)	
						resolve();				
					}
				})
				
				
				reader.readAsArrayBuffer(file);

			    promises.push(promise);

			}
			
			
		}
		
		Promise.all(promises).then(function () {
			console.log(arrayOfBytesArray)
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
						//policeReport: policeReport,
						photos: arrayOfBytesArray,
						status: "AWAITING"
					}
					console.log(claim)
					
					 $.ajax({
							type:"POST",
							contentType:"application/json",
							url: "http://localhost:8282/createClaim",
							data: JSON.stringify(claim),
							dataType: 'json',
							success: function(result){
								console.log(result)
								window.location.href = "http://localhost:8282/viewClaims"
			
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
		});
		
		
		
		
		
	})
})