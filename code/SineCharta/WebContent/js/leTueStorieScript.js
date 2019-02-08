$(document).ready(function(){
	
	$('.sTable').click(function(){
		
		var storia= $(this).attr('id');
		var desc=""
		
		$.post('../GestioneStoriaServlet', {action:"caricaStoria", id:storia}, function(responseText) {

			desc= responseText;
			
		});

		$.post('../GestioneStoriaServlet', {action:"caricaPG", id:storia}, function(responseText) {
			
			$('#desc').text(desc + "\n" + responseText);
			
		});
	});
});