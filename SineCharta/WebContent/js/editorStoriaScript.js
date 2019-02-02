/*
 * QUESTA FUNZIONE EFFETTUA UNA CHIAMATA ASINCRONA AD UNA SERVLET.
 * LA SERVLET UTILIZZERÀ USERSMANAGER PER CONTROLLARE L'ESISTENZA DELL'USERNAME INSERITO.
 * */

$(document).ready(function(){
	var nInvitato=0;
	var utenti=[];
	var data= "";


	console.log("loaded v0.12");


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

				} else alert("Questo utente non esiste. Riprova");
			});
		}


	});

	$("#tabellaInviti").on('click', '.cancella', function () {
		var row= $(this).closest('tr');
		var toRemove= row.find($('label')).text();

		console.log(toRemove);
		utenti.pop(toRemove);

		row.remove();


		console.log(utenti.toString());
	});

	$('#salvaStoria').click(function(){



		var tagTitolo= $('#titolo');
		var tagAmb= $('#ambientazione');
		var tagDesc= $('#descrizione');

		var titolo= tagTitolo.val();
		var ambi= tagAmb.val();
		var desc= tagDesc.val();

		data= utenti.toString();
		var value= '../GestioneStoriaServlet?action=inserisciStoria&Descrizione='+desc+'&Titolo='+titolo+'&Ambientazione='+ambi+'&data='+data;

		$('#form').attr('action', value);


	});

});

