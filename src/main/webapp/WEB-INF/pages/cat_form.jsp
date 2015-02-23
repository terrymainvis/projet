
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
<body class="bg">
<%@ include file="../templates/header.jsp" %>
	<div class=" large-offset-3 large-6 colums panel">
		<h2>Créez votre categorie !</h2>
		<form:form id="addCatForm" commandName="categorie" method="post" action="addCat">
			<div class="row">
				<div class="large-offset-3 large-6 colums">
					<form:input path="lib" placeholder="Libelle" required="required" />
				</div>
			</div>
			<div class="row">
				<div class="large-offset-3 large-6 colums">
					<form:textarea path="desc" placeholder="Description" />
				</div>
				
				<div class="inputs">
				</div>
				
				<br/>
				<input id="addchamp" class="button" value="+" />
				<br/>
				
				<input class="button" type="submit" value="Ajouter" />
			</div>

		</form:form>
	</div>
	<a href="cat_list">Liste des categories</a>
</body>

<script>
	$(document).ready(function(){


		var i = $('input').size() + 1;
		
		$('#addchamp').click(function() {
			$('<div><input type="text" name="champs[' + i + '].nom" placeholder="nom champ" />'
			+ '<select name="champs[' + i + '].type" >'
			+ '<option value="0" label="Type de champ" />'
			+ '<c:forEach var="item" items="${typelist}">'
            + '<option value="${item}">${item}</option>'
        	+ '</c:forEach>'
			+ '</select>'
			+ '<input type="checkbox" name="champs[' + i + '].requis" /> Champ obligatoire'
        	+ '</div>').fadeIn('slow').appendTo('.inputs');
			i++;
		});
		
		$('#remove').click(function() {
		if(i > 1) {
			$('.field:last').remove();
			i--; 
		}
		});
	});
	
</script>
</html>
