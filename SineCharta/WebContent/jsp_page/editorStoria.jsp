<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@page import="beans.User"%>
<jsp:include page="head.jsp"></jsp:include>
<script src="../js/editorStoriaScript.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="navigationbar.jsp"></jsp:include>

	<div class="container">

		<div class="row">

			<div class="col-8 card">
				<h3 class="card-title">DESCRIVI LA TUA STORIA</h3>

				<div class="container-card">
					<form action="EditorStoria" method="post">
						<div class="row">

							<div class="col-6">
								<input type="text" class="form-control"
									placeholder="Inserisci qui il titolo..." name="titolo">
							</div>
							<div class="col-6">
								<select class="form-control" name="ambientazione">
									<option>Seleziona un'ambientazione</option>
									<option>Sanctum Imperum</option>
									<option>Terre Perdute</option>
									<option>Soviet</option>
									<option>Quarto Reich</option>
								</select>
							</div>
						</div>
						<textarea class="form-control" aria-label="With textarea"
							placeholder="Scrivi qui l'introduzione della tua storia..."
							style="resize: none; height: 400px;" name="descrizione"></textarea>
						<button class="btn btn-dark"
							onclick="return validateTitle(this.form)">Salva storia</button>
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
								<td></td>
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