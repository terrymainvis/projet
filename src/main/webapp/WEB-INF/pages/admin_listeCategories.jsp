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

<div class="row">
	<h2>Administration des catégories</h2>
	<c:if test="${!empty categorieSupprimee && !empty isCategorieSupprimee}">
		<c:choose>
    		<c:when test="${isCategorieSupprimee == true}">
    			<div data-alert class="alert-box success">
					La catégorie <b><c:out value="${categorieSupprimee }"></c:out></b> a été supprimée <b>
					<a href="#" class="close">&times;</a>
				</div>
    		</c:when>
    		<c:when test="${isCategorieSupprimee == false}">
    			<div data-alert class="alert-box alert">
					La catégorie <b><c:out value="${categorieSupprimee }"></c:out></b> n'a pas été supprimée <b>
					<a href="#" class="close">&times;</a>
				</div>
    		</c:when>
    	</c:choose>
		
	</c:if>
	<div class="panel radius">
	<h4>Liste des catégories</h4>
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
			<c:if test="${!empty catList && !empty mapCategories}">
				<c:forEach items="${catList}" var="categorie">
					<tr>
						<td class="text-center">${categorie.lib}</td>
						<td class="text-center">${categorie.desc}</td>
						<td class="text-center"><c:out value="${mapCategories[categorie.id]}"/></td>
						<td class="text-center">
							<c:choose>
    							<c:when test="${mapCategories[categorie.id] == 0}">
							<a href="<c:url value='/administration/supprimer/categorie/${categorie.id}' />"
							class="button alert small">Supprimer la catégorie</a>
								</c:when>
								<c:when test="${mapCategories[categorie.id] != 0}">
							<button class="secondary small disabled">Supprimer la catégorie</button>
								</c:when>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</c:if>
			
		</tbody>
	</table>
	<a href="<c:url value='/categorie/new' />" class="button  small">Ajouter une catégorie</a>
	</div>
	</div>
	<script>
		$(document).foundation();
	</script>
</body>
</html>
