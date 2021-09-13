<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/cadastrarContato" var="linkServletCadastrarContato" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>Cadastrar contato</title>
</head>
<body>
	<a href="/gerenciador/login.html" class="Botao1">Sair</a>
	
	<div class="form-fundo">
	<h1>${usuario.nome}</h1>
	
	<a href="/gerenciador/contatos?usuarioId=${usuario.id}" class="Botao1">Agenda de contatos</a>
	
	<hr>
		<h2>Adicionar contato</h2>
		
		<form action="${linkServletCadastrarContato}" method="post">
		
			<h2>Pessoais</h2>
		
			Nome: <input type="text" name="nome" value="Matheus Lima" /><br />
			RG: <input type="text" name="rg" value="2124202" /><br />
			CPF: <input type="text" name="cpf" value="53232159210" /><br />
			
			<h2>Endereco</h2>
			
			Rua: <input type="text" name="rua" value="Rua Filomeno Dutra" /><br />
			Numero: <input type="text" name="numero" value="412" /><br />
			Complemento: <input type="text" name="complemento" value="S/R" /><br />
			Bairro: <input type="text" name="bairro" value="Centro" /><br />
			CEP: <input type="text" name="cep" value="5835121"/><br />
			Cidade: <input type="text" name="cidade" value="Sao Paulo" /><br />
			Estado: <input type="text" name="estado" value="SP" /><br />
			
			<input type="hidden" name="usuarioId" value="${usuario.id}">
			<input type="submit" value="Cadastrar" class="Botao2"/>
		</form>
	</div>
	
</body>
</html>