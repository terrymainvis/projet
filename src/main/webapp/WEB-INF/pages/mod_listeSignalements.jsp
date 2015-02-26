<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<c:url value="/resources/css/accueil.css" />	">
<link rel="stylesheet"
	href="<c:url value="/resources/css/listannonce.css" />	">
<title>Liste des signalements</title>
</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>

	<div class="row">
		<div class="large-8 columns">
		
		<h3>Liste des signalements</h3>

		</div>
	</div>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$('#listeSignalements')
									.DataTable(
											{
												"language" : {
													"url" : "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/French.json"
												}

											});
						});
	</script>
</body>
</html>
