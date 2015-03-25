
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/font.css" />	">
<link rel="stylesheet" href="<c:url value="/resources/css/form.css" />	">
<link rel="stylesheet" href="<c:url value="/resources/css/font.css" />	">
<title>Création catégorie</title>
</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>
	<div class=" large-offset-3 large-6 colums panel">
		<h2>Créez votre categorie !</h2>
		<form:form id="addCatForm" commandName="categorie" method="post"
			action="addCat">
			<div class="row">
				<div class="large-offset-3 large-6 colums">
					<form:input path="lib" placeholder="Libellé" required="required" />
				</div>
			</div>
			<div class="row">
				<div class="large-offset-3 large-6 colums">
					<form:input path="lib_en" placeholder="Libellé en anglais" required="required" />
				</div>
			</div>
			<div class="row">
				<div class="large-offset-3 large-6 colums">
					<form:textarea path="desc" placeholder="Description" />
				</div>

				<br /> <a href="#" id="addchamp" class="button">Ajouter un
					champ</a> <a href="#" id="removechamp" class="button">Enlever un
					champ</a> <br />

				<div class="inputs"></div>

				<div class="small-3 small-centered columns">
					<input class="button" type="submit" value="Ajouter la catégorie" />
				</div>
			</div>

		</form:form>
	</div>
	<a href="cat_list">Liste des catégories</a>
</body>

<script type="text/javascript">
	$(document)
			.ready(
					function() {

						var i = $('input').size() + 1;

						$('#addchamp')
								.click(
										function() {
											$(
													'<div id="ch'+i+'"><input type="text" name="champs[' + i + '].nom" placeholder="Nom du champ" />'
															+ '<input type="text" name="champs[' + i + '].nom_en" placeholder="Nom du champ en Anglais" />'
															+ '<select name="champs[' + i + '].type" >'
															+ '<option value="0" label="Type de champ" />'
															+ '<c:forEach var="item" items="${typelist}">'
															+ '<option value="${item}">${item}</option>'
															+ '</c:forEach>'
															+ '</select>'
															+ '<input type="checkbox" name="champs[' + i + '].requis" /> Champ obligatoire'
															+ '<br/><br/></div>')
													.fadeIn('slow').appendTo(
															'.inputs');
											i++;
											return false;
										});

						$('#removechamp')
								.click(
										function() {
											if (i > 1) {
												var element = document
														.getElementById('ch'
																+ (i - 1));
												element.parentNode
														.removeChild(element);
												i--;
												return false;
											}
										});
					});
</script>
</html>
