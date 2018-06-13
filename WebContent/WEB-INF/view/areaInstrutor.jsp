<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>GymSpring - Area do Instrutor</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>GymSpring - Acompanhamento de Alunos</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
					
			<input type="button" value="Cadastrar Aluno"
				   onclick="window.location.href='cadastrarAluno'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nome</th>
					<th>Sobrenome</th>
					<th>CPF</th>
					<th>Ação</th>
				</tr>
				
				
				<c:forEach var="aluno" items="${alunos}">
				
					
					<c:url var="addWorkoutLink" value="/instrutor/mostrarListaTreinos">
						<c:param name="alunoId" value="${aluno.id}" />
					</c:url>
					
					
					<c:url var="updateLink" value="/aluno/atualizarAluno">
						<c:param name="alunoId" value="${aluno.id}" />
					</c:url>					

					
					<c:url var="deleteLink" value="/aluno/apagarAluno">
						<c:param name="alunoId" value="${aluno.id}" />
					</c:url>					
					
					<tr>
						<td> ${aluno.nome} </td>
						<td> ${aluno.sobrenome} </td>
						<td> ${aluno.cpf} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${addWorkoutLink}">Treinos</a>
							|
							<a href="${updateLink}">Editar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Tem certeza que quer apagar este registro?'))) return false">Apagar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
			<p>
				<a href="${pageContext.request.contextPath}/fazerLogout">Fazer Logout.</a>
			</p>
				
		</div>
	
	</div>
	

</body>

</html>









