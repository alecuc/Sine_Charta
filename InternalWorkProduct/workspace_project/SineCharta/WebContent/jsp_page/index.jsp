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
<script src="../js/validation_registrazione.js"></script>
<title>Sine Charta</title>
</head>
<body>
	<div class="jumbotron text-center"
		style="margin-bottom: auto; background-color: white;">
		<img alt="logo" src="../images/logo_principal.png"
			style="width: 15rem;">
	</div>

	<div>
      <div class="container-fluid bg-cont card">
        <div class="row">
          <div class="col-sm-6">
             <jsp:include page="loginForm.jsp"></jsp:include>

          </div>

        <div class="col-sm-6">
          <jsp:include page="registrationForm.jsp"></jsp:include>
        <br><br>
        </div>
        
      </div>
     </div>
          	<jsp:include page="footer.jsp"></jsp:include>
     
        </div>


  </body>
	
	
	
	
</body>
</html>