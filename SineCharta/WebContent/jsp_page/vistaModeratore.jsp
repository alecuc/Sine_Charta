<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Il tuo personaggio</title>
<jsp:include page="head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="navigationbar.jsp"></jsp:include>
	<%@page import="beans.User"%>
	<%@page import="beans.Personaggio"%>
	<%@page import="beans.Abilita"%>
	<%@page import="java.util.Collection"%>
	<%
		
		/*	if ((session.getAttribute("user") == null)||session.getAttribute("personaggio")==null) {
				response.sendRedirect("error/error.jsp");
			}
			else{
				pg= (Personaggio)session.getAttribute("personaggio");	
			}//*/
	%>

	<nav>
		<ul class="nav flex-column float-right mt-5">
			<li class="nav-item"><button class="btn btn-dark my-5 ml-2"
					style="transform: rotate(90deg)" id="pgbutton">PG</button></li>
			<li class="nav-item"><button class="btn btn-dark my-5"
					style="transform: rotate(90deg)" id="mazzibutton">Mazzi</button></li>
			<li class="nav-item"><button class="btn btn-dark my-5"
					style="transform: rotate(90deg)" id="guidabutton">Guida</button></li>
		</ul>
	</nav>


	<div class="container card" id="sessione">
		<div class="row">
			<!-- QUI DESCRIZIONE SESSIONE ECCETERA -->
		</div>
	</div>

	

	<div class="container card" id="mazzi">
		<div class="row">

			<div class="col-6">
					<h3>ARCANI MAGGIORI</h3>
				<div class="row">
					<img src="../images/cardBack.png" id="mazzo" class="img-responsive mx-3">
					<img src="../images/cardBack.png" id="tDom" class="img-responsive">
				</div>
				<div class="row">
					<button class="btn btn-dark my-2 mx-5"
						style="background-color: #212529; border-color: red;" id="dealMaj">Estrai</button>
					<br>
					<button class="btn btn-dark"
						style="background-color: #212529; border-color: red;" id="shuffMaj">Mischia</button>
				</div>
			</div>
			<div class="col-6">
					<h3>ARCANI MINORI</h3>
				<div class="row">
					<img src="../images/cardBack.png" id="mazzo" class="img-responsive mx-3">
					<img src="../images/cardBack.png" id="tDom" class="img-responsive">
				</div>
				<div class="row">
					<button class="btn btn-dark my-2 mx-5"
						style="background-color: #212529; border-color: red;" id="deanMin">Estrai</button>
					<br>
					<button class="btn btn-dark"
						style="background-color: #212529; border-color: red;" id="shuffleMin">Mischia</button>
				</div>
			</div>


		</div>
	</div>
	
	
	<div class="container card" id="guida">
		
		<div class="row">
		
			<div class="col-6 card">
			<h4>Nome tarocco 1</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			<div class="col-6 card">
			<h4>Nome tarocco 2</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			
		</div>
		<div class="row">
		
			<div class="col-6 card">
			<h4>Nome tarocco 3</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			<div class="col-6 card">
			<h4>Nome tarocco 4</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			
		</div>
		<div class="row">
		
			<div class="col-6 card">
			<h4>Nome tarocco 5</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			<div class="col-6 card">
			<h4>Nome tarocco 6</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			
		</div>
		<div class="row">
		
			<div class="col-6 card">
			<h4>Nome tarocco 7</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			<div class="col-6 card">
			<h4>Nome tarocco 8</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			
		</div>
		<div class="row">
		
			<div class="col-6 card">
			<h4>Nome tarocco 9</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			<div class="col-6 card">
			<h4>Nome tarocco 10</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			
		</div>
		<div class="row">
		
			<div class="col-6 card">
			<h4>Nome tarocco 11</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			<div class="col-6 card">
			<h4>Nome tarocco 12</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			
		</div>
		
		<div class="row">
		
			<div class="col-6 card">
			<h4>Nome tarocco 13</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			<div class="col-6 card">
			<h4>Nome tarocco 14</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			
		</div>
	
	
	<div class="row">
		
			<div class="col-6 card">
			<h4>Nome tarocco 15</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			<div class="col-6 card">
			<h4>Nome tarocco 16</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			
		</div>
		
		<div class="row">
		
			<div class="col-6 card">
			<h4>Nome tarocco 17</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			<div class="col-6 card">
			<h4>Nome tarocco 18</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			
		</div>
		
		<div class="row">
		
			<div class="col-6 card">
			<h4>Nome tarocco 19</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			<div class="col-6 card">
			<h4>Nome tarocco 20</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			
		</div>
		
		<div class="row">
		
			<div class="col-6 card">
			<h4>Nome tarocco 21</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			<div class="col-6 card">
			<h4>Nome tarocco 0</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor 
			incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
			 exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
			</div>
			
		</div>
	</div>


</body>
</html>