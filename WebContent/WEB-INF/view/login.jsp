<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>GymSpring - Login</title>

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
			<h2>GymSpring - Login</h2>
		</div>
	</div>

	<div id="container">
		<h3>Login</h3>
		<c:if test = "${loginFailed}">
			<p>Usuario ou senha inválido<p>
		</c:if>		
	
		<form:form action="efetuarLogin" modelAttribute="dadosLogin" method="POST">
					
			<table>
				<tbody>
				
					<tr>
						<td><label>CPF:</label></td>
						<td><form:input path="cpf" /></td>
					</tr>
					
					<tr>
						<td><label>Senha:</label></td>
						<td><form:password path="senha" /></td>
					</tr>
					
					<tr>
						<td><label>Professor<form:radiobutton path="papel" value="professor" /></label></td>
						<td><label>Aluno<form:radiobutton path="papel" value="aluno" /></label></td>
							
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Login" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
	</div>

</body>

</html>
