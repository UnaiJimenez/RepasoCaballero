<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${nombreNoOk == true}">
		<div class="alert alert-danger">
			<p>No se ha insertado (rellena el nombre)</p>
		</div>
	</c:if>
	<c:if test="${nombreRepetido == true}">
		<div class="alert alert-danger">
			<p>No se ha insertado (nombre repetido)</p>
		</div>
	</c:if>
	<c:if test="${armaEscudoNull == true}">
		<div class="alert alert-danger">
			<p>No se ha insertado (arma y escudo no pueden estar vacios)</p>
		</div>
	</c:if>
	<c:if test="${insertarOk == true}">
		<div class="alert alert-success">
			<p>Se ha insertado correctamente</p>
		</div>
	</c:if>
	<a href="InsertarCaballero" style="background-color: lightgrey; text-decoration: none; color: green; margin-left: 10px">INSERTAR CABALLEROS</a>
	<table class="table table-responsive table-striped">
					<thead>
						<tr>
							<th scope="col">Caballero</th>
							<th scope="col">Nombre</th>
							<th scope="col">Fuerza</th>
							<th scope="col">Experiencia</th>
							<th scope="col">Foto</th>
							<th scope="col">Id Arma</th>
							<th scope="col">Id Escudo</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${caballeros}" var="caballero">
							<tr>
								<td id="${caballero.id}">${caballero.id}</td>
								<td>${caballero.nombre}</td>
								<td>${caballero.fuerza}</td>
								<td>${caballero.experiencia}</td>
								<td>${caballero.foto}</td>
								<td>${caballero.arma.id}</td>
								<td>${caballero.escudo.id}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
</body>
</html>