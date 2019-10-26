<%--
  User: Rafael Machado
  Date: 23/10/2019
  --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Rafael Machado">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Acesso Gerente</title>
<!-- Bootstrap CSS -->
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
				<h3 class="panel-title">Administração do Sistema</h3>
			</div>
			<div class="panel-body">
				<div align="center">
					<a href="resetAllSequences">Reset Senhas</a>
				</div>
				<br>
				<div align="center">
					<a href="getListOrdered">Lista Ordenada Senhas</a>
				</div>
				<br>
				<div align="center">
					<a href="deleteAllPasswords">Deletar Senhas</a>
				</div>

			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</body>
</html>