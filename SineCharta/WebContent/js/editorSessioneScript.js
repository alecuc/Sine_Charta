$(document).ready(function(){	

	console.log("loading v0.1");
	
	$('#salvaSessione').click(function(){
		
		var tagCont= $('#contenuto');
		var cont= tagCont.val();

		var value= '../GestioneSessioneServlet?action=inserisciSessione&Contenuto='+cont;

		$('#form').attr('action', value);

	});
	

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