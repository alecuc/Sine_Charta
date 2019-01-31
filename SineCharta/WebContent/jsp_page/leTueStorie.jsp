<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
<title>Le tue storie</title>
</head>
<body>
	<jsp:include page="navigationbar.jsp"></jsp:include>

		<%@page import="beans.User"%>
	<%User usr= (User)session.getAttribute("user");
	if(usr.getRuolo().equalsIgnoreCase("utenteModeratore")){
	%>
	
	<div class="container">
		<div class="row">
			<div class="col-5 card">
				<jsp:include page="leTueStorieComponent.jsp"></jsp:include>
			</div>
		</div>
	</div>

<%} else{ %>


<%} %>

	<div class="container">
		<div class="row">
			<h2 class="card-title">Siamo spiacenti, la modalità di promozione da Giocatore a Moderatore non è ancora stata implementata.</h2>
			
		</div>
	</div>
</body>
</html>