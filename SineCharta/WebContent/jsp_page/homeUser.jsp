<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="head.jsp"></jsp:include>
<title>Personal Page</title>
</head>
<body>


<div class="jumbotron text-center" style="margin-bottom:auto; background-color: white;">
<img alt="logo" src="../images/logo_principal.png" style="width: 15rem;">
</div>

<jsp:include page="navigationbar.jsp"></jsp:include>

<div class="container" style="margin-top:30px">
  <div class="row">
    <div class="col-sm-4">
      <h2><%=session.getAttribute("username")%></h2>
      <%
		if (session.getAttribute("username") == null) {
			response.sendRedirect("error.jsp");
		}
	%>
      <h5>Photo of me:</h5>
      <div class="fakeimg"><img src="../images/mini_logo.jpg" style="width: 50%;">
      </div>
      <p>Informazioni giocatore.</p>
      <h3>Some Links</h3>
      <p>Lorem ipsum dolor sit ame...</p>
      <ul class="nav nav-pills flex-column">
        <li class="nav-item">
          <a class="nav-link active" href="#">Informazioni</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Modifica credenziali</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="creazionePG.jsp">Crea pg (provvisorio)</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#">Disabled</a>
        </li>
      </ul>
      <hr class="d-sm-none">
    </div>
       
    <div class="col-sm-8">
   	 <div class ="container">
    	  <h2>Lista delle storie attive</h2>
    		<table class ="table table-bordered">
    			<thead>
    				<tr>
    					<th>Storie </th>
    					<th>Gioca</th>
    				</tr>
    		    </thead>
    	   		 <tbody>
    	    		<tr>
    	    			<td>Storia 1 - Pg1</td>
    	    			<td><button type="submit" class ="btn btn-primary">Gioca </button></td>
    	    			</tr>
    	    		<tr>
    	    			<td>Storia 2 - Pg2</td>
    	    			<td>Gioca</td>
    	    		</tr>
    	    	</tbody>	
    		</table>
    	</div>
    </div>
    
</div>
</div>
<div class="jumbotron text-center" style="margin-bottom:0;">
  <p>Sine Charta Project</p>
</div>


</body>
</html>