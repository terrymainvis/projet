<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/font.css" />	">
<script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>

<title>Liste des annonces à modérer</title>
</head>
<body class="bg">
<%@ include file="../templates/header.jsp" %>

<div class="row">
	<div class="large-12 columns">
	<h3>Liste des annonces à modérer</h3>
	<c:choose>
	<c:when test="${!empty annonceList}">
		<table id="listeAnnonces" class="display" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th><spring:message code="annList.titre"></spring:message></th>
					<th>Description</th>
					<th><spring:message code="annList.categorie"></spring:message></th>
					<th>Type</th>
					<th><spring:message code="annList.date"></spring:message></th>
					<th></th>
				</tr>
			</thead>
			<tfoot>
				<tr>
				<th>	
					<spring:message code="annList.titre"></spring:message></th>
					<th>Description</th>
					<th><spring:message code="annList.categorie"></spring:message></th>
					<th>Type</th>
					<th><spring:message code="annList.date"></spring:message></th>
					<th></th>
				</tr>
			</tfoot>
	   		<tbody id="lignes">
	   			
			 		<c:forEach items="${annonceList}" var="ann">
				        <tr>
						 	<td>${ann.titre}</td>
							<td>${ann.desc}</td>
							<td>${ann.categorie.lib}</td>
							<td>${ann.type }</td>
							<td>
							<fmt:formatDate value="${ann.date_fin}"
											var="dateString" pattern="dd/MM/yyyy" /> ${dateString}</td>
							<td><a href="<c:url value='/annonce/${ann.id}' />" class="button success">Voir l'annonce</a></td>
				 		</tr>
				 	</c:forEach>
	        </tbody>
		</table>
	</c:when>
	<c:otherwise>
		Aucune annonce à modérer actuellement
	</c:otherwise>
	</c:choose>
	</div>
	</div>
	<br>
		<script type="text/javascript">
		$(document)
		.ready(
				function() {
					$('#listeAnnonces')
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
