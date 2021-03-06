<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE hmtl>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/style.css">
<title>Agenda de contatos</title>
</head>
<body>
	<a href="/gerenciador/login.html" class="Botao1">Sair</a>

	<div class="form-fundo">
	<h1>${usuario.nome}</h1>
	
		<h2>Agenda de contatos</h2>
		
		<ul>
			<c:forEach items="${contatos}" var="contato">
				<li>
					${contato.nome} - 
					<a href="/gerenciador/exibirContato?contatoId=${contato.id}&usuarioId=${contato.usuario.id}">exibir</a>
					
					<a href="/gerenciador/editarContato?contatoId=${contato.id}&usuarioId=${contato.usuario.id}">editar</a>
					
					<a href="/gerenciador/deletarContato?contatoId=${contato.id}&usuarioId=${contato.usuario.id}">deletar</a>
				</li>
			</c:forEach>
		</ul>
	<a href="/gerenciador/cadastrarContato?usuarioId=${usuario.id}" class="Botao2">Adicionar</a>
	</div>
</body>
</html>