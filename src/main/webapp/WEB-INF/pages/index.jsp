<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<link rel="stylesheet"
	href="http://cdn.foundation5.zurb.com/foundation.css">
</head>
<body>
	<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="http://cdn.foundation5.zurb.com/foundation.js"></script>
	<%@ include file="../templates/header.jsp"%>
	<h2>Lille 1 Community</h2>
	<a href="categorie/list">Liste des categories</a>
	<a href="categorie/new">formulaire creation categorie</a>
	<br>
	<a href="<c:url value="annonce/list" />">Liste des annonce</a>
	<a href="annonce/new">formulaire creation annonce</a>
	<br>
	<a href="utilisateur/new">Creer user</a>
</body>
</html>