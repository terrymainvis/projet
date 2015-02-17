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


<title>Liste des catégories</title>
</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>

	<h1>Liste des catégories</h1>
	
	<a href="#" data-reveal-id="myModal">Click Me For A Modal</a>

<div id="myModal" class="reveal-modal" data-reveal>
  <h2>Awesome. I have it.</h2>
  <p class="lead">Your couch.  It is mine.</p>
  <p>I'm a cool paragraph that lives inside of an even cooler modal. Wins!</p>
  <a class="close-reveal-modal">&#215;</a>
</div>
	
	<table id="listeCategories" class="display" cellspacing="0" width="50%">
		<thead>
			<tr>
				<th>Libellé</th>
				<th>Nombre d'annonces</th>
				<th></th>
			</tr>
		</thead>
		<tbody id="lignes">
			<c:if test="${!empty catList && !empty mapCategories}">
				<c:forEach items="${catList}" var="categorie">
					<tr>
						<td>${categorie.lib}</td>
						<td><c:out value="${mapCategories[categorie.id]}"/></td>
						<td><a href="<c:url value='/administration/supprimerCategorie/${categorie.id}' />"
							class="button alert small">Supprimer catégorie</a></td>
					</tr>
				</c:forEach>
			</c:if>
			
		</tbody>
	</table>
	<br>
</body>
</html>
