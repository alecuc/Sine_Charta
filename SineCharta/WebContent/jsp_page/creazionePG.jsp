<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="head.jsp"></jsp:include>
<script src="../js/creazioneActions.js"></script>
<title>Crea personaggio</title>
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
		<form name="generalità" id="formGen">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label>Nome:</label> <input type="text" class="form-control"
						id="nomePG" placeholder="Nome" name="nome">
				</div>
				<div class="form-group col-md-6">
					<label>Cognome:</label> <input type="text" class="form-control"
						id="cognomePG" placeholder="Cognome" name="cognome">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<br> <label>Nazionalità:</label> <input type="text"
						class="form-control" id="nazionalitaPG" placeholder="Nazionalità"
						name="nazionalita">
				</div>

				<div class="form-group col-md-6">
					<br> <label>Età:</label> <input type="text"
						class="form-control" id="etaPG" placeholder="Età" name="eta">
				</div>
			</div>
			<label><input type="radio" name="sesso" value="uomo"
				id="PGuomo">Uomo</label> <label><input type="radio"
				name="sesso" value="donna" id="PGdonna"> Donna</label> <br>

		</form>
		<button class="btn btn-dark"
			style="background-color: #212529; border-color: red;" id="confGen">Conferma</button>
	</div>

	<br>
	<br>
	<br>

	<!-- ESTRAZIONE TAROCCO DOMINANTE -->

	<div class="container card p-2" id="taroccoDominante">
		<div class="row">

			<div class="col-8">

				<img src="../images/cardPlaceholder.png" id="mazzo" class="col-4">
				<img src="../images/cardPlaceholder.png" id="estratta" class="col-4">

			</div>


			<div class="col-3 container-card">
				<p>
					<br> <br> At vero eos et accusamus et iusto odio
					dignissimos ducimus qui blanditiis praesentium voluptatum deleniti
					atque corrupti quos dolores et quas molestias excepturi sint
					occaecati cupiditate non provident, similique sunt in culpa qui
					officia deserunt mollitia animi, id est laborum et dolorum fuga.
				</p>

				<br>
				<button class="btn btn-dark mb-2"
					style="background-color: #212529; border-color: red;" id="dealDom"
					disabled>Estrai nuovo</button>
				<br>
				<button class="btn btn-dark"
					style="background-color: #212529; border-color: red;" id="confDom"
					disabled>Conferma</button>
			</div>
		</div>
	</div>


	<br>
	<br>
	<br>

	<!-- ESTRAZIONE PUNTI CARATTERISTICHE -->

	<div class="container card p-2" id="caratteristiche">
		<div class="row">
			<br> <br> <br>
			<div class="col-3">
				<img src="../images/cardPlaceholder.png" id="tarCuori" class="mb-2"><br>
				<label>Valore cuori: </label><label id="valCuori">X</label><br>
				<button class="btn btn-dark mb-2"
					style="background-color: #212529; border-color: red;"
					id="dealCuori" disabled>Estrai nuova</button>

			</div>
			<div class="col-3">
				<img src="../images/cardPlaceholder.png" id="tarQuadri" class="mb-2"><br>
				<label>Valore quadri: </label><label id="valQuadri">X</label><br>
				<button class="btn btn-dark mb-2"
					style="background-color: #212529; border-color: red;"
					id="dealQuadri" disabled>Estrai nuova</button>
				<br>

			</div>
			<div class="col-3">
				<img src="../images/cardPlaceholder.png" id="tarFiori" class="mb-2"><br>
				<label>Valore fiori: </label><label id="valFiori">X</label><br>
				<button class="btn btn-dark mb-2"
					style="background-color: #212529; border-color: red;"
					id="dealFiori" disabled>Estrai nuova</button>
				<br>

			</div>
			<div class="col-3">
				<img src="../images/cardPlaceholder.png" id="tarPicche" class="mb-2"><br>
				<label>Valore picche: </label><label id="valPicche">X</label><br>
				<button class="btn btn-dark mb-2"
					style="background-color: #212529; border-color: red;"
					id="dealPicche" disabled>Estrai nuova</button>
				<br>
				<button class="btn btn-dark mb-2"
					style="background-color: #212529; border-color: red;"
					id="confermaPunti" disabled>Conferma punti</button>
			</div>
		</div>
	</div>



	<br>
	<br>
	<br>

	<!-- TABELLA SELEZIONE CARATTERISTICHE -->

	<fieldset id="setCar" class="container" disabled>
		<table class="table table-dark">
			<tbody>
				<tr>

					<th><label>CUORI - Rimasti: </label></th>
					<th><label id="cuoriRimasti">xx</label></th>
					<th><label>QUADRI - Rimasti: </label></th>
					<th><label id="quadriRimasti">xx</label></th>
					<th><label>FIORI - Rimasti: </label></th>
					<th><label id="fioriRimasti">xx</label></th>
					<th><label>PICCHE - Rimasti: </label></th>
					<th><label id="piccheRimasti">xx</label></th>

				</tr>
				<tr>
					<td><label>Intuito: </label></td>
					<td><input type="number" name="quantity" min="1" max="6"
						value="1"></td>
					<td><label>Aspetto: </label></td>
					<td><input type="number" name="quantity" min="1" max="6"
						value="1"></td>
					<td><label>Coordinazione: </label></td>
					<td><input type="number" name="quantity" min="1" max="6"
						value="1"></td>
					<td><label>Affinità occulta:</label></td>
					<td><input type="number" name="quantity" min="1" max="6"
						value="1"></td>
				</tr>
				<tr>
					<td><label>Memoria:</label></td>
					<td><input type="number" name="quantity" min="1" max="6"
						value="1"></td>
					<td><label>Comando:</label></td>
					<td><input type="number" name="quantity" min="1" max="6"
						value="1"></td>
					<td><label>Destrezza manuale:</label></td>
					<td><input type="number" name="quantity" min="1" max="6"
						value="1"></td>
					<td><label>Distanza dalla morte: </label></td>
					<td><input type="number" name="quantity" min="1" max="6"
						value="1"></td>
				</tr>
				<tr>
					<td><label>Percezione:</label></td>
					<td><input type="number" name="quantity" min="1" max="6"
						value="1"></td>
					<td><label>Creatività:</label></td>
					<td><input type="number" name="quantity" min="1" max="6"
						value="1"></td>
					<td><label>Forza fisica:</label></td>
					<td><input type="number" name="quantity" min="1" max="6"
						value="1"></td>
					<td><label>Equilibrio mentale: </label></td>
					<td><input type="number" name="quantity" min="1" max="6"
						value="1"></td>
				</tr>
				<tr>
					<td><label>Volontà:</label></td>
					<td><input type="number" name="quantity" min="1" max="6"
						value="1"></td>
					<td><label>Socievolezza:</label></td>
					<td><input type="number" name="quantity" min="1" max="6"
						value="1"></td>
					<td><label>Mira:</label></td>
					<td><input type="number" name="quantity" min="1" max="6"
						value="1"></td>
					<td><label>Karma: </label></td>
					<td><input type="number" name="quantity" min="1" max="6"
						value="1"></td>
				</tr>
			</tbody>
		</table>

	</fieldset>
	<button class="btn btn-dark mb-2 mx-1"
		style="background-color: #212529; border-color: red;" id="confCar"
		disabled>CONFERMA CARATTERISTICHE</button>
	<br>
	<br>
	<br>




	<div class="container">
		<h2 class="card-title">
			PUNTI ABILITÀ TOTALI: <label id="totAbi">XX</label>
		</h2>
	</div>
	<fieldset id="setAbi" class="container" disabled>
		<table class="table table-dark">
			<tbody>
				<tr>

					<th><label>ABILITÀ</label></th>
					<th><label>CARATTERISTICA</label></th>
					<th><label>PUNTI ABILITÀ</label></th>
					<th><label>TOTALE</label></th>

				</tr>
				<tr>
					<td><label>abi</label></td>

					<td><label>car</label></td>

					<td><input type="number" name="quantity" min="1" max="6"
						value="1"></td>

					<td><label>tot</label></td>
				</tr>
				<tr>
					<td><label>abi</label></td>

					<td><label>car</label></td>

					<td><input type="number" name="quantity" min="1" max="6"
						value="1"></td>

					<td><label>tot</label></td>
				</tr>
				<tr>
					<td><label>abi</label></td>

					<td><label>car</label></td>

					<td><input type="number" name="quantity" min="1" max="6"
						value="1"></td>

					<td><label>tot</label></td>
				</tr>
				<tr>
					<td><label>abi</label></td>

					<td><label>car</label></td>

					<td><input type="number" name="quantity" min="1" max="6"
						value="1"></td>

					<td><label>tot</label></td>
				</tr>
				<tr>
					<td><label>abi</label></td>

					<td><label>car</label></td>

					<td><input type="number" name="quantity" min="1" max="6"
						value="1"></td>

					<td><label>tot</label></td>
				</tr>
			</tbody>
		</table>

	</fieldset>
	<form action="riepilogoPG.jsp">
		<button class="btn btn-dark mb-2 mx-1"
			style="background-color: #212529; border-color: red;" id="completa"
			disabled>COMPLETA CREAZIONE PG</button>
	</form>
	<br>
	<br>
	<br>

</body>
</html>