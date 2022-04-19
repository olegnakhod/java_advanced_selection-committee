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
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	
</head>
<body>
	<div class="container">
		<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item">
				<spring:message code='sidebar.menu' />
			</h3>

			<a href="/home" class="w3-bar-item w3-button"><spring:message
					code='sidebar.home' /></a>

			<security:authorize access="hasRole('ROLE_CANDIDATE')">
				<a href="/applyToFaculty" class="w3-bar-item w3-button"><spring:message
						code='sidebar.apply' /></a>
				<a href="/addCertificate" class="w3-bar-item w3-button"><spring:message
						code='sidebar.addCrtificate' /></a>
			</security:authorize>

			<security:authorize access="hasRole('ROLE_ADMINISTRATOR')">
				<a href="/addFaculty" class="w3-bar-item w3-button"><spring:message
						code='sidebar.addFaculty' /></a>
				<a href="/viewCandidateInFaculty" class="w3-bar-item w3-button"><spring:message
						code='sidebar.statment' /></a>
			</security:authorize>

			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<form id="logoutForm" method="POST" action="${contextPath}/logout">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
				<a onclick="document.forms['logoutForm'].submit()"
					class="w3-bar-item w3-button"><spring:message
						code='sidebar.logout' /></a>

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
				<h1><spring:message code='statment.header' /></h1>
			</div>
		</div>
	</div>
		<c:choose>
		<c:when test="${mode == 'VIEW_CANDIDATE'}">
			<div style="margin: auto; margin-top: 5%;width: 75%">
				<table class="w3-table w3-striped w3-bordered">
					<thead>
						<tr class="w3-green">
							<th><spring:message code='statment.firsName' /></th>
							<th><spring:message code='statment.lastName' /></th>
							<th><spring:message code='statment.totalGrades' /></th>
							<th><spring:message code='statment.delete' /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="candidate" items="${candidates}">
						<c:set var="totalGrades" value="viewTotalGrades?id=${candidate.id}"/>
							<tr>
								<td>${candidate.firstName}</td>
								<td>${candidate.lastName}</td>
								<td>${totalGrades} </td>
								<td><a href = "deleteCandidate?userId=${candidate.id}"><spring:message code='statment.delete' /></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:when>
		<c:when test="${mode == 'VIEW_FACULTY'}">
			<div style="margin: auto; margin-top: 5%;width: 75%">
				<table class="w3-table w3-striped w3-bordered">
					<thead>
						<tr class="w3-green">
							<th><spring:message code='statment.name' /></th>
							<th><spring:message code='statment.numberOfSeats' /></th>
							<th><spring:message code='statment.minimumPassingScore' /></th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="faculity" items="${faculityes}">
							<tr>
								<td>${faculity.name}</td>
								<td>${faculity.numberOfSeats}</td>
								<td>${faculity.minimumPassingScore}</td>
								<td><a href = "viewCandidatesInFaculty?facultyId=${faculity.id}"><spring:message code='statment.viewCan' /></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:when>
	</c:choose>
	<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>