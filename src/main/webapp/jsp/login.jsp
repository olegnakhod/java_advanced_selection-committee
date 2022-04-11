<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link href="${contextPath}/resources/css/bootstrap.min.css"	rel="stylesheet">
<title>Log in with your account</title>
</head>
<body>
	<div class="w3-container w3-panel w3-border w3-round-large w3-border-green" style ="margin: auto; margin-top: 10%; width: 20%; hight: 30%">
		<p >Log in</p>
		<form method="POST" action="${contextPath}/login" class="w3-container">
			<div class=" ${error != null ? 'has-error' : ''}">
				<span>${message}</span>
			<input name="email" type="text" placeholder="Email" autofocus="true"  class="w3-input w3-border w3-round-large w3-hover-border-green" style ="margin-top: 10%;"/> 
			<input	name="password" type="password" placeholder="Password"  class="w3-input w3-border w3-round-largew3-hover-border-green" style ="margin-top: 10%;"/>
				<span>${error}</span>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<button type="submit" class="w3-button w3-green w3-round-xxlarge" style ="margin-top: 10%;">Log In</button>
				<h4 >
					<a href="${contextPath}/registration">Create an account</a>
				</h4>
			</div>
		</form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>