<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

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
			<h2>GymSpring - Cadastro de Alunos</h2>
		</div>
	</div>

	<div id="container">
		<h3>Cadastrar Aluno</h3>
	
		<form:form action="salvarAluno" modelAttribute="aluno" method="POST">

			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nome:</label></td>
						<td><form:input path="nome" /></td>
					</tr>
				
					<tr>
						<td><label>Sobrenome:</label></td>
						<td><form:input path="sobrenome" /></td>
					</tr>

					<tr>
						<td><label>CPF:</label></td>
						<td><form:input path="cpf" /></td>
					</tr>
					
					<tr>
						<td><label>Senha:</label></td>
						<td><form:password path="senha" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Salvar" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/aluno/listar">Voltar para a lista</a>
		</p>
	
	</div>

</body>

</html>










