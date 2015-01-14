
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/foundation/5.4.7/css/foundation.min.css">
<title>List</title>
</head>
<body class="bg">
<%@ include file="../templates/header.jsp" %>
	<c:if test="${!empty annList}">
		<c:forEach items="${annList}" var="ann">

			<div class="panel">
				<div class="row">
					<div class="small-2 medium-2 large-2 columns">

						<img height="100" width="auto"
							src="<c:url value="/resources/img/chat.png" />">

					</div>
					<div class="small-4 medium-4 large-3 columns">
						<span> ${ann.titre} </span>
					</div>
					<div class="small-4 medium-4 large-3 columns">
						<span> ${ann.categorie.lib } </span>
					</div>

					<div class="small-2 medium-2 large-2 columns">
						<span> ${ann.date_fin } </span>
					</div>
					<div class="small-2 medium-2 large-2 columns">
						<a href="#" class="button round">Voirl'annonce</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</c:if>



	<a href="ann_form">Ajout d'une nouvelle annonce</a>
</body>
</html>
