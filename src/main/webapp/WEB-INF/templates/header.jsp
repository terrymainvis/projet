<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>
<link rel="stylesheet"
	href="<c:url value="/resources/css/header.css" />	">
<link rel="stylesheet"
	href="<c:url value="/resources/css/foundation.min.css" />	">
<link rel="stylesheet" href="<c:url value="/resources/css/form.css" />	">
<script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>
<script src="<c:url value="/resources/js/foundation.min.js" />"></script>

<nav class="top-bar marginbot" data-topbar role="navigation">
	<section class="top-bar-section">

		<ul class="title-area">
			<li class="name">
				<h1>
					<a href="<c:url value="/" />">Accueil L1C</a>
				</h1>
			</li>
		</ul>
		<ul class="left">
			<li><a href="#">Mon compte</a></li>
			<li class="has-dropdown"><a href="#">Covoiturage</a>
				<ul class="dropdown">
					<li><a href="<c:url value="/annonce/new"  />">Créez votre
							covoit'</a></li>
					<li><a href="<c:url value="/annonce/list" />">Trouvez un
							covoit' </a></li>
				</ul></li>
			<li class="has-dropdown"><a href="#">Petites annonce</a>
				<ul class="dropdown">
					<li><a href="<c:url value="/annonce/new"  />">Créez votre
							petite annonce</a></li>
					<li><a href="<c:url value="/annonce/list" />">Recherche </a></li>
				</ul></li>

			<li><a href="#">Job</a></li>
			<li><a href="#">Forum</a></li>
		</ul>
		<form action="annonce/recherche" id="formulaireCat">
			<ul class="right">
				<li class="has-form"><input name="motCle" type="text"
					placeholder="Vélo, Lille, Anglais..." id="inputSearchCat"></li>
				<li class="has-form"><select name="cat" class="medium"
					name="listeCategorie" id="idSelectCat">

						<c:forEach items="${catList}" var="cat">
							<option id="${cat.id}">${cat.lib}</option>
						</c:forEach>
				</select></li>
				<li class="has-form">
<!-- 				<a href="#" class="alert button expand" -->
<!-- 					id="searchCat">Rechercher</a> -->
					<input class="button success" type="submit" value="Rechercher">
					</li>
			</ul>
		</form>

	</section>
</nav>
<script>
// 	$("#searchCat").click(
// 			function() {
// 				if ($("#inputSearchCat").val() !== "") {
// 					var input = $("<input>").attr("type", "hidden").attr(
// 							"name", "searchText").val(
// 							$("#inputSearchCat").val());
// 					$("#formulaireCat").attr("action",
// 							"/lille1community/categorie/annonceByMot").append(
// 							input).submit();
// 				} else {
// 					var input = $("<input>").attr("type", "hidden").attr(
// 							"name", "idCatSelect").val(
// 							$("#idSelectCat option:selected").attr("id"));
// 					$("#formulaireCat").attr("action",
// 							"/lille1community/categorie/annonceByCat").append(
// 							input).submit();
// 				}
// 			});
</script>
<script>
	$(document).foundation();
</script>