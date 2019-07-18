<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="springmvc.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin page</title>
</head>
<body>
	<% User user = (User)session.getAttribute("userIzBaze"); 
	System.out.println(user.getUserName() + " " + user.getPassword());
	%>
	<h1>DOBRODOŠLI</h1>
	<p>Vaš user name: <%=user.getUserName() %></p>
	
	<br><br>
	
	<a href = "pice-list"><button>PRIKAZI PIĆE</button></a>
	<a href = "hrana-list"><button>PRIKAZI HRANU</button></a>
	
	<br><br>
	

	
	<c:url var="logoutLink" value="/admin/logout"/>
	<a href = "${logoutLink}">Log out</a>
	
	<br><br>
	
	<h2>USER SECTION</h2>
	
	<table border="1">
		<tr>
			<th>USER NAME</th>
			<th>PASSWORD</th>
			<th>ROLE</th>
			<th>BALANCE</th>
			<th>EDIT</th>
		</tr>
		<c:forEach var = "u" items="${listaUsera}">
			<tr>
				<td>${u.userName}</td>
				<td>${u.password}</td>
				<td>${u.role}</td>
				<td>${u.balance}</td>
				<c:url var="linkZaEdit" value="/admin/editUser">
					<c:param name="idUser" value="${u.idUser}"/>
				</c:url>
				<td><a href="${linkZaEdit}">edit</a></td>
			<tr>
		</c:forEach>
	</table>
	



	
	
	
	
	
	
	
</body>
</html>