<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Create an account</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link href="${contextPath}/resources/css/bootstrap.min.css"	rel="stylesheet">
</head>
<body>
	<div class="w3-container w3-panel w3-border w3-round-large w3-border-green" style ="margin: auto; margin-top: 10%; width: 25%; hight: 30%">
		<form:form method="POST" action="${contextPath}/registration" enctype="multipart/form-data">
					<table>
						<tr style ="margin-top: 10%;">
							<td>First name</td>
							<td><input type="text" name="firstName" class="w3-input w3-border w3-round-large w3-hover-border-green"/></td>
						</tr>
						<tr style ="margin-top: 10%;">
							<td>Last name</td>
							<td><input type="text" name="lastName" class="w3-input w3-border w3-round-large w3-hover-border-green" /></td>
						</tr>
						<tr style ="margin-top: 10%;">
							<td>Age</td>
							<td><input type="number" name="age" class="w3-input w3-border w3-round-large w3-hover-border-green" /></td>
						</tr>
						<tr style ="margin-top: 10%;">
							<td>Email</td>
							<td><input type="text" name="email" class="w3-input w3-border w3-round-large w3-hover-border-green" /></td>
						</tr>
						<tr style ="margin-top: 10%;">
							<td>Password</td>
							<td><input type="text" name="password" class="w3-input w3-border w3-round-large w3-hover-border-green" /></td>
						</tr>
						<tr style ="margin-top: 10%;">
							<td>Password confirm</td>
							<td><input type="text" name="passwordConfirm" class="w3-input w3-border w3-round-large w3-hover-border-green" /></td>
						</tr>
						<tr>
							<td>Add foto</td>
							<td><input type="file" name="image" style ="margin-top: 10%;"/></td>
						</tr>
						<tr style ="margin-top: 10%;">
							<td>			
							<button type="submit" class="w3-button w3-green w3-round-xxlarge" style ="margin-top: 5%;margin-bottom: 5%">Submit</button>
							</td>
						</tr>
					</table>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form:form>
	</div>
</body>
</html>