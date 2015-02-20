<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="<c:url value="/resources/js/vendor/jquery.js" />"> </script>
<link rel="stylesheet" href="<c:url value="/resources/css/form.css" />">
<link rel="stylesheet"
	href="<c:url value='/resources/css/foundation.min.css'/>">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">




<style>
#cent {
	position: absolute;
	left: 50%;
	margin-left: -200px;
	top: 400px;
}
</style>



<script type="text/javascript">
function supprimerLigne(num)
{//alert(num);
	document.getElementById("idAnnonce").value=id;
	document.getElementById("SupprimerAnnonceUtilisateur").action("SupprimerAnnonceUtilisateur?idAnnonce="+id).submit;
		
		document.getElementById("listeAnnoncesEncours").deleteRow(num);
	
}



function modifierDate(id)
{
	//alert(num);
	document.getElementById("idAnnonce").value=id;
document.getElementById("SupprimerAnnonceUtilisateur").action("SupprimerAnnonceUtilisateur?idAnnonce="+id).submit;
	
	
	
}

function supprimerLigneEncour(num,id)
{
	//alert(num);
	document.getElementById("idAnnonce").value=id;
document.getElementById("SupprimerAnnonceUtilisateur").action("SupprimerAnnonceUtilisateur?idAnnonce="+id).submit;
	
	document.getElementById("listeAnnoncesEncours").deleteRow(num);
	
}

function toggle(anId)
{
	node = document.getElementById('div'+anId);
	if (node.style.visibility=="hidden")
	{
		// Contenu caché, le montrer
		document.getElementById('bDiv'+anId).value = 'Fermer';
		node.style.visibility = "visible";
		node.style.height = "auto";			// Optionnel rétablir la hauteur
	}
	else
	{
		// Contenu visible, le cacher
		document.getElementById('bDiv'+anId).value = 'voir details';
		node.style.visibility = "hidden";
		node.style.height = "0";			// Optionnel libérer l'espace
	}
}





		
</script>

<style type="text/css">
#global {
	margin: 0 auto;
	width: 700px;
}

body {
	padding: 30px;
}

#target {
	background: #9D0053;
	height: 5px;
	padding: 5px;
}
</style>

<title>Mon Compte</title>
</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>

	<div class="row">
		<div class="large-12 columns">
			<div id="global" class="panel" style="text-align: center">

				<b><b>Vos cordonnées</b></b><br> <br>

				<div class="row" style="text-align: center">
					<table>
						<tr>
							<td>Nom :</td>
							<td><b>${utilisateurConnecte.nom}</td>
							<td>Prenom :</td>
							<td><b>${utilisateurConnecte.prenom}</td>
						</tr>
						<tr>
							<td>Numéro de téléphone :</td>
							<td><b>${utilisateurConnecte.telephone}</td>
							<td>Mail Lille1 :</td>
							<td><b>${utilisateurConnecte.mailLille1}</td>
						</tr>
						<tr>
							<td>Deuxiéme mail :</td>
							<td><b>${utilisateurConnecte.mailAutre}</td>
							<td></td>
							<td><a href="<c:url value='/utilisateur/ModifCompte' />"
								class="button round">Modifier</a></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>



	<div class="panel">

		<b><b>liste des annonces en cours de modération</b></b><br> <br>

		<div>
			<form:form id="SupprimerAnnonceUtilisateur"
				modelAttribute="utilisateur" method="get"
				action="SupprimerAnnonceUtilisateur" enctype="multipart/form-data">

				<table id="listeAnnoncesEncours" class="display" cellspacing="0"
					width="100%">
					<input id="idAnnonce" name="idAnnonce" type="hidden" value="" />
					<thead>

					</thead>
					<tbody id="lignes">
						<c:if test="${!empty listeAmoderer}">
							<c:forEach items="${listeAmoderer}" var="ann" varStatus="status">
								<tr>

									<td width="400" height="100" colspan="2"><img height="100"
										width="100" src="<c:url value="/resources/img/chat.png" />"></td>
									<td width="400" height="100" colspan="2">${ann.titre}</td>
									<td width="400" height="100" colspan="2">${ann.categorie.lib}</td>
									<td width="400" height="100" colspan="2">${ann.date_fin.toString().substring(0,10)}</td>

									<td><input class="button" type="submit" value="Supprimer"
										onclick="supprimerLigneEncour(${status.index},${ann.id})"></td>



									<td><input type="button" id="bDiv${ann.id}"
										value="Voir Details" onclick="toggle(${ann.id})"></td>



								</tr>
								<tr>
									<td>
										<div id="div${ann.id}" style="visibility: hidden;" class="row"
											class="large-10 columns" align="center">



											<table id="detailAnnonce" class="display" cellspacing="0"
												width="180%">

												<tr>
													<td>${ann.titre}</td>

													<td>${ann.categorie.lib}</td>
													<td>${ann.desc}</td>
													<td>${ann.date_fin.toString().substring(0,10)}</td>
													<td><input name="date_fin" type="text"
														class="datepick"/> 
														</td>
