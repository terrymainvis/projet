
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.27/angular.min.js" ></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/foundation/5.4.7/css/foundation.min.css">
	
<title>Creation annonce</title>
</head>
<body>
	<h1>Créez votre annonce !</h1>
	<form:form id="addAnnForm" modelAttribute="annonce" method="post"
		action="addAnn">
		<div class="row">
			<div class="large-6 colums">
				<form:input path="desc" placeholder="Libelle"/>
			</div>
		</div>
		<div class="row">
			<div class="large-6 colums">
				<form:select path="categorie" >
				<form:option value="0" label="Selectionnez" />
				<form:options items="${catList}" itemValue="id" itemLabel="lib" />
				</form:select>
			</div>
			<input class="button" type="submit" value="Ajouter" />
		</div>

	</form:form>

</body>
</html>
