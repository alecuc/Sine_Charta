<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@page import="beans.User"%>
<jsp:include page="head.jsp"></jsp:include>
<script src="../js/editorSessioneScript.js"></script>
<meta charset="UTF-8">
<title>Nuova storia</title>
</head>
<body>

	<%@page import="beans.User"%>
	<%@page import="beans.Storia"%>
	<%@page import="beans.SessioneDiGioco"%>
	<%@page import="beans.Keyword"%>

	<jsp:include page="navigationbar.jsp"></jsp:include>

	<div class="container">

		<div class="row">

			<div class="col-8 card">
				<h3 class="card-title">Editor di sessione</h3>

				<div class="container-card">
					<form action="" method="post" id="form">


							<textarea class="form-control" aria-label="With textarea"
								placeholder="Descrivi la sessione qui..." id="contenuto"
								style="resize: none; height: 400px;" name="descrizione" required></textarea>
							<button class="btn btn-dark" id="salvaSessione">Salva sessione</button>
							<a class="btn btn-dark mx-2" id="annulla" href="leTueStorie.jsp">Annulla</a>
				</form>
				</div>
			</div>

			<div class="col-4 card">
				<h3 class="card-title">Inserisci una keyword</h3>
				<div class="row card">
					<input type="text" class="form-control"
						placeholder="Inserisci la parola chiave..." name="keyword">
					<textarea class="form-control" aria-label="With textarea"
						placeholder="Descrivi qui la tua parola chiave..."
						style="resize: none; height: 100px;" name="descrizione"></textarea>
					<button class="btn btn-dark" id="addKeyword">Aggiungi
						keyword</button>
				</div>

				<br>

				<div class="row card">
					<h3>Aggiungi dei nemici a questa sessione</h3>
					<table class="table table-dark">
						<tbody>
							<tr>
								<td>Simplex</td>
								<td><button class="btn btn-dark minusEnemy">-</button> <label class="mx-5"
									id="numSim">0</label>
									<button class="btn btn-dark plusEnemy">+</button></td>
							</tr>
							<tr>
								<td>Maior</td>
								<td><button class="btn btn-dark minusEnemy">-</button> <label class="mx-5"
									id="numMai">0</label>
									<button class="btn btn-dark plusEnemy">+</button></td>
							</tr>
							<tr>
								<td>Atrox</td>
								<td><button class="btn btn-dark minusEnemy">-</button> <label class="mx-5"
									id="numAtr">0</label>
									<button class="btn btn-dark plusEnemy">+</button></td>
							</tr>
							<tr>
								<td>Larva</td>
								<td><button class="btn btn-dark minusEnemy">-</button> <label class="mx-5"
									id="numLar">0</label>
									<button class="btn btn-dark plusEnemy">+</button></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
