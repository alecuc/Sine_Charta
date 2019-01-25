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
	
	var int=1, mem=1, per=1, vol=1, asp=1, com=1, cre=1, soc=1, coo=1, des=1, ffi=1, mir=1, aff=1, ddm=1, eqm=1, kar=1;

	var countDom=0;
	var countCuori=0;
	var countQuadri=0;
	var countFiori=0;
	var countPicche=0;

	var puntiCuori=0;
	var puntiQuadri=0;
	var puntiFiori=0;
	var puntiPicche=0;

	var TDom=		{descrizioneDominante:""};
	var TCuori=		{valoreCuori:""};
	var TQuadri=	{valoreQuadri:""};
	var TFiori=		{valoreFiori:""};
	var TPicche=	{valorePicche:""};

	var JTDom=		'{"nome":"", "numero":"", "descrizioneDominante":"", "valoreCuori":"", "valoreQuadri":"", "valoreFiori":"", "valorePicche":""}';
	var	JTCuori=	'{"nome":"", "numero":"", "valoreCuori":"", "valoreQuadri":"", "valoreFiori":"", "valorePicche":""}'
	var JTQuadri=	'{"nome":"", "numero":"", "valoreCuori":"", "valoreQuadri":"", "valoreFiori":"", "valorePicche":""}';
	var JTFiori=	'{"nome":"", "numero":"", "valoreCuori":"", "valoreQuadri":"", "valoreFiori":"", "valorePicche":""}';
	var JTPicche=	'{"nome":"", "numero":"", "valoreCuori":"", "valoreQuadri":"", "valoreFiori":"", "valorePicche":""}';

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
		$('#confermaPunti').prop('disabled',false);
	});


	$('#confermaPunti').click(function(){
		$(this).prop('disabled',true);
		$('#dealCuori').prop('disabled',true);
		$('#dealQuadri').prop('disabled',true);
		$('#dealFiori').prop('disabled',true);
		$('#dealPicche').prop('disabled',true);
		$('#setCar').prop('disabled',false);
		$('#confCar').prop('disabled',false);

		$('#cuoriRimasti').text(" "+puntiCuori);
		$('#quadriRimasti').text(" "+puntiQuadri);
		$('#fioriRimasti').text(" "+puntiFiori);
		$('#piccheRimasti').text(" "+puntiPicche);			

	});

	$('#confCar').click(function(){
		$(this).prop('disabled',true);
		$('#setCar').prop('disabled',true);
		$('#setAbi').prop('disabled',false);
		$('#completa').prop('disabled',false);
	});




	$('#dealDom').click(function(){
		countDom++;

		$.get('../EstraiCreazione', function(responseText) {
			JTDom= responseText;
			TDom=JSON.parse(JTDom);

			domDesc= TDom.descrizioneDominante;
			var n= TDom.numero;
			$('#domName').text(TDom.nome);
			$('#numDom').text(" "+3-countDom)
			$("#domDesc").text(TDom.descrizioneDominante);
			$("#tDom").animate({width:'toggle'},350);
			$("#tDom").attr("src","../images/TaroccoNum_"+n+".png");
			$("#tDom").animate({width:'toggle'},350);
		});


		if(countDom==3){
			$('#dealDom').prop('disabled',true);
		}

	});


	$('#dealCuori').click(function(){
		countCuori++;

		$.get('../EstraiCreazione', function(responseText) {
			JTCuori= responseText;
			TCuori=JSON.parse(JTCuori);
			var rim= 3-countCuori;
			var n= TCuori.numero;
			puntiCuori= TCuori.valoreCuori;
			$('#valCuori').text(" "+puntiCuori);
			$('#numCuori').text("Numero estrazioni rimaste: "+ rim);
			$("#tarCuori").animate({width:'toggle'},350);
			$("#tarCuori").attr("src","../images/TaroccoNum_"+n+".png");
			$("#tarCuori").animate({width:'toggle'},350);
		});


		if(countCuori==3){
			$('#dealCuori').prop('disabled',true);
		}

	});

	$('#dealQuadri').click(function(){
		countQuadri++;

		$.get('../EstraiCreazione', function(responseText) {
			JTQuadri= responseText;
			TQuadri=JSON.parse(JTQuadri);
			var rim= 3-countQuadri;
			var n= TQuadri.numero;
			puntiQuadri= TQuadri.valoreQuadri;
			$('#valQuadri').text(" "+puntiQuadri);
			$('#numQuadri').text("Numero estrazioni rimaste: "+ rim);
			$("#tarQuadri").animate({width:'toggle'},350);
			$("#tarQuadri").attr("src","../images/TaroccoNum_"+n+".png");
			$("#tarQuadri").animate({width:'toggle'},350);
		});

		if(countQuadri==3){
			$('#dealQuadri').prop('disabled',true);
		}

	});

	$('#dealFiori').click(function(){
		countFiori++;

		$.get('../EstraiCreazione', function(responseText) {
			JTFiori= responseText;
			TFiori=JSON.parse(JTFiori);
			var rim= 3-countFiori;
			var n= TFiori.numero;
			puntiFiori= TFiori.valoreFiori;
			$('#valFiori').text(" "+puntiFiori);
			$('#numFiori').text("Numero estrazioni rimaste: "+ rim);
			$("#tarFiori").animate({width:'toggle'},350);
			$("#tarFiori").attr("src","../images/TaroccoNum_"+n+".png");
			$("#tarFiori").animate({width:'toggle'},350);
		});

		if(countFiori==3){
			$('#dealFiori').prop('disabled',true);
		}

	});

	$('#dealPicche').click(function(){
		countPicche++;

		$.get('../EstraiCreazione', function(responseText) {
			JTPicche= responseText;
			TPicche=JSON.parse(JTPicche);
			var rim= 3-countPicche;
			var n= TPicche.numero;
			puntiPicche= TPicche.valorePicche;
			$('#valPicche').text(" "+puntiPicche);			
			$('#numPicche').text("Numero estrazioni rimaste: "+ rim);
			$("#tarPicche").animate({width:'toggle'},350);
			$("#tarPicche").attr("src","../images/TaroccoNum_"+n+".png");
			$("#tarPicche").animate({width:'toggle'},350);
		});

		if(countPicche==3){
			$('#dealPicche').prop('disabled',true);
		}

	});

	$('.setCuori').change(function(){
		var currCuori=puntiCuori;

		var currInt= parseInt($('#int').val(), 10);
		var currMem= parseInt($('#mem').val(), 10);
		var currPer= parseInt($('#per').val(), 10);
		var currVol= parseInt($('#vol').val(), 10);

		
		
		$('#cuoriRimasti').text(puntiCuori);	
	});








});