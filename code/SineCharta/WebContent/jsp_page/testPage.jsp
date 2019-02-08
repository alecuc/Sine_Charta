<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="../css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
</head>
<body>
<button type="button" class="btn btn-primary btn-dark"
						data-toggle="modal" data-target="#helpDom">Serve aiuto?</button>
<div class="modal fade" id="helpDom" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Il Tarocco
					Dominante</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">Cliccando su "Estrai" potrai scoprire
				il Tarocco Dominante del tuo Personaggio, il punto di partenza per
				sviluppare la sua personalità e il suo passato. Puoi cambiare la
				carta estratta se non ti piace, ma fa' attenzione: puoi estrarne al
				massimo tre.</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="helpCar" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Determinare i
					punti caratteristica</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">In Sine Requie le caratteristiche sono
				suddivise in quattro categorie: Mentali (Cuori), Sociali (Quadri),
				Fisiche (Fiori) e Spirituali (Picche). I punti caratteristica
				vengono generati attraverso i Tarocchi. Ognuno di essi ha un
				punteggio che va da 8 a 24 per ogni seme delle carte da Poker. Come
				per il Tarocco Dominante, puoi estrarre al massimo tre carte per
				ogni seme. Inoltre, maggiore è la somma dei quattro punteggi,
				maggiore è l'ammontare dei punti abilità.</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="helpPunti" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Le
					caratteristiche</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">In questa sezione puoi assegnare i
				punti caratteristica del tuo Personaggio. Per ogni caratteristica, i
				punti assegnati devono essere non più di 6 e non meno di 1.

				Attenzione: le caratteristiche con un solo punto sono tipiche di
				personaggi con seri problemi. Ad esempio, un personaggio con un solo
				punto in Aspetto è particolarmente brutto.</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

<div class="modal fade" id="helpAbi" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Le abilità</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">Le abilità del Personaggio
				rappresentano le competenze in differenti ambiti: battaglia, utilità
				eccetera. Il punteggio totale è determinato dalla somma dei punti
				abilità con la caratteristica corrispondente.</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
</body>	
</html>