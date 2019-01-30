function validate(){

$(document).ready(function(){	

	$.post('../GestioneMazzoServlet',{action: "mischiaTarocco"});

	
	var countDom=0;
	var countCuori=0;
	var countQuadri=0;
$(document).ready(function(){
			$('#dealQuadri').prop('disabled',false);
			$('#dealFiori').prop('disabled',false);
			$('#dealPicche').prop('disabled',false);
			$('#confermaPunti').prop('disabled',false);
			$('#confermaPunti').prop('disabled',false);
		}
	});

$(document).ready(function(){
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
$(document).ready(function(){
			
			console.log(data);
			data= data+$('#abiUso').val()+','+$('#totUso').text()+','+$('#abiPerc').val()+','+$('#totPerc').text()+','+$('#abiFurt').val()+','+$('#totFurt').text()+','+$('#abiUtil').val()+','+$('#totUtil').text()+','+$('#abiGuida').val()+','+$('#totGuida').text();
			$.get('../GestioneStoriaServlet',data);
			$.post('../GestioneStoriaServlet',data);
			
			
	});
$(document).ready(function(){
	$('#dealDom').click(function(){
		countDom++;

		$.get('../GestioneMazzoServlet', "estraiTarocco", function(responseText) {
		$.post('../GestioneMazzoServlet',{action: "estraiTarocco"}, function(responseText) {
			JTDom= responseText;
			TDom=JSON.parse(JTDom);

@@ $(document).ready(function(){
	$('#dealCuori').click(function(){
		countCuori++;

		$.get('../GestioneMazzoServlet', "estraiTarocco", function(responseText) {
		$.post('../GestioneMazzoServlet',{action: "estraiTarocco"}, function(responseText) {
			JTCuori= responseText;
			TCuori=JSON.parse(JTCuori);
			var rim= 3-countCuori;
$(document).ready(function(){
	$('#dealQuadri').click(function(){
		countQuadri++;

		$.get('../GestioneMazzoServlet', "estraiTarocco", function(responseText) {
		$.post('../GestioneMazzoServlet',{action: "estraiTarocco"}, function(responseText) {
			JTQuadri= responseText;
			TQuadri=JSON.parse(JTQuadri);
			var rim= 3-countQuadri;
$(document).ready(function(){
	$('#dealFiori').click(function(){
		countFiori++;

		$.get('../GestioneMazzoServlet', "estraiTarocco", function(responseText) {
		$.post('../GestioneMazzoServlet',{action: "estraiTarocco"}, function(responseText) {
			JTFiori= responseText;
			TFiori=JSON.parse(JTFiori);
			var rim= 3-countFiori;
$(document).ready(function(){
	$('#dealPicche').click(function(){
		countPicche++;

		$.get('../GestioneMazzoServlet', "estraiTarocco", function(responseText) {
		$.post('../GestioneMazzoServlet',{action: "estraiTarocco"}, function(responseText) {
			JTPicche= responseText;
			TPicche=JSON.parse(JTPicche);
			var rim= 3-countPicche;
$(document).ready(function(){

	$('.minusAbi').click(function(){

		var tag= $(this).next();
		var currValue= parseInt(tag.val(), 10);
		var caratteristica= parseInt($(this).prev().text(),10);
		var tot=0;
		var input= $(this).next();
		var currValue= parseInt(input.val(), 10);
		var totLabel= $(this).parent().next().children();
		var currTot= parseInt(totLabel.text(),10);
		
		if(currValue==1);
		else{
			currValue -=1;
			tag.val(currValue--);
	/***************/
			currTot -=1;
			input.val(currValue--);
			totLabel.text(currTot);
			puntiAbi +=1;
			$('#abiRimasti').text(puntiAbi);
			
		}
	});

$(document).ready(function(){

	$('.plusAbi').click(function(){

		var tag= $(this).prev();
		var currValue= parseInt(tag.val(), 10);

		if(puntiAbi==0||currValue==5);
		var input= $(this).prev();
		var currValue= parseInt(input.val(), 10);
		var totLabel= $(this).parent().next().children();
		var currTot= parseInt(totLabel.text(),10);
		
		if(currValue==4||puntiAbi==0);
		else{
			currValue +=1;
			tag.val(currValue++);
			currTot +=1;
			input.val(currValue++);
			totLabel.text(currTot);
			puntiAbi -=1;
			$('#abiRimasti').text(puntiAbi);
			
		}
	});
