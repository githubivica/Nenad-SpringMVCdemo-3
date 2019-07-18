<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="springmvc.model.Pice" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>vasa hrana</title>
</head>
<body>

	<br>
	
	<a href = "naruciArtikal"><button>NE ZELIM DA NARUCIM</button></a>
	
	<br><br>
	
	<h2>NARUCI </h2>
	
	<form:form modelAttribute="hranaZaNarucivanje" action = "dodajHranuNaRacun" method="post">
		
		IME: ${hranaZaNarucivanje.imeArtikla} <br>
		CENA: ${hranaZaNarucivanje.cena} <br><br>
		<form:hidden path="idArtikla"/>
		<form:hidden path="imeArtikla"/>
		<form:hidden path="cena"/>
		<form:hidden path="stanje"/>
		<form:hidden path="popust"/>
		<form:hidden path="masa"/>
		KOLICINA:
		<select name="kolicina">
			<c:forEach var = "i" begin="1" end="${hranaZaNarucivanje.stanje}">
				<option value="${i}" label = "${i}"/>
			</c:forEach>
		</select> 
		
		<br>
		<input type = "submit" value="DODAJ NA RACUN">
	</form:form>


</body>
</html>