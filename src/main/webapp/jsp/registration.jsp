<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Create an account</title>
   <link rel="stylesheet" href="css/login.css">
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->
			<a class="inactive underlineHover" href="login"> <spring:message code='login.logging' /> </a> <a
				class="active" href="registration"><spring:message code='login.create' /> </a>

			<!-- Login Form -->
			<form:form method="POST" action="${contextPath}/registration" enctype="multipart/form-data">
				<input name="firstName" type="text"	placeholder="<spring:message code='reg.firstName' />" id="login"	class="fadeIn second">
				<input name="lastName"	type="text"	placeholder="<spring:message code='reg.lastName'/>" id="login" class="fadeIn second">
				<input name="age" type="number"	placeholder="<spring:message code='reg.age' />" id="login"	class="fadeIn second">
				<input name="email"	type="text"	placeholder="<spring:message code='reg.email'/>" id="login" class="fadeIn second">
				<input name="password"	type="password"	placeholder="<spring:message code='reg.password'/>" id="password" class="fadeIn second">
				<input name="passwordConfirm" type="password"	placeholder="<spring:message code='reg.passwordConf' />" id="password"	class="fadeIn second">
				<input name="image"	type="file"	placeholder="<spring:message code='reg.addFoto'/>" id="login"class="fadeIn second">
				<button type="submit" class="fadeIn fourth"> <spring:message code='reg.registr' />	</button>
				<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />
			</form:form>

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