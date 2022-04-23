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
		<jsp:include page="sidebar.jsp"></jsp:include>
		<!-- Content  -->
		<div id="content" class="d-flex">
			<!-- Header  -->
			<nav
				class="navbar navbar-expand-lg navbar-light bg-secondary fixed-top">
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
							<li class="nav-item"><a href="/home"
								class=" btn btn-outline-info"><spring:message
										code='sidebar.home' /></a></li>
							<li class="nav-item"><c:if
									test="${pageContext.request.userPrincipal.name != null}">
									<form id="logoutForm" method="POST"
										action="${contextPath}/logout">
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" />
									</form>
									<a onclick="document.forms['logoutForm'].submit()"
										class="btn btn-info ml-2"><spring:message
											code='sidebar.logout' /></a>

								</c:if></li>
						</ul>
					</div>
				</div>
			</nav>

			<!-- Body -->
			<div
				class="container d-flex justify-content-center align-self-center">
				<div
					class="container d-flex flex-column bg-white shadow rounded overflow-hidden pt-5 pb-5">
					<form:form method="POST" action="${contextPath}/addCertificate"
						enctype="form-data"
						class="form-card d-flex flex-column col-8 align-self-center">
						<input class="form-group" type="number" name="firstSubject"
							placeholder="<spring:message code='addCert.firstSubj' />" />
						<input class="form-group" type="number" name="secondSubject"
							placeholder="<spring:message code='addCert.secondSubj' />" />
						<input class="form-group" type="number" name="thirdSubject"
							placeholder="<spring:message code='addCert.thirdSubj' />" />
						<input class="form-group" type="number"
							name="sumSchoolsCerticifate"
							placeholder="<spring:message code='addCert.sum' />" />
						<button type="submit" class=" btn btn-outline-info">
							<spring:message code='edit.update' />
						</button>
					</form:form>
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</div>
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>