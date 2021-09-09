<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE hmtl>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/style.css">
<title>Exibir contato</title>
</head>
<body>
	<a href="/gerenciador/login.html" class="Botao1">Sair</a>
	
	<div class="form-fundo">
	<h1>${contato.usuario.nome}</h1>
		<hr>
		
		<a href="/gerenciador/contatos?usuarioId=${contato.usuario.id}" class="Botao1">Voltar para agenda</a>
		
		<h2>${contato.nome}</h2>
	
		<h2>Pessoais</h2>
		
		<div>
			<p><strong>Nome:</strong> ${contato.nome}</p>
			<p><strong>RG:</strong> ${contato.rg}</p>
			<p><strong>CPF:</strong> ${contato.cpf}</p>
		</div>
		
		<h2>Enderecos</h2>
		
		<div>
		<c:forEach items="${contato.enderecos}" var="endereco">
			<div>
				${endereco.rua} - ${endereco.numero}<br />
				${endereco.cep}, ${endereco.cidade}, ${endereco.estado}<br />
				<a href="/gerenciador/deletarEndereco?contatoId=${contato.id}&usuarioId=${contato.usuario.id}&enderecoId=${endereco.id}">deletar</a>
			</div><br />
		</c:forEach>
		</div>
		
		<hr>
	
	<a href="/gerenciador/adicionarEndereco?contatoId=${contato.id}&usuarioId=${contato.usuario.id}" class="Botao2">Adicionar endereco</a>
	</div>
</body>
</html>