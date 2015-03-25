<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="<c:url value="/resources/css/font.css" />	">
<link rel="stylesheet"
	href="<c:url value='/resources/css/foundation.min.css'/>">
<script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>
<script src="<c:url value="/resources/js/foundation.min.js" />"></script>
<script src="<c:url value="/resources/js/vendor/modernizr.js" />"></script>


<title>Mon Compte</title>
</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>

	<div id="alertMail"></div>
	<div class="row" data-equalizer>

		<div class="large-6 columns" >
			<div id="global" class="panel callout" data-equalizer-watch>
				<h3 class="text-center">Mes informations</h3><br/>
				<c:choose>
					<c:when test="${!empty utilisateur}">
						<span>${utilisateur.prenom}</span>
						<span>${utilisateur.nom}</span>
						<br>
						<span>Mail lille 1 :</span>
						<span>${utilisateur.mailLille1}</span>
						<br>
						<span>Second mail :</span>
						<span id="spanMail"><c:choose>
								<c:when test="${empty utilisateur.mailAutre}">
								Aucun
								</c:when>
								<c:otherwise>
			    				${utilisateur.mailAutre}
			    				</c:otherwise>
							</c:choose> </span>
						<form:form id="updateUtiForm" commandName="utilisateur"
							method="post" action="updateMailUtilisateur">
							<div class="row" id="SecondeAdresseMail"></div>
						</form:form>
						<button id="ModifMail" class="success tiny">Modifier</button>
					</c:when>
					<c:otherwise>
							Se reconnecter
			    		</c:otherwise>
				</c:choose>
			</div>
		</div>
	<div class="large-6 columns">
	<div class="panel" data-equalizer-watch>
		<h3 class="text-center">Mes statistiques</h3><br/>
			Annonces en ligne : ${fn:length(listeAnnoncesPubliees)} <br/>
			Annonces en attente de modération : ${fn:length(listeAnnoncesAModerer)} <br/>
			Annonces expirées : ${fn:length(listeAnnoncesPerimees)} <br/>
		</div>
	</div>
	
</div><br/>
<div class="row">
<div class="tabs-content large-12 columns">
  	<ul class="tabs" data-tab>
	  <li class="tab-title active"><a href="#panelPubliees">Publiées</a></li>
	  <li class="tab-title"><a href="#panelModeration">En modération</a></li>
	  <li class="tab-title"><a href="#panelExpirees">Expirées</a></li>
	</ul>
  <div class="content active" id="panelPubliees">
    <div class="panel">
				<h3 style="text-align: center">Annonces publiées</h3><br/>
				<c:choose>
					<c:when test="${!empty listeAnnoncesPubliees}">
						<form:form id="formAnnoncePubliees" method="post"
							action="SupprimerAnnonceUtilisateur" commandName="annonce">
							<input id="idAnn2" type="hidden" name="idAnnonce" />
							<input id="date_fin2" type="hidden" name="datefin" />
							<input id="clicked_button2" type="hidden" name="clickedbutton" />
							<div class="row">
								<dl class="accordion " data-accordion>
									<c:forEach items="${listeAnnoncesPubliees}" var="ann"
										varStatus="status">
										<input id="idhidden" type="hidden" value="${ann.id}" />
										<dd id="annonce" class="accordion-navigation">
											<a href="#id${ann.id}">
												<div class="row">
													<div class="large-3 columns">${ann.titre}</div>
													<div class="large-3 columns">${ann.categorie.lib}</div>
													<div id="dateFinDiv" class="large-3 columns">
														<fmt:formatDate value="${ann.date_fin}" var="dateString"
															pattern="dd/MM/yyyy" />
														${dateString}
													</div>
												</div>
											</a>
											<div id="id${ann.id }" class="content">
												<div class="row">
												<div class="large-4 columns">"${ann.desc}"</div>
<!-- 												</div> -->
<!-- 												<div class="row"> -->
													<div class="large-3 columns">
														<span>Changer la date de fin :</span> <input
															class="datepick" name="date_fin" type="text" value="${dateString}" />
													</div>
													<div class="large-2 columns">
														<br> <input id="changeDateButton2"
															class="button small success" name="buttonchangedate"
															type="submit" value="Modifier" />
													</div>
													<div class="large-3 columns">
														<br/> <input id="deleteButton2" name="test"
															class="button small alert" type="submit"
															value="Supprimer cette annonce" />
													</div>
												</div>
											</div>
										</dd>

									</c:forEach>
								</dl>
							</div>
						</form:form>
					</c:when>
					<c:otherwise>
			 Aucune annonce publiée
		</c:otherwise>
		</c:choose>
	</div>
  </div>
  <div class="content" id="panelModeration">
   <div class="panel">
		<h3 style="text-align: center">Annonces en cours de modération</h3><br/>
		<c:choose>
			<c:when test="${!empty listeAnnoncesAModerer}">
				<form:form id="formAnnonceAModerer" method="post"
					action="SupprimerAnnonceUtilisateur" commandName="annonce">
					<input id="idAnn" type="hidden" name="idAnnonce" />
					<input id="date_fin" type="hidden" name="datefin" />
					<input id="clicked_button" type="hidden" name="clickedbutton" />
					<div class="row">
						<dl class="accordion " data-accordion>
							<c:forEach items="${listeAnnoncesAModerer}" var="ann"
								varStatus="status">
								<input type="hidden" name="idAnnonce" value="${ann.id}" />
								<dd id="annonce" class="accordion-navigation">
									<a href="#id${ann.id}">
										<div class="row">
											<div class="large-3 columns">${ann.titre}</div>
											<div class="large-3 columns">${ann.categorie.lib}</div>
											<div class="large-3 columns">
												<fmt:formatDate value="${ann.date_fin}" var="dateString"
													pattern="dd/MM/yyyy" />
												${dateString}
											</div>
										</div>
									</a>
									<div id="id${ann.id }" class="content">
												<div class="row">
												<div class="large-4 columns">"${ann.desc}"</div>
