<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Il tuo personaggio</title>
<jsp:include page="head.jsp"></jsp:include>
<script src="../js/vistaGiocatore.js"></script>
</head>
<body>
	<jsp:include page="navigationbar.jsp"></jsp:include>
	<%@page import="beans.User"%>
	<%@page import="beans.Personaggio"%>
	<%@page import="beans.Abilita"%>
	<%@page import="java.util.Collection"%>
	<%
		Personaggio pg = new Personaggio();
		/*	if ((session.getAttribute("user") == null)||session.getAttribute("personaggio")==null) {
				response.sendRedirect("error/error.jsp");
			}
			else{
				pg= (Personaggio)session.getAttribute("personaggio");	
			}//*/
	%>

	<nav>
		<ul class="nav nav-tabs flex-column float-right mt-5">
			<li class="nav-item active"><button
					class="btn btn-dark my-5 ml-2" style="transform: rotate(90deg)"
					id="pgbutton">PG</button></li>
			<li class="nav-item"><button class="btn btn-dark my-5"
					style="transform: rotate(90deg)" id="mazzibutton">Mazzi</button></li>
			<li class="nav-item"><button class="btn btn-dark my-5"
					style="transform: rotate(90deg)" id="guidabutton">Guida</button></li>
		</ul>
	</nav>



	<div>
		<div class="container card position-absolute" id="pg">
			<br>
			<h2 class="card-title text-center">IL TUO PERSONAGGIO</h2>
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
								<td class="border-left"><label>Distanza dalla
										morte:</label></td>
								<td><%=pg.getDistDaMorte()%></td>
							<tr>
								<td><label>Percezione: </label></td>
								<td><%=pg.getPercezione()%></td>
								<td class="border-left"><label>Creatività:</label></td>
								<td><%=pg.getCreativita()%></td>
								<td class="border-left"><label>Forza fisica: </label></td>
								<td><%=pg.getForzaFisica()%></td>
								<td class="border-left"><label>Equilibrio mentale:
								</label></td>
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
			<div class="row">
				<div class="col-12">

					<br>
					<h4 class=" card-title">LE TUE ABILITÀ</h4>
					<table class="table table-dark">
						<tbody>
							<tr>
								<%
									/*
															User utente= (User)session.getAttribute("user");
									
															Collection <Abilita> abList;
															
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
																	out.print("<td>" +ab.getNome()+ "</td>");
																	out.print("<td>" + ab.getValore() + "</td>");
																	out.print("<td>" + "</td>");
																	out.print("</tr>");
									
																}// */
								%>
							
						</tbody>
					</table>
				</div>
			</div>
		</div>


		<div class="container card position-absolute" id="mazzi"
			style="z-index: auto">
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
							style="background-color: #212529; border-color: red;"
							id="dealMaj">Estrai</button>
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
							style="background-color: #212529; border-color: red;"
							id="dealMin">Estrai</button>
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
		<div class="container card position-absolute" id="guida"
			style="z-index: -2">

			<div class="row">

				<div class="col-6 card">
					<h4>Nome tarocco 1</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>
				<div class="col-6 card">
					<h4>Nome tarocco 2</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>

			</div>
			<div class="row">

				<div class="col-6 card">
					<h4>Nome tarocco 3</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>
				<div class="col-6 card">
					<h4>Nome tarocco 4</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>

			</div>
			<div class="row">

				<div class="col-6 card">
					<h4>Nome tarocco 5</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>
				<div class="col-6 card">
					<h4>Nome tarocco 6</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>

			</div>
			<div class="row">

				<div class="col-6 card">
					<h4>Nome tarocco 7</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>
				<div class="col-6 card">
					<h4>Nome tarocco 8</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>

			</div>
			<div class="row">

				<div class="col-6 card">
					<h4>Nome tarocco 9</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>
				<div class="col-6 card">
					<h4>Nome tarocco 10</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>

			</div>
			<div class="row">

				<div class="col-6 card">
					<h4>Nome tarocco 11</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>
				<div class="col-6 card">
					<h4>Nome tarocco 12</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>

			</div>

			<div class="row">

				<div class="col-6 card">
					<h4>Nome tarocco 13</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>
				<div class="col-6 card">
					<h4>Nome tarocco 14</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>

			</div>


			<div class="row">

				<div class="col-6 card">
					<h4>Nome tarocco 15</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>
				<div class="col-6 card">
					<h4>Nome tarocco 16</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>

			</div>

			<div class="row">

				<div class="col-6 card">
					<h4>Nome tarocco 17</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>
				<div class="col-6 card">
					<h4>Nome tarocco 18</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>

			</div>

			<div class="row">

				<div class="col-6 card">
					<h4>Nome tarocco 19</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>
				<div class="col-6 card">
					<h4>Nome tarocco 20</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>

			</div>

			<div class="row">

				<div class="col-6 card">
					<h4>Nome tarocco 21</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>
				<div class="col-6 card">
					<h4>Nome tarocco 0</h4>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed
						do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut
						enim ad minim veniam, quis nostrud exercitation ullamco laboris
						nisi ut aliquip ex ea commodo consequat.</p>
				</div>

			</div>
		</div>

	</div>
</body>
</html>