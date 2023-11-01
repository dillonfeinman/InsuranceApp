$(document).ready(function(){
	var zip = undefined
	$("#userFormBtn").on('click', {}, function(e){
		zip = $("#zipcode").val();
		
		window.location.href = "http://localhost:8282/userForm?zipcode="+zip;
		console.log(zip)

	})
	$("#nullUserFormBtn").on('click',{},function(e){
		zip = $("#zipcode").val();
		
		window.location.href = "http://localhost:8282/userForm?zipcode="+zip;
		console.log(zip)
	})
	
})