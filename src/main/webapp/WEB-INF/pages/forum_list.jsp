<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<c:url value="/resources/css/accueil.css" />	">
<link rel="stylesheet" href="<c:url value="/resources/css/font.css" />	">
<script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>

<title>Liste des témoignages</title>
</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>
	<div class="row">
		<div class="large-8 columns">
		<h3>Liste des témoignages</h3>
		<c:if test="${!empty forumList}">
			<table id="listeforums" class="display" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>Titre</th>
						<th>Description</th>
						<th>Date de publication</th>
						<th></th>
						<c:if test="${not empty utilisateur.roles['MODERATEUR']}">
							<th>Signalements</th>
						</c:if>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>Titre</th>
						<th>description</th>
						<th>Date de publication</th>
						<th></th>
						<c:if test="${not empty utilisateur.roles['MODERATEUR']}">
							<th>Signalements</th>
						</c:if>
					</tr>
				</tfoot>
				<tbody id="lignes">
						<c:forEach items="${forumList}" var="forum">
							<tr>
								<td>${forum.titre}</td>
								<td>${forum.desc}</td>
								<td><fmt:formatDate value="${forum.date_pub}"
											var="dateString" pattern="dd/MM/yyyy" /> ${dateString}</td>
								<td><a href="<c:url value='/forum/${forum.id}'/>"
									class="button success tiny">Details</a>
								</td>
								<c:if test="${not empty utilisateur.roles['MODERATEUR']}">
									<td>
										<c:choose>
											<c:when test="${forum.signalements == 0}">
												${forum.signalements}
											</c:when>
											<c:otherwise>
												<a href="<c:url value='/forum/signalements/${forum.id}' />">
													${forum.signalements}
												</a>
											</c:otherwise>
										</c:choose>
									</td>
								</c:if>
							</tr>
						</c:forEach>
				</tbody>
			</table>
					</c:if>
				</div>
			<div class="large-4 columns">
			<div class="panel callout radius">
				<p>Vous ne trouvez pas ce que vous recherchez ?</p>
				<p>Partagez votre expérience en publiant un témoignage!</p>
					<a class="button success tiny" href="<c:url value="/forum/new"  />">Ajout d'un témoignage</a>
			</div>
		</div>
	</div>
	<script>
	$(document)
	.ready(
			function() {
				$('#listeforums')
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