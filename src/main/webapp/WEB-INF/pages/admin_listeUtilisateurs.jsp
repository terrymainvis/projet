<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>
<script src="<c:url value="/resources/js/foundation.min.js" />"></script>
<script src="<c:url value="/resources/js/vendor/modernizr.js" />"></script>


<title>Liste des utilisateurs</title>
</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>

<div class="row">
	<h2>Administration des utilisateurs</h2>
	<c:if test="${!empty nbAdminInsuffisant}">
		<div data-alert class="alert-box alert">
			Vous ne pouvez pas changer le statut d'un administrateur lorsqu'il
			n'y en a qu'un <a href="#" class="close">&times;</a>
		</div>
	</c:if>
	<c:if
		test="${!empty changementStatut && !empty utilisateurSelectionne}">
		<div data-alert class="alert-box success">
			<b><c:out value="${utilisateurSelectionne }"></c:out></b>
			<c:out value="${changementStatut }"></c:out> <a
				href="#" class="close">&times;</a>
		</div>
	</c:if>
	<div class="panel radius">
	<form:form modelAttribute="newUser" method="post" action="/lille1community/administration/nouveauStatut">
		<h4>Modifier les droits d'un utilisateur</h4>
		
		<div>
			<form:input path="mailLille1" placeholder="Mail de l'utilisateur" />
			<form:errors path="mailLille1" />
		</div>
		<div>
			<form:select path="" name="roleSelected">
				<form:options items="${roleList}" />
			</form:select>
		</div>
		<div>
			<input class="button" type="submit" value="Modifier" />
		</div>		
	</form:form>
	
	</div>
	<div class="panel radius">
	<h4>Liste des utilisateurs</h4>
	<table id="listeUtilisateurs" class="display" cellspacing="0"
		width="100%">
		<thead>
			<tr>
				<th>Pr&eacutenom</th>
				<th>Nom</th>
				<th>Mail</th>
				<th>Statut</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody id="lignes">
			<c:if test="${!empty listeUtilisateurs}">
				<c:forEach items="${listeUtilisateurs}" var="utilisateur">
					<tr>
						<td>${utilisateur.prenom}</td>
						<td>${utilisateur.nom}</td>
						<td>${utilisateur.mailLille1}</td>
						<td>
							<c:forEach items="${utilisateur.roles}" var="role">
								${role.key} <br/>
							</c:forEach>
						</td>
						<td>
						<c:choose>
				    		<c:when test="${not empty utilisateur.roles['ADMINISTRATEUR']}">
								<a href="<c:url value="/administration/modifierStatutAdmin/"/>${utilisateur.id}" class="button alert tiny">-Admin</a>
				    		</c:when>
				    		<c:otherwise>
								<a href="<c:url value="/administration/modifierStatutAdmin/"/>${utilisateur.id}" class="button success tiny">+Admin</a>
				    		</c:otherwise>
				    	</c:choose>
				    	<c:choose>
				    		<c:when test="${not empty utilisateur.roles['MODERATEUR']}">
								<a href="<c:url value="/administration/modifierStatutMod/"/>${utilisateur.id}" class="button alert tiny">-Modérateur</a>
				    		</c:when>
				    		<c:otherwise>
								<a href="<c:url value="/administration/modifierStatutMod/"/>${utilisateur.id}" class="button success tiny">+Modérateur</a>
				    		</c:otherwise>
				    	</c:choose>
				    	<c:choose>
				    		<c:when test="${not empty utilisateur.roles['REPRESENTANT']}">
								<a href="<c:url value="/administration/modifierStatutRep/"/>${utilisateur.id}" class="button alert tiny">-Représentant</a>
				    		</c:when>
				    		<c:otherwise>
								<a href="<c:url value="/administration/modifierStatutRep/"/>${utilisateur.id}" class="button success tiny">+Représentant</a>
				    		</c:otherwise>
				    	</c:choose>
						<a href="<c:url value="/administration/supprimer/utilisateur/"/>${utilisateur.id}" class="button alert tiny">Supprimer</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	<br>
	<script>
		$(document).foundation();
	</script>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#listeUtilisateurs').DataTable({});
		});
	</script>
	
	</div>
</div>

</body>
</html>
