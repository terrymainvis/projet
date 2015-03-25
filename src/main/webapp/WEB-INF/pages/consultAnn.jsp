<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Consulter une annonce</title>
<link rel="stylesheet" href="<c:url value="/resources/css/font.css" />	">
<link rel="stylesheet"
	href="<c:url value="/resources/css/consultAnn.css" />	">
<link rel="stylesheet" href="<c:url value="/resources/css/form.css" />">
<link rel="stylesheet"
	href="http://cdn.foundation5.zurb.com/foundation.css">
<script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>
<script src="<c:url value="/resources/js/foundation.min.js" />"></script>
<script src="<c:url value="/resources/js/vendor/modernizr.js" />"></script>
<script src="<c:url value="/resources/js/lang.js" />"></script>

</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>

	<div class="row">
		<div class="small-12 columns">
			<c:choose>
				<c:when test="${confirmMail == 'mailsent'}">
					<div data-alert class="alert-box success">
						Votre mail a bien &eacute;t&eacute; envoy&eacute;. <a href="#"
							class="close">&times;</a>
					</div>
				</c:when>
				<c:when test="${confirmMail == 'mailNotsent'}">
					<div data-alert class="alert-box alert">
						Votre mail n'a pas &eacute;t&eacute; envoy&eacute;, contactez-nous
						pour nous informer de cette erreur. <a href="#" class="close">&times;</a>
					</div>
				</c:when>
			</c:choose>

		</div>
	</div>

	<c:if test="${not empty utilisateur.roles['MODERATEUR']}">
		<div class="row">
			<div class="small-12 columns">
				<div class="panel">
					<a href="<c:url value="/moderation/list"/>"><h3>Modération</h3></a>
					<p>
						Statut de l'annonce : <b> <c:choose>
								<c:when test="${annonce.valide=='TRUE'}">
					    		Validée
					  		</c:when>
								<c:when test="${annonce.valide=='FALSE'}">
					    		Refusée
					  		</c:when>
								<c:otherwise>
							    En attente
							  </c:otherwise>
							</c:choose>
						</b>
					</p>
					<p class="text-center">
						<a
							href="<c:url value='/moderation/valider/annonce/${annonce.id}' />"
							class="button success">Valider l'annonce</a> <a href="#"
							class="button alert" id="modalLauncher">Refuser l'annonce</a>

					</p>
				</div>
			</div>
		</div>
	</c:if>

	<div class="row">
		<div class="large-12 columns">
			<div class="panel">
				<div class="row">
					<div class="large-12 columns">
						<c:choose>
							<c:when test="${annonce.type == 'propose'}">
								<h3>
									<spring:message code="consultAnn.titrePropose"></spring:message>
									${annonce.titre}
								</h3>
							</c:when>
							<c:when test="${annonce.type == 'demande'}">
								<h3>
									<spring:message code="consultAnn.titreDemande"></spring:message>
									${annonce.titre}
								</h3>
							</c:when>
						</c:choose>
						<hr>
					</div>
				</div>

				<div class="row">
					<div class="large-6 columns">
						<div>
							<h4>
								<spring:message code="consultAnn.description"></spring:message>
							</h4>
							<p>${annonce.desc }</p>
						</div>
						<br>
						<div id="champ_nom">
						</div>
					</div>

					<div class="large-6 columns">
						<div class="panel callout radius">
							<h4>Contact</h4>
							<div>
								<div>
									<div>
										<h5>
											<spring:message code="consultAnn.email"></spring:message>
											:
										</h5>
										<span>${annonce.auteur.mailLille1} </span>
									</div>
									</br>
									<div>
										<a href="<c:url value='/annonce/${annonce.id}/contact' />"
											class="button success small"> <spring:message
												code="consultAnn.envoyerMessage"></spring:message>
										</a>

									</div>
								</div>
							</div>
						</div>
						<!-- </div> -->
						</li>
						</ul>
						<!-- </div> -->
					</div>
				</div>
				<!-- </div> -->





			</div>
		</div>
	</div>

	<div id="myModal" class="reveal-modal" data-reveal>
		<h2 style="text-align: center">Refus de l'annonce</h2>
		<br />
		<form method="get"
			action="<c:url value='/moderation/refuser/annonce/${annonce.id}' />">
			<div class="large-12 columns">
				<input placeholder="Motif" name="motif" type="text" />
			</div>
			<br />
			<div style="text-align: center">To :
				${annonce.auteur.mailLille1}</div>
			<br />
			<div>
				<input class="button" type="submit" value="Envoyer" />
			</div>
		</form>
		<a href="#" class="close-reveal-modal" id="closeModal">&#215;</a>
	</div>

</body>
<script>
	$(document).foundation();
</script>
<script type="text/javascript">
	$("#modalLauncher").click(function(e) {
		$('#myModal').foundation('reveal', 'open');
		$('[data-reveal]').foundation('reveal', 'close')
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
	var query = gup('lang');
	
	if (query == null){
		$('<c:if test="${champscompletes != null && champscompletes.size()>0 }">'
				+'<c:forEach  items="${champscompletes}" var="cc">'
					+ '<h4><c:out value="${cc.champ.nom }" /> :</h4>'
					+ '<p><c:out value="${cc.valeur }" /></p>'
				+ '</c:forEach></c:if>').appendTo('#champ_nom');
	}
	
	else if (query == "en"){
		$('<c:if test="${champscompletes != null && champscompletes.size()>0 }">'
				+'<c:forEach  items="${champscompletes}" var="cc">'
					+ '<h4><c:out value="${cc.champ.nom_en }" /> :</h4>'
					+ '<p><c:out value="${cc.valeur }" /></p>'
				+ '</c:forEach></c:if>').appendTo('#champ_nom');
	}
	else if (query == "fr"){
		$('<c:if test="${champscompletes != null && champscompletes.size()>0 }">'
				+'<c:forEach  items="${champscompletes}" var="cc">'
					+ '<h4><c:out value="${cc.champ.nom }" /> :</h4>'
					+ '<p><c:out value="${cc.valeur }" /></p>'
				+ '</c:forEach></c:if>').appendTo('#champ_nom');
	}
});
</script>
</html>
