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
								<td>${caballero.arma_id}</td>
								<td>${caballero.escudo_id}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
</body>
</html>