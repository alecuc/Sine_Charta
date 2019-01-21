<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<footer class="card-footer">
  <div class="row fluid" style="text-align: center;">
    <div class="col" style="background-color:#212529;"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#aboutModal" style="background-color: #212529; border-color: #212529;">
  		  About</button></div>
    <div class="col" style="background-color: #212529;"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#helpModal" style="background-color: #212529; border-color: #212529;">
  		  Help</button></div>
    <div class="col" style="background-color: #212529;"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#faqModal" style="background-color: #212529; border-color: #212529;">
  		  FAQ</button></div>
 </div>

</footer>

<div class="modal" id="aboutModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title"><b>About</b></h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
      <!-- Modal body -->
      <div class="modal-body">
        <p>Progetto sviluppato per il corso di Ingegneria del Software.</p>
        <p>A cura di: </p>
        <ul>
        	<li>Vitiello Raffaele</li>
        	<li>Cuccurullo Alessio</li>
        	<li>Giuliano Francesco</li>
        </ul>
      </div>
      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<div class="modal" id="helpModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title"><b>Help</b></h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
      <!-- Modal body -->
      <div class="modal-body">
        <p>Contattaci:		<a href="mailto:SineCharta@mail.com?subject=Oggetto%20del%20messaggio">Invia una mail!!</a></p>
      </div>
      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

<div class="modal" id="faqModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title"><b>FAQ</b></h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
      <!-- Modal body -->
      <div class="modal-body">
    		<div class="container">
			  <div id="accordion">
			    <div class="card">
			      <div class="card-header">
			        <a class="card-link" data-toggle="collapse" href="#collapseOne" style="color: red;">
			          Che cos'è Sine Charta?
			        </a>
			      </div>
			      <div id="collapseOne" class="collapse" data-parent="#accordion">
			        <div class="card-body">
			        <p><em>Sine Charta</em> è un'applicazione web per la gestione virtuale di <em>Sine Requie</em> Sine Requie è un gioco di ruolo horror italiano, scritto da Matteo Cortini e Leonardo Moretti e pubblicato nel 2003 nella sua prima edizione da RosePoison. La seconda edizione è stata prodotta da Asterion Press prende il nome di Sine Requie Anno XIII. </p>
			        </div>
			      </div>
			    </div>
			    <div class="card">
			      <div class="card-header">
			        <a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo" style="color: red;">
			        Come funziona Sine Charta?
			      </a>
			      </div>
			      <div id="collapseTwo" class="collapse" data-parent="#accordion">
			        <div class="card-body">
			          Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
			        </div>
			      </div>
			    </div>
			    <div class="card">
			      <div class="card-header">
			        <a class="collapsed card-link" data-toggle="collapse" href="#collapseThree" style="color: red;">
			          A chi è rivolto?
			        </a>
			      </div>
			      <div id="collapseThree" class="collapse" data-parent="#accordion">
			        <div class="card-body">
			          Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
			        </div>
			      </div>
			    </div>
			  </div>
			</div>
      </div>
      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>