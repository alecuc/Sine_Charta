<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@page import="beans.User"%>
<jsp:include page="head.jsp"></jsp:include>
<script src="../js/editorStoriaScript.js"></script>
<meta charset="UTF-8">
<title>Nuova storia</title>
</head>
<body>
	<jsp:include page="navigationbar.jsp"></jsp:include>

	<div class="container">

		<div class="row">

			<div class="col-8 card">
				<h3 class="card-title">DESCRIVI LA TUA STORIA</h3>

				<div class="container-card">
					<form action="" method="post" id="form">
						<div class="row">

							<div class="col-6">
								<input type="text" class="form-control" id="titolo"
									placeholder="Inserisci qui il titolo..." name="titolo" required="required">
							</div>
							<div class="col-6">
								<select class="form-control" name="ambientazione" id="ambientazione" required="required">
									<option>Seleziona un'ambientazione</option>
									<option>Sanctum Imperum</option>
									<option>Terre Perdute</option>
									<option>Soviet</option>
									<option>Quarto Reich</option>
								</select>
							</div>
						</div>
						<textarea class="form-control" aria-label="With textarea" id="descrizione"
							placeholder="Scrivi qui l'introduzione della tua storia..."
							style="resize: none; height: 400px;" name="descrizione" required="required"></textarea>
						<button class="btn btn-dark" id="salvaStoria">Salva storia</button>
					</form>
				</div>
			</div>

			<div class="col-4 card">
				<h3 class="card-title">INVITA I TUOI AMICI</h3>
				<div class="row">
					<table class="table table-dark" id="tabellaInviti">
						<tbody>
							<tr>
								<th><label>Username</label></th>
								<th></th>
							</tr>
							<tr>
								<td hidden="true"></td>
							</tr>
						</tbody>
					</table>
					<input type="text" placeholder="Utente da invitare..." id="user" name="usr" class="form-control">
					<button class="btn btn-dark" id="aggiungiUtente">Aggiungi</button>
					<div class="row"></div>
					
				</div>


			</div>
		</div>
	</div>
</body>
</html>