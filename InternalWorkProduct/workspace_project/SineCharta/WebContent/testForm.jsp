<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<meta name="description" content="Progetto TSW sito F1">
<meta name="author" content="Francesco Pasquale Raffaele">
<link rel="stylesheet" href="responsive.css">
<link rel="shortcut icon" type="image/x-icon" href="images/icon.png" />
<title>REGISTRAZIONE</title>

</head>
<body>


	<h1>Registration Form</h1>
	<div class="ex">
		<form action="UsersCotrol" method="post">
			<input type="hidden" name="action" value="register">
			<table style="with: 50%">
				<tr>
					<td>Nickname</td>
					<td><input type="text" required="required" name="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" required="required" name="password" /></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" required="required" name="name" /></td>
				</tr>
				<tr>
					<td>Surname</td>
					<td><input type="text" required="required" name="surname" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" required="required" name="email" /></td>
				</tr>
			</table>
			<input type="submit" value="Register" />
		</form>
		<br>
	</div>
	
</body>
</html>