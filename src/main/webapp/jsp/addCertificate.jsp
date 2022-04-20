<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add certicifate</title>
<title>Create faculty</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="css/main.css" />
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
			<!-- Page Content -->
			<form:form method="POST" action="${contextPath}/addCertificate"
				enctype="form-data">
				<table>
					<tr>
						<td><input type="number" name="firstSubject"
							placeholder="<spring:message code='addCert.firstSubj' />"
							class="w3-input w3-border w3-round-large w3-hover-border-green"
							style="margin-top: 10%; width: 40%;" /></td>
					</tr>
					<tr>
						<td><input type="number" name="secondSubject"
							placeholder="<spring:message code='addCert.secondSubj' />"
							class="w3-input w3-border w3-round-large w3-hover-border-green"
							style="margin-top: 10%; width: 40%;" /></td>
					</tr>
					<tr>
						<td><input type="number" name="thirdSubject"
							placeholder="<spring:message code='addCert.thirdSubj' />"
							class="w3-input w3-border w3-round-large w3-hover-border-green"
							style="margin-top: 10%; width: 40%;" /></td>
					</tr>
					<tr>
						<td><input type="number" name="sumSchoolsCerticifate"
							placeholder="<spring:message code='addCert.sum' />"
							class="w3-border w3-round-large w3-hover-border-green"
							style="margin-top: 10%; width: 40%;" /></td>
					</tr>
					<tr>
						<td>
							<button type="submit" class="w3-button w3-green w3-round-xxlarge"
								style="margin-top: 5%; margin-bottom: 5%">
								<spring:message code='addCert.submit' />
							</button>
						</td>
					</tr>
				</table>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form:form>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>