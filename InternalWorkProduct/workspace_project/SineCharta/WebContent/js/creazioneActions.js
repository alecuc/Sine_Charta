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
		$(this).prop('disabled',true);
		$('#dealDom').prop('disabled',true);
		$('#dealCuori').prop('disabled',false);
		$('#dealQuadri').prop('disabled',false);
		$('#dealFiori').prop('disabled',false);
		$('#dealPicche').prop('disabled',false);
		$('#confCar').prop('disabled',false);
	});

	$('#confCar').click(function(){
		$(this).prop('disabled',true);
		$('#dealCuori').prop('disabled',true);
		$('#dealQuadri').prop('disabled',true);
		$('#dealFiori').prop('disabled',true);
		$('#dealPicche').prop('disabled',true);
		$('#setCar').prop('disabled',false);
	});

	
	var countDom=1;
	var countCuori=1;
	var countQuadri=1;
	var countFiori=1;
	var countPicche=1;
	
	$('#dealDom').click(function(){
		countDom++;
		/**
		 * ESTRAI TAROCCO DOMINANTE
		 * 
		 * */

		if(countDom==3){
			$('#dealDom').prop('disabled',true);
		}

	});

	$('#dealCuori').click(function(){
		countCuori++;
		/**
		 * ESTRAI CUORI
		 * 
		 * */

		if(countCuori==3){
			$('#dealCuori').prop('disabled',true);
		}

	});

	$('#dealQuadri').click(function(){
		countQuadri++;
		/**
		 * ESTRAI QUADRI
		 * 
		 * */

		if(countQuadri==3){
			$('#dealQuadri').prop('disabled',true);
		}

	});

	$('#dealFiori').click(function(){
		countFiori++;
		/**
		 * ESTRAI FIORI
		 * 
		 * */

		if(countFiori==3){
			$('#dealFiori').prop('disabled',true);
		}

	});

	$('#dealPicche').click(function(){
		countPicche++;
		/**
		 * ESTRAI PICCHE
		 * 
		 * */

		if(countPicche==3){
			$('#dealPicche').prop('disabled',true);
		}

	});

});