<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.edutecno.model.Show"%>
<%@page import="com.edutecno.model.Users"%>
<%@page import="com.edutecno.model.Rating"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="charset=ISO-8859-1">
<script src="/webjars/jquery/jquery.min.js"></script>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>TV Shows</title>
</head>
<body>
	<!-- Inicio navbar -->
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="/user">TV Shows</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarNav">
	      <ul class="navbar-nav ms-auto">	        
	        <li class="nav-item">
	          <a href="agregar" class="nav-link">Agregar Show</a>
	        </li>
	        <li class="nav-item">
			  <a class="nav-link" href="/logout">Logout</a>
	        </li>	       
	      </ul>
	    </div>
	  </div>
	</nav>	
	<!-- Fin navbar -->
	<!-- Inicio Contenido -->
	<div class="p-3">
		<!-- Inicio Mensajes -->
		<c:if test="${mensaje != null ? true : false}">
			<div class="alert alert-secondary alert-dismissible fade show" role="alert">${mensaje}
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:if>
		<!-- Fin Mensajes -->
		<div class="my-3">
			<h3>T?tulo: ${show.showTitle}</h3>
			<h4>Network: ${show.showNetwork}</h4>
			<p>Usuarios quienes clasificaron este show</p>
		</div>
		<!-- Inicio Tabla -->
		<div class="container-fluid">
			<table border="1" class="table table-dark table-striped">
				<thead class="thead-dark">
					<tr class="text-center">						
						<th class="col-2 align-middle" scope="col">Email</th>
						<th class="col-2 align-middle" scope="col">Rating</th>						
					</tr>
				</thead>
				<tbody class="text-center">
					<c:forEach items="${ratings}" var="u">
						<tr>							
							<td>${u.user.email}</td>
							<td>${u.rating}</td>							
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="col-2">
				<form action="/clasificar" method="post">
					<label class="form-label">Dejar un rating: </label>
					<input type="number" class="form-control" name="rating" id="rating">
					<button class="btn btn-dark my-3" name="Submit" type="Submit">Clasificar</button>				
				</form>
				<a href="/user" class="btn btn-dark my-3">Volver</a>
			</div>
		</div>		
		<!-- Fin tabla -->
	</div>
	<!-- Fin Contenido -->
	<!-- footer -->
	<footer
		class="container-fluid text-center bg-dark text-white py-2">
		<h1>Sistema IMDb</h1>
		<a href="" class="text-white">web site developed by Popopo <i class="far fa-registered"></i>
		</a>
	</footer>
</body>
</html>