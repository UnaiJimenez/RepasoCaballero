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
	<div class="formulario" style="margin-top: 5%; margin-left: 35%;">
        <form class="row g-3 col-6" action= "InsertarCaballero" method="post" style="background-color: #bebebe; border-radius: 2%;">
            <div class="col-12">
				<label for="Nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" name="nombre" placeholder="Nombre">
            </div>
            <div class="col-12">
                <label for="Fuerza" class="form-label">Fuerza</label>
                <input type="text" class="form-control" name="fuerza" placeholder="Fuerza">
            </div>
            <div class="col-12">
				<label for="Experiencia" class="form-label">Experiencia</label>
                <input type="text" class="form-control" name="experiencia" placeholder="Experiencia">
            </div>
            <div class="col-12">
                <label for="Foto" class="form-label">Foto</label>
                <input type="text" class="form-control" name="foto" placeholder="Foto">
            </div>
            <div class="col-12" style="margin-top: 5%">
             	<p style="margin-bottom: 0.5rem">Selecciona el arma</p>
				<select class="form-select" aria-label="arma_id" name="arma_id">
					<option selected></option>
					<c:forEach items="${armas}" var="arma">
						<option value="${arma.id}">${arma.id} - ${arma.nombre}</option>
					</c:forEach>
				</select>
			</div>
             <div class="col-12" style="margin-top: 5%">
             	<p style="margin-bottom: 0.5rem">Selecciona el escudo</p>
				<select class="form-select" aria-label="escudo_id" name="escudo_id">
					<option selected></option>
					<c:forEach items="${escudos}" var="escudo">
						<option value="${escudo.id}">${escudo.id} - ${escudo.nombre}</option>
					</c:forEach>
				</select>
			</div>
			<div style="margin: 2%">
   				<form action="InsertarCaballero" method="post" style="margin: 2%">
    				<input type="hidden" name="id" value="${caballero.id}"/>
    				<button type="submit" class="btn" style="background-color: blue; color: white; margin: 2%;">Confirmar</button>
    				<input type="hidden" name="Confirmacion" value="insertar">
				</form>
			</div>
		</form>
    </div> 
</body>
</html>