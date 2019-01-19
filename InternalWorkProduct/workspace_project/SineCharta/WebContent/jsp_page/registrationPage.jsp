<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<title>Registrazione</title>
</head>



<body>

	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<a href="index.jsp" style="color: red;"> <img alt="home"
					src="../images/mini_logo.jpg" style="width: 25%; margin: 5%;">HOME
				</a>
			</div>
			<div class="col-sm-4">
				<img src="../images/logo-scritta.png" class="rounded" alt="logo"
					style="width: 95%; margin-left: 5rem;">
			</div>
		</div>
		<form class="form-horizontal" method="post"
			action="../RegistrazioneServlet"
			style="border: 1px solid red; padding: 3%; border-radius: 1%"
			name="formRegistration">
			<input type="hidden" name="action" value="register">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<h2 style="text-align: center;">
						<b>Register New User</b>
					</h2>
					<hr>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="username">Username:</label>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<div class="input-group mb-2 mr-sm-2 mb-sm-0">
							<div class="input-group-addon" style="width: 2.6rem">
								<i class="fa fa-user"></i>
							</div>
							<input type="text" name="username" class="form-control"
								id="username" placeholder="your username" required autofocus>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="name">Name:</label>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<div class="input-group mb-2 mr-sm-2 mb-sm-0">
							<div class="input-group-addon" style="width: 2.6rem">
								<i class="fa fa-user"></i>
							</div>
							<input type="text" name="name" class="form-control" id="name"
								placeholder="your name" required autofocus>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="surname">Surname:</label>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<div class="input-group mb-2 mr-sm-2 mb-sm-0">
							<div class="input-group-addon" style="width: 2.6rem">
								<i class="fa fa-at"></i>
							</div>
							<input type="text" name="surname" class="form-control"
								id="surname" placeholder="your surname" required autofocus>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="email">Email address:</label>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<div class="input-group mb-2 mr-sm-2 mb-sm-0">
							<div class="input-group-addon" style="width: 2.6rem">
								<i class="fa fa-at"></i>
							</div>
							<input type="text" name="email" class="form-control" id="email"
								placeholder="your Email address" required autofocus>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="password">Password</label>
				</div>
				<div class="col-md-6">
					<div class="form-group has-danger">
						<div class="input-group mb-2 mr-sm-2 mb-sm-0">
							<div class="input-group-addon" style="width: 2.6rem">
								<i class="fa fa-key"></i>
							</div>
							<input type="password" name="password" class="form-control"
								id="password" placeholder="Password" required>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3 field-label-responsive">
					<label for="password">Confirm Password</label>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<div class="input-group mb-2 mr-sm-2 mb-sm-0">
							<div class="input-group-addon" style="width: 2.6rem">
								<i class="fa fa-repeat"></i>
							</div>
							<input type="password" name="passConfirm"
								class="form-control" id="passConfirm"
								placeholder="Password" required>
						</div>
					</div>
				</div>
			</div>
			<div class="text-center">
				<button type="submit" class="btn btn-success" value="Register"
					onclick="return validateRegistration(this.form)">
					<i class="fa fa-user-plus"></i> Register
				</button>
			</div>
		</form>
	</div>


</body>
</html>