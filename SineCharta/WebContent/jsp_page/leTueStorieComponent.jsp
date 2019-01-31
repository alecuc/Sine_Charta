	<%@page import="beans.User"%>
	<%@page import="beans.Storia"%>
	<%@page import="beans.SessioneDiGioco"%>
	<%@page import="java.util.Set"%>
	<%@page import="java.util.Collection"%>

				<%
							User utente = (User) session.getAttribute("user");
							Collection<Storia> stList = (Collection<Storia>) session.getAttribute("storieModeratore");

							if (!stList.isEmpty()) {
								for (Storia st : stList) {
									
									Set<SessioneDiGioco> listaSessioni= st.getListaSessioni();
											
									out.print("<div class=\"table-responsive col-8\">");

									out.print("<table class=\"table table-dark\" id=\"tabellaStorie\">");
									out.print("<thead>");
									out.print("<tr>");
									out.print("<th scope=\"col\">Nome Storia</th>");
									out.print("<th scope=\"col\"></th>");
									out.print("</tr>");
									out.print("</thead>");
									out.print("<tbody>");
									
										for(SessioneDiGioco sdg: listaSessioni){
											out.print("<tr>");
											out.print("<form method=\"post\" action=\"../GiocaServlet\">");
											out.print("<td class=\"td-prod\"><label>Sessione numero: " +sdg.getIdNumeroSessione() + "</label></td>");
											out.print("</form>");
											out.print("</tr>");
										}
								}
								out.print("<form method=\"post\" action=\"../EditorSessioneServlet\">");
								out.print("<td class=\"td-prod\"><button class=\"btn btn-dark\">Sessione numero: " +"Nuova sessione"+ "</button></td>");
								out.print("</form>");
								out.print("</tbody>");
								out.print("</table>");
								}
								else	{
								out.print("<h3>Non hai scritto nessuna storia. Clicca </h3>");
								out.print("<a href=\"editorStoria\">qui</a>");
								out.print("<h3> per iniziare.</h3>");
							}
						%>

	</div>