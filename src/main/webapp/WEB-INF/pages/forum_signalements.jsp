<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>

<title>Signalements</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/accueil.css" />	">
</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>
	
	<div class="row">
		<div class="large-10 large-offset-1 columns">
			<div class="panel" style="text-align: center">
				<b>Liste des signalements pour le t&eacute;moignage</b><br/>
					${forum.titre }
				 <br/><br/>
				<div class="row" style="text-align: center">
					<table id="listeforums" class="display" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>ID</th>
								<th>Description</th>								
								<th></th>
							</tr>
							<tr></tr>
						</thead>
						<tfoot>

						</tfoot>
						<tbody id="lignes">
							<c:if test="${!empty signalements}">
								<c:forEach items="${signalements}" var="signalement">
									<tr>
										<td><table border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td width="200" height="80"  colspan="2">${signalement.id}</td>
												</tr>
											</table></td>

										<td>
											<table border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td width="300" height="80" style="word-break:break-all;text-align:center">${signalement.desc}</td>
												</tr>
											</table>
										</td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
					<div class="large-12 columns">
						<div class="large-5 columns">
							<a href="<c:url value="/forum/list"  />" class="button radius">Retour aux témoignages</a>
						</div>
						<div class="large-5  columns">
							<a href="#" class="button alert" id="modalLauncher">Supprimer le t&eacute;moignage</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
					
	<div id="myModal" class="reveal-modal" data-reveal>
		<h2 style="text-align: center">Supprimer le t&eacute;moignage</h2>
		<br />
		<h3 style="text-align:center">${forum.titre}</h3>
		<br/>
	  <form method="get" action="<c:url value='/forum/supprimer/${forum.id}' />">
	  	<div class="large-12 columns" style="text-align:center">
	  		Voulez-vous supprimer ce t&eacute;moignage?
	  	</div>
	  		<br/><br/>
	  	<div class="large-12 columns" style="text-align:center">
	  		<div class="large-6 columns">
	  			<a href="<c:url value='/forum/supprimer/${forum.id}' />" class="button alert">Supprimer</a>
	  		</div>
	  		<div class="large-6 columns">
	  			<a href="" class="button" id="closeModal">Annuler</a>
	  		</div>
	  	</div>
	  </form>
	    <a href="#" class="close-reveal-modal" id="closeModal">&#215;</a>
	</div>
		
</body>
	<script type="text/javascript">
		$("#modalLauncher").click(function (e) {
		    $('#myModal').foundation('reveal', 'open');
		    $('[data-reveal]').foundation('reveal','close')
		});

	</script>
</html>