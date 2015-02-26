<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="<c:url value="/resources/css/form.css" />">
<link rel="stylesheet"
	href="<c:url value='/resources/css/foundation.min.css'/>">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">


<title>Creation d'une annonce</title>
</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>

	<div class="row">
		<div class="large-8 columns">
			<div class="panel">
			
			<div><i>Catégorie choisie : ${annform.cat_choisie.lib}</i></div>
			
			<br/>
				<form:form id="addAnnForm" modelAttribute="annform" method="get"
					action="addAnn" enctype="multipart/form-data">
					<h2>Créez votre annonce !</h2>
					
					<form:input type="hidden" path="annonce.categorie.id" value="${annform.cat_choisie.id }" />
					
					<div>
						<form:input path="annonce.titre" placeholder="Titre de l'annonce" />
						<form:errors path="annonce.titre" />
					</div>
					
					<div>
						<form:select id="select" path="annonce.type">
							<form:option value="Je cherche" itemValue="cherche"
								itemLabel="cherche" />
							<form:option value="Je propose" itemValue="propose"
								itemLabel="propose" />
						</form:select>
					</div>

					<div>
						<form:input path="annonce.date_fin" type="text" id="datepicker"
							placeholder="Fin de votre annonce:" />
					</div>

					<div>
						<form:textarea path="annonce.desc"
							placeholder="Décrivez votre annonce en quelque mots !" />
						<form:errors path="annonce.desc" />
					</div>
					
					<c:forEach var="cc" items="${annform.annonce.champscompletes}" varStatus="status" >
						<form:input type="hidden" path="annonce.champscompletes[${status.index }].champ.id" value="${cc.champ.id }" />
						<div>	
							<c:choose>
								<c:when test='${cc.champ.type == "NUMERIQUE"}'>
								
									<c:if test="${cc.champ.requis}">
										<form:input path="annonce.champscompletes[${status.index }].valeur" placeholder="${cc.champ.nom }"  type="number" required="required" />	
									</c:if>
									
									<c:if test="${!cc.champ.requis}">
										<form:input path="annonce.champscompletes[${status.index }].valeur" placeholder="${cc.champ.nom }"  type="number" />			
									</c:if>	
								</c:when>
								
								<c:when test='${cc.champ.type == "DATE"}'>
								
									<c:if test="${cc.champ.requis}">
										<form:input path="annonce.champscompletes[${status.index }].valeur" placeholder="${cc.champ.nom }"  type="text" class="datepick" required="required" />	
									</c:if>
									
									<c:if test="${!cc.champ.requis}">
										<form:input path="annonce.champscompletes[${status.index }].valeur" placeholder="${cc.champ.nom }"  type="text" class="datepick" />			
									</c:if>	
								</c:when>
								
								<c:when test='${cc.champ.type == "DESCRIPTION"}'>
									<c:if test="${cc.champ.requis}">
										<form:textarea path="annonce.champscompletes[${status.index }].valeur" placeholder="${cc.champ.nom }" required="required" />	
									</c:if>
									
									<c:if test="${!cc.champ.requis}">
										<form:textarea path="annonce.champscompletes[${status.index }].valeur" placeholder="${cc.champ.nom }" />			
									</c:if>	
								</c:when>
								
								<c:otherwise>
									<c:if test="${cc.champ.requis}">
										<form:input path="annonce.champscompletes[${status.index }].valeur" placeholder="${cc.champ.nom }"  type="text" required="required" />	
									</c:if>
									
									<c:if test="${!cc.champ.requis}">
										<form:input path="annonce.champscompletes[${status.index }].valeur" placeholder="${cc.champ.nom }"  type="text" />			
									</c:if>	
								</c:otherwise>								
							</c:choose>		
						</div>
					</c:forEach>
					
					
					
					<div>File to upload: <input  type="file" name="file"/><br /> </div>
					<div>
						<input class="button" type="submit" value="Ajouter" />
					</div>
					
				</form:form>
			</div>
		</div>
		<div class="large-4 columns">
			<div class="panel callout radius">
				<h5>Vos coordonnées</h5>

				<form:form id="updateUtiForm" commandName="utilisateur"
					method="post" action="updateMailUtilisateur">
					<div>
						<div>
							<form:radiobutton path="contactAutreMail" id="maiMail"
								name="mail" value="false" />
							${current_user.mailLille1} <br>
							<form:radiobutton path="contactAutreMail" id="autreMail"
								name="mail" value="true" />
							Autre adresse mail
							<div id="SecondeAdresseMail"></div>
							<input name="secondMail" class="button small" type="submit"
								value="Mettre à jour" />
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<%-- <div class="large-4 columns">
			<div class="panel callout radius">
				<h5>Images de l'annonce</h5>
				
				
				<form:form method="POST" action="uploadFile" enctype="multipart/form-data">
					File to upload: <input type="file" name="file"><br /> 
					Name: <input type="text" name="nameimage" value="image1.png"><br /> <br /> 
					<input type="submit" value="Upload"> Press here to upload the file!
				</form:form>
			</div>
		</div> --%>
	</div>


</body>
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script>
	$(document)
			.ready(
					
					function() {

						var frm = $('#updateUtiForm');
						frm.submit(function(ev) {
							$.ajax({
								type : frm.attr('method'),
								url : frm.attr('action'),
								data : frm.serialize(),
								success : function(data) {
								}
							});

							ev.preventDefault();
						});

						$('#autreMail')
								.click(
										function() {
											document
													.getElementById("SecondeAdresseMail").innerHTML = " <input id='secondMail' name='mailAutre' type='text' placeholder='Autre addresse mail' />";
											var elem = document
													.getElementById("secondMail");
											elem.value = "${current_user.mailAutre}";
										});
						$('#maiMail')
								.click(
										function() {
											document
													.getElementById("SecondeAdresseMail").innerHTML = "";
										});

						$(function() {
							$("#datepicker").datepicker(
									$.datepicker.regional['fr']);
						});
						
						$('.datepick').each(function(){
						    $(this).datepicker($.datepicker.regional['fr']);
						});
					});
</script>
<script type="text/javascript">
	function getUrlParameter(sParam) {
		var sPageURL = window.location.search.substring(1);
		var sURLVariables = sPageURL.split('&');
		for (var i = 0; i < sURLVariables.length; i++) {
			var sParameterName = sURLVariables[i].split('=');
			if (sParameterName[0] == sParam) {
				return sParameterName[1];
			}
		}
	}
	
	var choix = getUrlParameter('type');
	
	if (choix == "give"){
		document
		.getElementById("select").selectedIndex = 1;
	}
	else if (choix == "need"){
		document
		.getElementById("select").selectedIndex = 0;
	}
	
</script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/foundation/foundation.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/datepicker-fr.js" />">
	
</script>
</html>
