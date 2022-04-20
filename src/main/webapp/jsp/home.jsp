<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
				<div class="row py-5 px-4">
					<div class="col-md-12 mx-auto">
						<!-- Profile widget -->
						<div class="bg-white shadow rounded overflow-hidden">
							<div class="px-4 pt-0 pb-4 cover">
								<div class="media align-items-end profile-head">
									<div class="profile mr-3 ">
										<img
											src="data:image/jpg;base64, ${userViewer.encodeImage}"
											alt="..." width="130" class="rounded mb-2 img-thumbnail">
											<a href="/editProfile" class="btn btn-outline-dark btn-sm btn-block" ><spring:message code='home.editProfile' /></a>
									</div>
									<div class="media-body text-black d-flex align-items-baseline justify-content-center">
										<h4 class="mt-0 mb-0">${userViewer.firstName} ${userViewer.lastName}</h4>
									</div>
								</div>
							</div>
							
							<security:authorize access="hasRole('ROLE_CANDIDATE')">
							<div class="px-4 py-3">
								<div class="p-4 rounded shadow-sm bg-light">
									<h5 class="mb-0"><spring:message code='home.certificate' /></h5>
									<p class="font-italic mb-0"><spring:message code='home.firstSubj' />: ${subjectsViewer.firstSubject}</p>
									<p class="font-italic mb-0"><spring:message code='home.secondSubj' />: ${subjectsViewer.secondSubject}</p>
									<p class="font-italic mb-0"><spring:message code='home.thirdSubj' />: ${subjectsViewer.thirdSubject}</p>
									<p class="font-italic mb-0"><spring:message code='home.sum' />: ${subjectsViewer.sumSchoolsCerticifate}</p>
									<p class="font-italic mb-0"><spring:message code='home.totalGrades' />: ${subjectsViewer.totalGrades}</p>
									<a	href="/addCertificate" class="btn btn-outline-dark btn-sm btn-block col-4"><spring:message code='sidebar.addCrtificate' /></a>
								</div>
							</div>
							<a	href="/applyToFaculty" class="btn btn-outline-dark btn-sm btn-block "><spring:message code='sidebar.apply' /></a>
							</security:authorize>
							
						</div>
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