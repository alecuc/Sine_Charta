function validateCont(form){

	//espressioni regolari per i campi del form
	var contRX = /^(\w+[\._\-\?\!\+\*\']?(...)?){5,}$/;

	var contenutoOK = form.contenuto.value.match(contRX);

	if(!contenutoOK) {
		alert("Il contenuto della sessione non è corretto");
		return false;
	}
	return true;
}

$(document).ready(function(){	

	/*
	 * Questa funzione permette di salvare il contenuto di una sessione
	 * */

	$('#salvaSessione').click(function(){

		if(validateCont($("#form"))){

			var tagCont= $('#contenuto');
			var cont= tagCont.val();

			var value= '../GestioneSessioneServlet?action=inserisciSessione&Contenuto='+cont;

			$('#form').attr('action', value);
		}
	});

	/*
	 * Le due funzioni successive permettono di aggiungere o rimuovere dei nemici dalla sessione corrente
	 * */

	$('.minusEnemy').click(function(){

		var tag= $(this).next();
		var currValue= parseInt(tag.text(), 10);
		if(currValue==0);
		else{
			currValue -=1;
			tag.text(currValue--);
		}
	});

	$('.plusEnemy').click(function(){

		var tag= $(this).prev();
		var currValue= parseInt(tag.text(), 10);
		if(currValue==5);
		else{
			currValue +=1;
			tag.text(currValue++);
		}
	});
});