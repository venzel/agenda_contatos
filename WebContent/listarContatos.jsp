<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE hmtl>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de contatos</title>
</head>
<body>
	<a href="/gerenciador/login.html">Sair</a>
	
	<h1>${usuario.nome}</h1>

	<h2>Lista de contatos</h2>
	
	<ul>
		<c:forEach items="${contatos}" var="contato">
			<li>
				<a href="/gerenciador/exibirContato?rg=${contato.rg}&usuarioEmail=${contato.usuario.email}">${contato.nome}</a> - 
				<a href="/gerenciador/exibirContato?rg=${contato.rg}&usuarioEmail=${contato.usuario.email}">exibir</a>
				<a href="/gerenciador/editarContato?rg=${contato.rg}&usuarioEmail=${contato.usuario.email}">editar</a>
				<a href="/gerenciador/deletarContato?rg=${contato.rg}&usuarioEmail=${contato.usuario.email}">deletar</a>
			</li>
		</c:forEach>
	</ul>
	
	<a href="/gerenciador/adicionarContato?usuarioEmail=${usuario.email}">Adicionar</a>
</body>
</html>