<!-- 												</div> -->
<!-- 												<div class="row"> -->
													<div class="large-3 columns">
														<span>Changer la date de fin :</span> <input
															class="datepick" name="date_fin" type="text" value="${dateString}" />
													</div>
													<div class="large-2 columns">
														<br> <input id="changeDateButton"
															class="button small success"
															type="submit" value="Modifier" />
													</div>
													<div class="large-3 columns">
														<br/> <input id="deleteButton"
															class="button small alert" type="submit"
															value="Supprimer cette annonce" />
													</div>
												</div>
											</div>
								</dd>
	
							</c:forEach>
						</dl>
					</div>
				</form:form>
			</c:when>
			<c:otherwise>
	 	Aucune annonce en cours de modération
	   		</c:otherwise>
			</c:choose>
		</div>
  </div>
  <div class="content" id="panelExpirees">
    <div class="panel">
				<h3 style="text-align: center;">Annonces expirées</h3><br/>
				<c:choose>
					<c:when test="${!empty listeAnnoncesPerimees}">

						<form:form id="formAnnoncePerimees" method="post" action="SupprimerAnnonceUtilisateur" commandName="annonce">
							<input id="idAnn3" type="hidden" name="idAnnonce" />
							<input id="date_fin3" type="hidden" name="datefin" />
							<input id="clicked_button3" type="hidden" name="clickedbutton" />
							<div class="row">
								<dl class="accordion " data-accordion>
									<c:forEach items="${listeAnnoncesPerimees}" var="ann"
										varStatus="status">
										<input id="idhidden" type="hidden" value="${ann.id}" />
										<dd id="annonce" class="accordion-navigation">
											<a href="#id${ann.id}">
												<div class="row">
													<div class="large-3 columns">${ann.titre}</div>
													<div class="large-3 columns">${ann.categorie.lib}</div>
													<div id="dateFinDiv" class="large-3 columns">
														<fmt:formatDate value="${ann.date_fin}" var="dateString"
															pattern="dd/MM/yyyy" />
														${dateString}
													</div>
												</div>
											</a>
											<div id="id${ann.id }" class="content">
												<div class="row">
												<div class="large-4 columns">"${ann.desc}"</div>
<!-- 												</div> -->
<!-- 												<div class="row"> -->
													<div class="large-3 columns">
														<span>Changer la date de fin :</span> <input
															class="datepick" name="date_fin" type="text" value="${dateString}" />
													</div>
													<div class="large-2 columns">
														<br> <input id="changeDateButton3"
															class="button small success" name="buttonchangedate"
															type="submit" value="Modifier" />
													</div>
													<div class="large-3 columns">
														<br/> <input id="deleteButton3" name="test"
															class="button small alert" type="submit"
															value="Supprimer cette annonce" />
													</div>
												</div>
											</div>
										</dd>

									</c:forEach>
								</dl>
							</div>
						</form:form>
					</c:when>
					<c:otherwise>
			 Aucune annonce expirée
		</c:otherwise>
				</c:choose>
			</div>
  </div>
