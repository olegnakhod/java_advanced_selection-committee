<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Welcome</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
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

		<div class="w3-container" style="margin-left: 10%;  width: 100% ;hight: 100%">
			<!-- Header -->
			<div class="w3-container w3-teal">
				<h1><spring:message code='home.header' /></h1>
			</div>
			<!-- Body -->
			
			<div class="w3-container w3-left" style="width:35% ; margin-left: 5%; margin-top: 5%">
				<h2><spring:message code='home.profile' /></h2>
				<div class="w3-container">
					<img  class="w3-left" style="width:35%"  alt="Avatar" src="data:image/jpg;base64, ${userViewer.encodeImage}">
  					<div class="container"  style="margin-left: 5%;">
  			 			<h5><spring:message code='home.firsName' />: ${userViewer.firstName}</h5>
						<h5><spring:message code='home.lastName' />: ${userViewer.lastName}</h5>
						<h5><spring:message code='home.age' />: ${userViewer.age}</h5>
 			 		</div>
 			 	</div>
 			 	<a href="/editProfile"><spring:message code='home.editProfile' /></a>
			</div>
			
			<security:authorize access="hasRole('ROLE_CANDIDATE')">
			<div class="w3-container w3-left" style="width:35% ; margin-left: 5%; margin-top: 5%">
				<h2><spring:message code='home.certificate' /></h2>
				<div class="container">
					<table  class="w3-container">
						<tr>
							<td><spring:message code='home.firstSubj' />:</td>
							<td>${subjectsViewer.firstSubject}</td>
						</tr>
						<tr>
							<td><spring:message code='home.secondSubj' />:</td>
							<td>${subjectsViewer.secondSubject}</td>
						</tr>
						<tr>
							<td><spring:message code='home.thirdSubj' />:</td>
							<td>${subjectsViewer.thirdSubject}</td>
						</tr>
						<tr>
							<td><spring:message code='home.sum' />:</td>
							<td>${subjectsViewer.sumSchoolsCerticifate}</td>
						</tr>
						<tr>
							<td><spring:message code='home.totalGrades' />:</td>
							<td>${subjectsViewer.totalGrades}</td>
						</tr>
					</table>
				</div>
			</div>
			</security:authorize>
		</div>
	</div>
	<!-- /container -->
	<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<!-- /container -->
</body>
</html>