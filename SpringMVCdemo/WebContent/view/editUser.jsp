<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="springmvc.model.User" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit user</title>
</head>
<body>	<label>Edit user</label>
		<form:form modelAttribute="editThisUser" action = "updateUser" method="get">
			<fieldset>
						   <form:hidden path="idUser"/>
				User name: <form:input path="userName"/><br>
				Password:  <form:input path="password"/><br>
				Role:	   <form:select path="role">
							  <form:option value="ADMIN" label="ADMIN"/>
							  <form:option value="KORISNIK" label="KORISNIK"/>
						   </form:select><br><br>
						   <input type="submit" value="EDIT USER">
			</fieldset>
		</form:form> 
		
		<label>Delete user</label>
		<form:form modelAttribute="editThisUser" action = "deleteUser">
			<fieldset>
				<form:hidden path="idUser"/>
				<input type="submit" value="DELETE USER">
			</fieldset>
		</form:form>

		<label>Add balance to user</label>
		<form:form modelAttribute="editThisUser" action = "addBalance" method = "post">
			<fieldset>
				<form:hidden path = "idUser"/>
				<form:hidden path = "idUser"/>
				<form:hidden path = "userName"/>
				<form:hidden path = "password"/>
				<form:hidden path = "role"/>
				<form:hidden path = "balance"/>
				
				<input type="text" name = "balanceAdd"/><br>
				<input type="submit" value="ADD BALANCE">
			</fieldset>
		</form:form>
</body>
</html>