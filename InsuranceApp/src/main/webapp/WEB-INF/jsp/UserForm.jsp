<!DOCTYPE html>
<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page isELIgnored="false" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%
String zipcode = request.getParameter("zipcode");
%>
<head>
<meta charset="ISO-8859-1">
<title>Home Page of Travel Gig</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src='js/user.js'></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="home.css">
</head>
<body>
    <div class="container">
        <form id="insuredForm">
            <h2>About you</h2>
            <div class="form-group">
                <label for="fname">First Name</label>
                <input type="text" class="form-control" id="fname">
            </div>
            <div class="form-group">
                <label for="lname">Last Name</label>
                <input type="text" class="form-control" id="lname">
            </div>
            <div class="form-group">
                <label for="gender">Gender</label>
                <select class="form-control" id="gender">
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                    <option value="other">Other</option>
                </select>
            </div>
            <div class="form-group">
                <label for="dob">Date of Birth</label>
                <input type="date" class="form-control" id="dob">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" class="form-control" id="email">
            </div>
            <div class="form-group">
                <label for="mobile">Phone Number</label>
                <input type="tel" class="form-control" id="mobile">
            </div>
            <div class="form-group">
                <label for="street">Address</label>
                <input type="text" class="form-control" id="street">
            </div>
            <div class="form-group">
                <label for="city">City</label>
                <input type="text" class="form-control" id="city">
            </div>
            <div class="form-group">
                <label for="state">State</label>
                <input type="text" class="form-control" id="state">
            </div>
            <div class="form-group">
                <label for="zipcode">Zip Code</label>
                <input type="text" class="form-control" id="zipcode" value=<%=zipcode %>>
            </div>
            <div class="form-group">
                <label for="education">Education Level</label>
                <select class="form-control" id="education">
                    <option>High school diploma/GED</option>
                    <option>Some college</option>
                    <option>Bachelor's Degree</option>
                    <option>Master's Degree</option>
                    <option>PhD</option>
                </select>
            </div>
            <div class="form-group">
                <label for="employment">Employment Status</label>
                <select class="form-control" id="employment">
                    <option>Unemployed</option>
                    <option>Self Employed</option>
                    <option>Student</option>
                    <option>Employed</option>
                    <option>Retired</option>
                </select>
            </div>
            <div class="form-group">
                <label for="industry">Industry</label>
                <input type="text" class="form-control" id="industry">
            </div>
            <div class="form-group">
                <form method="post" action="/saveDocument" enctype="multipart/form-data">
                    <label>Document Upload</label>
                    <input type="file" id="file">
                </form>
                
            </div>

            <button type="submit" class="btn btn-primary" id="userSubmit">Submit</button>
        </form>
    </div>
</body>
</html>