<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/font.css" />	">
<script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>
<script src="<c:url value="/resources/js/foundation.min.js" />"></script>
<script src="<c:url value="/resources/js/vendor/modernizr.js" />"></script>


<title>Liste des catégories</title>
</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>

<div class="row">
	<h2>Administration des catégories</h2>
	<c:if test="${!empty categorieSupprimee && !empty isCategorieSupprimee}">
		<c:choose>
    		<c:when test="${isCategorieSupprimee == true}">
    			<div data-alert class="alert-box success">
					La catégorie <b><c:out value="${categorieSupprimee }"></c:out></b> a été supprimée
					<a href="#" class="close">&times;</a>
				</div>
    		</c:when>
    		<c:when test="${isCategorieSupprimee == false}">
    			<div data-alert class="alert-box alert">
					La catégorie <b><c:out value="${categorieSupprimee }"></c:out></b> n'a pas été supprimée
					<a href="#" class="close">&times;</a>
				</div>
    		</c:when>
    	</c:choose>
		
	</c:if>
	<div id="modalSuppression" class="reveal-modal" data-reveal>
  		<h2>Suppression d'une catégorie</h2><a class="close-reveal-modal">&#215;</a>
  		<p>Voulez-vous vraiment supprimer la catégorie <b id="categ"></b>? Cela supprimera toutes les annonces de cette catégorie s'il y en a.</p>
  		<a id="lienSuppression" class="button alert" href="">Supprimer</a>
	</div>
	<div class="panel radius">
	<h4>Liste des catégories</h4>
	<c:choose>
	<c:when test="${!empty catList && !empty mapCategories}">
	<table id="listeCategories">
		<thead>
			<tr>
				<th class="text-center">Libellé</th>
				<th class="text-center">Description</th>
				<th class="text-center">Nombre d'annonces</th>
				<th class="text-center">Actions</th>
			</tr>
		</thead>
		<tbody id="lignes">
				<c:forEach items="${catList}" var="categorie">
					<tr>
						<td class="text-center">${categorie.lib}</td>
						<td class="text-center">${categorie.desc}</td>
						<td class="text-center"><c:out value="${mapCategories[categorie.id]}"/></td>
						<td class="text-center">
							<button data-reveal-id="modalSuppression" class="alert small" onclick='confirmerSuppression("${categorie.lib}","${categorie.id}")'>Supprimer la catégorie</button>
						</td>
					</tr>
				</c:forEach>
		</tbody>
	</table>
	</c:when>
	<c:otherwise>
		Aucune catégorie dans la base <br/>
	</c:otherwise>
	</c:choose>
	<a href="<c:url value='/categorie/new' />" class="button success small">Ajouter une catégorie</a>
	</div>
	</div>
	<script>
		$(document).foundation();
		function confirmerSuppression(nomCateg, idCateg) {
			document.getElementById("categ").innerHTML = nomCateg;
		    document.getElementById("lienSuppression").href = "/lille1community/administration/supprimer/categorie/"+idCateg;
		    return false;
		} 
		</script>
		<script>
		$(document)
		.ready(
				function() {
					$('#listeCategories')
							.DataTable(
									{
										"language" : {
											"url" : "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/French.json"
										}

									});
				});
		</script>
</body>
</html>
