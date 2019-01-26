$(document).ready(function(){	


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