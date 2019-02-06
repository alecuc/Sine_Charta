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

	$.post('../GestioneMazzoServlet',{action: "mischiaTarocco"});

	/*
	 * Qui vengono inizializzati:
	 *  i contatori per il numero di estrazioni
	 * 	i punteggi delle caratteristiche
	 *  gli oggetti temporanei per la gestione delle estrazioni
	 * */

	var countDom=0;
	var countCuori=0;
	var countQuadri=0;
	var countFiori=0;
	var countPicche=0;

	var puntiCuori=0;
	var puntiQuadri=0;
	var puntiFiori=0;
	var puntiPicche=0;
	var puntiAbi=0;

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

	
	/*
	 * Questa funzione disattiva il form delle generalità e attiva quello per l'estrazione del tarocco dominante
	 * */
	
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

	/*
	 * Questa funzione disattiva la sezione per il tarocco dominante e attiva quella per l'estrazione delle caratteristiche
	 * */
	
	$('#confDom').click(function(){

		if(countDom==0){
			alert("Devi estrarre un tarocco dominante!");
		} else{

			$(this).prop('disabled',true);
			$('#dealDom').prop('disabled',true);
			$('#dealCuori').prop('disabled',false);
			$('#dealQuadri').prop('disabled',false);
			$('#dealFiori').prop('disabled',false);
			$('#dealPicche').prop('disabled',false);
			$('#confermaPunti').prop('disabled',false);
		}
	});

	/*
	 * Questa funzione disattiva la sezione dell'estrazione delle caratteristiche ed attiva quella per la distribuzione dei punteggi 
	 * */
	
	$('#confermaPunti').click(function(){

		if(countCuori==0||countQuadri==0||countFiori==0||countPicche==0){
			alert("Devi estrarre almeno una carta per seme!");
		}else{

			$(this).prop('disabled',true);
			$('#dealCuori').prop('disabled',true);
			$('#dealQuadri').prop('disabled',true);
			$('#dealFiori').prop('disabled',true);
			$('#dealPicche').prop('disabled',true);
			$('#setCar').prop('disabled',false);
			$('#confCar').prop('disabled',false);

			puntiAbi= Math.floor((parseInt(puntiCuori,10)+parseInt(puntiQuadri,10)+parseInt(puntiFiori,10)+parseInt(puntiPicche,10))/4);
			puntiCuori -=4;
			puntiQuadri -=4;
			puntiFiori -=4;
			puntiPicche -=4;

			$('#abiRimasti').text(" "+puntiAbi);
			$('#cuoriRimasti').text(" "+puntiCuori);
			$('#quadriRimasti').text(" "+puntiQuadri);
			$('#fioriRimasti').text(" "+puntiFiori);
			$('#piccheRimasti').text(" "+puntiPicche);
		};
	});

	/*
	 * Questa funzione disabilita la sezione per distribuire i punti caratteristica e attiva quella per la scelta delle abilità
	 * */
	
	$('#confCar').click(function(){
		if(puntiCuori!=0 || puntiQuadri!=0 || puntiFiori!=0 || puntiPicche!=0){
			alert("Inserisci i punti caratteristica rimasti! Il tuo pg potrebbe essere più forte!");
		} else{
			$(this).prop('disabled',true);
			$('#setCar').prop('disabled',true);
			$('#setAbi').prop('disabled',false);
			$('#completa').prop('disabled',false);
			$('#carUso').text($('#mir').val());
			$('#carPerc').text($('#per').val());
			$('#carFurt').text($('#des').val());
			$('#carUtil').text($('#int').val());
			$('#carGuida').text($('#des').val());
			$('#totUso').text(parseInt($('#mir').val(),10)+1);
			$('#totPerc').text(parseInt($('#per').val(),10)+1);
			$('#totFurt').text(parseInt($('#des').val(),10)+1);
			$('#totUtil').text(parseInt($('#int').val(),10)+1);
			$('#totGuida').text(parseInt($('#des').val(),10)+1);
			puntiAbi-=5;
		}

	});


	/*
	 * Questa funzione finalizza la creazione del personaggio, eseguendo una richiesta asincrona alla servlet
	 * e mandando in input alla servlet tutti i dati in un'unica stringa
	 * */
	
	$('#completa').click(function(){
		if (puntiAbi!=0){
			alert("Inserisci i punti abilità rimasti! Il tuo pg potrebbe essere più bravo a fare queste cose!")
			return false;
		} else

			var data= $('#nomePG').val() + ',' + $('#cognomePG').val() + ',' + $('#etaPG').val() + ',' + $('#nazionalitaPG').val() + ',' + $('#domName').text()+',';

		data = data+$('#int').val()+','+$('#asp').val()+','+$('#coo').val()+','+$('#aff').val()+','+$('#mem').val()+','+$('#com').val()+','+$('#des').val()+','+$('#ddm').val()+','+$('#per').val()+','+$('#cre').val()+','+$('#for').val()+','+$('#eqm').val()+','+$('#vol').val()+','+$('#soc').val()+','+$('#mir').val()+','+$('#kar').val()+',';

		data= data+$('#abiUso').val()+','+$('#totUso').text()+','+$('#abiPerc').val()+','+$('#totPerc').text()+','+$('#abiFurt').val()+','+$('#totFurt').text()+','+$('#abiUtil').val()+','+$('#totUtil').text()+','+$('#abiGuida').val()+','+$('#totGuida').text();
		console.log(data);

		
		//QUESTA FUNZIONE FA IL REDIRECT AL RIEPILOGO DOPO AVER COMPLETATO LA CREAZIONE DEL PG E SALVATAGGIO IN DB
		
		$.ajax({
			  type: "POST",
			  url: '../GestioneStoriaServlet',
			  data: {dati: data, action: "inserisciPg"},
			  success: function(){
				  //QUESTA PARTE È NECESSARIA PER IL REDIRECT, POICHÉ AJAX ESEGUE OPERAZIONI SU THREAD SECONDARI
					window.location.assign("riepilogoPG.jsp");
				}
			});

	});



	/*
	 * Questa funzione invia una richiesta asincrona alla servlet che estrae il tarocco dominante
	 * */


	$('#dealDom').click(function(){
		countDom++;

		$.post('../GestioneMazzoServlet',{action: "estraiTarocco"}, function(responseText) {
			JTDom= responseText;
			TDom=JSON.parse(JTDom);

			domDesc= TDom.descrizioneDominante;
			var n= TDom.numero;
			$('#domName').text(TDom.nome);
			$('#numDom').text(" "+3-countDom)
			$("#domDesc").text(TDom.descrizioneDominante);
			$("#tDom").animate({width:'toggle'},350, function(){
				$("#tDom").attr("src","../images/TaroccoNum_"+n+".png");
			});
			$("#tDom").animate({width:'toggle'},350);
		});


		if(countDom==3){
			$('#dealDom').prop('disabled',true);
		}

	});

	/*
	 * Questa funzione invia una richiesta asincrona alla servlet che estrae il tarocco per le caratteristiche CUORI
	 * */
	
	$('#dealCuori').click(function(){
		countCuori++;

		$.post('../GestioneMazzoServlet',{action: "estraiTarocco"}, function(responseText) {
			JTCuori= responseText;
			TCuori=JSON.parse(JTCuori);
			var rim= 3-countCuori;
			var n= TCuori.numero;
			puntiCuori= TCuori.valoreCuori;
			$('#valCuori').text(" "+puntiCuori);
			$('#numCuori').text("Numero estrazioni rimaste: "+ rim);
			$("#tarCuori").animate({width:'toggle'},350, function(){
				$("#tarCuori").attr("src","../images/TaroccoNum_"+n+".png");
			});
			$("#tarCuori").animate({width:'toggle'},350);
		});


		if(countCuori==3){
			$('#dealCuori').prop('disabled',true);
		}

	});

	/*
	 * Questa funzione invia una richiesta asincrona alla servlet che estrae il tarocco per le caratteristiche QUADRI
	 * */
	
	$('#dealQuadri').click(function(){
		countQuadri++;

		$.post('../GestioneMazzoServlet',{action: "estraiTarocco"}, function(responseText) {
			JTQuadri= responseText;
			TQuadri=JSON.parse(JTQuadri);
			var rim= 3-countQuadri;
			var n= TQuadri.numero;
			puntiQuadri= TQuadri.valoreQuadri;
			$('#valQuadri').text(" "+puntiQuadri);
			$('#numQuadri').text("Numero estrazioni rimaste: "+ rim);
			$("#tarQuadri").animate({width:'toggle'},350, function(){
				$("#tarQuadri").attr("src","../images/TaroccoNum_"+n+".png");
			});
			$("#tarQuadri").animate({width:'toggle'},350);
		});

		if(countQuadri==3){
			$('#dealQuadri').prop('disabled',true);
		}

	});

	/*
	 * Questa funzione invia una richiesta asincrona alla servlet che estrae il tarocco per le caratteristiche FIORI
	 * */
	
	$('#dealFiori').click(function(){
		countFiori++;

		$.post('../GestioneMazzoServlet',{action: "estraiTarocco"}, function(responseText) {
			JTFiori= responseText;
			TFiori=JSON.parse(JTFiori);
			var rim= 3-countFiori;
			var n= TFiori.numero;
			puntiFiori= TFiori.valoreFiori;
			$('#valFiori').text(" "+puntiFiori);
			$('#numFiori').text("Numero estrazioni rimaste: "+ rim);
			$("#tarFiori").animate({width:'toggle'},350, function(){
				$("#tarFiori").attr("src","../images/TaroccoNum_"+n+".png");
			});
			$("#tarFiori").animate({width:'toggle'},350);
		});

		if(countFiori==3){
			$('#dealFiori').prop('disabled',true);
		}

	});

	/*
	 * Questa funzione invia una richiesta asincrona alla servlet che estrae il tarocco per le caratteristiche PICCHE
	 * */
	
	$('#dealPicche').click(function(){
		countPicche++;

		$.post('../GestioneMazzoServlet',{action: "estraiTarocco"}, function(responseText) {
			JTPicche= responseText;
			TPicche=JSON.parse(JTPicche);
			var rim= 3-countPicche;
			var n= TPicche.numero;
			puntiPicche= TPicche.valorePicche;
			$('#valPicche').text(" "+puntiPicche);
			$('#numPicche').text("Numero estrazioni rimaste: "+ rim);
			$("#tarPicche").animate({width:'toggle'},350, function(){
				$("#tarPicche").attr("src","../images/TaroccoNum_"+n+".png");
			});
			$("#tarPicche").animate({width:'toggle'},350);
		});

		if(countPicche==3){
			$('#dealPicche').prop('disabled',true);
		}

	});

	/*
	 * Le due funzioni successive permettono di distribuire i punti delle caratteristiche CUORI
	 * */

	$('.minusCuori').click(function(){

		var tag= $(this).next();
		var currValue= parseInt(tag.val(), 10);

		if(currValue==1);
		else{
			currValue -=1;
			tag.val(currValue--);
			console.log(currValue);
			puntiCuori +=1;
			$('#cuoriRimasti').text(puntiCuori);
		}
	});


	$('.plusCuori').click(function(){

		var tag= $(this).prev();
		var currValue= parseInt(tag.val(), 10);

		if(puntiCuori==0||currValue==6);
		else{
			currValue +=1;
			tag.val(currValue++);
			puntiCuori -=1;
			$('#cuoriRimasti').text(puntiCuori);
		}
	});

	/*
	 * Le due funzioni successive permettono di distribuire i punti delle caratteristiche QUADRI
	 * */
	
	$('.minusQuadri').click(function(){

		var tag= $(this).next();
		var currValue= parseInt(tag.val(), 10);

		if(currValue==1);
		else{
			currValue -=1;
			tag.val(currValue--);
			puntiQuadri +=1;
			$('#quadriRimasti').text(puntiQuadri);
		}
	});



	$('.plusQuadri').click(function(){

		var tag= $(this).prev();
		var currValue= parseInt(tag.val(), 10);

		if(puntiQuadri==0||currValue==6);
		else{
			currValue +=1;
			tag.val(currValue++);
			puntiQuadri -=1;
			$('#quadriRimasti').text(puntiQuadri);
		}
	});

	/*
	 * Le due funzioni successive permettono di distribuire i punti delle caratteristiche FIORI
	 * */
	
	$('.minusFiori').click(function(){

		var tag= $(this).next();
		var currValue= parseInt(tag.val(), 10);

		if(currValue==1);
		else{
			currValue -=1;
			tag.val(currValue--);
			puntiFiori +=1;
			$('#fioriRimasti').text(puntiFiori);
		}
	});



	$('.plusFiori').click(function(){

		var tag= $(this).prev();
		var currValue= parseInt(tag.val(), 10);

		if(puntiFiori==0||currValue==6);
		else{
			currValue +=1;
			tag.val(currValue++);
			puntiFiori -=1;
			$('#fioriRimasti').text(puntiFiori);
		}
	});

	/*
	 * Le due funzioni successive permettono di distribuire i punti delle caratteristiche PICCHE
	 * */
	
	$('.minusPicche').click(function(){

		var tag= $(this).next();
		var currValue= parseInt(tag.val(), 10);

		if(currValue==1);
		else{
			currValue -=1;
			tag.val(currValue--);
			puntiPicche +=1;
			$('#piccheRimasti').text(puntiPicche);
		}
	});



	$('.plusPicche').click(function(){

		var tag= $(this).prev();
		var currValue= parseInt(tag.val(), 10);

		if(puntiPicche==0||currValue==6);
		else{
			currValue +=1;
			tag.val(currValue++);
			puntiPicche -=1;
			$('#piccheRimasti').text(puntiPicche);
		}
	});

	/*
	 * Le due funzioni successive permettono di distribuire i punti abilità
	 * */
	
	$('.minusAbi').click(function(){

		var input= $(this).next();
		var currValue= parseInt(input.val(), 10);
		var totLabel= $(this).parent().next().children();
		var currTot= parseInt(totLabel.text(),10);

		if(currValue==1);
		else{
			currValue -=1;
			currTot -=1;
			input.val(currValue--);
			totLabel.text(currTot);
			puntiAbi +=1;
			$('#abiRimasti').text(puntiAbi);

		}
	});



	$('.plusAbi').click(function(){

		var input= $(this).prev();
		var currValue= parseInt(input.val(), 10);
		var totLabel= $(this).parent().next().children();
		var currTot= parseInt(totLabel.text(),10);

		if(currValue==4||puntiAbi==0);
		else{
			currValue +=1;
			currTot +=1;
			input.val(currValue++);
			totLabel.text(currTot);
			puntiAbi -=1;
			$('#abiRimasti').text(puntiAbi);

		}
	});

});

$(window).bind('beforeunload', function(){
	  return 'Attenzione: ogni operazione non sarà salvata. Sei sicuro di voler uscire?';
	});