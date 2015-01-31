
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/form.css" />	">
<title>Creation d'un champ</title>
</head>
<body>
	<%@ include file="../templates/header.jsp"%>
	<div class=" large-offset-3 large-6 colums panel">
		<h2>Ajoutez des champs à compléter dans une annonce !</h2>
		<form:form id="addChampForm" modelAttribute="champ" method="get"
			action="addChamp">
			<div class="row">
				<div>
					<form:select path="cat">
						<form:option value="0" label="Categorie" />
						<form:options items="${catlist}" itemValue="id" itemLabel="lib" />
					</form:select>
				</div>
			</div>
			<br/><br/>
			
			<div class="row">
				<form:input type="text" path="nom" placeholder="Nom du champ" />
			</div>
			
			<div>
				<form:select path="type">
					<form:option value="0" label="Type de champ" />
					<form:options items="${typelist}" />
				</form:select>
			</div>
			
			<div>
				<form:checkbox path="requis" /> Champ obligatoire
			</div>
			
			<br/>
			<input class="button" type="submit" value="Ajouter" />

		</form:form>
	</div>
</body>
</html>
