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
	<%@page import="beans.Storia"%>
	<%@page import="beans.SessioneDiGioco"%>
	<%@page import="java.util.Set"%>
	<%@page import="java.util.Collection"%>

	<div class="container">

		<div class="row">

			<div class="col-4 card">

				<%
						/*	User utente = (User) session.getAttribute("user");
							Collection<Storia> stList = (Collection) session.getAttribute("listaStorie");

							if (!stList.isEmpty()) {
								for (Storia st : stList) {
									
									ArrayList<SessioneDiGioco> ls= st.
											
											
									out.print("<div class=\"table-responsive col-8\">");

									out.print("<table class=\"table table-dark\" id=\"tabellaStorie\">");
									out.print("<thead>");
									out.print("<tr>");
									out.print("<th scope=\"col\">Nome Storia</th>");
									out.print("<th scope=\"col\"></th>");
									out.print("<th scope=\"col\"></th>");
									out.print("</tr>");
									out.print("</thead>");
									out.print("<tbody>");
									
										for(SessioneDiGioco sdg: ){
											out.print("<tr>");
											out.print("<form method=\"post\" action=\"../GiocaServlet\">");
											out.print("<td class=\"td-prod\">" + st.getTitolo() + "</td>");
											out.print("<td class=\"td-prod\">"+"QUI NOME PG" + "</td>");
		
											out.print("<td><button type=\"submit\" class=\"btn btn-dark\" style=\"background-color: #212529; border-color: red;\">Gioca</button></td>");
											out.print("</form>");
											out.print("</tr>");
										}
								}
								out.print("</tbody>");
								out.print("</table>");
								}
								else	{
								out.print("<h3>Non hai scritto nessuna storia. Clicca </h3>");
								out.print("<a href=\"editorStoria\">qui</a>");
								out.print("<h3> per iniziare.</h3>");
							} //*/
						%>

			</div>



			<div class="col-8 card"></div>
		</div>
	</div>
</body>
</html>