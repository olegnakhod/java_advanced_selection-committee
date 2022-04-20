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
	<div class="wrapper">
		<!-- Sidebar  -->
		<nav id="sidebar" class='active'>
			<div class="sidebar-header">
				<h3 class="w3-bar-item">
					<spring:message code='sidebar.menu' />
				</h3>
			</div>
			<a href="/home" class="w3-bar-item w3-button"><spring:message
					code='sidebar.home' /></a>
			<security:authorize access="hasRole('ROLE_ADMINISTRATOR')">
				<a href="/addFaculty" class="w3-bar-item w3-button"><spring:message
						code='sidebar.addFaculty' /></a>
				<a href="/viewCandidateInFaculty" class="w3-bar-item w3-button"><spring:message
						code='sidebar.statment' /></a>
			</security:authorize>

		</nav>

		<!-- Page Content  -->
		<div id="content">
			<!-- Header  -->
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">
					<security:authorize access="hasRole('ROLE_ADMINISTRATOR')">
					<button type="button" id="sidebarCollapse" class="btn btn-info">
						<i class="fas fa-align-left"></i> <span>Toggle Sidebar</span>
					</button>
					<button class="btn btn-dark d-inline-block d-lg-none ml-auto"
						type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<i class="fas fa-align-justify"></i>
					</button>
					</security:authorize>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="nav navbar-nav ml-auto">
							<li class="nav-item active"><a href="/home" class="nav-link"><spring:message
										code='sidebar.home' /></a></li>
							<li class="nav-item"><c:if
									test="${pageContext.request.userPrincipal.name != null}">
									<form id="logoutForm" method="POST"
										action="${contextPath}/logout">
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />
									</form>
									<a onclick="document.forms['logoutForm'].submit()"
										class="nav-link"><spring:message code='sidebar.logout' /></a>

								</c:if></li>
						</ul>
					</div>
				</div>
			</nav>
			<!-- Body -->
			<h2>
				<spring:message code='home.profile' />
			</h2>
			<div class="container">
				<img class="w3-left" style="width: 35%" alt="Avatar"
					src="data:image/jpg;base64, ${userViewer.encodeImage}">
				<div class="container" style="margin-left: 5%;">
					<h5>
						<spring:message code='home.firsName' />
						: ${userViewer.firstName}
					</h5>
					<h5>
						<spring:message code='home.lastName' />
						: ${userViewer.lastName}
					</h5>
					<h5>
						<spring:message code='home.age' />
						: ${userViewer.age}
					</h5>
				</div>
			</div>
			<a href="/editProfile"><spring:message code='home.editProfile' /></a>
		</div>

		<security:authorize access="hasRole('ROLE_CANDIDATE')">
			<div class="w3-container w3-left"
				style="width: 35%; margin-left: 5%; margin-top: 5%">
				<h2>
					<spring:message code='home.certificate' />
				</h2>
				<div class="container">
					<table class="w3-container">
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
				<a href="/addCertificate" ><spring:message code='sidebar.addCrtificate' /></a>
				</div>
			</div>
		</security:authorize>
	</div>
		<jsp:include page="footer.jsp"></jsp:include>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>