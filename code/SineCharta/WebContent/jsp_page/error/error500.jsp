<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<meta charset="UTF-8">
<title>MANNAGGIA</title>
</head>
<body>
	<h3 class="card-title">OOPS! QUALCCOSA È ANDATO STORTO.</h3>

	<%
		if (session.getAttribute("user") == null) {
			%>
	<h3 class="card-title">
		Clicca <a href="../index.jsp">qui</a> per tornare alla pagina iniziale.
	</h3>


	<%
		} else {
		%>

	<h3 class="card-title">
		Clicca <a href="../homeUser.jsp">qui</a> per tornare alla tua pagina
		personale.
	</h3>
	<%
        }
        %>
</body>
</html>