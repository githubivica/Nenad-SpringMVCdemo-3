<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
	<style>
		.error{
			color: red;
			border: 1px solid blue;
		}
	</style>
</head>
<body>
	<h1>Login page</h1>
	
	<form:form modelAttribute="user" action="procesuiranjeLogin" method="post">
		<label>User name </label>
			<form:input path="userName"/>
			<form:errors path="userName" cssClass="error"/>
		<br><br>
		<label>Password </label>
			<form:password path="password" />
			<form:errors path="password" cssClass="error"/>
		<br><br>
		<input type="submit" value="LOGIN">
	</form:form>
</body>
</html>