<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true"%>

<link rel="stylesheet"
	href="<c:url value="/resources/css/header.css" />    ">
<link rel="stylesheet"
	href="<c:url value="/resources/css/foundation.min.css" />	">
<link rel="stylesheet" href="<c:url value="/resources/css/form.css" />	">
<link rel="stylesheet" href="<c:url value="/resources/css/flag.css" />	">
<link rel="stylesheet"
	href="//cdn.datatables.net/1.10.5/css/jquery.dataTables.min.css">

<script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>
<script src="<c:url value="/resources/js/foundation.min.js" />"></script>
<script src="<c:url value="/resources/js/lang.js" />"></script>

<script src="//cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js" /></script>


<div id="wrapper">
	<div id="header-wrapper">

		<div id="header" class="container">
			<div id="logo" class="medium-6 large-6 columns">
				<a href="http://localhost:8080/lille1community/"><img
					src="<c:url value="/resources/img/UL1-BLANC-WEB-2014.png" />"
					alt="Community Lille 1" /></a>
			</div>

			<div id="text" class="medium-6 large-6 columns">
				<h1>Lille 1 Community</h1>
				<p>
					<spring:message code="header.accroche"></spring:message>
				</p>
			</div>
		</div>
	</div>
</div>
<!-- <div id="wrapper"> -->
<!-- 	<div id="header-wrapper" class="row"> -->

<!-- 			<div id="logo" class="small-6 medium-6 large-6 columns"> -->
<%-- 				<a href="http://localhost:8080/lille1community/"><img src="<c:url value="/resources/img/UL1-BLANC-WEB-2014.png" />" --%>
<!-- 					alt="Site de Lille 1 Community" /></a> -->
<!-- 			</div> -->

<!-- 			<div id="text" class="small-6 medium-6 large-6 columns"> -->
<!-- 				<h1>Lille 1 Community</h1> -->
<!-- 				<p>Un lieu d'échange et d'entraide pour la communauté Lille 1</p> -->
<!-- 			</div> -->
<!-- 	</div> -->




<nav class="top-bar marginbot" data-topbar role="navigation">

	<section class="top-bar-section">

<!-- 		<ul class="title-area"> -->
<!-- 			<li class="name"> -->
<!-- 				<h1> -->
<%-- 					<a href="<c:url value="/" />"><spring:message --%>
<%-- 							code="header.acceuil"></spring:message></a> --%>
<!-- 				</h1> -->
<!-- 			</li> -->
<!-- 		</ul> -->
		<ul class="left">


			<c:choose>
				<c:when test="${(not empty utilisateur.roles['ADMINISTRATEUR'])}">
					<li class="has-dropdown"><a href="#">Administration</a>
						<ul class="dropdown">
							<li><a href="<c:url value="/administration/list"/>">Admin.
									des rôles</a></li>
							<li><a
								href="<c:url value="/administration/listCategories"/>">Admin.
									des catégories</a></li>
							<c:if test="${not empty utilisateur.roles['MODERATEUR']}">
								<li><a href="<c:url value="/moderation/list"/>">Mod.
										annonces</a></li>
								<li><a href="<c:url value="/moderation"/>">Mod.
										paramètres & stats</a></li>
							</c:if>
							<c:if test="${not empty utilisateur.roles['REPRESENTANT']}">
								<li><a href="<c:url value="/job/new"/>">Créer un job</a></li>
							</c:if>
						</ul></li>
				</c:when>
				<c:when test="${not empty utilisateur.roles['MODERATEUR']}">
					<li class="has-dropdown"><a href="#">Modération</a>
						<ul class="dropdown">
							<li><a href="<c:url value="/moderation/list"/>">Mod.
									annonces</a></li>
							<li><a href="<c:url value="/moderation"/>">Mod.
									paramètres & stats</a></li>
							<c:if test="${not empty utilisateur.roles['REPRESENTANT']}">
								<li><a href="<c:url value="/job/new"/>">Créer un job</a></li>
							</c:if>
						</ul></li>
				</c:when>
				<c:when test="${not empty utilisateur.roles['REPRESENTANT']}">
					<li><a href="<c:url value="/job/new"/>">Créer un job</a></li>
				</c:when>
			</c:choose>
			<li><a href="<c:url value="/utilisateur/monCompte"  />"><spring:message
						code="header.monCompte"></spring:message></a></li>

			<li class="has-dropdown"><a href="#"><spring:message
						code="header.covoiturage"></spring:message></a>


				<ul class="dropdown">
					<li><a href="<c:url value="/annonce/new/categoriechoice"  />">
							<spring:message code="header.creerCovoiturage"></spring:message>
					</a></li>
					<li><a href="<c:url value="/annonce/listCov" />"> <spring:message
								code="header.trouverCovoiturage"></spring:message>
					</a></li>
				</ul></li>
			<li class="has-dropdown"><a href="#"><spring:message
						code="header.petitesAnnonces"></spring:message></a>
				<ul class="dropdown">
					<li><a href="<c:url value="/annonce/new/categoriechoice"  />">
							<spring:message code="header.creerAnnonce"></spring:message>
					</a></li>
					<li><a href="<c:url value="/annonce/list" />"> <spring:message
								code="header.rechercherAnnonce"></spring:message>
					</a></li>
				</ul></li>

			<li><a href="<c:url value="/job/list" />"> <spring:message
						code="header.Job"></spring:message>
			</a></li>
			<li><a href="<c:url value="/forum/list" />"> <spring:message
						code="header.temoignages"></spring:message>
			</a></li>
		</ul>
		<form action="/lille1community/annonce/recherche" id="formulaireCat">
			<ul class="right">
				<li class="has-form"><input name="motCle" type="text"
					placeholder="<spring:message code="header.hintRecherche"></spring:message>"
					id="inputSearchCat"></li>
				<li class="has-form"><select name="cat" class="medium"
					name="listeCategorie" id="idSelectCat">

						<c:forEach items="${catList}" var="cat">
							<option id="${cat.id}">${cat.lib}</option>
						</c:forEach>
				</select></li>
				<li class="has-form">
					<!-- 				<a href="#" class="alert button expand" --> <!-- 					id="searchCat">Rechercher</a> -->
					<input class="button success" type="submit"
					value="<spring:message code="header.rechercher"></spring:message>">
				</li>
			</ul>
		</form>


	</section>
</nav>

<div id="share-wrapper">
	<ul class="share-inner-wrp">
		<li id="flag" class="lang button-wrap"><a onclick="switchLang()"><span><spring:message
						code="header.tranduire"></spring:message></span></a></li>
	</ul>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		//user hovers on the social button  
		$('#share-wrapper li').hover(function() {
			var hoverEl = $(this); //get element

			//browsers with width > 699 get button slide effect
			if ($(window).width() > 699) {
				if (hoverEl.hasClass('visible')) {
					hoverEl.animate({
						"margin-left" : "-110px"
					}, "fast").removeClass('visible');
				} else {
					hoverEl.animate({
						"margin-left" : "0px"
					}, "fast").addClass('visible');
				}
			}
		});
	});
</script>
<script>
	$(document).foundation();
</script>