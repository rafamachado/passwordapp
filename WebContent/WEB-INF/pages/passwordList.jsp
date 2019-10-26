<%--
  User: Rafael Machado
  Date: 23/10/2019
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gerador de Senhas</title>
<!-- Bootstrap CSS -->
<%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<style type="text/css">
.myrow-container {
	margin: 20px;
}
</style>
</head>
<body class=".container-fluid">
	<div class="container myrow-container">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">
					<div align="left">
						<b>Painel de Senhas</b>
					</div>
					<div align="right">
						<a href="managersView">Gerente</a>
					</div>
				</h3>
			</div>
			<div class="panel-body">

				<div align="center">
					<a href="createPassword?id=1">Senha Normal</a>
				</div>
				<br>
				<div align="center">
					<a href="createPassword?id=2">Senha Preferencial</a>
				</div>
				<br>

				<c:if test="${empty passwordList}">
                Nenhuma senha gerada
            </c:if>
				<c:if test="${not empty passwordList}">
					<table class="table table-hover table-bordered">
						<thead style="background-color: #bce8f1;">
							<tr>
								<!--                         <th>Id</th> -->
								<th>Senha</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${passwordList}" var="password">
								<tr>
									<%--                             <th><c:out value="${password.id}"/></th> --%>
									<th><c:out value="${password.codigoSenha}" /></th>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</div>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>