<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="springmvc.model.Pice" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>naruci pice i hranu</title>
</head>
<body>
		
		<a href="pogledajRacun"><button>POGLEDAJ RACUN</button></a>
		
		<br><br>
		
		<a href = "korisnikPage"> back to korisnik page </a>
		
		<br><br>
		
		<h2> TABELA PICA</h2>
		
		<table border="1">
			
			<tr>
				<th>ID</th>
				<th>IME</th>
				<th>CENA</th>
				<th>ZAPREMINA</th>
				<th>POPUST</th>
			</tr>
			<c:forEach var="p" items="${listaPica}">
				<tr>
					<td>${p.idArtikla}</td>
					<td>${p.imeArtikla}</td>
					<td>${p.cena}</td>
					<td>${p.zapremina}</td>	
					<td>
						<c:url var="linkPice" value="pregledajPice">
							<c:param name="idPice" value="${p.idArtikla}"/>
						</c:url>
						<a href="${linkPice}">dodaj</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<br><br>
		
		
		<h2> TABELA HRANE</h2>
		
		<table border="1">
			
			<tr>
				<th>ID</th>
				<th>IME</th>
				<th>CENA</th>
				<th>MASA</th>
				<th>POPUST</th>
			</tr>
			<c:forEach var="h" items="${listaHrane}">
				<tr>
					<td>${h.idArtikla}</td>
					<td>${h.imeArtikla}</td>
					<td>${h.cena}</td>
					<td>${h.masa}</td>	
					<td>
						<c:url var="linkHrana" value="pregledajHranu">
							<c:param name="idHrana" value="${h.idArtikla}"/>
						</c:url>
						<a href="${linkHrana}">dodaj</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	

</body>
</html>