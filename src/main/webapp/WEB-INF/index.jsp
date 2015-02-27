<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>L1C Accueil</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/accueil.css" />	">

</head>
<body class="bg">

	<%@ include file="templates/header.jsp"%>

	<div id="covoiturage">
		<div class="row">
			<div class="large-6 columns">
				<img src="<c:url value="/resources/img/carpool.jpg" />">
			</div>
			<div class="large-6 columns">
				<h4 style="text-align:center"><spring:message code="index.covoiturageTitre"></spring:message></h4>
				<div class="row">
					<div class="large-6 columns">
						<p><spring:message code="index.covoiturageProposeDesc"></spring:message></p>
					</div>
					<div class="large-6 columns">
						<p><spring:message code="index.covoiturageChercheDesc"></spring:message></p>
					</div>
				</div>
				<div class="row">
					<div class="large-6 columns">
						<a href="/lille1community/annonce/demande/listCov" class="button success small">
							<spring:message code="index.covoiturageProposeBouton"></spring:message>
						</a>
					</div>
					<div class="large-6 columns">
						<a href="/lille1community/annonce/propose/listCov" class="button success small">
							<spring:message code="index.covoiturageChercheBouton"></spring:message>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<hr />
	</div>
	<div id="experience">
		<div class="row">
			<div class="large-6 columns">
				<br> <br> <img
					src="<c:url value="/resources/img/cuisine.jpg" />">
			</div>
			<div class="large-6 columns">
				<h4 style="text-align:center"><spring:message code="index.annoncesTitre"></spring:message></h4>
				<div class="row">
					<div class="large-6 columns">
						<p><spring:message code="index.annoncesProposeDesc"></spring:message></p>
					</div>
					<div class="large-6 columns">
						<p><spring:message code="index.annoncesChercheDesc"></spring:message></p>
					</div>
				</div>
				<div class="row">
					<div class="large-6 columns">
						<a href="/lille1community/annonce/demande/list" class="button success small">
							<spring:message code="index.annoncesProposeBouton"></spring:message>
						</a>
					</div>
					<div class="large-6 columns">
						<a href="/lille1community/annonce/propose/list" class="button success small">
							<spring:message code="index.annoncesChercheBouton"></spring:message>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<hr />
	<div id="experience">
		<div class="row">
			<div class="large-6 columns">
				<img src="<c:url value="/resources/img/voyage.jpg" />">
			</div>
			<div class="large-6 columns">
				<h4 style="text-align:center"><spring:message code="index.experiencesTitre"></spring:message></h4>
				<div class="row">
					<div class="large-6 columns">
						<p><spring:message code="index.experiencesDecouvreDesc"></spring:message></p>
					</div>
					<div class="large-6 columns">
						<p><spring:message code="index.experiencesRaconteDesc"></spring:message></p>
					</div>
				</div>
				<div class="row">					
					<div class="large-6 columns">
						<a href="<c:url value="/forum/list" />" class="button success small">
							<spring:message code="index.experiencesDecouvreBouton"></spring:message>
						</a>
					</div>
					<div class="large-6 columns">
						<a href="<c:url value="/forum/new"/>" class="button success small">
							<spring:message code="index.experiencesRaconteBouton"></spring:message>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="templates/footer.jsp"%>

</body>
</html>