<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
	<title>Iniciar Sesión</title>
	<!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">TV Shows</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarNav">
	      <ul class="navbar-nav ms-auto">	        
	        <li class="nav-item">
			  <a href="/registrarse" class="nav-link">Registrarse</a>
	        </li>	       
	      </ul>
	    </div>
	  </div>
	</nav>	
	<div class="container mt-5">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<form action="/login" method="POST">
					<h3 class="form-signin-heading">Credenciales</h3>
					<br/> 
					<input type="email" id="email" name="email" placeholder="User" class="form-control" /> 
					<br/> 
					<input type="password" placeholder="Password" id="password" name="password" class="form-control" /> 
					<br/>					
					<c:if test="${not empty param.error}">
						<div class="alert alert-danger">
							<strong>Error! credenciales no encontradas</strong>
						</div>
					</c:if>						
					<button class="btn btn-dark" name="Submit" value="Login" type="Submit">Login
					</button>
				</form>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
</body>
</html>

