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
	<nav class="navbar navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="/home">TV Shows</a>
			<div class="navbar">
				<div class="navbar-nav">
					<ul>
						<li class="nav-item"><a href="login" class="nav-link">Login</a><li>						
					</ul>
				</div>
			</div>
		</div>
	</nav>
	<div class="container mt-5">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<form action="/registrarte" method="post">
					<h3 class="form-signin-heading">Ingrese datos</h3>
					<br/>
					<input type="text" id="username" name="username" placeholder="User name" class="form-control" />
					<br/> 
					<input type="email" id="email" name="email" placeholder="Email" class="form-control" /> 
					<br/> 
					<input type="password" placeholder="Password" id="password" name="password" class="form-control" /> 
					<br/>
					<input type="password" placeholder="Password confirmación" id="passwordConfirmation" name="passwordConfirmation" class="form-control" />					
					<br/>
					<input type="hidden" name="role" value="USER">
					<button class="btn btn-lg btn-dark" name="Submit" value="Login" type="Submit">Registrarse</button>
				</form>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
</body>
</html>

