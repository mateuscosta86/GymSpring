<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>

<html>

<head>
	<title>GymSpring - Area do Instrutor</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>GymSpring - Area do Instrutor</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Cadastrar Treino</h3>
	
		<form:form action="cadastrarTreino" modelAttribute="exercicio" method="POST">
											
			<table>
				<tbody>
					<tr>
						<td><label>Nome:</label></td>
						<td><form:input path="nome" /></td>
					</tr>
				
					<tr>
						<td><label>Séries:</label></td>
						<td><form:input path="series" /></td>
					</tr>

					<tr>
						<td><label>Repetições:</label></td>
						<td><form:input path="repeticoes" /></td>
					</tr>
					
					<tr>
						<td><label>Tempo:</label></td>
						<td><form:input path="tempo" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Adicionar" class="save" /></td>
					</tr>
				
				</tbody>
			</table>		
		</form:form>
		<div style="clear; both;"></div>
		
		<div id="content">
		
			<!-- put new button: Add Customer 
		
			<input type="button" value="Cadastrar Aluno"
				   onclick="window.location.href='cadastrarAluno'; return false;"
				   class="add-button"
			/>
			-->					
			<table>
				<tr>
					<th>Nome</th>
					<th>Séries</th>
					<th>Repetições</th>
					<th>Tempo</th>
					<th>Ação</th>					
				</tr>
				
				<c:forEach var="exerc" items="${exercicios}" varStatus="iterator">
				
				<c:url var="deleteLink" value="/instrutor/apagarExercicio">
						<c:param name="exercicioIndex" value="${iterator.index}" />
				</c:url>
								
				<tr>
					<td> ${exerc.nome} </td>
					<td> ${exerc.series} </td>
					<td> ${exerc.repeticoes} </td>
					<td> ${exerc.tempo}</td>
					<td> <a href="${deleteLink}"
							   onclick="if (!(confirm('Tem certeza que quer apagar este registro?'))) return false">Apagar</a> </td>
					
				</tr>
				</c:forEach>	
														
			</table>
			<c:url var="saveLink" value="salvarTreino">
						<c:param name="alunoId" value="${alunoId}" />
						<c:param name="treinoId" value="${treinoId}" />
			</c:url>
			<input type="button" value="Salvar Treino"
				   onclick="window.location.href='${saveLink}'; return false;"
				   class="add-button"
			/>
		</div>
	
	</div>
	

</body>

</html>









