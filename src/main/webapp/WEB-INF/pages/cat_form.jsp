
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<c:url value="/resources/css/form.css" />	">
<title>Creation categorie</title>
</head>
<body>
<%@ include file="../templates/header.jsp" %>
	<div class=" large-offset-3 large-6 colums panel">
		<h2>Créez votre categorie !</h2>
		<form:form id="addCatForm" modelAttribute="categorie" method="post" action="addCat">
			<div class="row">
				<div class="large-offset-3 large-6 colums">
					<form:input path="lib" placeholder="Libelle" />
				</div>
			</div>
			<div class="row">
				<div class="large-offset-3 large-6 colums">
					<form:textarea path="desc" placeholder="Description" />
				</div>
				<input class="button" type="submit" value="Ajouter" />
			</div>

		</form:form>
	</div>
	<a href="cat_list">Liste des categories</a>
</body>
</html>
