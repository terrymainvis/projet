<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<link rel="stylesheet"
	href="http://cdn.foundation5.zurb.com/foundation.css">
</head>
<body>
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="http://cdn.foundation5.zurb.com/foundation.js"></script>
	<%@ include file="templates/header.jsp"%>
	<h2>Lille 1 Community</h2>
	<a href="categorie/list">Liste des categories</a>
	<a href="categorie/new">formulaire creation categorie</a>
	<br>
	<a href="<c:url value="annonce/list" />">Liste des annonce</a>
	<a href="annonce/new">formulaire creation annonce</a>
	<br>
	<a href="utilisateur/new">Créer user</a>


	<ul class="small-block-grid-2 medium-block-grid-2 large-block-grid-2">
		<li>
				<div class="panel ">
					<h5>Annonce</h5>
					<c:forEach begin="0" end="9" items="${annList}" var="ann">
						<div class="row">
							<div class="small-2 columns"><img height="50" width="auto"
								src="<c:url value="/resources/img/chat.png" />"></div>
								 <div class="small-10 columns">
									 <span> ${ann.titre} </span>
									 <span> ${ann.desc} </span>
								 </div>
						</div>
	
					</c:forEach>
				</div>
		</li>
		<li>
			<div class="panel">
				<h5>Covoiturage</h5>
			</div>
		</li>
		<li>
			<div class="panel">
				<h5>Job étudiant</h5>
			</div>
		</li>
		<li>
			<div class="panel">
				<h5>Forum</h5>
			</div>
		</li>
	</ul>


</body>
</html>