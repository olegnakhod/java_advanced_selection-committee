<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add certicifate</title>
<title>Create faculty</title>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<!-- Sidebar -->
	<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
		<h3 class="w3-bar-item">Menu</h3>
		<a href="/home" class="w3-bar-item w3-button">Home</a>
		<a href="/addFaculty" class="w3-bar-item w3-button">Add Faculty</a>
		<a href="/applyToFaculty" class="w3-bar-item w3-button">Apply faculty</a>
		<a href="/addCertificate" class="w3-bar-item w3-button">Add certificate</a>
		<a href="/viewCandidateInFaculty" class="w3-bar-item w3-button">Candidate in faculty</a>

	</div>
	<!-- Page Content -->
	<div style="margin-left: 10%">
		<div class="w3-container w3-teal">
			<h1>Add certificate</h1>
	</div>

			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<form id="logoutForm" method="POST" action="${contextPath}/logout">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
				<h2>
					User: ${pageContext.request.userPrincipal.name} | <a
						onclick="document.forms['logoutForm'].submit()">Logout</a>
				</h2>
			</c:if>	

	<div class="w3-container w3-panel w3-border w3-round-large w3-border-green" style ="margin: auto; margin-top: 10%; width: 20%; hight: 30%">
		<form:form method="POST" modelAttribute="subjectForm" >
			<h2 class="form-signin-heading">Create subject</h2>
			<spring:bind path="subject"> 
				<div class="${status.error ? 'has-error' : ''}">
					<form:input type="text" path="subject" placeholder="Set subject" autofocus="true" class="w3-input w3-border w3-round-large w3-hover-border-green" style ="margin-top: 10%;"></form:input>
					<form:errors path="subject"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="grade">
				<div class="${status.error ? 'has-error' : ''}">
					<form:input type="text" path="grade" placeholder="Set frades" autofocus="true" class="w3-input w3-border w3-round-large w3-hover-border-green" style ="margin-top: 10%;"></form:input>
					<form:errors path="grade"></form:errors>
				</div>
			</spring:bind>
			<button type="submit" class="w3-button w3-green w3-round-xxlarge" style ="margin-top: 5%;margin-bottom: 5%">Submit</button>
		</form:form>
	</div>
	
	<div style="margin: auto; margin-top: 5%;width: 75%">
				<table class="w3-table w3-striped w3-bordered">
					<thead>
						<tr class="w3-green">
							<th>Id</th>
							<th>Subjects</th>
							<th>Grades</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="subjectCurrent" items="${subjects}">
							<tr>
								<td>${subjectCurrent.id}</td>
								<td>${subjectCurrent.subject}</td>
								<td>${subjectCurrent.grade}</td>
								<td></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
	<div class="w3-striped w3-bordered" style="margin: auto; margin-top: 5%;width: 75%">
		<p>Average score: ${averageScore}</p>
	</div>
	
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>