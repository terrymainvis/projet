<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<link rel="stylesheet"
	href="<c:url value='/resources/css/foundation.min.css'/>">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">



<title>Mon Compte</title>
</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>

	<div class="row">
		<div class="large-12 columns">
			<div id="global" class="panel" style="text-align: center">
				<div class="panel">
					<h1>Vos informations</h1>
					<span>Nom </span> <span>${utilisateurConnecte.nom}</span><br>
					<span>Prenom </span> <span>${utilisateurConnecte.prenom}</span><br>
					<span>Mail lille 1 </span> <span>${utilisateurConnecte.mailLille1}</span><br>
					<span>Second mail </span> <span>${utilisateurConnecte.mailAutre}</span><br>
					<a href="<c:url value='/utilisateur/ModifCompte' />"
						class="button round">Modifier</a>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>

	<h1 style="text-align: center;">Annonces en cours de modération</h1>
	<div class="row">
		<dl class="accordion " data-accordion>
			<c:forEach items="${listeAmoderer}" var="ann">
				<dd class="accordion-navigation">
					<a href="#id${ann.id}">
						<div class="row">
							<div class="large-2 columns">${ann.titre}</div>
							<div class="large-2 columns">${ann.categorie.lib}</div>
							<div class="large-2 columns">${ann.date_fin}</div>
							<div class="large-2 columns">
								<input class="button" type="submit" value="Supprimer"
									onclick="supprimerLigneEncour(${status.index},${ann.id})">

							</div>
						</div>
					</a>
					<div id="id${ann.id }" class="content">
						<div class="row">${ann.desc}</div>
						<br>
						<div class="row">
							<div class="large-4 columns">
								<span>Changer la date de fin :</span> <input name="date_fin"
									type="text" id="datepicker" />
							</div>
							<div class="large-2 columns">
								<input class="button" type="submit" value="Modifier"
									onclick="modifierDate(${ann.id})">
							</div>
						</div>


					</div>
				</dd>

			</c:forEach>
		</dl>
	</div>

	<h1 style="text-align: center;">Annonces publiées</h1>
	<div class="row">
		<dl class="accordion " data-accordion>
			<c:forEach items="${listePublie}" var="ann">
				<dd class="accordion-navigation">
					<a href="#id${ann.id}">
						<div class="row">
							<div class="large-2 columns">${ann.titre}</div>
							<div class="large-2 columns">${ann.categorie.lib}</div>
							<div class="large-2 columns">${ann.date_fin}</div>
							<div class="large-2 columns">
								<input class="button" type="submit" value="Supprimer"
									onclick="supprimerLigneEncour(${status.index},${ann.id})">

							</div>
						</div>
					</a>
					<div id="id${ann.id }" class="content">
						<div class="row">${ann.desc}</div>
						<br>
						<div class="row">
							<div class="large-4 columns">
								<span>Changer la date de fin :</span> <input name="date_fin"
									type="text" id="datepicker" />
							</div>
							<div class="large-2 columns">
								<input class="button" type="submit" value="Modifier"
									onclick="modifierDate(${ann.id})">
							</div>
						</div>
					</div>
				</dd>
			</c:forEach>
		</dl>
	</div>


	<script type="text/javascript"
		src="<c:url value="/resources/js/vendor/jquery.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/foundation/foundation.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/foundation/foundation.accordion.js" />"></script>
	<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/datepicker-fr.js" />"></script>

	<script>
		$(document).foundation({
			accordion : {
				callback : function(accordion) {
					console.log(accordion);
				}
			}
		});
	</script>
	<script>
$(function() {
$( "#datepicker" ).datepicker(
		$.datepicker.regional['fr']
		);
});
</script>



</body>
</html>






