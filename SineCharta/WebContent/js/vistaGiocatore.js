$(document).ready(function(){
	
	var tarocchiRimasti=22;
	var pokerRimaste= 52;
	
	var pgbool=true;
	var mazzibool=false;
	var guidabool=false;
	var JTDom=		'{"nome":"", "numero":"", "descrizione":"", "descrizioneDominante":"", "valoreCuori":"", "valoreQuadri":"", "valoreFiori":"", "valorePicche":""}';
	var TDom=		{descrizioneDominante:""};

	
	$('#mazzi').toggle();
	$('#guida').toggle();
	
	
	$('#pgbutton').click(function(){
		if(!pgbool){
			pgbool=true;
			$('#pg').fadeToggle();

			
			if (!mazzibool);
			else {
				mazzibool=false;
				$('#mazzi').fadeToggle();
			}
			
			if(!guidabool);
			else {
				guidabool=false;
				$('#guida').fadeToggle();
			}
			
		}
		else;
	});
	
	$('#mazzibutton').click(function(){
		if(!mazzibool){
			mazzibool=true;
			$('#mazzi').fadeToggle();
			
			if (!pgbool);
			else {
				pgbool=false;
				$('#pg').fadeToggle();
			}
			
			if(!guidabool);
			else {
				guidabool=false;
				$('#guida').fadeToggle();
			}
			
		} else;
	});

	$('#guidabutton').click(function(){
		if(!guidabool){
			guidabool=true;
			$('#guida').fadeToggle();

			
			if (!mazzibool);
			else {
				mazzibool=false;
				$('#mazzi').fadeToggle();
			}
			
			if(!pgbool);
			else {
				pgbool=false;
				$('#pg').fadeToggle();
			}
			
		}
		else;
	});
	
	$('#dealMaj').click(function(){

		if(tarocchiRimasti==0) alert("Il mazzo dei tarocchi è finito. Devi mischiarlo prima di poter pescare di nuovo.");
		else{

			$.get('../GestioneMazzoServlet', {action:"estraiTarocco"}, function(responseText) {

				JTDom= responseText;
				TDom=JSON.parse(JTDom);

				var n= TDom.numero;
				$('#taroccoEstratto').text(TDom.nome);
				$("#desc").text(TDom.descrizione);
				$("#tMaj").animate({width:'toggle'},350,function(){
					$("#tMaj").attr("src","../images/TaroccoNum_"+n+".png");				
				});
				$("#tMaj").animate({width:'toggle'},350);
			});
			tarocchiRimasti -=1;
		}
		
	});
	
	
	$('#shuffMaj').click(function(){


		$.get('../GestioneMazzoServlet',{action: "mischiaTarocco"}, function(responseText) {
			
			$("#tMaj").animate({width:'toggle'},350,function(){
				$("#tMaj").attr("src","../images/cardBack.png");				
			});
			$("#tMaj").animate({width:'toggle'},350);
		});

		tarocchiRimasti=22;
		
	});
	
	
	
	$('#dealMin').click(function(){

		if(tarocchiRimasti==0) alert("Il mazzo da poker è finito. Devi mischiarlo prima di poter pescare di nuovo.");
		else{

			$.get('../GestioneMazzoServlet',{action: "estraiPoker"}, function(responseText) {


				$('#minoreEstratto').text(TDom.nome);
				$("#pokerEstratta").text(responseText);
				$("#tMin").animate({width:'toggle'},350,function(){
					$("#tMin").attr("src","../images/cardBack.png");				
				});
				$("#tMin").animate({width:'toggle'},350);
			});
			pokerRimaste -=1;
		}
		
	});
	
	
	$('#shuffleMin').click(function(){


		$.get('../GestioneMazzoServlet',{action: "mischiaPoker"}, function(responseText) {
			
			$("#tMin").animate({width:'toggle'},350,function(){
				$("#tMin").attr("src","../images/cardBack.png");				
			});
			$("#tMin").animate({width:'toggle'},350);
		});

		pokerRimaste=52;
	});

});
