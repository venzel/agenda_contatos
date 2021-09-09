<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE hmtl>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/style.css">
<title>Lista de usuarios</title>
</head>
<body>
	<div class="form-fundo">
		Listar:
		<br />
		<ul>
			<c:forEach items="${usuarios}" var="usuario">
				<li>
					${usuario.nome} - 
					<a href="/gerenciador/editarUsuario?usuarioId=${usuario.id}">editar</a>
					<a href="/gerenciador/deletarUsuario?usuarioId=${usuario.id}">deletar</a>
				</li>
			</c:forEach>
		</ul>
	
	<a href="/gerenciador/adicionarUsuario.html" class="Botao2">Adicionar</a>
	</div>
</body>
</html>