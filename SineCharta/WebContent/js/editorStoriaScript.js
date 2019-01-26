/*
 * QUESTA FUNZIONE PERMETTE DI VALIDARE IL TITOLO DELLA STORIA CHE SI STA CREANDO
 * */

function  validateTitle(formStoria){
	var titoloValidator = /^[A-Za-z]+([\s\'\-\._]?[A-Za-z]+)*$/;
	var titoloIsOK = formStoria.titolo.value.match(titoloValidator);

	if(!titoloIsOK) {
		alert("Niente caratteri speciali nel titolo");
		return false;
	} return true;
}


/*
 * QUESTA FUNZIONE EFFETTUA UNA CHIAMATA ASINCRONA AD UNA SERVLET.
 * LA SERVLET UTILIZZERÀ USERSMANAGER PER CONTROLLARE L'ESISTENZA DELL'USERNAME INSERITO.
 * */

$(document).ready(function(){
	var nInvitato=0;
	$('#aggiungiUtente').click(function(){

		var rmButton= '<button class="btn btn-dark cancella">Rimuovi</button>';
		var name = $('#user').val();
		var match="";

		
		
		if(name==match){
			alert('Hai già invitato questo utente!');
		} else{

			$.get('../UserExistServlet', {usr : name}, function(responseText) {
				console.log(responseText);
				if(name == responseText){
					nInvitato= nInvitato + 1;
					$('#tabellaInviti > tbody:last-child').append('<tr><td><label id="'+nInvitato+'">"'+name+'"></label></td><td>'+rmButton+'</td></tr>');

				} else alert("Questo utente non esiste. Riprova");
			});
		}



	});

	$("#tabellaInviti").on('click', '.cancella', function () {
		$(this).closest('tr').remove();
	});

});

