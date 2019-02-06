<%@page import="beans.SessioneDiGioco"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>La tua sessione</title>
<jsp:include page="head.jsp"></jsp:include>
<script src="../js/vistaModeratore.js"></script>
</head>
<body>
	<jsp:include page="navigationbar.jsp"></jsp:include>
	<%@page import="beans.User"%>
	<%@page import="beans.SessioneDiGioco"%>
	<%@page import="beans.Keyword"%>
	<%@page import="java.util.Collection"%>
	<%
			if ((session.getAttribute("user") == null)||session.getAttribute("sessione")==null) {
				response.sendRedirect("error/error.jsp");
			}
			
	%>


	<nav>
		<ul class="nav nav-tabs flex-column float-right mt-5">
			<li class="nav-item active"><button
					class="btn btn-dark my-5 ml-2" style="transform: rotate(90deg)"
					id="sessionebutton">Sessione</button></li>
			<li class="nav-item"><button class="btn btn-dark my-5"
					style="transform: rotate(90deg)" id="mazzibutton">Mazzi</button></li>
			<li class="nav-item"><button class="btn btn-dark my-5"
					style="transform: rotate(90deg)" id="guidabutton">Guida</button></li>
		</ul>
	</nav>

	<div class="container card position-absolute" id="sessione">
		<div class="row">
			<div class="col-8 card">
				<h4>Sessione</h4>
				<p>
					<% 
				SessioneDiGioco sdg= (SessioneDiGioco) session.getAttribute("sessione");

				out.print(sdg.getContenutoSessione()); %>
				</p>
			</div>
			<div class="col-4 card">
				<h4>Keyword</h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
					do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
					enim ad minim veniam, quis nostrud exercitation ullamco laboris
					nisi ut aliquip ex ea commodo consequat.</p>
			</div>
		</div>
	</div>
	<br>

	<div class="container card position-absolute ml-3" id="mazzi">
		<div class="row">
			<div class="col-6">
				<h3>ARCANI MAGGIORI</h3>
				<div class="row">
					<img src="../images/cardBack.png" id="mazzoMaj"
						class="img-responsive mx-3"> <img
						src="../images/cardBack.png" id="tMaj" class="img-responsive">
				</div>
				<div class="row">
					<button class="btn btn-dark my-2 mx-5"
						style="background-color: #212529; border-color: red;" id="dealMaj">Estrai</button>
					<br>
					<button class="btn btn-dark"
						style="background-color: #212529; border-color: red;"
						id="shuffMaj">Mischia</button>
				</div>
				<div class="row">
					<p>Hai estratto:</p>
					<p id="taroccoEstratto"></p>
					<p id="desc"></p>
				</div>
			</div>
			<div class="col-6">
				<h3>ARCANI MINORI</h3>
				<div class="row">
					<img src="../images/cardBack.png" id="mazzoMin"
						class="img-responsive mx-3"> <img
						src="../images/cardBack.png" id="tMin" class="img-responsive">
				</div>
				<div class="row">
					<button class="btn btn-dark my-2 mx-5"
						style="background-color: #212529; border-color: red;" id="dealMin">Estrai</button>
					<br>
					<button class="btn btn-dark"
						style="background-color: #212529; border-color: red;"
						id="shuffleMin">Mischia</button>
					<br>
					<p>Hai estratto:</p>
					<p id="pokerEstratta"></p>
				</div>


			</div>
		</div>

	</div>
	<div class="container card position-absolute" id="guida">

		<div class="row">

			<jsp:include page="guida.jsp"></jsp:include>

		</div>
	</div>
</body>
</html>