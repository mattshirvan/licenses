<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	
	<meta charset="ISO-8859-1">
	<title>Department of Licensing</title>
</head>
<body>
	<h1>New Person</h1>
	<form:form action="/persons" method="POST" modelAttribute="person">
	  <div class="form-group">
	    <form:label path="firstName">First Name</form:label>
	    <form:errors path="firstName"/>
	    <form:input path="firstName" class="form-control"/>
	  </div>
	  <div class="form-group">
	    <form:label path="lastName">Last Name</form:label>
	    <form:errors path="lastName" />
	    <form:input path="lastName" class="form-control"/>
	  </div>	  
	  <input type="submit" value="create">
	</form:form>	
</body>
</html>