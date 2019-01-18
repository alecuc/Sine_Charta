<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<title>Crea personaggio</title>

<script>
// Warning before leaving the page (back button, or outgoinglink)
window.onbeforeunload = function() {
   return "ATTENZIONE: Se ricarichi o abbandoni la pagina perderai TUTTI i progressi della creazione del tuo PG!!";
};
</script>

</head>
<body>
<%
		if (session.getAttribute("username") == null) {
			response.sendRedirect("error.jsp");
		}
	%>
	<h1 class="card-title">Crea il tuo personaggio</h1>

	<!-- TASTI ANNULLA E AIUTO -->

	<div class="position-fixed">
	<form action="homeUser.jsp">
		<button class="btn btn-dark mb-2 mx-1"
			style="background-color: #212529; border-color: red;">Annulla</button>
	</form>
		<br>
		<button class="btn btn-dark mx-2"
			style="background-color: #212529; border-color: red;">Aiuto</button>
	</div>

	<!-- FORM GENERALITÀ -->

	<div class="container card p-2" id="generalità">
		<form name="generalità">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label>Nome</label> <input type="text" class="form-control"
						id="nomePG" placeholder="Nome:">
				</div>
				<div class="form-group col-md-6">
					<label>Cognome</label> <input type="text" class="form-control"
						id="cognomePG" placeholder="Cognome:">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<br> <label>Nazionalità</label> <input type="text"
						class="form-control" id="nazionalitaPG" placeholder="Nazionalità:">
				</div>

				<div class="form-group col-md-6">
					<br> <label>Età</label> <input type="text"
						class="form-control" id="etaPG" placeholder="Età:">
				</div>
			</div>
			<input type="radio" name="sesso" value="uomo"> Uomo<br>
			<input type="radio" name="sesso" value="donna"> Donna<br>
			<button class="btn btn-dark"
				style="background-color: #212529; border-color: red;">Conferma</button>
		</form>
	</div>

	<br>
	<br>
	<br>

	<!-- ESTRAZIONE TAROCCO DOMINANTE -->

	<div class="container card p-2" id="taroccoDominante">
		<div class="row">

			<div class="col-8">

				<img src="../images/cardPlaceholder.png" id="mazzo" class="col-4">
				<img src="../images/cardPlaceholder.png" id="mazzo" class="col-4">

			</div>


			<div class="col-3">
				<br> <br> At vero eos et accusamus et iusto odio
				dignissimos ducimus qui blanditiis praesentium voluptatum deleniti
				atque corrupti quos dolores et quas molestias excepturi sint
				occaecati cupiditate non provident, similique sunt in culpa qui
				officia deserunt mollitia animi, id est laborum et dolorum fuga.
			</div>
		</div>
	</div>


	<br>
	<br>
	<br>

	<!-- ESTRAZIONE CARATTERISTICHE -->

	<div class="container card p-2" id="caratteristiche">
		<div class="row">
			<br> <br> <br>
			<div class="col-3">
				<img src="../images/cardPlaceholder.png" id="tarCuori" class="mb-2"><br>
				<label>Valore cuori: </label><label id="valCuori">X</label><br>
				<button class="btn btn-dark mb-2"
					style="background-color: #212529; border-color: red;">Estrai
					nuova</button>
				<br>
				<button class="btn btn-dark"
					style="background-color: #212529; border-color: red;">Conferma</button>
			</div>
			<div class="col-3">
				<img src="../images/cardPlaceholder.png" id="tarQuadri" class="mb-2"><br>
				<label>Valore quadri: </label><label id="valQuadri">X</label><br>
				<button class="btn btn-dark mb-2"
					style="background-color: #212529; border-color: red;">Estrai
					nuova</button>
				<br>
				<button class="btn btn-dark"
					style="background-color: #212529; border-color: red;">Conferma</button>

			</div>
			<div class="col-3">
				<img src="../images/cardPlaceholder.png" id="tarFiori" class="mb-2"><br>
				<label>Valore fiori: </label><label id="valFiori">X</label><br>
				<button class="btn btn-dark mb-2"
					style="background-color: #212529; border-color: red;">Estrai
					nuova</button>
				<br>
				<button class="btn btn-dark"
					style="background-color: #212529; border-color: red;">Conferma</button>

			</div>
			<div class="col-3">
				<img src="../images/cardPlaceholder.png" id="tarPicche" class="mb-2"><br>
				<label>Valore picche: </label><label id="valPicche">X</label><br>
				<button class="btn btn-dark mb-2"
					style="background-color: #212529; border-color: red;">Estrai
					nuova</button>
				<br>
				<button class="btn btn-dark"
					style="background-color: #212529; border-color: red;">Conferma</button>

			</div>
		</div>
	</div>



	<br>
	<br>
	<br>

	<!-- TABELLA SELEZIONE CARATTERISTICHE -->

	<div class="container">
		<div class="row">
			<table class="table table-dark">
				<tbody>
					<tr>
						<td><label>Intuito: </label></td>
						<td><input type="number" name="quantity" min="1" max="6"></td>

						<td><label>Memoria: </label></td>
						<td><input type="number" name="quantity" min="1" max="6"></td>
						<td><label>Percezione: </label></td>
						<td><input type="number" name="quantity" min="1" max="6"></td>
						<td><label>Volontà:</label></td>
						<td><input type="number" name="quantity" min="1" max="6"></td>
						<td><label>Punti rimasti:</label><label id="quadriRimasti">x</label></td>
					</tr>
					<tr>
						<td><label>Aspetto:</label></td>
						<td><input type="number" name="quantity" min="1" max="6"></td>
						<td><label>Comando:</label></td>
						<td><input type="number" name="quantity" min="1" max="6"></td>
						<td><label>Creatività:</label></td>
						<td><input type="number" name="quantity" min="1" max="6"></td>
						<td><label>Socievolezza: </label></td>
						<td><input type="number" name="quantity" min="1" max="6"></td>
						<td><label>Punti rimasti: </label><label id="quadriRimasti">x</label></td>
					</tr>
					<tr>
						<td><label>Coordinazione:</label></td>
						<td><input type="number" name="quantity" min="1" max="6"></td>
						<td><label>Destrezza manuale:</label></td>
						<td><input type="number" name="quantity" min="1" max="6"></td>
						<td><label>Forza fisicca:</label></td>
						<td><input type="number" name="quantity" min="1" max="6"></td>
						<td><label>Mira: </label></td>
						<td><input type="number" name="quantity" min="1" max="6"></td>
						<td><label>Punti rimasti: </label><label id="quadriRimasti">x</label></td>
					</tr>
					<tr>
						<td><label>Affinità occulta:</label></td>
						<td><input type="number" name="quantity" min="1" max="6"></td>
						<td><label>Dist. dalla morte:</label></td>
						<td><input type="number" name="quantity" min="1" max="6"></td>
						<td><label>Equilibrio mentale:</label></td>
						<td><input type="number" name="quantity" min="1" max="6"></td>
						<td><label>Karma: </label></td>
						<td><input type="number" name="quantity" min="1" max="6"></td>
						<td><label>Punti rimasti: </label><label id="quadriRimasti">x</label></td>
					</tr>
				</tbody>
			</table>
			<button class="btn btn-dark"
				style="background-color: #212529; border-color: red;">Conferma</button>
		</div>
	</div>
	<br>
	<br>
	<br>

	<!-- 
		<div class="container">
			<div class="row">

				<table class="table table-dark">
					<tbody>
						<tr>
							<th>Nome abilità</th>
							<th>Grado abilità</th>
							<th>Caratteristica</th>
							<th>Totale</th>
						</tr>
						<tr>
							<td><select class="form-control" id="sel1">
									<option>Abilità 1</option>
									<option>Abilità 2</option>
									<option>Abilità 3</option>
									<option>Abilità 4</option>
									<option>Abilità 5</option>
									<option>Abilità 6</option>
									<option>Abilità 7</option>
									<option>Abilità 8</option>
									<option>Abilità 9</option>
									<option>Abilità 10</option>
							</select></td>
							<td><input type="number" name="quantity" min="1" max="6"></td>
							<td><label>Car+xx</label></td>
							<td><label>XX</label></td>
						</tr>
						<tr>
							<td><select class="form-control" id="sel1">
									<option>Abilità 1</option>
									<option>Abilità 2</option>
									<option>Abilità 3</option>
									<option>Abilità 4</option>
									<option>Abilità 5</option>
									<option>Abilità 6</option>
									<option>Abilità 7</option>
									<option>Abilità 8</option>
									<option>Abilità 9</option>
									<option>Abilità 10</option>
							</select></td>
							<td><input type="number" name="quantity" min="1" max="6"></td>
							<td><label>Car+xx</label></td>
							<td><label>XX</label></td>
						</tr>
						<tr>
							<td><select class="form-control" id="sel1">
									<option>Abilità 1</option>
									<option>Abilità 2</option>
									<option>Abilità 3</option>
									<option>Abilità 4</option>
									<option>Abilità 5</option>
									<option>Abilità 6</option>
									<option>Abilità 7</option>
									<option>Abilità 8</option>
									<option>Abilità 9</option>
									<option>Abilità 10</option>
							</select></td>
							<td><input type="number" name="quantity" min="1" max="6"></td>
							<td><label>Car+xx</label></td>
							<td><label>XX</label></td>
						</tr>
						<tr>
							<td><select class="form-control" id="sel1">
									<option>Abilità 1</option>
									<option>Abilità 2</option>
									<option>Abilità 3</option>
									<option>Abilità 4</option>
									<option>Abilità 5</option>
									<option>Abilità 6</option>
									<option>Abilità 7</option>
									<option>Abilità 8</option>
									<option>Abilità 9</option>
									<option>Abilità 10</option>
							</select></td>
							<td><input type="number" name="quantity" min="1" max="6"></td>
							<td><label>Car+xx</label></td>
							<td><label>XX</label></td>
						</tr>
					</tbody>
				</table>

				<button class="btn btn-dark">Conferma</button>


			</div>
		</div>
		<br> <br> <br>
 -->
</body>
</html>