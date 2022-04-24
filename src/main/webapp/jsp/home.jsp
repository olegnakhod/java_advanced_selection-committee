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
		<jsp:include page="sidebar.jsp"></jsp:include>
		<!-- Content  -->
		<div id="content" class="d-flex">
			<!-- Header  -->
			<nav
				class="navbar navbar-expand-lg navbar-light bg-secondary fixed-top">
				<div class="container-fluid">
					<security:authorize access="hasRole('ROLE_ADMINISTRATOR')">
						<button type="button" id="sidebarCollapse" class="btn btn-info">
							<i class="fas fa-align-left"></i> <span><spring:message
								code='header.admin' /></span>
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
			<c:choose>
				<c:when test="${mode == 'VIEW_PROFILE'}">
					<div class="container align-self-start mb-5">
						<div class="row py-5 px-4">
							<div class="col-12 mx-auto">
								<!-- Profile widget -->
								<div class="bg-white shadow rounded overflow-hidden pb-2">
									<div class="px-4 pt-3 pb-4 mt-2 cover">
										<div class="media profile-head d-flex align-items-baseline">
											<div class="profile mr-3 ">
												<img src="data:image/jpg;base64, ${userViewer.encodeImage}"
													alt="" width="130" class="rounded mb-2 img-thumbnail">
												<a href="/editProfile"
													class="btn btn-outline-dark btn-sm btn-block"><spring:message
														code='home.editProfile' /></a>
											</div>
											<div class="media-body text-black align-self-start">
												<h4 class="text-center">${userViewer.firstName}
													${userViewer.lastName}</h4>
											</div>
										</div>
									</div>

									<security:authorize access="hasRole('ROLE_CANDIDATE')">
										<div class="px-4 py-3">
											<div class="p-4 rounded shadow-sm bg-light">
												<h5 class="mb-0">
													<spring:message code='home.certificate' />
												</h5>
												<p class="font-italic mb-0">
													<spring:message code='home.firstSubj' />
													: ${subjectsViewer.firstSubject}
												</p>
												<p class="font-italic mb-0">
													<spring:message code='home.secondSubj' />
													: ${subjectsViewer.secondSubject}
												</p>
												<p class="font-italic mb-0">
													<spring:message code='home.thirdSubj' />
													: ${subjectsViewer.thirdSubject}
												</p>
												<p class="font-italic mb-0">
													<spring:message code='home.sum' />
													: ${subjectsViewer.sumSchoolsCerticifate}
												</p>
												<p class="font-italic mb-0">
													<spring:message code='home.totalGrades' />
													: ${subjectsViewer.totalGrades}
												</p>
												<a href="/addCertificate"
													class="btn btn-outline-dark btn-sm btn-block col-4"><spring:message
														code='sidebar.addCrtificate' /></a>
											</div>
										</div>
										<div class="container mb-2">
											<div class="row">
												<div class="col-6">
													<a href="/viewActiveApplyes"
														class="btn btn-outline-dark btn-sm btn-block "><spring:message
															code='home.viewApp' /></a> 
												</div>
												<div class="col-6">
													<a href="/applyToFaculty"
														class="btn btn-outline-dark btn-sm btn-block "><spring:message
															code='home.apply' /></a>
												</div>
											</div>
										</div>
									</security:authorize>

								</div>
							</div>
						</div>
					</div>
				</c:when>
				<c:when test="${mode == 'VIEW_CANDIDATE'}">
					<div class="container align-self-start mb-5">
						<div class="row py-5 px-4">
							<div class="col-12 mx-auto">
								<!-- Profile widget -->
								<div class="bg-white shadow rounded overflow-hidden">
									<div class="px-4 pt-3 pb-4 mt-2 cover">
										<div class="media profile-head d-flex align-items-baseline">
											<div class="profile mr-3 ">
												<img src="data:image/jpg;base64, ${userViewer.encodeImage}"
													alt="" width="130" class="rounded mb-2 img-thumbnail">
											</div>
											<div class="media-body text-black align-self-start">
												<h4 class="text-center">${userViewer.firstName}
													${userViewer.lastName}</h4>
											</div>
										</div>
									</div>
									<div class="px-4 py-3">
										<div class="p-4 rounded shadow-sm bg-light">
											<h5 class="mb-0">
												<spring:message code='home.certificate' />
											</h5>
											<p class="font-italic mb-0">
												<spring:message code='home.firstSubj' />
												: ${subjectsViewer.firstSubject}
											</p>
											<p class="font-italic mb-0">
												<spring:message code='home.secondSubj' />
												: ${subjectsViewer.secondSubject}
											</p>
											<p class="font-italic mb-0">
												<spring:message code='home.thirdSubj' />
												: ${subjectsViewer.thirdSubject}
											</p>
											<p class="font-italic mb-0">
												<spring:message code='home.sum' />
												: ${subjectsViewer.sumSchoolsCerticifate}
											</p>
											<p class="font-italic mb-0">
												<spring:message code='home.totalGrades' />
												: ${subjectsViewer.totalGrades}
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:when>
			</c:choose>
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
	</div>

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