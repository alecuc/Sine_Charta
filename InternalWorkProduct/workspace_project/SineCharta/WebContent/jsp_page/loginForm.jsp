<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="../css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Sign In</h5>
            <form class="form-signin">
              <div class="form-label-group" style="padding: 5px;">
                <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
               
              </div>

              <div class="form-label-group" style="padding: 5px;">
                <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
                
              </div>

              <div class="custom-control custom-checkbox mb-3">
                <input type="checkbox" class="custom-control-input" id="customCheck1">
                <label class="custom-control-label" for="customCheck1">Remember password</label>
              </div>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" style="background-color: #212529; border-color: red;">Sign in</button>             
              </form> 
              <a href="#">Registrati</a>   
              <br>
              <a href="homeUser.jsp">pagina utente (link provvisorio)</a>         
          </div>
        </div>
      </div>
    </div>
  </div>

</body>
</html>