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
		
			<!-- put new button: Add Customer 
		
			<input type="button" value="Cadastrar Aluno"
				   onclick="window.location.href='cadastrarAluno'; return false;"
				   class="add-button"
			/>
			-->
		
			<!--  add our html table here -->
		
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
				
		</div>
	
	</div>
	

</body>

</html>









