<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>registration page</title>
	<style>
		.error{
			color: red;
			border: 1px solid blue;
		}
	</style>
</head>
<body>
	<h1>Registracija</h1>
	
	<form:form action="procesuiranjeRegistracije" modelAttribute="automatskiUser">
			<form:input path="userName" placeholder = "User name"/>
				<form:errors path="userName" cssClass="error"/>
			<br><br>
			<form:password path="password" placeholder = "Password"/>
				<form:errors path="password" cssClass="error"/>
			<br><br>
			<input type="password" name="repeatPassword" placeholder="Repeat Password" />
			<br><br>
		<input type="submit" value="REGISTRUJ SE">
	</form:form>
</body>
</html>