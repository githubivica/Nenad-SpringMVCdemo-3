<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="springmvc.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user page</title>
</head>
<body>
	<jsp:useBean id="userIzBaze" scope="session" class="springmvc.model.User">
	</jsp:useBean>
	<h1>DOBRODOŠLI</h1>
	<p>Vaš user name: ${userIzBaze.userName}</p>
	<p> BALANCE : ${userIzBaze.balance}</p>
	
	<a href="../admin/logout">LOG OUT</a> 
	
	<br><br>
	
	<a href="naruciArtikal"><button>NARUČI PIĆE I HRANU</button></a> 
	
	<br><br>
	
	

	
	
	
	
</body>
</html>