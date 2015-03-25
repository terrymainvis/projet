<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/font.css" />	">
<link rel="stylesheet"
	href="<c:url value="/resources/css/accueil.css" />	">
<link rel="stylesheet"
	href="<c:url value="/resources/css/listannonce.css" />	">
	
<script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>
<script src="<c:url value="/resources/js/foundation.min.js" />"></script>
<script src="<c:url value="/resources/js/vendor/modernizr.js" />"></script>
<script src="<c:url value="/resources/js/lang.js" />"></script>

<title>Liste des annonces</title>
</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>

	<div class="row">
		<div class="large-9 columns">
		
		<h3 style="text-align:center"><spring:message code="annList.listeAnnonces"></spring:message></h3>

			<table id="listeAnnonces" class="display" cellspacing="0"
				width="100%">
				<thead>
					<tr>
						<th><spring:message code="annList.titre"></spring:message></th>
						<th><spring:message code="annList.categorie"></spring:message></th>
						<th>Type</th>
						<th><spring:message code="annList.date"></spring:message></th>
						<th></th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th><spring:message code="annList.titre"></spring:message></th>
						<th><spring:message code="annList.categorie"></spring:message></th>
						<th>Type</th>
						<th><spring:message code="annList.date"></spring:message></th>
						<th></th>
					</tr>
				</tfoot>
				<tbody id="lignes">
					<c:if test="${!empty annList}">
						<c:forEach items="${annList}" var="ann">
							<c:if test="${ann.valide}">

								<tr>
									<td>${ann.titre}</td>

									<td><div id="cat_lib"> ${ann.categorie.lib}</div></td>
									<td>${ann.type}</td>

									<td><fmt:formatDate value="${ann.date_fin}"
											var="dateString" pattern="dd/MM/yyyy" /> ${dateString}</td>

									<td><a href="<c:url value='/annonce/${ann.id}' />"
										class="button tiny"> <spring:message
												code="annList.voirAnnonce"></spring:message>
									</a></td>
								</tr>

							</c:if>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
		<div class="large-3 columns">
			<div class="panel callout radius">
				<p><spring:message code="annList.messageNeTrouvePas1"></spring:message></p>
				<p><spring:message code="annList.messageNeTrouvePas2"></spring:message></p>
					<a class="button success tiny" href="<c:url value="/annonce/new/categoriechoice" />">
						<spring:message code="annList.nouvelleAnnonce"></spring:message>
					</a>
			</div>
		</div>
	</div>
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
