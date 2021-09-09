<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/alterarUsuario" var="linkServletAlterarUsuario" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>Alterar usuario</title>
</head>
<body>
	<div class="form-fundo">
		<form action="${linkServletAlterarUsuario}" method="post">
			Nome: <input type="text" name="nome" value="${usuario.nome}" /><br /><br />
			<input type="hidden" name="email" value="${usuario.email}">
			<input type="submit" value="Alterar" class="Botao2"/>
		</form>
	</div>
</body>
</html>