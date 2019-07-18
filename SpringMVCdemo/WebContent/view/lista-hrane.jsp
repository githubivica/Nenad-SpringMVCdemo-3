<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="springmvc.model.Hrana" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>lista hrane</title>
</head>
<body>
	
	<h2> HRANA </h2>
	<br>
	<a href = "listOfUsers">back to admin page</a>
	<br><br>
	
	<a href = "dodajHranu"><button>DODAJ HRANU</button></a>
	
	<br><br>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>IME</th>
			<th>CENA</th>
			<th>MASA</th>
			<th>STANJE</th>
			<th>POPUST</th>
			<th>UREDI</th>
		</tr>
		<c:forEach var="h" items="${listaHrane}">
			<tr>
				<td>${h.idArtikla}</td>
				<td>${h.imeArtikla}</td>
				<td>${h.cena}</td>
				<td>${h.masa}</td>
				<td>${h.stanje}</td>
				<td>${h.popust}</td>
				<c:url var="edit" value="editHrana">
					<c:param name="idHrana" value="${h.idArtikla}"/>
				</c:url>
				<td><a href="${edit}">edit</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>