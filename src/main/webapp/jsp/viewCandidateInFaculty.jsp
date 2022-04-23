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
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="css/profile.css" />
</head>
<body>
	<div class="wrapper">
		<!-- Sidebar  -->
		<jsp:include page="sidebar.jsp"></jsp:include>
		<!-- Content  -->
		<div id="content" class = "d-flex">
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

			<!-- Page Content -->
			<div
				class="container d-flex justify-content-center align-self-start mt-5">
				<c:choose>
					<c:when test="${mode == 'VIEW_CANDIDATE'}">
						<div class = "mt-3 col-10">
							<table class="table table-striped col-10">
								<thead class="thead-dark ">
									<tr>
										<th scope="col"><spring:message code='statment.firsName' /></th>
										<th scope="col"><spring:message code='statment.lastName' /></th>
										<th scope="col"><spring:message code='statment.totalGrades' /></th>
										<th scope="col"><spring:message code='statment.delete' /></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="candidate" items="${candidates}">
										<tr>
											<td>${candidate.firstName}</td>
											<td>${candidate.lastName}</td>
											<c:forEach var="subject" items="viewTotalGrades?userId=${candidate.id}">
												<td>${subject.totalGrades}"</td>
											</c:forEach>
											<td><a href="deleteCandidate?userId=${candidate.id}"><spring:message
														code='statment.delete' /></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</c:when>
					<c:when test="${mode == 'VIEW_FACULTY'}">
						<div class = "mt-3 col-10">
							<table class="table table-striped col-10">
								<thead class="thead-dark">
									<tr>
										<th scope="col"><spring:message code='statment.name' /></th>
										<th scope="col"><spring:message code='statment.numberOfSeats' /></th>
										<th scope="col"><spring:message code='statment.minimumPassingScore' /></th>
										<th scope="col"></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="faculity" items="${faculityes}">
										<tr>
											<td>${faculity.name}</td>
											<td>${faculity.numberOfSeats}</td>
											<td>${faculity.minimumPassingScore}</td>
											<td> <a href="viewCandidatesInFaculty?facultyId=${faculity.id}"><spring:message code='statment.viewCan' /></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</c:when>
				</c:choose>
			</div>
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