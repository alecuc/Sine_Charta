$(document).ready(function(){
	
	$('.sTable').click(function(){
		
		var storia= $(this).attr('id');
		$.post('../GestioneStoriaServlet', {action:"caricaStoria", id:storia}, function(responseText) {

			$('#desc').text(responseText);
		});
		
		
		
		
	});
	
	
});