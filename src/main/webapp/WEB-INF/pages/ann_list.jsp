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
<%@ include file="../templates/header.jsp" %>

	<table id="listeAnnonces" class="display" cellspacing="0" width="100%">
		<thead>
			<tr><th>Image</th><th>Titre</th><th>Cat&eacute;gorie</th><th>Date</th><th></th></tr>
		</thead>
		<tfoot>
			<tr><th>Image</th><th>Titre</th><th>Cat&eacute;gorie</th><th>Date</th><th></th></tr>
		</tfoot>
   		<tbody id="lignes">
   			<c:if test="${!empty annList}">
		 		<c:forEach items="${annList}" var="ann">
			        <tr>
					 				<td>
					 					<img height="100" width="auto" src="<c:url value="/resources/img/chat.png" />">
			 						</td>
						<td>${ann.titre}</td>
						<td>${ann.categorie.lib}</td>
						<td>${ann.date_fin.toString().substring(0,10)}</td>
						<td><a href="<c:url value='/annonce/${ann.id}' />" class="button round">Voir l'annonce</a></td>
			 		</tr>
			 	</c:forEach>
			 </c:if>
        </tbody>
	</table>
	<br>

	<a href="ann_form">Ajout d'une nouvelle annonce</a>

	<script type="text/javascript">
		$(document).ready(function(){
			$('#listeAnnonces').DataTable({
			});
		});
	</script>
</body>
</html>
