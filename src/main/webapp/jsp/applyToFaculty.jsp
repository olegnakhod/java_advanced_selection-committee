<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apply to faculty</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<!-- Sidebar -->
	<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item">Menu</h3>
			
			<a href="/home" class="w3-bar-item w3-button">Home</a>
			
			<security:authorize access="hasRole('ROLE_CANDIDATE')">
			<a href="/applyToFaculty" class="w3-bar-item w3-button">Apply to faculty</a>
			<a href="/addCertificate" class="w3-bar-item w3-button">Add/update certificate</a>
			</security:authorize>
			
			<security:authorize access="hasRole('ROLE_ADMINISTRATOR')">
			<a href="/addFaculty" class="w3-bar-item w3-button">Add Faculty</a>
			<a href="/viewCandidateInFaculty" class="w3-bar-item w3-button">Statment</a>
			</security:authorize>
			
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<form id="logoutForm" method="POST" action="${contextPath}/logout">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
					<a onclick="document.forms['logoutForm'].submit()" class="w3-bar-item w3-button">Logout</a>

			</c:if>
		</div>
	<div style="margin-left: 10%">
		<div class="w3-container w3-teal">
			<h1>Check faculty</h1>
		</div>
		
		<div class="w3-container">
			<c:if test="${not empty facultyes}">
				<c:forEach items="${facultyes}" var="currentFacultyes">

					<div class="w3-card-4" style="width: 20%; margin: 2%">
						<div class="w3-container w3-center">
							<h3>Name faculty: ${currentFacultyes.name}</h3>
							<p>Number of seats: ${currentFacultyes.numberOfSeats}</p>
							<p>Minimum passing score: ${currentFacultyes.minimumPassingScore}</p>
						</div>

						<form:form action="${contextPath}/applyToFaculty" method="POST"
							enctype="multipart/form-data">
							<input type="hidden" value="${currentFacultyes.id}"	name="facultyId">
							<input type="submit" class="w3-button w3-block w3-dark-grey" value="+ apply to faculty">
						</form:form>
					</div>

				</c:forEach>
			</c:if>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>