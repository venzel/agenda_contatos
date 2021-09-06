<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE hmtl>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de usuarios</title>
</head>
<body>
	Listar:
	<br />
	<ul>
		<c:forEach items="${usuarios}" var="usuario">
			<li>
				${usuario.nome} - 
				<a href="/gerenciador/exibirUsuario?email=${usuario.email}">exibir</a>
				<a href="/gerenciador/deletarUsuario?email=${usuario.email}">deletar</a>
			</li>
		</c:forEach>
	</ul>
	
	<a href="/gerenciador/adicionarUsuario.html">Adicionar</a>
</body>
</html>