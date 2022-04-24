<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css" />
<link rel="stylesheet" href="css/profile.css" />
</head>
<body>
	<!-- Sidebar  -->
	<nav id="sidebar" class='active'>
		<div class="sidebar-header">
			<h3 class="w3-bar-item">
				<spring:message code='sidebar.menu' />
			</h3>
		</div>
		<div class="list-group">
			<a class="list-group-item btn-outline-info" href="/home"><spring:message
					code='sidebar.home' /></a> <a class="list-group-item btn-outline-info"
				href="/addFaculty"><spring:message code='sidebar.addFaculty' /></a>
			<a class="list-group-item btn-outline-info"
				href="/viewCandidateInFaculty"><spring:message
					code='sidebar.statment' /></a>
		</div>
	</nav>
</body>
</html>