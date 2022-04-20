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
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="css/profile.css" />
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

		<!-- Header  -->
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
			<div class="container">
				<!-- Page Content -->
				<div style="margin-left: 10%">
					<div class="w3-container w3-teal">
						<h1>
							<spring:message code='applyFacylty.header' />
						</h1>
					</div>

					<div class="w3-container">
						<c:if test="${not empty facultyes}">
							<c:forEach items="${facultyes}" var="currentFacultyes">

								<div class="w3-card-4" style="width: 20%; margin: 2%">
									<div class="w3-container w3-center">
										<h3>
											<spring:message code='applyFacylty.name' />
											: ${currentFacultyes.name}
										</h3>
										<p>
											<spring:message code='applyFacylty.numberOfSeats' />
											: ${currentFacultyes.numberOfSeats}
										</p>
										<p>
											<spring:message code='applyFacylty.minimumPassingScore' />
											: ${currentFacultyes.minimumPassingScore}
										</p>
									</div>

									<form:form action="${contextPath}/applyToFaculty" method="POST"
										enctype="multipart/form-data">
										<input type="hidden" value="${currentFacultyes.id}"
											name="facultyId">
										<input type="submit" class="w3-button w3-block w3-dark-grey"
											value="<spring:message code='applyFacylty.applyTo' />">
									</form:form>
								</div>

							</c:forEach>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>