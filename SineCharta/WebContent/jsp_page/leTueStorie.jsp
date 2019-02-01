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

			<div class="col-5 card">

				<%
							User utente = (User) session.getAttribute("user");
							Collection<Storia> stList = (Collection<Storia>) session.getAttribute("storieModeratore");

							if(stList!=null){
							
							if (!stList.isEmpty()) {
								for (Storia st : stList) {
									
									Set<SessioneDiGioco> listaSessioni= st.getListaSessioni();
											
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
									
										for(SessioneDiGioco sdg: listaSessioni){
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
								out.print("<a href=\"editorStoria.jsp\">qui</a>");
								out.print("<h3> per iniziare.</h3>");
							}
							
							} else{%>
							
							<h2>SIAMO SPIACENTI, MA LA FUNZIONE PER DIVENTARE MODERATORI NON È PRESENTE.</h2>
							
								
						<%	}	%>

			</div>



			<div class="col-7 card"></div>
		</div>
	</div>
</body>
</html>