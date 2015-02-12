<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire de contact</title>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link rel="stylesheet"
	href="<c:url value="/resources/css/formContact.css" />	">
</head>

<body>
	<div class="wrapper">
		<div  id="main" style="padding: 50px 0 0 0;" >

			<!-- Form -->
			<form:form action="sendmail" id="contact-form" method="post">
				<h3>Contactez l'auteur de l'offre</h3>
				<h4>Votre adresse mail sera transmise pour que vous puissez
					obtenir une réponse</h4>

				<div>
					<label> <span>Message *</span> <textarea name="contentMail"
							placeholder="Indiquez quelles sont vos disponibilité et les informations que vous jugez importantes"
							tabindex="5" ></textarea>
					</label>
				</div>
				<div>
					<button type="submit" name="Envoyez" id="contact-submit">Envoyer</button>
				</div>
			</form:form>
			<!-- /Form -->

		</div>
	</div>
	<script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>

</body>
</html>