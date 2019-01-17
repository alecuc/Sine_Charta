<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
</head>
<body>

	<div class="container">
		<form name="generalità">
			<div class="row">
				<label>Nome:</label><input type="text" name="nome"
					class="form-control col-sm-3" id="nomePG" placeholder="Nome del pg"
					required> <label>Cognome:</label><input type="text"
					name="nome" class="form-control col-sm-3" id="nomePG"
					placeholder="Nome del pg" required>
			</div>
			<div class="row">
				<label>Nazionalità:</label><input type="text" name="nome"
					class="form-control col-sm-3" id="nomePG" placeholder="Nome del pg"
					required> <label>Età:</label><input type="text" name="nome"
					class="form-control col-sm-3" id="nomePG" placeholder="Nome del pg"
					required>
			</div>
			<input type="radio" name="sesso" value="uomo"> Uomo<br>
			<input type="radio" name="sesso" value="donna"> Donna<br>
			<button class="btn btn-dark">Conferma</button>
		</form>
	</div>

	<div class="container">
		<br> <br> <br> <span class="row"> <img
			src="../images/cardPlaceholder.png" id="mazzo"> <img
			src="../images/cardPlaceholder.png" id="estratta">At vero eos
			et accusamus et iusto odio dignissimos ducimus qui blanditiis
			praesentium voluptatum deleniti atque corrupti quos dolores et quas
			molestias excepturi sint occaecati cupiditate non provident,
			similique sunt in culpa qui officia deserunt mollitia animi, id est
			laborum et dolorum fuga.<br>
			<button class="btn btn-dark">Estrai nuova</button>
			<button class="btn btn-dark">Conferma</button>
		</span>
	</div>

	<div class="container row">
		<br> <br> <br> <span class="col-3"> <img
			src="../images/cardPlaceholder.png" id="mazzo"><br> <label>Valore
				cuori: </label><label id="valCuori">X</label><br>
			<button class="btn btn-dark">Estrai nuova</button> <br>
			<button class="btn btn-dark">Conferma</button>
		</span> <span class="col-3"> <img src="../images/cardPlaceholder.png"
			id="mazzo"><br> <label>Valore quadri: </label><label
			id="valQuadri">X</label><br>
			<button class="btn btn-dark">Estrai nuova</button> <br>
			<button class="btn btn-dark">Conferma</button>
		</span> <span class="col-3"> <img src="../images/cardPlaceholder.png"
			id="mazzo"><br> <label>Valore fiori: </label><label
			id="valFiori">X</label><br>
			<button class="btn btn-dark">Estrai nuova</button> <br>
			<button class="btn btn-dark">Conferma</button>
		</span> <span class="col-3"> <img src="../images/cardPlaceholder.png"
			id="mazzo"><br> <label>Valore picche: </label><label
			id="valPicche">X</label><br>
			<button class="btn btn-dark">Estrai nuova</button> <br>
			<button class="btn btn-dark">Conferma</button>
		</span>
	</div>

	<div class="container">
	<table class="table table-dark">
		<tbody>
			<tr>
				<td scope="row"><label>Intuito: </label><input type="number"
					name="quantity" min="1" max="6"></td>
				<td><label>Memoria: </label><input type="number"
					name="quantity" min="1" max="6"></td>
				<td><label>Percezione: </label><input type="number"
					name="quantity" min="1" max="6"></td>
				<td><label>Volontà: </label><input type="number"
					name="quantity" min="1" max="6"></td>
				<td><label>Punti rimasti: </label><label id="cuoriRimasti">x</label></td>
			</tr>
			<tr>
				<td scope="row"><label>Aspetto: </label><input type="number"
					name="quantity" min="1" max="6"></td>
				<td><label>Comando: </label><input type="number"
					name="quantity" min="1" max="6"></td>
				<td><label>Creatività: </label><input type="number"
					name="quantity" min="1" max="6"></td>
				<td><label>Socievolezza: </label><input type="number"
					name="quantity" min="1" max="6"></td>
				<td><label>Punti rimasti: </label><label id="quadriRimasti">x</label></td>
			</tr>
			<tr>
				<td scope="row"><label>Coordinazione: </label><input
					type="number" name="quantity" min="1" max="6"></td>
				<td><label>Destrezza manuale: </label><input type="number"
					name="quantity" min="1" max="6"></td>
				<td><label>Forza fisica: </label><input type="number"
					name="quantity" min="1" max="6"></td>
				<td><label>Mira: </label><input type="number" name="quantity"
					min="1" max="6"></td>
				<td><label>Punti rimasti: </label><label id="fioriRimasti">x</label></td>
			</tr>
			<tr>
				<td scope="row"><label>Affinità occulta: </label><input
					type="number" name="quantity" min="1" max="6"></td>
				<td><label>Dist. dalla morte: </label><input type="number"
					name="quantity" min="1" max="6"></td>
				<td><label>Equilibrio mentale: </label><input type="number"
					name="quantity" min="1" max="6"></td>
				<td><label>Karma: </label><input type="number" name="quantity"
					min="1" max="6"></td>
				<td><label>Punti rimasti: </label><label id="piccheRimasti">x</label></td>
			</tr>
		</tbody>
	</table>
	<button class="btn btn-dark">Conferma</button>
</div>
	<div class="container"></div>

	<div class="container"></div>


</body>
</html>