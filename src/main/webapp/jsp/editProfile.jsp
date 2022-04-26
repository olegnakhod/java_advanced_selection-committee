<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
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

<<<<<<< HEAD
			<!-- Page Content -->
				<!-- Body -->
				<div
					class="w3-container w3-panel w3-border w3-round-large w3-border-green"
					style="margin: auto; margin-top: 10%; width: 25%; hight: 30%">
					<form:form method="POST" action="${contextPath}/changeUser"
						enctype="form-data">
						<table>
							<tr style="margin-top: 10%;">
								<td><input type="text" name="firstName"
									placeholder="<spring:message code='edit.firsName' />"
									class="w3-input w3-border w3-round-large w3-hover-border-green" /></td>
							</tr>
							<tr style="margin-top: 10%;">

								<td><input type="text" name="lastName"
									placeholder="<spring:message code='edit.lastName'/>"
									class="w3-input w3-border w3-round-large w3-hover-border-green" /></td>
							</tr>
							<tr style="margin-top: 10%;">
								<td><input type="number" name="age"
									placeholder="<spring:message code='edit.age'/>"
									class="w3-input w3-border w3-round-large w3-hover-border-green" /></td>
							</tr>
							<tr style="margin-top: 10%;">
								<td>
									<button type="submit"
										class="w3-button w3-green w3-round-xxlarge"
										style="margin-top: 5%; margin-bottom: 5%">
										<spring:message code='edit.update' />
									</button>
								</td>
							</tr>
						</table>
					</form:form>
					<form:form method="POST" action="${contextPath}/changeFoto"
						enctype="multipart/form-data">
						<table>
							<tr>
								<td><input type="file" name="image"
									style="margin-top: 10%;" /></td>
							</tr>
							<tr style="margin-top: 10%;">
								<td>
									<button type="submit"
										class="w3-button w3-green w3-round-xxlarge"
										style="margin-top: 5%; margin-bottom: 5%">
										<spring:message code='edit.update' />
									</button>
								</td>
							</tr>
						</table>
					</form:form>
					<form:form method="POST" action="${contextPath}/changePassword"
						enctype="form-data">
						<table>
							<tr style="margin-top: 10%;">
								<td><input type="text" name="password"
									placeholder="<spring:message code='edit.password'/>"
									class="w3-input w3-border w3-round-large w3-hover-border-green" /></td>
							</tr>
							<tr style="margin-top: 10%;">
								<td><input type="text" name="passwordConfirm"
									placeholder="<spring:message code='edit.passwordConf'/>"
									class="w3-input w3-border w3-round-large w3-hover-border-green" /></td>
							</tr>
							<tr style="margin-top: 10%;">
								<td>
									<button type="submit"
										class="w3-button w3-green w3-round-xxlarge"
										style="margin-top: 5%; margin-bottom: 5%">
										<spring:message code='edit.update' />
									</button>
								</td>
							</tr>
						</table>
					</form:form>
				</div>
=======
			<!-- Body -->
			<div
				class="container d-flex justify-content-center align-self-center">
				<c:choose>
					<c:when test="${mode == 'CHANGE_USER'}">
						<div
							class="container d-flex flex-column bg-white shadow rounded overflow-hidden pt-5 pb-5">
							<form:form method="POST" action="${contextPath}/changeUser"
								enctype="form-data"
								class="form-card d-flex flex-column col-8 align-self-center">
								<input class="form-group" type="text" name="firstName"
									placeholder="<spring:message code='edit.firsName' />" />
								<input class="form-group" type="text" name="lastName"
									placeholder="<spring:message code='edit.lastName'/>" />
								<input class="form-group" type="number" name="age"
									placeholder="<spring:message code='edit.age'/>" />
								<button type="submit" class=" btn btn-outline-info">
									<spring:message code='edit.update' />
								</button>
							</form:form>
							<div class="align-self-center mt-5">
								<span class="font-weight-light text-muted"><spring:message code='edit.title' />:</span>
							</div>
							<div class="btn-group mt-3 align-self-center" role="group"
								aria-label="Basic example">
								<a href="changeUser" class="btn btn-info"><spring:message code='edit.page1' /></a> <a
									href="changeFoto" class="btn btn-secondary"><spring:message code='edit.page2' /></a> <a
									href="changePassword" class="btn btn-secondary"><spring:message code='edit.page3' /></a>
							</div>
						</div>
					</c:when>
					<c:when test="${mode == 'CHANGE_FOTO'}">
						<div
							class="container d-flex flex-column bg-white shadow rounded overflow-hidden pt-5 pb-5">
							<form:form
								class="form-card d-flex flex-column col-8 align-self-center"
								method="POST" action="${contextPath}/changeFoto"
								enctype="multipart/form-data">
								<input class="form-group form-control-file" type="file"
									name="image" />
								<button class=" btn btn-outline-info" type="submit">
									<spring:message code='edit.update' />
								</button>
							</form:form>
							<div class="align-self-center mt-2">
								<span class="font-weight-light text-muted"><spring:message code='edit.title' />:</span>
							</div>
							<div class="btn-group mt-3  mb-3 align-self-center" role="group"
								aria-label="Basic example">
								<a href="changeUser" class="btn btn-secondary"><spring:message code='edit.page1' /></a> <a
									href="changeFoto" class="btn btn-info"><spring:message code='edit.page2' /></a> <a
									href="changePassword" class="btn btn-secondary"><spring:message code='edit.page3' /></a>
							</div>
						</div>
					</c:when>
					<c:when test="${mode == 'CHANGE_PASSWORD'}">
						<div
							class="container d-flex flex-column bg-white shadow rounded overflow-hidden pt-5 pb-5">
							<form:form
								class="form-card d-flex flex-column col-8 align-self-center"
								method="POST" action="${contextPath}/changePassword"
								enctype="form-data">
								<input class="form-group " type="text" name="password"
									placeholder="<spring:message code='edit.password'/>" />
								<input class="form-group" type="text" name="passwordConfirm"
									placeholder="<spring:message code='edit.passwordConf'/>" />
								<button class=" btn btn-outline-info" type="submit">
									<spring:message code='edit.update' />
								</button>
							</form:form>
							<div class="align-self-center mt-4">
								<span class="font-weight-light text-muted"><spring:message code='edit.title' />:</span>
							</div>
							<div class="btn-group mt-3 mb-3 align-self-center" role="group"
								aria-label="Basic example">
								<a href="changeUser" class="btn btn-secondary"><spring:message code='edit.page1' /></a> <a
									href="changeFoto" class="btn btn-secondary"><spring:message code='edit.page2' /></a> <a
									href="changePassword" class="btn btn-info"><spring:message code='edit.page3' /></a>
							</div>
						</div>
					</c:when>
				</c:choose>

>>>>>>> 85f97a2a4ed35f60fb399a59696cf45f98c4dea8
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