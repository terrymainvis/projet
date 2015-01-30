<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div id="main" style="padding: 50px 0 0 0;">

			<!-- Form -->
			<form id="contact-form" method="post">
				<h3>Contactez la personne propose ce qui vous interesse</h3>
				<h4>Votre adresse mail sera transmise pour que vous puissez
					obtenir une réponse</h4>
				<div>
					<label> <span>Email: (required)</span> <input
						placeholder="Entrez votre adresse mail" type="email" tabindex="2"
						required>
					</label>
				</div>
				<div>
					<label> <span>Message: (required)</span> <textarea
							placeholder="Indiquez quelles sont vos disponibilité et les informations que vous jugez importantes"
							tabindex="5" required></textarea>
					</label>
				</div>
				<div>
					<button name="Envoyez" id="contact-submit">Send Email</button>
				</div>
			</form>
			<!-- /Form -->

		</div>
	</div>
	<script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>

	<script type="text/javascript">
		$("#contact-submit").click(
				function() {
					var mail = $("input[type='email']").val();
					var content = $("textarea").val();

					var link = "mailto:" + mail + "&subject="
							+ "This is my subject" + "&body=" + content

					window.location.href = link;

				});
	</script>

</body>
</html>