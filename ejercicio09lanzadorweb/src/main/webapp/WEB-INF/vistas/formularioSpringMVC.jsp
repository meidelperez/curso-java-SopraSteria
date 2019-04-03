<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aulas del edificio!!!!!</title>
</head>
<body>
	<h1>Bienvenidos a Spring MVC</h1>
	<form action="aulas">
		Nombre del Aula: <input type="text" name="nombreAula"/><br/>
		Nombre del Alumno: <input type="text" name="nombreAlumno"/><br/>
		<input type="submit" value="Asignar alumno al aula y si no existe el aula, creala y asigna el alumno!">
	</form>
</body>
</html>