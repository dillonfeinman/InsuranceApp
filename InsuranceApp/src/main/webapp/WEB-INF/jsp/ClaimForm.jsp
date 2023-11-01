<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
 <%
 String userId = request.getParameter("userId");
 %>
<head>
<meta charset="ISO-8859-1">
<title>Home Page of Travel Gig</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src='./js/claim.js'></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="home.css">
</head>
<body>
	<div class="container">
        <h1 class="mt-4">Auto Insurance Claim Form</h1>
        <form id="claimForm" class="mt-4">
            <h2>Hi, ${principal.getName()}</h2>
            <div class="form-group">
                <label for="policy_number">Policy Number:</label>
                <input type="text" id="policy_number" class="form-control" value="${policyNumber}" readonly="true" required>
            </div>

            <div class="form-group">
                <label for="claim_description">Description of the Incident:</label>
                <textarea id="claim_description" class="form-control" rows="4" required></textarea>
            </div>

            <div class="form-group">
                <label for="incident_date">Date of the Incident:</label>
                <input type="date" id="incident_date" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="claim_amount">Estimated Claim Amount (USD):</label>
                <input type="number" id="claim_amount" step="0.01" class="form-control" required>
            </div>

            <div class="form-group">
                <label for="police_report">Police Report (if available):</label>
                <input type="file" id="police_report" class="form-control-file" accept="application/pdf">
            </div>

            <div class="form-group">
                <label for="photos">Upload Photos (up to 5):</label>
                <input type="file" id="photos" class="form-control-file" accept="image/*" multiple>
            </div>

            <button type="submit" id="submitBtn" class="btn btn-primary">Submit Auto Insurance Claim</button>
        </form>
    </div>
</body>
</html>