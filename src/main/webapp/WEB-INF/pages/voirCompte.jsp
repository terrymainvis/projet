<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
		<div class="large-12 columns">
			<div id="global" class="panel" style="text-align: center">
				<div class="panel">
					<h1>Vos informations</h1>
					<span>Nom </span> <span>${utilisateurConnecte.nom}</span><br>
					<span>Prenom </span> <span>${utilisateurConnecte.prenom}</span><br>
					<span>Mail lille 1 </span> <span>${utilisateurConnecte.mailLille1}</span><br>
					<span>Second mail </span> <span>${utilisateurConnecte.mailAutre}</span><br>
					<a href="<c:url value='/utilisateur/ModifCompte' />"
						class="button round">Modifier</a>
				</div>
			</div>
		</div>
	</div>
	<br>
	<br>

	<h1 style="text-align: center;">Annonces en cours de modération</h1>

	<form:form id="formAnnonceAModerer" method="post"
		action="SupprimerAnnonceUtilisateur" commandName="annonce">
		<input id="idAnn" type="hidden" name="idAnnonce" />
		<input id="date_fin" type="hidden" name="datefin" />
		<input id="clicked_button" type="hidden" name="clickedbutton" />
		<div class="row">
			<dl class="accordion " data-accordion>
				<c:forEach items="${listeAmoderer}" var="ann" varStatus="status">
					<input type="hidden" name="idAnnonce" value="${ann.id}" />
					<dd id="annonce" class="accordion-navigation">
						<a href="#id${ann.id}">
							<div class="row">
								<div class="large-3 columns">${ann.titre}</div>
								<div class="large-3 columns">${ann.categorie.lib}</div>
								<div class="large-3 columns">${ann.date_fin}</div>
							</div>
						</a>
						<div id="id${ann.id }" class="content">
							<div class="row">${ann.desc}</div>
							<br>
							<div class="row">
								<div class="large-3 columns">
									<span>Changer la date de fin :</span> <input class="datepick"
										name="date_fin" type="text" />
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



	<h1 style="text-align: center;">Annonces publiées</h1>
	<form:form id="formAnnoncePubliees" method="post"
		action="SupprimerAnnonceUtilisateur" commandName="annonce">
		<input id="idAnn2" type="hidden" name="idAnnonce" />
		<input id="date_fin2" type="hidden" name="datefin" />
		<input id="clicked_button2" type="hidden" name="clickedbutton" />
		<div class="row">
			<dl class="accordion " data-accordion>
				<c:forEach items="${listePublie}" var="ann" varStatus="status">
					<input id="idhidden" type="hidden" value="${ann.id}" />
					<dd id="annonce" class="accordion-navigation">
						<a href="#id${ann.id}">
							<div class="row">
								<div class="large-3 columns">${ann.titre}</div>
								<div class="large-3 columns">${ann.categorie.lib}</div>
								<div class="large-3 columns">
								<fmt:formatDate value="${ann.date_fin}" var="dateString" pattern="dd/MM/yyyy" />
								${dateString}
								</div>
							</div>
						</a>
						<div id="id${ann.id }" class="content">
							<div class="row">${ann.desc}</div>
							<br>
							<div class="row">
								<div class="large-3 columns">
									<span>Changer la date de fin :</span> <input class="datepick"
										name="date_fin" type="text" />
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


	<script type="text/javascript"
		src="<c:url value="/resources/js/vendor/jquery.js" />"></script>
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
	$(document).on('click', '#changeDateButton', function() {
		$("input[type=hidden]").each(function(index, element) {
			var $this = $(this);
			var $form2 = $('#formAnnonceAModerer');

			$form2.submit(function(ev) {
				if ($this.next('dd').is(".active")) {
					$('#clicked_button').val("changeaction");
					$("#idAnn").val($this.val());
					$("#date_fin").val($this.next('dd').find('.datepick').val());
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
	$(document).on('click', '#changeDateButton2', function() {
		$("input[type=hidden]").each(function(index, element) {
			var $this = $(this);
			var $form4 = $('#formAnnoncePubliees');

			$form4.submit(function(ev) {
				if ($this.next('dd').is(".active")) {
					$('#clicked_button2').val("changeaction");
					$("#idAnn2").val($this.val());
					$("#date_fin2").val($this.next('dd').find('.datepick').val());
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






