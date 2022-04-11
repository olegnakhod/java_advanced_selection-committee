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
<title>Insert title here</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="container">
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
				<h1>View shedule candidats at faculty</h1>
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
			
			<div style="margin: auto; margin-top: 5%;width: 75%">
				<table class="w3-table w3-striped w3-bordered">
					<thead>
						<tr class="w3-green">
							<th>Id</th>
							<th>First name</th>
							<th>Last Name</th>
							<th>Average score</th>
							<th>Add to statment</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="candidate" items="${candidates}">
							<tr>
								<td>${candidate.id}</td>
								<td>${candidate.firstName}</td>
								<td>${candidate.lastName}</td>
								<td></td>
								<td></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
	</div>
</body>
</html>