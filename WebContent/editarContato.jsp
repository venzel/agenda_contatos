<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/alterarContato" var="linkServletAlterarContato" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar contato</title>
</head>
<body>

	<a href="/gerenciador/login.html">Sair</a>
	
	<h1>Editar contato</h1>

	<h2>${contato.nome}</h2>
	
	<form action="${linkServletAlterarContato}" method="post">
		Nome: <input type="text" name="nome" value="${contato.nome}" /><br /><br />
		RG: <input type="text" name="rg" value="${contato.rg}" /><br /><br />
		CPF: <input type="text" name="cpf" value="${contato.cpf}" /><br /><br />
		<input type="hidden" name="contatoId" value="${contato.id}">
		<input type="hidden" name="usuarioId" value="${contato.usuario.id}">
		<input type="submit" value="Alterar" />
	</form>
</body>
</html>