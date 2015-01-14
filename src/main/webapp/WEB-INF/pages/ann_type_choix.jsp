<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<c:url value="/resources/css/typechoix.css" />">
<title>Type d'annonce</title>
</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>
	<div class="row">

		<div class="medium-4 large-5 columns">
			<div class="panel">
				<h4>J'ai besoin de quelque chose</h4>
				<hr>
				<p>Je suis à la recherche d’un service ou d'un objet</p>
				<a href="<c:url value="/annonce/new?type=need"/>" class="button round">Trouver</a>
			</div>
		</div>


		<div class="medium-5 medium-offset-1 large-5 columns">
			<div class="panel">
				<h4>Je propose quelque chose</h4>
				<hr>
				<p>Je peux rendre certains services ou possède des objets que je
					veux preter ou vendre</p>
				<a href="<c:url value="/annonce/new?type)give"/>" class="button round">Proposer</a>
			</div>
		</div>
	</div>

</body>
</html>