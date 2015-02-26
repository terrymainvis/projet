<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<link rel="stylesheet"
	href="<c:url value='/resources/css/foundation.min.css'/>">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">


<title>Mon Compte</title>
</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>

	<div class="row">
		<!-- 	<div id="modalModifMail" class="reveal-modal" data-reveal> -->
		<!--   		<h2>Suppression d'une catégorie</h2><a class="close-reveal-modal">&#215;</a> -->
		<!--   		<p>Voulez-vous vraiment supprimer la catégorie <b id="categ"></b>? Cela supprimera toutes les annonces de cette catégorie s'il y en a.</p> -->
		<!--   		<a id="lienSuppression" class="button alert" href="">Supprimer</a> -->
		<!-- 	</div> -->
		<div class="large-6 columns">
			<div id="global" class="panel callout">
				<h3 class="text-center">Mes informations</h3>
				<c:choose>
					<c:when test="${!empty utilisateur}">
						<span>${utilisateur.prenom}</span>
						<span>${utilisateur.nom}</span>
						<br>
						<span>Mail lille 1 :</span>
						<span>${utilisateur.mailLille1}</span>
						<br>
						<span>Second mail :</span>
						<span><c:choose>
								<c:when test="${empty utilisateur.mailAutre}">
								Aucun
								</c:when>
								<c:otherwise>
			    				${utilisateur.mailAutre}
			    				</c:otherwise>
							</c:choose> </span>
						<div id="SecondeAdresseMail"></div>
						<button id="modalModifMail" class="success tiny">Modifier</button>
					</c:when>
					<c:otherwise>
							Se reconnecter
			    		</c:otherwise>
				</c:choose>
			</div>
		</div>

		<div class="large-6 columns">
			<div class="panel">
				<h3 style="text-align: center">Annonces publiées</h3>
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
												<div class="row">${ann.desc}</div>
												<br>
												<div class="row">
													<div class="large-3 columns">
														<span>Changer la date de fin :</span> <input
															class="datepick" name="date_fin" type="text" />
													</div>
													<div class="large-offset-2 large-2 columns end">
														<br> <input id="changeDateButton2" class="button"
															name="buttonchangedate" type="submit" value="Modifier" />
													</div>
												</div>
												<br>
												<div class="row">
													<div class=" large-offset-4">
														<input id="deleteButton2" name="test" class="button"
															type="submit" value="Supprimer cette annonce" />
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
	</div>
	</div>
	<div class="row">
		<div class="large-6 columns">
			<div class="panel">
				<h3 style="text-align: center">Annonces en cours de modération</h3>
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
												<div class="row">${ann.desc}</div>
												<br>
												<div class="row">
													<div class="large-3 columns">
														<span>Changer la date de fin :</span> <input
															class="datepick" name="date_fin" type="text" />
													</div>
													<div class="large-offset-2 large-2 columns end">
														<br> <input id="changeDateButton" class="button"
															type="submit" value="Modifier" />
													</div>
												</div>
												<br>
												<div class="row">
													<div class=" large-offset-4">
														<input id="deleteButton" class="button" type="submit"
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
		<div class="large-6 columns">
			<div class="panel">
				<h3 style="text-align: center;">Annonces expirées</h3>
				<c:choose>
					<c:when test="${!empty listeAnnoncesPerimees}">



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
												<div class="row">${ann.desc}</div>
												<br>
												<div class="row">
													<div class="large-3 columns">
														<span>Changer la date de fin :</span> <input
															class="datepick" name="date_fin" type="text" />
													</div>
													<div class="large-offset-2 large-2 columns end">
														<br> <input id="changeDateButton2" class="button"
															name="buttonchangedate" type="submit" value="Modifier" />
													</div>
												</div>
												<br>
												<div class="row">
													<div class=" large-offset-4">
														<input id="deleteButton2" name="test" class="button"
															type="submit" value="Supprimer cette annonce" />
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

	<script src="<c:url value="/resources/js/vendor/modernizr.js" />"></script>

	<script type="text/javascript"
		src="<c:url value="/resources/js/foundation/foundation.js" />"></script>
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
		$(function() {
			$('#modalModifMail')
					.click(
							function() {
								document.getElementById("SecondeAdresseMail").innerHTML = " <input id='secondMail' name='mailAutre' type='text' placeholder='Autre addresse mail' />";
								var elem = document
										.getElementById("secondMail");
								elem.value = "${current_user.mailAutre}";
							});

			$('.datepick').each(function() {
				$(this).datepicker($.datepicker.regional['fr']);
			});

			$("#datepicker").datepicker($.datepicker.regional['fr']);
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
</body>
</html>






