<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="head.jsp"></jsp:include>
<title>Riepilogo</title>
</head>
<body>

	<jsp:include page="navigationbar.jsp"></jsp:include>

	<%
		if (session.getAttribute("username") == null) {
			response.sendRedirect("error.jsp");
		}
	%>
	<div class="container">

		<table class="table table-dark">
			<tbody>
				<tr>
					<td><label>Intuito: </label></td>
					<td><label>XX</label></td>
					<td><label>Memoria: </label></td>
					<td><label>XX</label></td>
					<td><label>Percezione: </label></td>
					<td><label>XX</label></td>
					<td><label>Volontà:</label></td>
					<td><label>XX</label></td>
				</tr>
				<tr>
					<td><label>Aspetto:</label></td>
					<td><label>XX</label></td>
					<td><label>Comando:</label></td>
					<td><label>XX</label></td>
					<td><label>Creatività:</label></td>
					<td><label>XX</label></td>
					<td><label>Socievolezza: </label></td>
					<td><label>XX</label></td>
				</tr>
				<tr>
					<td><label>Coordinazione:</label></td>
					<td><label>XX</label></td>
					<td><label>Destrezza manuale:</label></td>
					<td><label>XX</label></td>
					<td><label>Forza fisica:</label></td>
					<td><label>XX</label></td>
					<td><label>Mira: </label></td>
					<td><label>XX</label></td>
				</tr>
				<tr>
					<td><label>Affinità occulta:</label></td>
					<td><label>XX</label></td>
					<td><label>Dist. dalla morte:</label></td>
					<td><label>XX</label></td>
					<td><label>Equilibrio mentale:</label></td>
					<td><label>XX</label></td>
					<td><label>Karma: </label></td>
					<td><label>XX</label></td>
				</tr>
			</tbody>
		</table>

		<h3 class="card-title">Per tornare alla tua pagina personale,
			clicca</h3>
		<a href="homeUser.jsp">qui.</a>

	</div>

</body>
</html>