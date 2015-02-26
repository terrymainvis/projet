<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>

<title>Liste des offres d'emploi</title>

</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>

	<div class="row">
		<div class="large-10 columns">

				<h3>Liste des offres d'emploi</h3>

				<div class="row">
				<c:if test="${!empty jobList}">
					<table id="listejobs" class="display" cellspacing="0"
				width="100%">
						<thead>
							<tr>
								<th>Titre</th>
								<th>Description</th>
								<th>Date</th>
								<th>Rémunération</th>
								<th></th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Titre</th>
								<th>Description</th>
								<th>Date</th>
								<th>Rémunération</th>
								<th></th>
							</tr>
						</tfoot>
						<tbody id="lignes">
							
								<c:forEach items="${jobList}" var="job">
								<tr>
									<td>${job.titre}</td>
									<td>${job.desc}</td>
									<td><fmt:formatDate value="${job.date_fin}"
											var="dateString" pattern="dd/MM/yyyy" /> ${dateString}</td>
									<td>${job.prix}</td>
									<td><a href="<c:url value='/job/${job.id}'/>"
											class="button success tiny">Details</a></td>
									</tr>
								</c:forEach>
							
						</tbody>
					</table>
					</c:if>
				</div>
			</div>
			<c:if test="${not empty utilisateur.roles['REPRESENTANT']}">
				<a href="<c:url value="/job/new"  />" class="button success">Ajouter une nouvelle offre d'emploi</a>
			</c:if>
	</div>

	<script type="text/javascript">
	$(document)
	.ready(
			function() {
				$('#listejobs')
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
