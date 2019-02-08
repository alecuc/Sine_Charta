<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../../css/bootstrap.min.css">

<meta charset="UTF-8">
<title>Errore!</title>
	<%@page import="javax.servlet.http.HttpSession" %>
	<%if (session.getAttribute("user")==null){  %>
        <meta http-equiv="refresh" content="5; url=../index.jsp" />
        <link rel="stylesheet" href="../css/bootstrap.min.css">
    <%}else{ %> 
    	<meta http-equiv="refresh" content="5; url=../homeUser.jsp" />
        <link rel="stylesheet" href="../css/bootstrap.min.css">
    <%} %>   
</head>
<body>
<div class="container bg-cont">
    <br>
    <br>
    <br>
	<h3 class="card-title">
          E CHE FAI? MI VUOI ROMPERE IL SITO?
        </h3>
        <%if (session.getAttribute("user")==null){  %>
        <h3 class="card-title">
          Clicca <a href="../index.jsp">qui</a> se non vuoi attendere oltre e non ti permettere più. 
        </h3>
        <%}else{ %>
        	<h3 class="card-title">
          Clicca <a href="../homeUser.jsp">qui</a> se non vuoi attendere oltre e non ti permettere più. 
        </h3>
        
        <%} %>
</div>
</body>
</html>