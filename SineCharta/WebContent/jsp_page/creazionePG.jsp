<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="head.jsp"></jsp:include>
<script src="../js/creazioneAction.js"></script>
<title>Crea personaggio</title>
</head>
<body>
<jsp:include page="navigationbar.jsp"></jsp:include>

	<%
			if (session.getAttribute("user") == null) {
				response.sendRedirect("error/error.jsp");
			};
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
			<button class="btn btn-dark float-right"
				style="background-color: #212529; border-color: red;" id="confGen">Conferma</button>
		</form>
	</div>

	<br>
	<br>
	<br>

	<!-- ESTRAZIONE TAROCCO DOMINANTE -->

	<div class="container card p-2" id="taroccoDominante">
		<div class="row">

			<div class="col-8">
				<div class="row">

					<img src="../images/cardBack.png" id="mazzo"
						class="img-responsive mx-5"> <img
						src="../images/cardBack.png" id="tDom" class="img-responsive">

				</div>
			</div>


			<div class="col-4 container-card">
				<div class="row">
					<h4 id="domName">Clicca estrai per scoprire il tuo tarocco
						dominante.</h4>
				</div>
				<div class="row">

					<h6>Numero di estrazioni possibili:</h6>
					<h6 id="numDom">3</h6>

					<p id="domDesc"></p>
				</div>
				<div class="row">
					<button class="btn btn-dark my-2 mr-5"
						style="background-color: #212529; border-color: red;" id="dealDom"
						disabled>Estrai</button>
					<br>
					<button class="btn btn-dark"
						style="background-color: #212529; border-color: red;" id="confDom"
						disabled>Conferma</button>
				</div>
			</div>
		</div>
	</div>


	<br>
	<br>
	<br>

	<!-- ESTRAZIONE PUNTI CARATTERISTICHE -->

	<div class="container card" id="caratteristiche">
		<div class="row">
			<div class="col-3">
				<div class="row">

					<img src="../images/cardBack.png" id="tarCuori"
						class="mb-2 img-responsive">
				</div>
				<div class="row">

					<div>
						<label>Valore cuori: </label><label id="valCuori">X</label><br>
						<h6 id="numCuori">Numero estrazioni possibili: 3</h6>
						<br>
						<button class="btn btn-dark mb-2"
							style="background-color: #212529; border-color: red;"
							id="dealCuori" disabled>Estrai</button>
					</div>
				</div>
			</div>
			<div class="col-3">
				<div class="row">

					<img src="../images/cardBack.png" id="tarQuadri"
						class="mb-2 img-responsive">
				</div>
				<div class="row">
					<div>
						<label>Valore quadri: </label><label id="valQuadri">X</label><br>
						<h6 id="numQuadri">Numero estrazioni possibili: 3</h6>
						<br>
						<button class="btn btn-dark mb-2"
							style="background-color: #212529; border-color: red;"
							id="dealQuadri" disabled>Estrai</button>
					</div>
				</div>
			</div>
			<div class="col-3">
				<div class="row">

					<img src="../images/cardBack.png" id="tarFiori"
						class="mb-2 img-responsive">
				</div>
				<div class="row">
					<div>
						<label>Valore fiori: </label><label id="valFiori">X</label><br>
						<h6 id="numFiori">Numero estrazioni possibili: 3</h6>
						<br>
						<button class="btn btn-dark mb-2"
							style="background-color: #212529; border-color: red;"
							id="dealFiori" disabled>Estrai</button>
					</div>
				</div>
			</div>

			<div class="col-3">
				<div class="row">

					<img src="../images/cardBack.png" id="tarPicche"
						class="mb-2 img-responsive">
				</div>
				<div class="row">
					<div>
						<label>Valore picche: </label><label id="valPicche">X</label><br>
						<h6 id="numPicche">Numero estrazioni possibili: 3</h6>
						<br>
						<button class="btn btn-dark mb-2"
							style="background-color: #212529; border-color: red;"
							id="dealPicche" disabled>Estrai</button>
						<br>
						<button class="btn btn-dark mb-2"
							style="background-color: #212529; border-color: red;"
							id="confermaPunti" disabled>Conferma punti</button>
					</div>
				</div>
			</div>
		</div>
	</div>


	<br>
	<br>
	<br>

	<!-- TABELLA SELEZIONE CARATTERISTICHE -->
	<div class="container">
		<fieldset id="setCar" disabled>
			<table class="table table-responsive table-dark">
				<tbody>
					<tr>

						<th><label>CUORI - Rimasti: </label></th>
						<th><label id="cuoriRimasti"class="text-center">xx</label></th>
						<th><label>QUADRI - Rimasti: </label></th>
						<th><label id="quadriRimasti"class="text-center">xx</label></th>
						<th><label>FIORI - Rimasti: </label></th>
						<th><label id="fioriRimasti"class="text-center">xx</label></th>
						<th><label>PICCHE - Rimasti: </label></th>
						<th><label id="piccheRimasti" class="text-center">xx</label></th>

					</tr>
					<tr>
					
						<td><label>Intuito: </label></td>
						<td>
							<button class="btn btn-dark minusCuori"style="width: 20px;">-</button>
							<input type="text" name="quantity"
							value="1" class="setCuori" id="int" style="width: 18px;" readonly>
							<button class="btn btn-dark plusCuori"style="width: 20px;">+</button>
						</td>
						
						<td><label>Aspetto: </label></td>
						<td>
							<button class="btn btn-dark minusQuadri" style="width: 20px;">-</button>
							<input type="text" name="quantity" style="width: 18px;"
							value="1" class="setQuadri" id="asp" style="width: 18px;" readonly>
							<button class="btn btn-dark plusQuadri" style="width: 20px;">+</button>
						</td>
						<td><label>Coordinazione: </label></td>
						<td>
							<button class="btn btn-dark minusFiori" style="width: 20px;">-</button>
							<input type="text" name="quantity" 
							value="1" class="setFiori" id="coo" style="width: 18px;" readonly>
							<button class="btn btn-dark plusFiori" style="width: 20px;">+</button>
						</td>
						<td><label>Affinità occulta:</label></td>
						<td>
							<button class="btn btn-dark minusPicche" style="width: 20px;">-</button>
							<input type="text" name="quantity" 
							value="1" class="setPicche" id="aff" style="width: 18px;" readonly>
							<button class="btn btn-dark plusPicche" style="width: 20px;">+</button>
						</td>
						
					</tr>
					<tr>
						<td><label>Memoria: </label></td>
						<td>
							<button class="btn btn-dark minusCuori"style="width: 20px;">-</button>
							<input type="text" name="quantity"
							value="1" class="setCuori" id="mem" style="width: 18px;" readonly>
							<button class="btn btn-dark plusCuori"style="width: 20px;">+</button>
						</td>
						
						<td><label>Comando: </label></td>
						<td>
							<button class="btn btn-dark minusQuadri"style="width: 20px;">-</button>
							<input type="text" name="quantity" style="width: 18px;"
							value="1" class="setQuadri" id="com" style="width: 18px;" readonly>
							<button class="btn btn-dark plusQuadri"style="width: 20px;">+</button>
						</td>
						<td><label>Destrezza manuale: </label></td>
						<td>
							<button class="btn btn-dark minusFiori"style="width: 20px;">-</button>
							<input type="text" name="quantity" 
							value="1" class="setFiori" id="des" style="width: 18px;" readonly>
							<button class="btn btn-dark plusFiori"style="width: 20px;">+</button>
						</td>
						<td><label>Distanza dalla morte:</label></td>
						<td>
							<button class="btn btn-dark minusPicche"style="width: 20px;">-</button>
							<input type="text" name="quantity" 
							value="1" class="setPicche" id="ddm" style="width: 18px;" readonly>
							<button class="btn btn-dark plusPicche"style="width: 20px;">+</button>
						</td>
					</tr>
					<tr>
						<td><label>Percezione: </label></td>
						<td>
							<button class="btn btn-dark minusCuori"style="width: 20px;">-</button>
							<input type="text" name="quantity"
							value="1" class="setCuori" id="per" style="width: 18px;" readonly>
							<button class="btn btn-dark plusCuori"style="width: 20px;">+</button>
						</td>
						
						<td><label>Creatività: </label></td>
						<td>
							<button class="btn btn-dark minusQuadri"style="width: 20px;">-</button>
							<input type="text" name="quantity" style="width: 18px;"
							value="1" class="setQuadri" id="cre" style="width: 18px;" readonly>
							<button class="btn btn-dark plusQuadri"style="width: 20px;">+</button>
						</td>
						<td><label>Forza fisica: </label></td>
						<td>
							<button class="btn btn-dark minusFiori"style="width: 20px;">-</button>
							<input type="text" name="quantity" 
							value="1" class="setFiori" id="for" style="width: 18px;" readonly>
							<button class="btn btn-dark plusFiori"style="width: 20px;">+</button>
						</td>
						<td><label>Equilibrio mentale:</label></td>
						<td>
							<button class="btn btn-dark minusPicche"style="width: 20px;">-</button>
							<input type="text" name="quantity" 
							value="1" class="setPicche" id="eqm" style="width: 18px;" readonly>
							<button class="btn btn-dark plusPicche"style="width: 20px;">+</button>
						</td>
					</tr>
					<tr>
						<td><label>Volontà: </label></td>
						<td>
							<button class="btn btn-dark minusCuori"style="width: 20px;">-</button>
							<input type="text" name="quantity"
							value="1" class="setCuori" id="vol" style="width: 18px;" readonly>
							<button class="btn btn-dark plusCuori"style="width: 20px;">+</button>
						</td>
						
						<td><label>Socievolezza: </label></td>
						<td>
							<button class="btn btn-dark minusQuadri"style="width: 20px;">-</button>
							<input type="text" name="quantity" style="width: 18px;"
							value="1" class="setQuadri" id="soc" style="width: 18px;" readonly>
							<button class="btn btn-dark plusQuadri"style="width: 20px;">+</button>
						</td>
						<td><label>Mira: </label></td>
						<td>
							<button class="btn btn-dark minusFiori"style="width: 20px;">-</button>
							<input type="text" name="quantity" 
							value="1" class="setFiori" id="mir" style="width: 18px;" readonly>
							<button class="btn btn-dark plusFiori"style="width: 20px;">+</button>
						</td>
						<td><label>Karma:</label></td>
						<td>
							<button class="btn btn-dark minusPicche"style="width: 20px;">-</button>
							<input type="text" name="quantity" 
							value="1" class="setPicche" id="kar" style="width: 18px;" readonly>
							<button class="btn btn-dark plusPicche"style="width: 20px;">+</button>
						</td>
					</tr>
				</tbody>
			</table>

		</fieldset>
		<button class="btn btn-dark mb-2 mx-1 float-right"
			style="background-color: #212529; border-color: red;" id="confCar"
			disabled>Conferma caratteristiche</button>
	</div>
	<br>
	<br>
	<br>




	<div class="container">
		<h2 class="card-title">
			PUNTI ABILITÀ TOTALI: <label id="abiRimasti">XX</label>
		</h2>
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

						<td><button class="btn btn-dark minusAbi">-</button>
							<input type="text" name="quantity" 
							value="1" class="setAbi" id="ab1" style="width: 30px;" readonly>
							<button class="btn btn-dark plusAbi">+</button></td>

						<td><label>tot</label></td>
					</tr>
					<tr>
						<td><label>abi</label></td>

						<td><label>car</label></td>

						<td><button class="btn btn-dark minusAbi">-</button>
							<input type="text" name="quantity" 
							value="1" class="setAbi" id="ab2" style="width: 30px;" readonly>
							<button class="btn btn-dark plusAbi">+</button></td>

						<td><label>tot</label></td>
					</tr>
					<tr>
						<td><label>abi</label></td>

						<td><label>car</label></td>

						<td><button class="btn btn-dark minusAbi">-</button>
							<input type="text" name="quantity" 
							value="1" class="setAbi" id="ab3" style="width: 30px;" readonly>
							<button class="btn btn-dark plusAbi">+</button></td>

						<td><label>tot</label></td>
					</tr>
					<tr>
						<td><label>abi</label></td>

						<td><label>car</label></td>

						<td><button class="btn btn-dark minusAbi">-</button>
							<input type="text" name="quantity" 
							value="1" class="setAbi" id="ab4" style="width: 30px;" readonly>
							<button class="btn btn-dark plusAbi">+</button></td>

						<td><label>tot</label></td>
					</tr>
					<tr>
						<td><label>abi</label></td>

						<td><label>car</label></td>

						<td><button class="btn btn-dark minusAbi">-</button>
							<input type="text" name="quantity" 
							value="1" class="setAbi" id="ab5" style="width: 30px;" readonly>
							<button class="btn btn-dark plusAbi">+</button></td>

						<td><label>tot</label></td>
					</tr>
				</tbody>
			</table>

		</fieldset>
		<form action="riepilogoPG.jsp">
			<button class="btn btn-dark mb-2 mx-1 float-right"
				style="background-color: #212529; border-color: red;" id="completa"
				disabled>Completa il tuo PG</button>
		</form>
	</div>


	<br>
	<br>
	<br>
</body>
</html>