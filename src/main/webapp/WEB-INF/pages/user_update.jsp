<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/resources/css/font.css" />	">
<title>Insert title here</title>
</head>
<body>


	<%@ include file="../templates/header.jsp"%>

	<div class="row">
		<div class="large-12 columns">
			<div id="global" class="panel" style="text-align: center">
				<form:form id="updateUserForm" modelAttribute="utilisateur"
					method="post" action="update" enctype="multipart/form-data">
					<b><b>Vos coordonnées</b></b>
					<br>
					<br>
					<div class="row" style="text-align: center">
						<table>
							<tr>
								<td>Nom :</td>
								<td><b> <input type="text" name="nom"
										value=" ${utilisateurConnecte.nom}"></td>
								<td>Prénom :</td>
								<td><b> <input type="text" name="prenom"
										value=" ${utilisateurConnecte.prenom}"></td>
							</tr>
							<tr>
								<td>Numéro de téléphone :</td>
								<td><b> <input type="text" name="tel"
										value=" ${utilisateurConnecte.telephone}"> <%-- <input type="texte" ${utilisateurConnecte.telephone} --%></td>
								<td>Mail Lille1 :</td>
								<td><b> <input type="text" name="mail"
										value=" ${utilisateurConnecte.mailLille1}"></td>
							</tr>
							<tr>
								<td>Deuxième mail :</td>
								<td><b> <input type="text" name="mailautre"
										value=" ${utilisateurConnecte.mailAutre}"></td>
								<td></td>
								<td><input class="button" type="submit" value="Modifier" /></td>
							</tr>
						</table>

					</div>
				</form:form>
			</div>
		</div>
	</div>


</body>
</html>