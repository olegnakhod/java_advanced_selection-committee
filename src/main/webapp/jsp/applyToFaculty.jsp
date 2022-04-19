<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<h3 class="w3-bar-item"><spring:message code='sidebar.menu' /></h3>

		<a href="/home" class="w3-bar-item w3-button"><spring:message code='sidebar.home' /></a>

		<security:authorize access="hasRole('ROLE_CANDIDATE')">
			<a href="/applyToFaculty" class="w3-bar-item w3-button"><spring:message code='sidebar.apply' /></a>
			<a href="/addCertificate" class="w3-bar-item w3-button"><spring:message code='sidebar.addCrtificate' /></a>
		</security:authorize>

		<security:authorize access="hasRole('ROLE_ADMINISTRATOR')">
			<a href="/addFaculty" class="w3-bar-item w3-button"><spring:message code='sidebar.addFaculty' /></a>
			<a href="/viewCandidateInFaculty" class="w3-bar-item w3-button"><spring:message code='sidebar.statment' /></a>
		</security:authorize>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
			<a onclick="document.forms['logoutForm'].submit()"
				class="w3-bar-item w3-button"><spring:message code='sidebar.logout' /></a>

		</c:if>
		<div>
			<fieldset>
				<label><spring:message code='login.choose_language' /></label> <select
					id="locales">
					<option value="en"><spring:message code='login.english' /></option>
					<option value="ua"><spring:message code='login.ukrainian' /></option>

				</select>
			</fieldset>
		</div>
	</div>
	<!-- Page Content -->
	<div style="margin-left: 10%">
		<div class="w3-container w3-teal">
			<h1><spring:message code='applyFacylty.header' /></h1>
		</div>
		
		<div class="w3-container">
			<c:if test="${not empty facultyes}">
				<c:forEach items="${facultyes}" var="currentFacultyes">

					<div class="w3-card-4" style="width: 20%; margin: 2%">
						<div class="w3-container w3-center">
							<h3><spring:message code='applyFacylty.name' />: ${currentFacultyes.name}</h3>
							<p><spring:message code='applyFacylty.numberOfSeats' />: ${currentFacultyes.numberOfSeats}</p>
							<p><spring:message code='applyFacylty.minimumPassingScore' />: ${currentFacultyes.minimumPassingScore}</p>
						</div>

						<form:form action="${contextPath}/applyToFaculty" method="POST"
							enctype="multipart/form-data">
							<input type="hidden" value="${currentFacultyes.id}"	name="facultyId">
							<input type="submit" class="w3-button w3-block w3-dark-grey" value="<spring:message code='applyFacylty.applyTo' />">
						</form:form>
					</div>

				</c:forEach>
			</c:if>
		</div>
	</div>
	<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>