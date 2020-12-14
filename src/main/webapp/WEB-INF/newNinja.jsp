<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Ninja</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>
	<div class="col-4 mx-auto my-5">
		<form:form action="/ninja/create" method="post" modelAttribute="ninja" class="">
			<h2 class="text-center">Add A New Ninja:</h2>
			<input type="hidden" name="_method" value="post" />

			<div class="form-group">
				<form:label path="firstName">First Name:</form:label>
				<form:errors path="firstName" />
				<form:input path="firstName" type="text" name="firstName" class="form-control" />
			</div>
			
			<div class="form-group">
				<form:label path="lastName">Last Name:</form:label>
				<form:errors path="lastName" />
				<form:input path="lastName" type="text" name="lastName" class="form-control" />
			</div>
			
			<div class="form-group">
				<form:label path="age">Age:</form:label>
				<form:errors path="age" />
				<form:input path="age" type="number" name="age" class="form-control" />
			</div>
			
			<div class="form-group">
				<form:label path="dojo">Dojo:</form:label>
				<form:errors path="dojo" />
				<form:select path="dojo">
					<form:options items="${dojos}" itemValue="id" itemLabel="name" />
				</form:select>
			</div>
			
			<div class="d-flex justify-content-end">
				<button class="btn btn-outline-dark">Create Ninja</button>
			</div>
		</form:form>
		
		<ul class="text-center">
			<h3>Current Ninjas</h3>
			<c:forEach items="${ninjas}" var="ninja">
			<li><c:out value="${ninja.firstName} ${ninja.lastName}, Dojo Location: ${ninja.dojo.name}" /></li>
			</c:forEach>
		</ul>
	</div>
	
</body>
</html>