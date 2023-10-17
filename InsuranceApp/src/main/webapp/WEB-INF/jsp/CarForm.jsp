<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>

<head>
<meta charset="ISO-8859-1">
<title>Home Page of Travel Gig</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src='./js/hotel.js'></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="home.css">
</head>
<body>
	<div>
		<h2>About your vehicle</h2>
		<b>VIN</b>
		<input type="text" id="vin"/>
		<b>Year</b>
		<input type="date" id="year"/>
		<b>Make</b>
		<input type="text" id="make"/>
		<b>Model</b>
		<input type="text" id="model"/>
		<b>Phone Number</b>
		<input type="tel" id="mobile"/>
		<b>Do you own it?</b>
		<select>
			<option value="owned">Owned</option>
			<option value="financed">Financed</option>
			<option value="leased">Leased</option>
		</select>

		<b>Annual Milage</b>
		<select>
			<option value="3000">0-3000</option>
			<option value="5000">3001-5000</option>
			<option value="7500">5001-7500</option>
			<option value="10000">7501-10,000</option>
			<option value="15000">10,000-15,000</option>
			<option value="20000">15,000-20,000</option>
			<option value="over">20,001+</option>
		</select>

		<h2>Security measures can lower your cost! [Select all that apply]</h2>
		<b>Alarm system</b>
		<input type="checkbox" value="alarm"/>
		<b>Location tracking</b>
		<input type="checkbox" value="location"/>
		<b>Other</b>
		<input type="checkbox" value="other"/>


		<input type="button" id="go"/>
		

	</div>

</body>
</html>