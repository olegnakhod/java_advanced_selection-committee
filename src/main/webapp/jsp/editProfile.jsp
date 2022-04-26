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