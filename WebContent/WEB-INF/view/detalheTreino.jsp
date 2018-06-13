<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>GymSpring - Area do Aluno</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>GymSpring - Area do Aluno</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
				
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
					<th>Nome</th>
					<th>Séries</th>
					<th>Repetições</th>
					<th>Tempo</th>					
				</tr>
				
				<c:forEach var="exercicio" items="${treino.exercicios}">
												
				<tr>
					<td> ${exercicio.nome} </td>
					<td> ${exercicio.series} </td>
					<td> ${exercicio.repeticoes} </td>
					<td> ${exercicio.tempo} </td>
				</tr>
				</c:forEach>	
														
			</table>
			<p>
				<a href="${pageContext.request.contextPath}/aluno/areaAluno">Retornar.</a>
			</p>
			<p>
				<a href="${pageContext.request.contextPath}/fazerLogout">Fazer Logout.</a>
			</p>
				
		</div>
	
	</div>
	

</body>

</html>









