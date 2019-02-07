<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="head.jsp"></jsp:include>
<%@page import="manager.AbilitaManager"%>
<%@page import="beans.User"%>
<%@page import="beans.Personaggio"%>
<%@page import="beans.Abilita"%>
<%@page import="java.util.Collection"%>
<title>Riepilogo</title>

</head>
<body>

	<jsp:include page="navigationbar.jsp"></jsp:include>

	<%
		Personaggio pg = new Personaggio();
		if ((session.getAttribute("user") == null) || session.getAttribute("nuovoPG") == null) {
			response.sendRedirect("error/error.jsp");
		} else {
			pg = (Personaggio) session.getAttribute("nuovoPG");
		}
	%>
	<div class="container">
		<br>
		<h2 class="card-title text-center">IL TUO PERSONAGGIO È COMPLETO!
			ECCO IL RIEPILOGO</h2>
		<br>
		<div class="row">
			<div class="col-12">
				<br>
				<h4 class=" card-title">LE TUE GENERALITÀ</h4>
				<table class="table table-dark">
					<tbody>
						<tr>
							<th><label>Nome</label></th>
							<th><label>Cognome</label></th>
							<th><label>Nazionalità</label></th>
							<th><label>Età</label></th>
							<th><label>Tarocco dominante</label></th>
						</tr>
						<tr>
							<td><label><%=pg.getNome()%></label></td>
							<td><label><%=pg.getCognome()%></label></td>
							<td><label><%=pg.getNazionalita()%></label></td>
							<td><label><%=pg.getAge()%></label></td>
							<td><label><%=pg.getTaroccoDominante()%></label></td>

						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<div class="row">
			<div class="col-12">
				<br>
				<h4 class=" card-title">LE TUE CARATTERISTICHE</h4>
				<table class="table table-dark">
					<tbody>
						<tr>

							<th><label>CUORI</label></th>
							<th></th>
							<th class="border-left"><label>QUADRI</label></th>
							<th></th>
							<th class="border-left"><label>FIORI</label></th>
							<th></th>
							<th class="border-left"><label>PICCHE</label></th>
							<th></th>

						</tr>
						<tr>
							<td><label>Intuito:</label></td>
							<td><%=pg.getIntuito()%></td>
							<td class="border-left"><label>Aspetto:</label></td>
							<td><%=pg.getAspetto()%></td>
							<td class="border-left"><label>Coordinazione:</label></td>
							<td><%=pg.getCoordinazione()%></td>
							<td class="border-left"><label>Affinità occulta:</label></td>
							<td><%=pg.getAffinOcculta()%></td>
						</tr>
						<tr>
							<td><label>Memoria:</label></td>
							<td><%=pg.getMemoria()%></td>
							<td class="border-left"><label>Comando:</label></td>
							<td><%=pg.getComando()%></td>
							<td class="border-left"><label>Destrezza manuale:</label></td>
							<td><%=pg.getDestrManuale()%></td>
							<td class="border-left"><label>Distanza dalla morte:</label></td>
							<td><%=pg.getDistDaMorte()%></td>
						<tr>
							<td><label>Percezione: </label></td>
							<td><%=pg.getPercezione()%></td>
							<td class="border-left"><label>Creatività:</label></td>
							<td><%=pg.getCreativita()%></td>
							<td class="border-left"><label>Forza fisica: </label></td>
							<td><%=pg.getForzaFisica()%></td>
							<td class="border-left"><label>Equilibrio mentale: </label></td>
							<td><%=pg.getEquilibrMentale()%></td>
						</tr>
						<tr>
							<td><label>Volontà: </label></td>
							<td><%=pg.getVolonta()%></td>
							<td class="border-left"><label>Socievolezza: </label></td>
							<td><%=pg.getSocievolezza()%></td>
							<td class="border-left"><label>Mira: </label></td>
							<td><%=pg.getMira()%></td>
							<td class="border-left"><label>Karma: </label></td>
							<td><%=pg.getKarma()%></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<h4 class=" card-title">LE TUE ABILITÀ</h4>
		<div class="row">
			<div class="col-12">
				<table class="table table-dark">
						<tbody>
							<tr>
								<%
									Collection<Abilita> abList = pg.getListaAbilita();

									out.print("<div class=\"table-responsive\">");

									out.print("<table class=\"table table-dark\" id=\"tabellaAbilita\">");
									out.print("<thead>");
									out.print("<tr>");
									out.print("<th scope=\"col\">Abilità</th>");
									out.print("<th scope=\"col\">Punti abilità</th>");
									out.print("<th scope=\"col\">Totale</th>");
									out.print("</tr>");
									out.print("</thead>");
									out.print("<tbody>");

									for (Abilita ab : abList) {

										out.print("<tr>");
										out.print("<td>" + ab.getNome() + "</td>");
										out.print("<td>" + ab.getValore() + "</td>");
										out.print("<td>" + "</td>");
										out.print("</tr>");

									} // */
								%>
							
						</tbody>
					</table>
			</div>
		</div>
		<br>
			<h3 class="card-title">
				Per tornare alla tua pagina personale, clicca <a href="homeUser.jsp">qui.</a>
			</h3>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>