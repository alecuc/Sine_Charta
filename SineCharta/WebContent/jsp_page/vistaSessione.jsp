<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="navigationbar.jsp"></jsp:include>
<title>Sessione</title>
</head>
<body>
	
	<%-- <%
		if (session.getAttribute("user") == null) {
			response.sendRedirect("error/error.jsp");
		}
	%> --%>
	<h1 class ="card-title text-center" >Storia x - Sessione 1</h1>
	
	<div class = "" style = "float:right">
		<ul class="nav sticky-top flex-column nav-pills" >
  			<li class="nav-item">
   				 <a class="nav-link active" href="#">Active</a>
  					</li>
 			 <li class="nav-item">
    			<a class="nav-link" href="#">Link</a>
  			</li>
  			<li class="nav-item">
    			<a class="nav-link" href="#">Link</a>
  			</li>
  			<li class="nav-item">
    			<a class="nav-link disabled" href="#">Disabled</a>
  			</li>
		</ul>		
	</div>
	<div class = "container">
			<div class ="row">
				<div class = "col-8">
					<div class = "card">
					<h4><p>
					Lorem ipsum dolor sit amet, consectetur adipisci elit, 
					sed eiusmod tempor incidunt ut labore et dolore magna aliqua. 
					Ut enim ad minim veniam, quis nostrum exercitationem ullam c
					orporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur.
					 Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu
					  fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, 
					  sunt in culpa qui officia deserunt mollit anim id est laborum</p>
					</h4>
					</div>
					<form class ="form-inline" action ="/EditorSessioneServlet">
						<button type="submit" class ="btn btn-dark"> Modifica</button>
					</form>
				</div>
				<div class = "col-3">
					<div class = "card">
					<h4>
					<p id = "kwDescrizione">Clicca su una keyword per mostrarne la descrizione</p>
					</h4>
					</div>
				</div>
			</div>
		</div>
		
	

</body>
</html>