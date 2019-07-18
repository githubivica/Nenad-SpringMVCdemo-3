<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="springmvc.model.Artikal" %>
<%@ page import="springmvc.model.Pice" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>dodaj hranu</title>
</head>
<body>
	
	<a href = "hrana-list">back</a>

	<form:form modelAttribute="hrana" action="dodajHranuUBazu" method="get">
		Ime: 		<form:input path="imeArtikla"/><br><br>
		Cena: 		<form:input path="cena"/><br><br>
		Stanje: 	<form:input path="stanje"/><br><br>
		Popust: 	<form:input path="popust"/><br><br>
		Masa:  		<form:input path="masa"/><br><br>
		
		<br><br>
		
		<input type="submit" value="DODAJ">
	</form:form>

</body>
</html>