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



	<div class="jumbotron text-center"
		style="margin-bottom: auto; background-color: white;">
		<img alt="logo" src="../images/logo_principal.png"
			style="width: 15rem;">
	</div>

	<jsp:include page="navigationbar.jsp"></jsp:include>

	<div class="container" style="margin-top: 30px">
		<div class="row">
			<div class="col-sm-4">
				<%
					if (session.getAttribute("user") == null) {
						response.sendRedirect("error/error.jsp");
					} else {
						User utente = (User) session.getAttribute("user");
				%>
				<h2><%=utente.getUsername()%></h2>

				<%
					}
				%>


				<h5>Photo of me:</h5>
				<div class="fakeimg">
					<img src="../images/mini_logo.jpg" style="width: 50%;">
				</div>
				<p>Informazioni giocatore.</p>
				<h3>Some Links</h3>
				<p>Lorem ipsum dolor sit ame...</p>
				<ul class="nav nav-pills flex-column">
					<li class="nav-item"><a class="nav-link active" href="#">Informazioni</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Modifica
							credenziali</a></li>
					<li class="nav-item"><a class="nav-link"
						href="creazionePG.jsp">Crea pg (provvisorio)</a></li>
					<li class="nav-item"><a class="nav-link disabled" href="#">Disabled</a>
					</li>
				</ul>
				<hr class="d-sm-none">
			</div>
			<div class="col-8">

				<!-- TABELLA DELLE STORIE ATTIVE
		QUESTA TABELLA È FORMATA DA:
		
		NOME_STORIA - NOME_PG - 	PULSANTE_GIOCA
		il nome		- il nome -	   il pulsante che
		della storia- del pg  - carica la pagina del pg	 -->

				<%
					User utente = (User) session.getAttribute("user");
					Collection<Storia> stList = (Collection) session.getAttribute("storieGiocatore");
					Set<Personaggio> pgList = utente.getPersonaggiUtente();

					if (!stList.isEmpty()) {
						ArrayList <Storia> stNoPG = new ArrayList<Storia>();


						out.print("<div class=\"row\">");
						out.print("<table class=\"table table-responsive table-dark\" id=\"tabellaStorie\">");
						out.print("<thead>");
						out.print("<tr>");
						out.print("<th scope=\"col\">Nome Storia</th>");
						out.print("<th scope=\"col\">Nome PG</th>");
						out.print("<th scope=\"col\"></th>");
						out.print("</tr>");
						out.print("</thead>");
						out.print("<tbody>");

						for (Storia st : stList) {

							boolean pgFound = false;
							for (Personaggio pg : pgList) {

								if (pg.getIdStoria() == st.getId()) {

									out.print("<tr>");
									out.print("<form method=\"post\" action=\"../GestioneSessioneServlet?action=gioca&idStoria="+st.getId()+"\">");
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
								if(!pgFound) {
									stNoPG.add(st);
								}
						}
						out.print("</tbody>");
						out.print("</table>");
						out.print("</div>");
						/*CHIUDI TABELLA "GIOCA"*/

						System.out.println("Qui le storie a cui partecipi, senza pg");
						for (Storia st : stNoPG) {
							System.out.println(st.toString());
						}

						if (!stNoPG.isEmpty()) {
							//APRI TABELLA "CREA"
							out.print("<div class=\"row\">");
							out.print("<table class=\"table table-responsive table-dark\" id=\"tabellaNoPG\">");
							out.print("<thead>");
							out.print("<tr>");
							out.print("<th>Nome Storia</th>");
							out.print("<th>.</th>");
							out.print("</tr>");
							out.print("</thead>");
							out.print("<tbody>");

							for (Storia st : stNoPG) {
								out.print("<tr>");
								out.print("<form method=\"post\" action=\"../GestioneStoriaServlet?action=creaPG&idStoria="+st.getId()+"\">");
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
					}
				%>


			</div>
		</div>
	</div>

</body>
</html>
