function validateTitle(form) {

	//define storia form regular expression
	var titleRX = /^(\w+[\._\-\?\!\+\*\']?(...)?){5,}$/;
	var descrRX = /^(\w+[\._\-\?\!\+\*\']?(...)?){5,}$/;

	var titleOK = form.titolo.value.match(titleRX);
	var descOK = form.descrizione.value.match(descrRX);

	if(!titleOK){ //check titolo
		alert("Il campo titolo non è corretto");
		return false;
	}else if(!descOK){ // check descrizione
		alert("Il campo descrizione non è corretto");
		return false;
	}else
		return true;
}

$(document).ready(function(){
	var nInvitato=0;
	var utenti=[];
	var data= "";

	/*
	 * QUESTA FUNZIONE EFFETTUA UNA CHIAMATA ASINCRONA AD UNA SERVLET.
	 * LA SERVLET UTILIZZERÀ USERSMANAGER PER CONTROLLARE L'ESISTENZA DELL'USERNAME INSERITO.
	 * */

	$('#aggiungiUtente').click(function(){

		var rmButton= '<button class="btn btn-dark cancella">Rimuovi</button>';
		var name = $('#user').val();


		if(utenti.includes(name)){
			alert('Hai già invitato questo utente!');
		} else{

			$.get('../UserExistServlet', {usr : name}, function(responseText) {

				if(name == responseText){
					nInvitato= nInvitato + 1;
					$('#tabellaInviti > tbody:last-child').append('<tr><td><label id="'+nInvitato+'">'+name+'</label></td><td>'+rmButton+'</td></tr>');
					utenti.push(name);
					console.log(utenti.toString());

				} else if(responseText== "TU"){
					alert("Non preocccuparti! Non devi invitarti alla tua stessa storia!");	
				}
				else alert("Questo utente non esiste. Riprova");
			});
		}


	});

	/*
	 * Questa funzione elimina l'utente selezionato dalla lista di utenti da invitare
	 * */


	$("#tabellaInviti").on('click', '.cancella', function () {
		var row= $(this).closest('tr');
		var toRemove= row.find($('label')).text();

		console.log(toRemove);
		utenti.pop(toRemove);

		row.remove();


		console.log(utenti.toString());
	});


	/*
	 * Questa funzione finalizza la creazione della storia
	 * */

	$('#salvaStoria').click(function(){

		if(validateTitle($("#form"))){


			if(utenti.length == 0) {
				alert('Devi invitare qualcuno a giocare!');
			} else{

				var tagTitolo= $('#titolo');
				var tagAmb= $('#ambientazione');
				var tagDesc= $('#descrizione');

				var titolo= tagTitolo.val();
				var ambi= tagAmb.val();
				var desc= tagDesc.val();

				data= utenti.toString();

				var value= '../GestioneStoriaServlet?action=inserisciStoria&Descrizione='+desc+'&Titolo='+titolo+'&Ambientazione='+ambi+'&data='+data;

				$('#form').attr('action', value);
			}
		}
	});

});

