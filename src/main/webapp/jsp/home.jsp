<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
	<div class="container">
		<!-- Sidebar -->
		<div class="w3-sidebar w3-light-grey w3-bar-block" style="width: 10%">
			<h3 class="w3-bar-item">Menu</h3>
			<a href="/home" class="w3-bar-item w3-button">Home</a>
			<a href="/addFaculty" class="w3-bar-item w3-button">Add Faculty</a>
			<a href="/applyToFaculty" class="w3-bar-item w3-button">Apply to faculty</a>
			<a href="/viewCandidateInFaculty" class="w3-bar-item w3-button">Statment</a>
			<a href="/addCertificate" class="w3-bar-item w3-button">Add/update certificate</a>
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<form id="logoutForm" method="POST" action="${contextPath}/logout">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
					<a onclick="document.forms['logoutForm'].submit()" class="w3-bar-item w3-button">Logout</a>

			</c:if>
		</div>


		<!-- Page Content -->

		<div class="w3-container" style="margin-left: 10%;  width: 100% ;hight: 100%">
			<!-- Header -->
			<div class="w3-container w3-teal">
				<h1>Home</h1>
			</div>
			<!-- Body -->
			
			<div class="w3-container w3-left" style="width:35% ; margin-left: 5%; margin-top: 5%">
				<h2>Profile</h2>
				<div class="w3-container">
					<img  class="w3-left" style="width:35%"  alt="Avatar" src="data:image/jpg;base64, ${userViewer.encodeImage}">
  					<div class="container"  style="margin-left: 5%;">
  			 			<h5>First name: ${userViewer.firstName}</h5>
						<h5>Last name: ${userViewer.lastName}</h5>
						<h5>Age: ${userViewer.age}</h5>
 			 		</div>
 			 	</div>
 			 	<a href="/editProfile">Edit profile</a>
			</div>
			<div class="w3-container w3-left" style="width:35% ; margin-left: 5%; margin-top: 5%">
				<h2>Cetrificate</h2>
				<div class="container">
					<table  class="w3-container">
						<tr>
							<td>Ukranian language:</td>
							<td>${subjectsViewer.firstSubject}</td>
						</tr>
						<tr>
							<td>Mathematics:</td>
							<td>${subjectsViewer.secondSubject}</td>
						</tr>
						<tr>
							<td>Physics:</td>
							<td>${subjectsViewer.thirdSubject}</td>
						</tr>
						<tr>
							<td>Sum schools certicifate:</td>
							<td>${subjectsViewer.sumSchoolsCerticifate}</td>
						</tr>
						<tr>
							<td>Total grades:</td>
							<td>${subjectsViewer.totalGrades}</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- /container -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	<!-- /container -->
</body>
</html>