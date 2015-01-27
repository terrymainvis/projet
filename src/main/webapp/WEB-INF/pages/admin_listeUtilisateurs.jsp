<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>

<title>Liste des utilisateurs</title>
</head>
<body class="bg">
<%@ include file="../templates/header.jsp" %>

	<h1>Liste des utilisateurs</h1>
	<c:if test="${!empty nbAdminInsuffisant}">
		<div data-alert class="alert-box alert">
		  Vous ne pouvez pas changer le statut d'un administrateur lorsqu'il n'y en a qu'un
		  <a href="#" class="close">&times;</a>
		</div>
	</c:if>
	<c:if test="${!empty changementStatut && !empty utilisateurSelectionne}">
		<div data-alert class="alert-box success">
		  <b><c:out value="${utilisateurSelectionne }"></c:out></b> est maintenant un <b><c:out value="${changementStatut }"></c:out></b>
		  <a href="#" class="close">&times;</a>
		</div>
	</c:if>
	
	<table id="listeUtilisateurs" class="display" cellspacing="0" width="100%">
		<thead>
			<tr><th>Pr&eacutenom</th><th>Nom</th><th>Mail</th><th>Statut</th><th></th></tr>
		</thead>
   		<tbody id="lignes">
			<c:if test="${!empty listeUtilisateursAdmin}">
		 		<c:forEach items="${listeUtilisateursAdmin}" var="utilisateur">
			        <tr>
		 				<td>${utilisateur.prenom}</td>
						<td>${utilisateur.nom}</td>
						<td>${utilisateur.mailLille1}</td>
						<td>Administrateur</td>
						<td>
						<a href="<c:url value='/administration/modifierEnMod/${utilisateur.id}' />" class="button small">Mettre mod&eacuterateur</a>
						<a href="<c:url value='/administration/modifierEnUti/${utilisateur.id}' />" class="button small">Mettre utilisateur</a>
						</td>
			 		</tr>
			 	</c:forEach>
			</c:if>
			<c:if test="${!empty listeUtilisateursMod}">
		 		<c:forEach items="${listeUtilisateursMod}" var="utilisateur">
			        <tr>
		 				<td>${utilisateur.prenom}</td>
						<td>${utilisateur.nom}</td>
						<td>${utilisateur.mailLille1}</td>
						<td>Mod&eacuterateur</td>
						<td>
						<a href="<c:url value='/administration/modifierEnAdmin/${utilisateur.id}' />" class="button small">Mettre administrateur</a>
						<a href="<c:url value='/administration/modifierEnUti/${utilisateur.id}' />" class="button small">Mettre utilisateur</a>
						</td>
			 		</tr>
			 	</c:forEach>
			</c:if>
   			<c:if test="${!empty listeUtilisateurs}">
		 		<c:forEach items="${listeUtilisateurs}" var="utilisateur">
			        <tr>
		 				<td>${utilisateur.prenom}</td>
						<td>${utilisateur.nom}</td>
						<td>${utilisateur.mailLille1}</td>
						<td>Utilisateur</td>
						<td>
						<a href="<c:url value='/administration/modifierEnAdmin/${utilisateur.id}' />" class="button small">Mettre administrateur</a>
						<a href="<c:url value='/administration/modifierEnMod/${utilisateur.id}' />" class="button small">Mettre mod&eacuterateur</a>
						</td>
			 		</tr>
			 	</c:forEach>
			 </c:if>
        </tbody>
	</table>
	<br>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#listeUtilisateurs').DataTable({
			});
		});
	</script>
</body>
</html>
