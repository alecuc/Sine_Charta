<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="head.jsp"></jsp:include>


</head>
<body>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">

		<a class="navbar-brand" href="index.jsp">Home</a>
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
			<button type="submit" id="logout" class="btn-dark btn">Logout</button>
		</form>
	</nav>

</body>
</html>