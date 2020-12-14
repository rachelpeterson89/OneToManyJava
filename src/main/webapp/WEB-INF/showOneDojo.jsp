<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show One Dojo</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>
<div class="col-6 mx-auto my-5">
	<h2 class="text-center">Ninjas of Dojo Location: <c:out value="${dojo.name}" /></h2>
	<table class="table table">
		<thead>
			<tr class="">
	            <th scope="col">Fist Name</th>
	            <th scope="col">Last Name</th>
	            <th scope="col">Age</th>
        	</tr>
		</thead>
		<tbody>
        <c:forEach items="${dojo.ninjas}" var="ninja">
	        <tr class="text-dark">
	            <td><c:out value="${ninja.firstName}"/></td>
	            <td><c:out value="${ninja.lastName}"/></td>
	            <td><c:out value="${ninja.age}"/></td>
	        </tr>
        </c:forEach>
    </tbody>
	</table>
	</div>
</body>
</html>