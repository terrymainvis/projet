<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="resources/css/form.css">
<link rel="stylesheet"
	href="http://cdn.foundation5.zurb.com/foundation.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">



<title>Creation d'une annonce</title>
</head>
<body>
	<%@ include file="../templates/header.jsp"%>

	<div class="row">
		<div class="large-8 columns">
			<div class="panel">
				<form:form id="addAnnForm" modelAttribute="annonce" method="post"
					action="addAnn">
					<h2>Créez votre annonce !</h2>

					<div>
						<form:input path="titre" placeholder="Titre de l'annonce" />
					</div>


					<div>
						<form:select path="categorie">
							<form:option value="0" label="Selectionnez" />
							<form:options items="${catList}" itemValue="id" itemLabel="lib" />
						</form:select>
					</div>


					<div>
						<form:input path="date_fin" type="text" id="datepicker"
							placeholder="Fin de votre annonce:" />
					</div>

					<div>
						<form:textarea path="desc"
							placeholder="Décrivez votre annonce en quelque mots !" />
					</div>
					<div>
						<input class="button" type="submit" value="Ajouter" />
					</div>

				</form:form>
			</div>
		</div>
		<div class="large-4 columns">
			<div class="panel callout radius">
				<h5>Vos coordonnées</h5>
				<form id="updateUtiForm"
					method="post" action="updateMailUtilisateur">
					<div>
						<div>
							<input id="maiMail" type="radio" name="mail"  value="lille1" />
							${current_user.mailLille1}
							<br><input id="autreMail" type="radio" name="mail" value="autre"  />
							Autre adresse mail
							<div id="SecondeAdresseMail"></div>
							<input name="secondMail" class="button small" type="submit" value="Mettre à jour" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


</body>
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script>
$(document).ready(function() {
	 $('#autreMail').click(function(){
		 document.getElementById("SecondeAdresseMail").innerHTML =" <input type='text' placeholder='Autre addresse mail:' />";
	 });
	 $('#maiMail').click(function(){
		 document.getElementById("SecondeAdresseMail").innerHTML ="";
	 });



	$(function() {
		$("#datepicker").datepicker($.datepicker.regional['fr']);
	});
	 
});
</script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script type="text/javascript"
	src="resources/js/foundation/foundation.js"></script>
<script type="text/javascript" src="resources/js/datepicker-fr.js">
	
</script>
</html>
