<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="springmvc.model.Artikal" %>
<%@ page import="springmvc.model.Pice" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>strana sa picima</title>
</head>
<body>
	<br><br>
	<a href = "listOfUsers">back to admin page</a>
	<br><br>
	<a href = "dodajPice"><button>DODAJ PICE</button></a>
	<br><br>
	
	<h2>TABELA PICA</h2>
	<table border = "1">
		<tr>
			<th>ID</th>
			<th>IME</th>
			<th>CENA</th>
			<th>ZAPREMINA</th>
			<th>STANJE</th>
			<th>POPUST</th>
			<th>UREDI</th>
		</tr>
		
		<c:forEach var="p" items="${listaPica}">
			<tr>
				<td>${p.idArtikla}</td>
				<td>${p.imeArtikla}</td>
				<td>${p.cena}</td>
				<td>${p.zapremina}</td>
				<td>${p.stanje}</td>
				<td>${p.popust}</td>
			<c:url var="link" value="editPice">
				<c:param name="idPice" value="${p.idArtikla}"></c:param>
			</c:url>
				<td><a href = "${link}">Edit</a></td>
			</tr>	
		</c:forEach>
	</table>
</body>
</html>