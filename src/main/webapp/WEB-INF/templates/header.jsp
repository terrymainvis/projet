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
<%-- <link rel="stylesheet" href="<c:url value="/resources/css/jquery.dataTables.css" />"> --%>


<script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>
<link rel="stylesheet" type="text/css"
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/css/jquery.dataTables.css">
<script src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/jquery.dataTables.min.js"></script>

<script src="<c:url value="/resources/js/foundation.min.js" />"></script>


<nav class="top-bar marginbot" data-topbar role="navigation">

	<section class="top-bar-section">

		<ul class="title-area">
			<li class="name">
				<h1>
					<a href="<c:url value="/" />"><spring:message code="header.acceuil"></spring:message></a>
				</h1>
			</li>
		</ul>
		<ul class="left">
		
		<c:forEach items="${roleList}" var="role">
<%-- 			<c:out value="${role.nom}"></c:out> --%>
<%-- 			<c:out value="${utilisateur.roleId}"></c:out> --%>
			<c:if test="${utilisateur.roleId==role.id}">
				<c:choose>
				  <c:when test="${(role.nom=='ADMINISTRATEUR') || (role.nom=='UTILISATEUR')}">
				    <li class="has-dropdown"><a href="#">Administration</a>
						<ul class="dropdown">
							 <li><a href="<c:url value="/administration/list"/>">Liste des utilisateurs</a></li>
							 <li><a href="<c:url value="/moderation/list"/>">Modération</a></li>
						</ul>
					</li>
				  </c:when>
				  <c:when test="${(role.nom=='MODERATEUR')}">
				    <li><a href="<c:url value="/moderation/list"/>">Modération</a></li>
				  </c:when>
				</c:choose>
			</c:if>
		</c:forEach>
			<li><a href="<c:url value="/utilisateur/monCompte"  />"><spring:message code="header.monCompte"></spring:message></a></li>

			<li class="has-dropdown"><a href="#"><spring:message code="header.covoiturage"></spring:message></a>

				<ul class="dropdown">
					<li><a href="<c:url value="/annonce/new"  />">
						<spring:message code="header.creerCovoiturage"></spring:message>
					</a></li>
					<li><a href="<c:url value="/annonce/listCov" />">
						<spring:message code="header.trouverCovoiturage"></spring:message>
					</a></li>
				</ul></li>
			<li class="has-dropdown"><a href="#"><spring:message code="header.petitesAnnonces"></spring:message></a>
				<ul class="dropdown">
					<li><a href="<c:url value="/annonce/typechoice"  />">
						<spring:message code="header.creerAnnonce"></spring:message>
					</a></li>
					<li><a href="<c:url value="/annonce/list" />">
						<spring:message code="header.rechercherAnnonce"></spring:message>
					</a></li>
				</ul></li>

			<li><a href="<c:url value="/job/list" />">
					<spring:message code="header.Job"></spring:message>
				</a></li>
			<li><a href="<c:url value="/forum/list" />">Témoignages</a></li>
		</ul>
		<form action="annonce/recherche" id="formulaireCat">
			<ul class="right">
				<li class="has-form"><input name="motCle" type="text"
					placeholder="<spring:message code="header.hintRecherche"></spring:message>" id="inputSearchCat"></li>
				<li class="has-form"><select name="cat" class="medium"
					name="listeCategorie" id="idSelectCat">

						<c:forEach items="${catList}" var="cat">
							<option id="${cat.id}">${cat.lib}</option>
						</c:forEach>
				</select></li>
				<li class="has-form">
<!-- 				<a href="#" class="alert button expand" -->
<!-- 					id="searchCat">Rechercher</a> -->
					<input class="button success" type="submit" value="<spring:message code="header.rechercher"></spring:message>">
					</li>
			</ul>
		</form>


	</section>
</nav>

<span style="float: right;">  
    <a href="<c:url value="?lang=fr"/>">FR</a>  
    |  
    <a href="<c:url value="?lang=en"/>">EN</a>  
</span>
<!-- <script>
 	$("#searchCat").click(
 			function() {
 				if ($("#inputSearchCat").val() !== "") {
					var input = $("<input>").attr("type", "hidden").attr(
 							"name", "searchText").val(
 							$("#inputSearchCat").val());
 					$("#formulaireCat").attr("action",
 							"/lille1community/categorie/annonceByMot").append(
 							input).submit();
 				} else {
 					var input = $("<input>").attr("type", "hidden").attr(
 							"name", "idCatSelect").val(
 							$("#idSelectCat option:selected").attr("id"));
 					$("#formulaireCat").attr("action",
 							"/lille1community/categorie/annonceByCat").append(
							input).submit();
				}
			});
</script> -->
<script>
	$(document).foundation();

</script>