<!-- 													<td><input type="submit" value="Modifier"  -->
<%-- 														onclick="modifierDate(${ann.id})"></td>  --%>
												</tr>
											</table>

										</div>
							</c:forEach>
						</c:if>
					</tbody>


				</table>
			</form:form>
		</div>
	</div>
	</div>
	</div>

	<div class="row">
		<div class="large-12 columns">
			<div class="panel" style="text-align: center">

				<b><b>liste des annonces publiées</b></b><br> <br>

				<div class="row" style="text-align: center">
					<table id="listeAnnonces" class="display" cellspacing="0"
						width="100%">


						<tbody id="lignes">
							<c:if test="${!empty listePublie}">
								<c:forEach items="${listePublie}" var="ann" varStatus="status">
									<tr>

										<td width="50" height="50" colspan="2"><img height="100"
											width="100" src="<c:url value="/resources/img/chat.png" />"></td>
										<td width="100" height="100" colspan="2">${ann.titre}</td>
										<td width="100" height="100" colspan="2">${ann.categorie.lib}</td>
										<td width="100" height="100" colspan="2">${ann.date_fin.toString().substring(0,10)}</td>
										<td><input class="button" type="submit" value="Supprimer"
											onclick="supprimerLigneEncour(${status.index},${ann.id})"></td>
										<%-- <td onclick="supprimerLigne(this.parentNode.rowIndex);">X</td>
													<td width="400" height="100" colspan="2"><a href="<c:url value='/utilisateur/SupprimerAnnonceUtilisateur' />"
								class="button round">Supprimer</a> --%>

										<td width="100" height="100" colspan="2"><input
											type="button" id="bDiv${ann.id}" value="Voir Details"
											onclick="toggle(${ann.id})"></td>
									</tr>
									<tr>
										<td>
											<div id="div${ann.id}" style="visibility: hidden;"
												class="row" class="large-12 columns" align="center">



												<table id="detailAnnonce" class="display" cellspacing="0"
													width="180%">

													<tr>
														<td width="100" height="100" colspan="2">${ann.titre}</td>

														<td width="100" height="100" colspan="2">${ann.categorie.lib}</td>
														<td width="100" height="100" colspan="2">${ann.desc}</td>
														<td width="100" height="100" colspan="2">${ann.date_fin.toString().substring(0,10)}</td>
														<td><input name="date_fin" type="text"
															id="datepick"> </td>
														<td><input type="submit" value="Modifier"
															onclick="modifierDate(${ann.id})"></td>
													</tr>
												</table>
									</div>
									</td>
									</tr>

								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


	<div class="row">
		<div class="large-12 columns">
			<div class="panel" style="text-align: center">

				<b><b>liste des anciennes annonces</b></b><br> <br>

				<div class="row" style="text-align: center">

					<table id="listeAnnoncesAncien" class="display" cellspacing="0"
						width="100%">
						<thead>
							<tr>
								<th>Image</th>
								<th>Titre</th>
								<th>Cat&eacute;gorie</th>
								<th>Date</th>
								<th></th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		$(document).ready(function(){
			$('#listeAnnonces').DataTable({
			});
		});
		
		$(document).ready(function(){
			$('#listeAnnoncesEncours').DataTable({
			});
		});
		$(document).ready(function(){
			$('#detailAnnonce').DataTable({
			});
		});
		
		
				$(function(){
					$(".datepick").datepicker(
							$.datepicker.regional['fr']);
				});
		
		
	</script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/foundation/foundation.js" />"></script>
	<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/datepicker-fr.js" />"></script>



</body>
</html>