</div>

	</div>


	<script type="text/javascript"
		src="<c:url value="/resources/js/foundation/foundation.accordion.js" />"></script>
	<script src="//code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/datepicker-fr.js" />"></script>


	<script>
		$(document).foundation({
			accordion : {
				callback : function(accordion) {
					console.log(accordion);
				}
			}
		});
	</script>
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

							$('#ModifMail')
									.click(
											function() {
												document
														.getElementById("SecondeAdresseMail").innerHTML = "<div id='divInput' class='large-6 columns'> <input id='secondMail' name='mailAutre' type='text' placeholder='Autre addresse mail'  /></div>"
														+ "<div id='divButton' class='success tiny large-6 columns'> <button id='saveMail' class='success tiny'>Sauvegarder</button></div>";
												var elem = document
														.getElementById("secondMail");
												elem.value = "${current_user.mailAutre}";
											});

							$(function() {
								$.datepicker
										.setDefaults($.datepicker.regional['fr']);

								$("#datepicker").datepicker({
									minDate : '+1D',
									maxDate : '+${duree_vie_ann}D'
								});
							});

							$('.datepick').each(function() {
								$(this).datepicker({
									minDate : '+0D'
								});
							});
						});
	</script>

	<script type="text/javascript">
		$(document)
				.on(
						'click',
						'#saveMail',
						function() {
							var newmail = $("#secondMail").val();
							document.getElementById("spanMail").innerHTML = newmail;
							document.getElementById("alertMail").innerHTML = '<div class="row"> <div class="small-12 columns"><div data-alert class="alert-box success"> Votre adresse mail a bien été mise à jour <a href="#" class="close">&times;</a> </div> </div></div>'
						});
	</script>

	<script type="text/javascript">
		$(document).on('click', '#deleteButton', function() {
			$("input[type=hidden]").each(function(index, element) {
				var $this = $(this);
				var $form = $('#formAnnonceAModerer');

				$form.submit(function(ev) {
					if ($this.next('dd').is(".active")) {
						$('#clicked_button').val("deleteaction");
						$("#idAnn").val($this.val());
						$.ajax({
							type : $form.attr('method'),
							url : $form.attr('action'),
							data : $form.serialize(),
							success : function(data) {
							}
						});

						ev.preventDefault();

						$("input[type=hidden]").each(

						function() {
							if ($(this).next('dd').is(".active")) {
								$(this).next('dd').remove();
							}

						});

					}
				});
			});

		});
	</script>

	<script type="text/javascript">
		$(document).on(
				'click',
				'#changeDateButton',
				function() {
					$("input[type=hidden]").each(
							function(index, element) {
								var $this = $(this);
								var $form2 = $('#formAnnonceAModerer');

								$form2.submit(function(ev) {
									if ($this.next('dd').is(".active")) {
										$('#clicked_button')
												.val("changeaction");
										$("#idAnn").val($this.val());
										$("#date_fin").val(
												$this.next('dd').find(
														'.datepick').val());
										$.ajax({
											type : $form2.attr('method'),
											url : $form2.attr('action'),
											data : $form2.serialize(),
											success : function(data) {
											}
										});

										ev.preventDefault();
										return false;

									}
								});
							});

				});
	</script>


	<script type="text/javascript">
		$(document).on('click', '#deleteButton2', function() {
			$("input[type=hidden]").each(function(index, element) {
				var $this = $(this);
				var $form3 = $('#formAnnoncePubliees');

				$form3.submit(function(ev) {
					if ($this.next('dd').is(".active")) {
						$('#clicked_button2').val("deleteaction");
						$("#idAnn2").val($this.val());
						$.ajax({
							type : $form3.attr('method'),
							url : $form3.attr('action'),
							data : $form3.serialize(),
							success : function(data) {
							}
						});

						ev.preventDefault();

						$("input[type=hidden]").each(

						function() {
							if ($(this).next('dd').is(".active")) {
								$(this).next('dd').remove();
							}

						});

					}
				});
			});

		});
	</script>

	<script type="text/javascript">
		$(document).on(
				'click',
				'#changeDateButton2',
				function() {

					$("input[type=hidden]").each(
							function(index, element) {
								var $this = $(this);
								var $form4 = $('#formAnnoncePubliees');

								$form4.submit(function(ev) {
									if ($this.next('dd').is(".active")) {
										$('#clicked_button2').val(
												"changeaction");
										$("#idAnn2").val($this.val());
										$("#date_fin2").val(
												$this.next('dd').find(
														'.datepick').val());

										$.ajax({
											type : $form4.attr('method'),
											url : $form4.attr('action'),
											data : $form4.serialize(),
											success : function(data) {
											}
										});

										ev.preventDefault();
										return false;

									}
								});
							});

				});
	</script>
	
	<script type="text/javascript">
		$(document).on('click', '#deleteButton3', function() {
			$("input[type=hidden]").each(function(index, element) {
				var $this = $(this);
				var $form5 = $('#formAnnoncePerimees');

				$form3.submit(function(ev) {
					if ($this.next('dd').is(".active")) {
						$('#clicked_button3').val("deleteaction");
						$("#idAnn3").val($this.val());
						$.ajax({
							type : $form5.attr('method'),
							url : $form5.attr('action'),
							data : $form5.serialize(),
							success : function(data) {
							}
						});

						ev.preventDefault();

						$("input[type=hidden]").each(

						function() {
							if ($(this).next('dd').is(".active")) {
								$(this).next('dd').remove();
							}

						});

					}
				});
			});

		});
	</script>

	<script type="text/javascript">
		$(document).on(
				'click',
				'#changeDateButton3',
				function() {

					$("input[type=hidden]").each(
							function(index, element) {
								var $this = $(this);
								var $form6 = $('#formAnnoncePerimees');

								$form6.submit(function(ev) {
									if ($this.next('dd').is(".active")) {
										$('#clicked_button3').val(
												"changeaction");
										$("#idAnn3").val($this.val());
										$("#date_fin3").val(
												$this.next('dd').find(
														'.datepick').val());

										$.ajax({
											type : $form6.attr('method'),
											url : $form6.attr('action'),
											data : $form6.serialize(),
											success : function(data) {
											}
										});

										ev.preventDefault();
										return false;

									}
								});
							});

				});
	</script>
</body>
</html>
