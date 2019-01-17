<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>

	<div class="col mx-auto">
			<h5 class="card-title text-center">Registrati</h5>
			<form method="post" action="../RegistrazioneServlet"
				name="formRegistration">
				<input type="hidden" name="action" value="register">
				<div class="row">
					<div class="col-md-6">
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 field-label-responsive">
						<label for="username">Username:</label>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<div class="input-group mb-2 mr-sm-2 mb-sm-0">
								<div class="input-group-addon" style="width: 2.6rem">
									<i class="fa fa-user"></i>
								</div>
								<input type="text" name="username" class="form-control"
									id="username" placeholder="Username" required autofocus>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 field-label-responsive">
						<label for="name">Nome:</label>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<div class="input-group mb-2 mr-sm-2 mb-sm-0">
								<div class="input-group-addon" style="width: 2.6rem">
									<i class="fa fa-user"></i>
								</div>
								<input type="text" name="name" class="form-control" id="name"
									placeholder="Nome" required autofocus>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 field-label-responsive">
						<label for="surname">Cognome:</label>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<div class="input-group mb-2 mr-sm-2 mb-sm-0">
								<div class="input-group-addon" style="width: 2.6rem">
									<i class="fa fa-at"></i>
								</div>
								<input type="text" name="surname" class="form-control"
									id="surname" placeholder="Cognome" required autofocus>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 field-label-responsive">
						<label for="email">Indirizzo e-mail:</label>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<div class="input-group mb-2 mr-sm-2 mb-sm-0">
								<div class="input-group-addon" style="width: 2.6rem">
									<i class="fa fa-at"></i>
								</div>
								<input type="text" name="email" class="form-control" id="email"
									placeholder="e-mail" required autofocus>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 field-label-responsive">
						<label for="password">Password:</label>
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
					<div class="col-md-4 field-label-responsive">
						<label for="password">Conferma password:</label>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<div class="input-group mb-2 mr-sm-2 mb-sm-0">
								<div class="input-group-addon" style="width: 2.6rem">
									<i class="fa fa-repeat"></i>
								</div>
								<input type="password" name="passConfirm" class="form-control"
									id="passConfirm" placeholder="Conferma password" required>
							</div>
						</div>
					</div>
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-success" value="Register"
						onclick="return validateRegistration(this.form)">
						<i class="fa fa-user-plus"></i> Registrati
					</button>
				</div>
			</form>
		</div>


</body>