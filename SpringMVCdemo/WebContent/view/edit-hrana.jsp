<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="springmvc.model.Hrana" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit pice</title>
</head>
<body>
	<a href = "pice-list">back </a><br><br>
	
	<form:form modelAttribute="hranaIzBaze" action="uradiUpdateHrane" method="get">
						
						<form:hidden path="idArtikla"/><br>
			Ime: 		<form:input path="imeArtikla"/><br><br>
			Cena: 		<form:input path="cena"/><br><br>
			Stanje: 	<form:input path="stanje"/><br><br>
			Popust: 	<form:input path="popust"/><br><br>
			Masa:  		<form:input path="masa"/><br><br>
			
		<br><br>
		
		<input type="submit" value="UPDATE">

	</form:form>
	
	<form:form modelAttribute="hranaIzBaze" action ="deleteHrana" method = "post">
		<form:hidden path="idArtikla"/><br>
		<input type="submit" value="DELETE">
	</form:form>
	
</body>
</html>