
	<div class="col mx-auto">
				<h5 class="card-title text-center">Login</h5>
				<form class="form-signin" method="post" action="../LoginServlet">
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
										id="us" placeholder="Username" required autofocus>
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
										id="pwd" placeholder="Password" required>
								</div>
							</div>
						</div>
					</div>
					<div class="custom-control custom-checkbox mb-3">
						<input type="checkbox" class="custom-control-input"
							id="customCheck1"> <label class="custom-control-label"
							for="customCheck1">Ricordami</label>
					</div>
					<div class="text-center">
					<button type="submit" class="btn btn-success"
						style="background-color: #212529; border-color: red;">Login</button>
					</div>
				</form>
				 
			</div>