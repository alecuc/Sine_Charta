function validate(){

	var nameValidator = /^[a-zA-Z]+([\s\-]?[A-Za-z]+)*$/;
	var surnameValidator = /^[A-Za-z]+([\s\'\-]?[A-Za-z]+)*$/;
	var nazionalitaValidator = /^[a-zA-Z]+([\s\-]?[A-Za-z]+)*$/;
	var etaValidator = /^[0-9]+$/;

	var name = document.getElementById('nomePG').value;
	var nameIsOK = name.match(nameValidator);

	var surname = document.getElementById('cognomePG').value;
	var surnameIsOK = surname.match(surnameValidator);

	var nazionalita= document.getElementById('nazionalitaPG').value;
	var nazionalitaIsOK = nazionalita.match(nazionalitaValidator);			

	var eta = document.getElementById('etaPG').value;
	var etaIsOK = eta.match(etaValidator);

	if (!nameIsOK) { //Check nome
		alert('Inserisci un nome valido');
		return false;
		//Negate access
	} else

		if (!surnameIsOK) { //Check cognome
			alert('Inserisci un cognome valido');
			return false;
			//Negate access
		} else

			if (!nazionalitaIsOK) { //Check nazionalità
				alert('Inserisci una nazionalità valida')
				return false;
				//Negate access
			} else	  

				if (!etaIsOK) { //Check età
					alert('L\'età è solo un numero');
					return false;
					//Negate access
				} else if(eta>90){
					alert('Siamo un po\' troppo veccchi eh?');

				}  else if(eta<5){
					alert('Ehi bimbo! Posa quella pistola!');

				} else return true;
};



$(document).ready(function(){

	

	$('#confGen').click(function(){

		if(validate('#formGen')){

			$(this).prop('disabled',true);
			$('#nomePG').prop('disabled',true);
			$('#cognomePG').prop('disabled',true);
			$('#nazionalitaPG').prop('disabled',true);
			$('#etaPG').prop('disabled',true);
			$('#PGuomo').prop('disabled',true);
			$('#PGdonna').prop('disabled',true);
			$('#dealDom').prop('disabled',false);
			$('#confDom').prop('disabled',false);
		}

	});

	$('#confDom').click(function(){
		//	SHUFFLE MAZZO TAROCCHI
		$(this).prop('disabled',true);
		$('#dealDom').prop('disabled',true);
		$('#dealCuori').prop('disabled',false);
		$('#dealQuadri').prop('disabled',false);
		$('#dealFiori').prop('disabled',false);
		$('#dealPicche').prop('disabled',false);
		$('#confermaPunti').prop('disabled',false);
	//	$.get(url, oggetti da inviare, funzione da eseguire in caso di successo)
	});

	
	$('#confermaPunti').click(function(){
		$(this).prop('disabled',true);
		$('#dealCuori').prop('disabled',true);
		$('#dealQuadri').prop('disabled',true);
		$('#dealFiori').prop('disabled',true);
		$('#dealPicche').prop('disabled',true);
		$('#setCar').prop('disabled',false);
		$('#confCar').prop('disabled',false);
	});
	
	$('#confCar').click(function(){
		$(this).prop('disabled',true);
		$('#setCar').prop('disabled',true);
		$('#setAbi').prop('disabled',false);
		$('#completa').prop('disabled',false);
	});
	
	
	var countDom=1;
	var countCuori=1;
	var countQuadri=1;
	var countFiori=1;
	var countPicche=1;
	
	$('#dealDom').click(function(){
		countDom++;
		/**
		 * ESTRAI TAROCCO DOMINANTE:
		 * 	 SETTA L'IMMAGINE DI #TDOM
		 * 	 SETTA LA DESCRIZIONE DI #TDOM
		 * $.get(url, oggetti da inviare, funzione da eseguire in caso di successo)
		 * */

		$("#tDom").animate({width:'toggle'},350);
		
		//QUESTO DEVE CAMBIARE IN BASE A QUELLA ESTRATTA
		$("#tDom").attr("src","../images/cardPlaceholder2.png");
		
		
		$("#tDom").animate({width:'toggle'},350);
		
		if(countDom==3){
			$('#dealDom').prop('disabled',true);
		}

	});
	
	
	$('#dealCuori').click(function(){
		countCuori++;
		/**
		 * ESTRAI CUORI
		 * SETTA IL VALORE E L'IMMAGINE
		 * $.get(url, oggetti da inviare, funzione da eseguire in caso di successo)
		 * */
		$("#tarCuori").animate({width:'toggle'},350);
		$("#tarCuori").attr("src","../images/cardPlaceholder2.png");
		$("#tarCuori").animate({width:'toggle'},350);

		if(countCuori==3){
			$('#dealCuori').prop('disabled',true);
		}

	});

	$('#dealQuadri').click(function(){
		countQuadri++;
		/**
		 * ESTRAI QUADRI
		 * SETTA IL VALORE E L'IMMAGINE
		 * $.get(url, oggetti da inviare, funzione da eseguire in caso di successo)
		 * */
		$("#tarQuadri").animate({width:'toggle'},350);
		$("#tarQuadri").attr("src","../images/cardPlaceholder2.png");
		$("#tarQuadri").animate({width:'toggle'},350);
		
		if(countQuadri==3){
			$('#dealQuadri').prop('disabled',true);
		}

	});

	$('#dealFiori').click(function(){
		countFiori++;
		/**
		 * ESTRAI FIORI
		 * SETTA IL VALORE E L'IMMAGINE
		 * $.get(url, oggetti da inviare, funzione da eseguire in caso di successo)
		 * */
		$("#tarFiori").animate({width:'toggle'},350);
		$("#tarFiori").attr("src","../images/cardPlaceholder2.png");
		$("#tarFiori").animate({width:'toggle'},350);

		if(countFiori==3){
			$('#dealFiori').prop('disabled',true);
		}

	});

	$('#dealPicche').click(function(){
		countPicche++;
		/**
		 * ESTRAI PICCHE
		 * SETTA IL VALORE E L'IMMAGINE
		 * $.get(url, oggetti da inviare, funzione da eseguire in caso di successo)
		 * */		
		$("#tarPicche").animate({width:'toggle'},350);
		$("#tarPicche").attr("src","../images/cardPlaceholder2.png");
		$("#tarPicche").animate({width:'toggle'},350);

		if(countPicche==3){
			$('#dealPicche').prop('disabled',true);
		}

	});

});