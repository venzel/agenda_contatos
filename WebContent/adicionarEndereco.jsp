<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/cadastrarEndereco" var="linkServletCadastrarEndereco" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar contato</title>
</head>
<body>
	<a href="/gerenciador/login.html">Sair</a>

	<h1>${contato.usuario.nome}</h1>
	
	<a href="/gerenciador/contatos?usuarioId=${contato.usuario.id}">Agenda de contatos</a>
	
	<hr>
	
	<h2>Adicionar contato</h2>
	
	<form action="${linkServletCadastrarEndereco}" method="post">
		Rua: <input type="text" name="rua" value="Rua Pedro I" /><br />
		Numero: <input type="text" name="numero" value="212" /><br />
		Complemento: <input type="text" name="complemento" value="S/R" /><br />
		Bairro: <input type="text" name="bairro" value="Prata" /><br />
		CEP: <input type="text" name="cep" value="5832212"/><br />
		Cidade: <input type="text" name="cidade" value="Campina Grande" /><br />
		Estado: <input type="text" name="estado" value="PB" /><br />
		
		<input type="hidden" name="contatoId" value="${contato.id}">
		<input type="hidden" name="usuarioId" value="${contato.usuario.id}">
		
		<input type="submit" value="Cadastrar" />
	</form>
	
</body>
</html>