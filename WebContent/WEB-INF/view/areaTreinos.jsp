<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>GymSpring - Area de Treinos</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>GymSpring - Área de Treinos</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<c:url var="createLink" value="/instrutor/cadastrarTreino">
						<c:param name="alunoId" value="${aluno.id}" />						
			</c:url>
				
			<input type="button" value="Cadastrar Treino"
				   onclick="window.location.href='${createLink}'; return false;"
				   class="add-button"
			/>
					
					
			<table>
				<tr>
					<th>Nome</th>
					<th>Sobrenome</th>
					<th>CPF</th>					
				</tr>
					
				<tr>
					<td> ${aluno.nome} </td>
					<td> ${aluno.sobrenome} </td>
					<td> ${aluno.cpf} </td>
					
				</tr>										
			</table>
			
			<table>
				<tr>
					<th>ID</th>
					<th>Data de Criação</th>
					<th>Ações</th>					
				</tr>
				
				<c:forEach var="treino" items="${aluno.treinos}">
				
				<c:url var="updateLink" value="/instrutor/gerenciarTreino">
						<c:param name="alunoId" value="${aluno.id}" />
						<c:param name="treinoId" value="${treino.id}" />
				</c:url>
				<c:url var="deleteLink" value="/instrutor/apagarTreino">
						<c:param name="alunoId" value="${aluno.id}" />
						<c:param name="treinoId" value="${treino.id}" />
				</c:url>
					
				<tr>
					<td> ${treino.id} </td>
					<td> ${treino.dataCriacao} </td>
					<td><!-- display the update link -->
						<a href="${updateLink}">Gerenciar</a>
						|
						<a href="${deleteLink}"
					    	onclick="if (!(confirm('Tem certeza que quer apagar este treino?'))) return false">Apagar</a>
					</td>
					
				</tr>
				</c:forEach>	
														
			</table>
			
			<div style="clear; both;"></div>
		
			<p>
				<a href="${pageContext.request.contextPath}/instrutor/relacaoAlunos">Voltar para a relacação de alunos.</a>
			</p>
					
		</div>
	
	</div>
	

</body>

</html>









