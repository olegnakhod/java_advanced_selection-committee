<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<div class="w3-container w3-panel w3-border w3-round-large w3-border-green" style ="margin: auto; margin-top: 10%; width: 20%; hight: 30%">
    <form:form method="POST" modelAttribute="userForm" >
        <h2 class="form-signin-heading">Create your account</h2> 
        
        <spring:bind path="firstName">
            <div class="${status.error ? 'has-error' : ''}">
                <form:input type="text" path="firstName" placeholder="First name" autofocus="true" class="w3-input w3-border w3-round-large w3-hover-border-green" style ="margin-top: 10%;"></form:input>
                <form:errors path="firstName"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="lastName">
          	<div class="${status.error ? 'has-error' : ''} ">
                <form:input type="text" path="lastName" placeholder="Last name" autofocus="true" class="w3-input w3-border w3-round-large w3-hover-border-green" style ="margin-top: 10%;"></form:input>
                <form:errors path="lastName"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="email">
            <div class="${status.error ? 'has-error' : ''}">
                <form:input type="text" path="email"  placeholder="Email" autofocus="true" class="w3-input w3-border w3-round-large w3-hover-border-green" style ="margin-top: 10%;"></form:input>
                <form:errors path="email"></form:errors>
            </div>
        </spring:bind>
        
         <spring:bind path="age">
            <div class="${status.error ? 'has-error' : ''}">
                <form:input type="number" path="age" placeholder="Age" class="w3-input w3-border w3-round-large w3-hover-border-green" style ="margin-top: 10%;"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password"  placeholder="Password" class="w3-input w3-border w3-round-large w3-hover-border-green" style ="margin-top: 10%;"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
            <div class="${status.error ? 'has-error' : ''}">
                <form:input type="password" path="passwordConfirm" placeholder="Confirm your password" class="w3-input w3-border w3-round-large w3-hover-border-green" style ="margin-top: 10%;"></form:input>
                <form:errors path="passwordConfirm"></form:errors>
            </div>
        </spring:bind>

        <button  type="submit" class="w3-button w3-green w3-round-xxlarge" style ="margin-top: 5%;margin-bottom: 5%">Submit</button>
    </form:form>

</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>