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
	<ul class="small-block-grid-2 medium-block-grid-2 large-block-grid-2">
		<li>
			<div class="panel ">
				<h5>Dernière annonces</h5>
				<br>
				<c:forEach begin="0" end="9" items="${annList}" var="ann">
					<div class="row">
						<div class="small-2 columns">
							<img height="50" width="auto"
								src="<c:url value="/resources/img/chat.png" />">
						</div>
						<div class="small-5 columns">
							<span> ${ann.titre} </span> <br> <span> ${ann.desc} </span>
						</div>
						<div class="small-5 columns">
							<a href="<c:url value='/annonce/${ann.id}' />"
								class="button round">Voir l'annonce</a>
						</div>
					</div>

				</c:forEach>
			</div>
		</li>
		<li>
			<div class="panel">
				<h5>Covoiturage</h5>
				<br>
				<c:forEach begin="0" end="9" items="${covoitList}" var="covoit">
					<div class="row">
						<div class="small-2 columns">
							<img height="50" width="auto"
								src="<c:url value="/resources/img/chat.png" />">
						</div>
						<div class="small-5 columns">
							<span> ${covoit.titre} </span> <br> <span>
								${covoit.desc} </span>
						</div>
						<div class="small-5 columns">
							<a href="<c:url value='/annonce/${covoit.id}' />"
								class="button round">Voir l'annonce</a>
						</div>
					</div>

				</c:forEach>
			</div>
		</li>
		<li>
			<div class="panel">
				<h5>Job étudiant</h5>
				<br>
				<c:forEach begin="0" end="9" items="${jobList}" var="job">
					<div class="row">
						
						<div class="small-5 columns">
							<span> ${job.titre} </span> <br> <span>
								 </span>
						</div>
						<div class="small-5 columns">
							<a href="<c:url value='/job/${job.id}' />"
								class="button round">Voir l'offre</a>
						</div>
					</div>

				</c:forEach>
				
				
				<br>
			</div>
		</li>
		<li>
			<div class="panel">
				<h5>Forum</h5>
				<br>
			</div>
		</li>
	</ul>


</body>
</html>