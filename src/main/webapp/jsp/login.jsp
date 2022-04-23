<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<link rel="stylesheet" href="css/login.css">
	<title>Login page</title>
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->
			<a class="active" href="login"> Sign In </a> <a
				class="inactive underlineHover" href="registration">Sign Up </a>

			<!-- Login Form -->
			<form method="POST" action="${contextPath}/login">
				<input name="email" type="text"
					placeholder="<spring:message code='login.email' />" id="login"
					class="fadeIn second"> <input name="password"
					type="password"
					placeholder="<spring:message code='login.password'/>" id="password"
					class="fadeIn third">
				<button type="submit" class="fadeIn fourth">
					<spring:message code="login.signin" />
				</button>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>

			<!-- Remind Passowrd -->
			<div id="formFooter">
				<div>
					<label><spring:message code='login.choose_language' /></label> <select
						id="locales">
						<option value="en"><spring:message code='login.english' /></option>
						<option value="ua"><spring:message code='login.ukrainian' /></option>

					</select>
				</div>
			</div>

		</div>
	</div>
	<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>