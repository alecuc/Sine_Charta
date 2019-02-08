<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="head.jsp"></jsp:include>
<title>Personal Page</title>

<%@page import="beans.User"%>
<%@page import="beans.Storia"%>
<%@page import="beans.Personaggio"%>

<%@page import="java.util.Set"%>
<%@page import="java.util.Collection"%>
</head>
<body>

	<jsp:include page="navigationbar.jsp"></jsp:include>

	<div class="container" style="margin-top: 30px">
		<div class="row">
			<div class="col-sm-4 card">
				<%
					if (session.getAttribute("user") == null) {
						response.sendRedirect("error/error.jsp");
					} else {
						User utente = (User) session.getAttribute("user");
				%>
				<h2 class="text-center"><%=utente.getUsername()%></h2>




				<div class="fakeimg text-center">
					<img src="../images/mini_logo.jpg" style="width: 50%;">
				</div>

				<br>

				<div class="card container-card">

					<ul class="list-group">
						<li class="list-group-item">Nome: <%=utente.getName()%></li>
						<li class="list-group-item">Cognome: <%=utente.getSurname()%>
						</li>
						<li class="list-group-item">Grado: <%=utente.getRuolo()%></li>
					</ul>

				</div>


			</div>
			<div class="col-8">



				<%
					Collection<Storia> stList = (Collection<Storia>) session.getAttribute("storieGiocatore");
						Set<Personaggio> pgList = utente.getPersonaggiUtente();

						if (!stList.isEmpty()) {
							ArrayList<Storia> stNoPG = new ArrayList<Storia>();

							out.print("<div class=\"row\">");
							out.print("<table class=\"table table-dark ml-2\" id=\"tabellaStorie\">");
							out.print("<thead>");
							out.print("<tr>");
							out.print("<th scope=\"col\">Nome Storia</th>");
							out.print("<th scope=\"col\" colspan=\"2\">Nome PG</th>");
							out.print("</tr>");
							out.print("</thead>");
							out.print("<tbody>");

							for (Storia st : stList) {

								boolean pgFound = false;
								for (Personaggio pg : pgList) {

									if (pg.getIdStoria() == st.getId()) {

										out.print("<tr>");
										out.print(
												"<form method=\"post\" action=\"../GestioneSessioneServlet?action=gioca&idStoria="
														+ st.getId() + "\">");
										out.print("<td class=\"td-prod\">" + st.getTitolo() + "</td>");
										out.print("<td class=\"td-prod\">" + pg.getNome() + " " + pg.getCognome() + "</td>");
										out.print(
												"<td><button type=\"submit\" class=\"btn btn-dark\" style=\"background-color: #212529; border-color: red;\">Gioca</button></td>");
										out.print("</form>");
										out.print("</tr>");
										pgFound = true;
										break;
									}

								}
								if (!pgFound) {
									stNoPG.add(st);
								}
							}
							out.print("</tbody>");
							out.print("</table>");
							out.print("</div>");
							/*CHIUDI TABELLA "GIOCA"*/

							if (!stNoPG.isEmpty()) {
								//APRI TABELLA "CREA"
								out.print("<div class=\"row\">");
								out.print("<table class=\"table table-responsive table-dark ml-2\" id=\"tabellaNoPG\">");
								out.print("<thead>");
								out.print("<tr>");
								out.print("<th>Nome Storia</th>");
								out.print("<th>.</th>");
								out.print("</tr>");
								out.print("</thead>");
								out.print("<tbody>");

								for (Storia st : stNoPG) {
									out.print("<tr>");
									out.print("<form method=\"post\" action=\"../GestioneStoriaServlet?action=creaPG&idStoria="
											+ st.getId() + "\">");
									out.print("<td class=\"td-prod\">" + st.getTitolo() + "</td>");
									out.print(
											"<td><button type=\"submit\" class=\"btn btn-dark\" style=\"background-color: #212529; border-color: red;\">Crea PG</button></td>");
									out.print("</form>");
									out.print("</tr>");
								}
								out.print("</tbody>");
								out.print("</table>");
								out.print("</div>");
							}
						} else {
				%>

				<div class="row">
					<h3>Non partecipi ad alcuna storia! Fatti invitare da
						qualcuno.</h3>
				</div>

				<%
					}
				%>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<%
		}
	%>
</body>
</html>
