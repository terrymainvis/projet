
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/font.css" />	">
<link rel="stylesheet" href="<c:url value="/resources/css/form.css" />">
<link rel="stylesheet"
	href="<c:url value='/resources/css/foundation.min.css'/>">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/foundation/foundation.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/datepicker-fr.js" />">
	
</script>

<style>
.scroll {
	padding: 2px; /* équivalent cellpadding */
	display: inline-block;
	overflow-y: auto;
	width: 200px;
}

<
style type ="text/css">td {
	word-wrap: break-word;
}
</style>
<title>Statistiques</title>
</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>


	<div class="row">
		<div class="large-8 columns">
			<div class="panel text-center">

				<h3>Statistiques</h3>
				<c:choose>
					<c:when test="${!empty stats}">
					<table id=stat class="display small-12">
					<tr>
						<td>Nombre d'utilisateurs
						</td>
						<td>${nbUser}</td>
					</tr>
						<tr>
							<td>Nombre d'annonces
								créées</td>
							<td>${stats.stats_nb_ann_crees}</td>
						</tr>
						<tr>
							<td>Nombre de jobs créés
							</td>
							<td>${stats.stats_nb_jobs_crees}</td>
						</tr>
						<tr>
							<td>Nombre de forums
								créés</td>
							<td>${stats.stats_nb_forums_crees}</td>
						</tr>
					<tr>
						<td>Nombre d'annonces en
							ligne</td>
						<td>${nbAnnonceEnligne}</td>
					</tr>
					<c:if test="${!empty annonceByCat}">
						<c:forEach items="${annonceByCat}" var="ann">
							<tr>
								<td>Nombre d'annonces
									"${ann.key}"</td>
								<td>${ann.value}</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
					</c:when>
					<c:otherwise>
						Aucune statistique à afficher
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		
		<div class="large-4 columns">
			<div class="panel" style="text-align: center">
				<h3>Changer la durée de vie d'une annonce</h3>
				<br/>
				Actuellement : <b>${dureeVieAnnonce}</b> jour(s) <br/>
				<form action="setDureeVieAnn" action="get">
					<input type="number" name="duree_vie" placeholder="Durée de vie (en jours)" required="required"/>
					<input class="button success" type="submit" value="Changer"/>
				</form>
			</div>
		</div>

	</div>

</body>
</html>