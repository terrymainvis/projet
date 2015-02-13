<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>


<script type="text/javascript">
function supprimerLigne(num)
{//alert(num);
	document.getElementById("idAnnonce").value=id;
	document.getElementById("SupprimerAnnonceUtilisateur").action("SupprimerAnnonceUtilisateur?idAnnonce="+id).submit;
		
		document.getElementById("listeAnnoncesEncours").deleteRow(num);
	
}


function supprimerLigneEncour(num,id)
{
	//alert(num);
	document.getElementById("idAnnonce").value=id;
document.getElementById("SupprimerAnnonceUtilisateur").action("SupprimerAnnonceUtilisateur?idAnnonce="+id).submit;
	
	document.getElementById("listeAnnoncesEncours").deleteRow(num);
	
}
</script>
<style type="text/css">
#global {
	margin: 0 auto;
	width: 700px;
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


	<div class="row">
		<div class="large-12 columns">
			<div class="panel" style="text-align: center">

				<b><b>liste des annonces en cours de modération</b></b><br>
				<br>

				<div class="row" style="text-align: center">
		<form:form id="SupprimerAnnonceUtilisateur" modelAttribute="utilisateur" method="get"
					action="SupprimerAnnonceUtilisateur">
					
					<table id="listeAnnoncesEncours" class="display" cellspacing="0"
						width="100%">
						 <input id="idAnnonce"  name ="idAnnonce" type="hidden" value=""/>
						<thead>

						</thead>
						<tbody id="lignes">
							<c:if test="${!empty listeAmoderer}">
								<c:forEach items="${listeAmoderer}" var="ann" varStatus="status">
									<tr>

										<td width="400" height="100" colspan="2"><img
											height="100" width="auto"
											src="<c:url value="/resources/img/chat.png" />"></td>
										<td width="400" height="100" colspan="2">${ann.titre}</td>
										<td width="400" height="100" colspan="2">${ann.categorie.lib}</td>
										<td width="400" height="100" colspan="2">${ann.date_fin.toString().substring(0,10)}</td>

										<td><input class="button" type ="submit" value="Supprimer"
											onclick="supprimerLigneEncour(${status.index},${ann.id})" ></td>
											
											
										<%-- <td onclick="supprimerLigne(this.parentNode.rowIndex);">X</td>
													<td width="400" height="100" colspan="2"><a href="<c:url value='/utilisateur/SupprimerAnnonceUtilisateur' />"
								class="button round">Supprimer</a> --%>

									</tr>
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

				<b><b>liste des annonces en cours</b></b><br> <br>

				<div class="row" style="text-align: center">
					<table id="listeAnnonces" class="display" cellspacing="0"
						width="100%">


						<tbody id="lignes">
							<c:if test="${!empty listePublie}">
								<c:forEach items="${listePublie}" var="ann" varStatus="status">
									<tr>

										<td width="400" height="100" colspan="2"><img
											height="100" width="auto"
											src="<c:url value="/resources/img/chat.png" />"></td>
										<td width="400" height="100" colspan="2">${ann.titre}</td>
										<td width="400" height="100" colspan="2">${ann.categorie.lib}</td>
										<td width="400" height="100" colspan="2">${ann.date_fin.toString().substring(0,10)}</td>
									<td><input class="button" type ="submit" value="Supprimer"
											onclick="supprimerLigneEncour(${status.index},${ann.id})" ></td>
										<%-- <td onclick="supprimerLigne(this.parentNode.rowIndex);">X</td>
													<td width="400" height="100" colspan="2"><a href="<c:url value='/utilisateur/SupprimerAnnonceUtilisateur' />"
								class="button round">Supprimer</a> --%>


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
	</script>

</body>
</html>






