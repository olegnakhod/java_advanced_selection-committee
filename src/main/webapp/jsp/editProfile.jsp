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
	<div class = "w3-container">
	<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item">Menu</h3>
			<a href="/home" class="w3-bar-item w3-button">Home</a>
			<a href="/addFaculty" class="w3-bar-item w3-button">Add Faculty</a>
			<a href="/applyToFaculty" class="w3-bar-item w3-button">Apply faculty</a>
			<a href="/viewCandidateInFaculty" class="w3-bar-item w3-button">Candidate in faculty</a>
			<a href="/addCertificate" class="w3-bar-item w3-button">Add certificate</a>
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<form id="logoutForm" method="POST" action="${contextPath}/logout">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
					<a onclick="document.forms['logoutForm'].submit()" class="w3-bar-item w3-button">Logout</a>

			</c:if>
		</div>
		<!-- Page Content -->
		<div class="w3-container" style="margin-left: 10%;  width: 100% ;hight: 100%">
			<!-- Header -->
			<div class="w3-container w3-teal">
				<h1>Edit profile</h1>
			</div>
			
		<!-- Body -->
		<div class="w3-container w3-panel w3-border w3-round-large w3-border-green" style ="margin: auto; margin-top: 10%; width: 25%; hight: 30%">
		<form:form method="POST" action="${contextPath}/changeUser" enctype="form-data">
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
							<td>			
							<button type="submit" class="w3-button w3-green w3-round-xxlarge" style ="margin-top: 5%;margin-bottom: 5%">Submit</button>
							</td>
						</tr>
					</table>
				</form:form>
			<form:form method="POST" action="${contextPath}/changeFoto" enctype="multipart/form-data">
					<table>
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
				</form:form>
				<form:form method="POST" action="${contextPath}/changePassword" enctype="form-data">
					<table>
						<tr style ="margin-top: 10%;">
							<td>Password</td>
							<td><input type="text" name="password" class="w3-input w3-border w3-round-large w3-hover-border-green" /></td>
						</tr>
						<tr style ="margin-top: 10%;">
							<td>Password confirm</td>
							<td><input type="text" name="passwordConfirm" class="w3-input w3-border w3-round-large w3-hover-border-green" /></td>
						</tr>
						<tr style ="margin-top: 10%;">
							<td>			
							<button type="submit" class="w3-button w3-green w3-round-xxlarge" style ="margin-top: 5%;margin-bottom: 5%">Submit</button>
							</td>
						</tr>
					</table>
				</form:form>
			</div>
			<!-- Body -->
		</div>
	</div>
</body>
</html>