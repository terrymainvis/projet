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
<body>

	<%@ include file="templates/header.jsp"%>
	<ul class="small-block-grid-2 medium-block-grid-2 large-block-grid-2">
		<li>
			<div class="panel ">
				<h5>Dernière annonces</h5><br>
				<c:forEach begin="0" end="9" items="${annList}" var="ann">
					<div class="row">
						<div class="small-2 columns">
							<img height="50" width="auto"
								src="<c:url value="/resources/img/chat.png" />">
						</div>
						<div class="small-10 columns">
							<span> ${ann.titre} </span> <span> ${ann.desc} </span>
						</div>
					</div>

				</c:forEach>
			</div>
		</li>
		<li>
			<div class="panel">
				<h5>Covoiturage</h5><br>
				<c:forEach begin="0" end="9" items="${covoitList}" var="covoit">
					<div class="row">
						<div class="small-2 columns">
							<img height="50" width="auto"
								src="<c:url value="/resources/img/chat.png" />">
						</div>
						<div class="small-10 columns">
							<span> ${covoit.titre} </span> <span> ${covoit.desc} </span>
						</div>
					</div>

				</c:forEach>
			</div>
		</li>
		<li>
			<div class="panel">
				<h5>Job étudiant</h5><br>
			</div>
		</li>
		<li>
			<div class="panel">
				<h5>Forum</h5><br>
			</div>
		</li>
	</ul>


</body>
</html>