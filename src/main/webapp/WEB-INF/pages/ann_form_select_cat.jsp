<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value="/resources/css/form.css" />	">
<title>Nouvelle annonce</title>
</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>
	<div class=" large-offset-3 large-6 colums panel">
		<h2>Nouvelle annonce</h2>
		
		<!-- l'action dirige vers la fonction annonce/new/form -->
		<form:form id="catchoice" modelAttribute="annform" method="get"
					action="form" enctype="multipart/form-data">
		
			<form:input type="hidden" path="annonce.type" value="${annonce.type }" />
			<div>
				<h4>Choisissez d'abord la catégorie de votre annonce</h4><br/>
				<form:select path="cat_choisie">					
					<form:options items="${catList}" itemValue="id" itemLabel="lib" />
				</form:select>				
			</div>
			<br/>
			<div>				
				<input class="button" type="submit" value="Suivant" />
			</div>
		</form:form>
	</div>
</body>
</html>