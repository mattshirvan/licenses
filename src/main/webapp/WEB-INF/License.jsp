<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New License</title>
</head>
<body>
	<h1>Add a New License</h1>
	<form:form action="/licenses" method="POST" modelAttribute="license">
		<div>
			<form:label path="person">People</form:label>
			<form:errors path="person"/>
			<form:select path="person">
				<c:forEach items="${people}" var="person">
					<form:option value="${person.id}"> ${person.firstName} ${person.lastName}</form:option>
				</c:forEach>
			</form:select>
		</div>
		<div>
		
			<form:label path="state">State</form:label>
			<form:errors path="state"/>
			<form:input path="state"/>
		</div>
		<div>
			<form:label path="expires">Expiration</form:label>
			<form:errors path="expires"/>
			<form:input type="date" path="expires"/>
		</div>
		<button>Add License</button>
	</form:form>
</body>
</html>