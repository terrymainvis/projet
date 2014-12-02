
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="resources/css/form.css">
<link rel="stylesheet"
	href="http://cdn.foundation5.zurb.com/foundation.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">



<title>Creation d'une annonce</title>
</head>
<body>
<%@ include file="../templates/header.jsp" %>
<div class=" large-offset-3 large-6 colums panel">
	<form:form id="addAnnForm" modelAttribute="annonce" method="post"
		action="addAnn">
		<h2>Créez votre annonce !</h2>
		<div class="row">
			<div class="large-offset-3 large-6 colums">
				<form:input path="desc" placeholder="Libelle" />
			</div>
		</div>
		<div class="row">
			<div class="large-offset-3 large-6 colums">
				<form:select path="categorie">
					<form:option value="0" label="Selectionnez" />
					<form:options items="${catList}" itemValue="id" itemLabel="lib" />
				</form:select>
			</div>
		</div>

		<div class="row">
			<div class="large-offset-3 large-6 colums">
				<form:input path="date_fin" type="text" id="datepicker" placeholder="Fin de votre annonce:"/>
			</div>
		</div>
		<div class="row">
			<input class="button" type="submit" value="Ajouter" />
		</div>

	</form:form>
	</div>

</body>
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker($.datepicker.regional['fr']);
		});
</script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script type="text/javascript" src="resources/js/foundation/foundation.js"></script>
<script type="text/javascript"  src="resources/js/datepicker-fr.js"> </script>
</html>
