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
				<h4>Rendez vos trajets habituels moins solitaire.</h4>
				<div class="row">
					<div class="large-6 columns">
						<p>En covoiturant ensembles, allez en fac en économisant le
							coût de vos trajets ainsi qu'en faisant de nouvelles rencontres</p>
					</div>
					<div class="large-6 columns">
						<p>De plus, covoiturer, c'est penser écologie, n'attendez plus
							!</p>

					</div>
				</div>
				<div class="row">
					<div class="large-6 columns">
						<a href="#" class="button small">Proposez un covoiturage</a>
					</div>
					<div class="large-6 columns">
						<a href="#" class="button small">Chercher un covoiturage</a>
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
				<h4>Rendez-vous service mutuellement</h4>
				<div class="row">
					<div class="large-6 columns">
						<p>Vous êtes un crack en mathématiques mais avez besoin d'aide
							en sociologie, proposez votre aide tout en cherchant une personne
							pouvant vous rendre service à son tour</p>
					</div>
					<div class="large-6 columns">
						<p>Vous avez du petit bricolage à faire mais vous n'avez pas
							les outils ? Quelqu'un dans la communauté Lille 1 pourra vous
							dépanner. Vous cuisinez toujours pour deux plus de personne que
							prévu, partagez vos talents culinaires avec vos voisins de
							résidence</p>

					</div>
				</div>
				<div class="row">
					<div class="large-6 columns">
						<a href="#" class="button small">Proposez vos services</a>
					</div>
					<div class="large-6 columns">
						<a href="#" class="button small">Demandez de l'aide</a>
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
				<h4>Partagez vos expérience</h4>
				<div class="row">
					<div class="large-6 columns">
						<p>Vous envisagez en semestre à l'étranger ? Un stage au
							sommet du Mont Blanc ? Profitez de l'expérience des personnes de
							la communité Lille 1</p>
					</div>
					<div class="large-6 columns">
						<p>De retour d'une expérience extraordinaire ? Venez en
							parlerà la communauté Lille 1 afin de donner envie à d'autre
							personne de suivre vos pas.</p>

					</div>
				</div>
				<div class="row">
					<div class="large-6 columns">
						<a href="#" class="button small">Racontez votre histoire</a>
					</div>
					<div class="large-6 columns">
						<a href="#" class="button small">Découvrir d'extraordinaires
							expériences</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="templates/footer.jsp"%>

</body>
</html>