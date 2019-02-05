
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

	<%@page import="beans.User"%>

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="homeUser.jsp">Profilo</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="bacheca.jsp">Bacheca</a></li>
			<li class="nav-item"><a class="nav-link" href="iTuoiInviti.jsp">Inviti</a></li>
			<%
			if (session.getAttribute("user")==null) response.sendRedirect("error/error.jsp");
			else{
				User user= (User) session.getAttribute("user");
				if(user.getRuolo().equalsIgnoreCase("utenteModeratore")){%>
			
			<li class="nav-item"><a class="nav-link" href="leTueStorie.jsp">Le tue
					storie</a></li>
			<%} else {%>
			<li class="nav-item"><a class="nav-link" href="leTueStorie.jsp">Diventa un
					moderatore</a></li>

			<%}} %>
		</ul>
	</div>
	<form action="../LogoutServlet" method="post">
		<button type="submit" id="logout" class="btn-dark btn"
			onclick="return confirm('Sei sicuro di voler ettettuare il logout?');">Logout</button>
	</form>
</nav>