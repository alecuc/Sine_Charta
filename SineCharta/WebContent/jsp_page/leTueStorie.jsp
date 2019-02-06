<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
<script src="../js/leTueStorieScript.js"></script>
<title>Le tue storie</title>
</head>
<body>
	<jsp:include page="navigationbar.jsp"></jsp:include>
	<%@page import="beans.User"%>
	<%@page import="beans.Storia"%>
	<%@page import="beans.SessioneDiGioco"%>
	<%@page import="java.util.Set"%>
	<%@page import="java.util.Collection"%>

	<div class="container">
<br>
		<div class="row">

			<div class="col-5 card">
			<jsp:include page="leTueStorieComponent.jsp"></jsp:include>
			</div>



			<div class="col-7 card">
				<div class="row"><h4 id="desc"></h4></div>
			</div>
		</div>
	</div>
</body>
</html>