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
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<title>Login page</title>
</head>
<body>
	<div class="w3-container w3-panel w3-border w3-round-large w3-border-green" style ="margin: auto; margin-top: 10%; width: 20%; hight: 30%">
		<form method="POST" action="${contextPath}/login" class="w3-container">
			<div class=" ${error != null ? 'has-error' : ''}">
			<span>${message}</span>
			<input name="email" type="text" placeholder="<spring:message code='login.email' />" 
				autofocus="true"  class="w3-input w3-border w3-round-large w3-hover-border-green" style ="margin-top: 10%;"/> 
			<input	name="password" type="password" placeholder="<spring:message code='login.password'/>"
				 class="w3-input w3-border w3-round-largew3-hover-border-green" style ="margin-top: 10%;"/>
			<span>${error}</span>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<button type="submit" class="w3-button w3-green w3-round-xxlarge" style ="margin-top: 10%;"><spring:message code="login.signin"/></button>
				<h4 >
					<a href="${contextPath}/registration"><spring:message code='login.create'/></a>
				</h4>
			</div>
		</form>
	</div>
	<div>
		<fieldset>
			<label><spring:message code='login.choose_language' /></label> <select
				id="locales">
				<option value="en"><spring:message code='login.english' /></option>
				<option value="ua"><spring:message code='login.ukrainian' /></option>

			</select>
		</fieldset>
	</div>
	<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>