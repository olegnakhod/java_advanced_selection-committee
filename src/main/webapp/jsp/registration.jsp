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
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link href="${contextPath}/resources/css/bootstrap.min.css"	rel="stylesheet">
</head>
<body>
	<div class="w3-container w3-panel w3-border w3-round-large w3-border-green" style ="margin: auto; margin-top: 10%; width: 25%; hight: 30%">
		<form:form method="POST" action="${contextPath}/registration"
			enctype="multipart/form-data">
			<table>
				<tr style="margin-top: 10%;">
					<td><input type="text" name="firstName"
						placeholder="<spring:message code='reg.firsName' />"
						class="w3-input w3-border w3-round-large w3-hover-border-green" /></td>
				</tr>
				<tr style="margin-top: 10%;">

					<td><input type="text" name="lastName"
						placeholder="<spring:message code='reg.lastName'/>"
						class="w3-input w3-border w3-round-large w3-hover-border-green" /></td>
				</tr>
				<tr style="margin-top: 10%;">
					<td><input type="number" name="age"
						placeholder="<spring:message code='reg.age'/>"
						class="w3-input w3-border w3-round-large w3-hover-border-green" /></td>
				</tr>
				<tr style="margin-top: 10%;">
					<td><input type="text" name="email"
						placeholder="<spring:message code='reg.email'/>"
						class="w3-input w3-border w3-round-large w3-hover-border-green" /></td>
				</tr>
				<tr style="margin-top: 10%;">
					<td><input type="text" name="password"
						placeholder="<spring:message code='reg.password'/>"
						class="w3-input w3-border w3-round-large w3-hover-border-green" /></td>
				</tr>
				<tr style="margin-top: 10%;">
					<td><input type="text" name="passwordConfirm"
						placeholder="<spring:message code='reg.passwordConf'/>"
						class="w3-input w3-border w3-round-large w3-hover-border-green" /></td>
				</tr>
				<tr>
					<td><input type="file" name="image"
						value="<spring:message code='reg.addFoto'/>"
						style="margin-top: 10%;" /></td>
				</tr>
				<tr style="margin-top: 10%;">
					<td>
						<button type="submit" class="w3-button w3-green w3-round-xxlarge"
							style="margin-top: 5%; margin-bottom: 5%">
							<spring:message code='reg.registr' />
						</button>
					</td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form:form>
		<div>
				<fieldset>
				<label><spring:message code='login.choose_language' /></label>
				 	<select id="locales">
						<option value="en"><spring:message code='login.english' /></option>
						<option value="ua"><spring:message code='login.ukrainian' /></option>
					</select>
				</fieldset>
			</div>
	</div>
	<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="js/main.js"></script>
</body>
</html>