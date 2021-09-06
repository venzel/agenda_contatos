<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/cadastrarContato" var="linkServletCadastrarContato" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar contato</title>
</head>
<body>
	<a href="/gerenciador/login.html">Sair</a>

	<h1>Adicionar contato</h1>
	
	<h2>${usuario.nome}</h2>
	
	<form action="${linkServletCadastrarContato}" method="post">
		Nome: <input type="text" name="nome" /><br />
		RG: <input type="text" name="rg" /><br />
		CPF: <input type="text" name="cpf" /><br />
		<hr>
		<h3>Endereco</h3>
		Rua: <input type="text" name="rua" /><br />
		Numero: <input type="text" name="numero" /><br />
		Complemento: <input type="text" name="complemento" /><br />
		Bairro: <input type="text" name="bairro" /><br />
		CEP: <input type="text" name="cep" /><br />
		Cidade: <input type="text" name="cidade" /><br />
		Estado: <input type="text" name="estado" /><br />
		<input type="hidden" name="usuarioEmail" value="${usuario.email}">
		<input type="submit" value="Cadastrar" />
	</form>
</body>
</html>