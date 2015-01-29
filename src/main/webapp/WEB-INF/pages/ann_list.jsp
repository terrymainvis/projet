<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>

<title>List</title>
</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>

	<div class="row">
		<div class="large-12 columns">
			<div class="panel" style="text-align: center">

				<b><b>liste des annonces</b></b><br> <br>

				<div class="row" style="text-align: center">

			



	<table id="listeAnnonces" class="display" cellspacing="0" width="100%">
		<thead>
			<tr>
				<th>Image</th>
				<th>Titre</th>
				<th>Cat&eacute;gorie</th>
				<th>Date</th>
				<th></th>
			</tr>
		</thead>
		<tfoot>
			<tr>
				<th>Image</th>
				<th>Titre</th>
				<th>Cat&eacute;gorie</th>
				<th>Date</th>
				<th></th>
			</tr>
		</tfoot>
		<tbody id="lignes">
			<c:if test="${!empty annList}">
				<c:forEach items="${annList}" var="ann">
					<tr>
					<td><table border="0" cellspacing="0" cellpadding="0"><tr><td width="400" height="100" colspan="2">
						<img height="100" width="auto"
							src="<c:url value="/resources/img/chat.png" />"></td></tr></table>

						<td><table border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="400" height="100" colspan="2">${ann.titre}</td>
								</tr>
							</table></td>

						<td><table border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="400" height="100" colspan="2">${ann.categorie.lib}</td>
								</tr>
							</table></td>
						<td><table border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="400" height="100" colspan="2">${ann.date_fin.toString().substring(0,10)}</td>
								</tr>
							</table></td>

						<td><table border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td><a href="<c:url value='/annonce/${ann.id}' />"
										class="button round">Voir l'annonce</a></td>
								</tr>
							</table></td>



						<%-- <td>
						<td>${ann.titre}</td>
						<td>${ann.categorie.lib}</td>
						<td>${ann.date_fin.toString().substring(0,10)}</td>
						<td><a href="<c:url value='/annonce/${ann.id}' />"
							class="button round">Voir l'annonce</a></td> --%>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	</div>
	</div>
	</div>
	</div>
	
	<br>

	<a href="/job/new">Ajout d'une nouvelle annonce</a>

	<script type="text/javascript">
		$(document).ready(function(){
			$('#listeAnnonces').DataTable({
			});
		});
	</script>
</body>
</html>
