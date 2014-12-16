
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Creation categorie</title>
</head>
<body>
	<%@ include file="../templates/header.jsp"%>
	<div class=" large-offset-3 large-6 colums panel">
		<h2>Créez votre compte !</h2>
		<form:form id="addUserForm" modelAttribute="utilisateur" method="post"
			action="addUser">
			<div class="row">
				<div class="large-offset-3 large-6 colums">
					<form:input path="prenom" placeholder="prenom" />
				</div>
			</div>


			<div class="row">
				<div class="large-offset-3 large-6 colums">
					<form:input path="nom" placeholder="nom" />
				</div>
			</div>

			<div class="row">
				<div class="large-offset-3 large-6 colums">
					<form:input path="mailLille1" placeholder="mailLille1" />
				</div>
				<input class="button" type="submit" value="Ajouter" />
			</div>

		</form:form>
	</div>
</body>
</html>
