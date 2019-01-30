	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="homeUser.jsp">Profilo</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Bacheca</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Inviti</a></li>
			</ul>
		</div>
		<form action="../LogoutServlet" method="post">
			<button type="submit" id="logout" class="btn-dark btn" onclick="return confirm('Sei sicuro di voler ettettuare il logout?');">Logout</button>
		</form>
	</nav>