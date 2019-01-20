<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="head.jsp"></jsp:include>
<%@page import="beans.Personaggio"%>
<%@page import="manager.PersonaggioManager"%>
<title>Riepilogo</title>

</head>
<body>

	<jsp:include page="navigationbar.jsp"></jsp:include>

	<%
		Personaggio pg = new Personaggio();
		if (session.getAttribute("username") == null // ||session.getAttribute("storia") == null
		) {
			response.sendRedirect("error.jsp");
		} else {
			PersonaggioManager pgm = new PersonaggioManager();
			//pg= pgm.getPersonaggioByStory(session.getAttribute("storia"), session.getAttribute("username"));
		}
	%>
	<div class="container">
		<div class="row">
			<div class="col-10">
				<table class="table table-dark">
					<tbody>
						<tr>
							<th><label>Nome</label></th>
							<th><label>Cognome</label></th>
							<th><label>Nazionalità</label></th>
							<th><label>Età</label></th>
						</tr>
						<tr>
							<td><label><%=pg.getNome()%></label></td>
							<td><label><%=pg.getCognome()%></label></td>
							<td><label><%=pg.getNazionalita()%></label></td>
							<td><label><%=pg.getAge()%></label></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

		<div class="row">
			<div class="col-10">
				<table class="table table-dark">
					<tbody>
						<tr>

							<th><label>CUORI</label></th>
							<th><label>QUADRI</label></th>
							<th><label>FIORI</label></th>
							<th><label>PICCHE</label></th>

						</tr>
						<tr>
							<td><label>Intuito:<%=pg.getIntuito()%></label></td>

							<td><label>Aspetto:<%=pg.getAspetto()%>
							</label></td>

							<td><label>Coordinazione: <%=pg.getCoordinazione()%></label></td>

							<td><label>Affinità occulta: <%=pg.getAffinOcculta()%></label></td>

						</tr>
						<tr>
							<td><label>Memoria: <%=pg.getMemoria()%></label></td>

							<td><label>Comando: <%=pg.getComando()%></label></td>

							<td><label>Destrezza manuale: <%=pg.getDestrManuale()%></label></td>

							<td><label>Distanza dalla morte: <%=pg.getDistDaMorte()%></label></td>
						<tr>
							<td><label>Percezione: <%=pg.getPercezione()%></label></td>

							<td><label>Creatività: <%=pg.getCreativita()%></label></td>

							<td><label>Forza fisica: <%=pg.getForzaFisica()%></label></td>

							<td><label>Equilibrio mentale: <%=pg.getEquilibrMentale()%></label></td>

						</tr>
						<tr>
							<td><label>Volontà: <%=pg.getVolonta()%></label></td>

							<td><label>Socievolezza: <%=pg.getSocievolezza()%></label></td>

							<td><label>Mira: <%=pg.getMira()%></label></td>

							<td><label>Karma: <%=pg.getKarma()%></label></td>

						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-10">
				<table class="table table-dark">
					<tbody>
						<tr>

							<th><label>ABILITÀ</label></th>
							<th><label>CARATTERISTICA</label></th>
							<th><label>PUNTI ABILITÀ</label></th>
							<th><label>TOTTALE</label></th>

						</tr>
						<tr>
							<td><label>abi</label></td>

							<td><label>car</label></td>

							<td><label>pa</label></td>

							<td><label>tot</label></td>
						</tr>
						<tr>
							<td><label>abi</label></td>

							<td><label>car</label></td>

							<td><label>pa</label></td>

							<td><label>tot</label></td>
						</tr>
						<tr>
							<td><label>abi</label></td>

							<td><label>car</label></td>

							<td><label>pa</label></td>

							<td><label>tot</label></td>
						</tr>
						<tr>
							<td><label>abi</label></td>

							<td><label>car</label></td>

							<td><label>pa</label></td>

							<td><label>tot</label></td>
						</tr>
						<tr>
							<td><label>abi</label></td>

							<td><label>car</label></td>

							<td><label>pa</label></td>

							<td><label>tot</label></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-2">
				<h3 class="card-title">
					Per tornare alla tua pagina personale, clicca <a
						href="homeUser.jsp">qui.</a>
				</h3>

			</div>
		</div>
	</div>

</body>
</html>