<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aulas o Edificio</title>
</head>
<body>
	Aula: ${aula.nombre} - ${aula.tienePizarra}
	<br /> Alumno: ${persona.nombre} 
	<br />
	<%-- Puesto: ${puesto.mesa} - ${puesto.persona}<br/> --%>
	<%-- Session: ${mensajeSession.nombre} - ${mensajeSession.descripcion}<br/> --%>

</body>
</html>