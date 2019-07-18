<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="springmvc.model.Pice" %>
<%@ page import="springmvc.model.Artikal" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>racun</title>
</head>
<body>
	<jsp:useBean scope="session" class="springmvc.model.User" id = "userIzBaze"/>
	<a href = "naruciArtikal">nazad na naruci artikal</a>
	
	<h2> U NOVCANIKU IMATE ${userIzBaze.balance} DINARA </h2>
	<h2> RACUN </h2>
	<table border="1">
		
		<tr>
			<th>IME</th>
			<th>CENA</th>
			<th>POPUST</th>
			<th>KOLICINA</th>
			<th>UKLONI</th>
		</tr>
		<form:form modelAttribute="racunKolicina" action = "platiRacun" method="post">
		

			<c:choose>
				<c:when test="${fn:length(racunKolicina.listaArtikala)==0}">
				    <c:forEach var="i" begin="0" end = "${fn:length(racunKolicina.listaArtikala)}">
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>	
						</tr>
					</c:forEach> 	
				</c:when>
				<c:when test="${fn:length(racunKolicina.listaArtikala)!=0}">
					<c:forEach var="i" begin="0" end = "${fn:length(racunKolicina.listaArtikala)-1}">
						<tr>
							<td>${racunKolicina.listaArtikala[i].imeArtikla}</td>
							<td>${racunKolicina.listaArtikala[i].cena}</td>
							<td>${racunKolicina.listaArtikala[i].popust}</td>
							<td>${racunKolicina.kolicina[i]}</td>
							<c:url var="linkZaBrisanje" value="obrisiArtikalSaListe">
								<c:param name="idArtikla" value="${racunKolicina.listaArtikala[i].idArtikla}"/>
							</c:url>
							<td><a href = "${linkZaBrisanje}">ukloni</a></td>	
						</tr>
					</c:forEach> 	
				</c:when>
			</c:choose> 
			
			<br> <br>
			
			IZNOS VASEG RACUNA JE: ${racunKolicina.totalPrice}
			
			<br> <br>
			 
			<input type="submit" value="PLATI RACUN">
		</form:form>	
	</table>
	
	<br><br>
	
	<a href = "ponistiRacun"><button>PONISTI RACUN</button></a>
	
	
	
</body>
</html>