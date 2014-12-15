<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>L1C Accueil</title>

</head>
<body>

	<%@ include file="templates/header.jsp"%>
	<ul class="small-block-grid-2 medium-block-grid-2 large-block-grid-2">
		<li>
			<div class="panel ">
				<h5>Dernière annonces</h5>
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
				<h5>Covoiturage</h5>
				<c:forEach begin="0" end="9" items="${covoitList}" var="covoit">
					<div class="row">
						<div class="small-2 columns">
							<img height="50" width="auto"
								src="<c:url value="/resources/img/chat.png" />">
						</div>
						<div class="small-10 columns">
							<span> ${covoit.titre} </span> <span> ${covoi.desc} </span>
						</div>
					</div>

				</c:forEach>
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