<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Consulter un job</title>
<link rel="stylesheet" href="<c:url value="/resources/css/font.css" />	">
<link rel="stylesheet" href="<c:url value="/resources/css/form.css" />">
<link rel="stylesheet"
	href="http://cdn.foundation5.zurb.com/foundation.css">

</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>


	<div class="row">
		<div class="large-12 columns">
			<div class="panel">
				<c:if test="${ !empty param[' estSignale ']}">
					Ce témoignage a été bien signalé.
				</c:if>
				<h3>
					<b>${job.titre}</b>
				</h3>
				<hr>
				<h4>
					<spring:message code="voirJob.description"></spring:message>
				</h4>
				<p>${job.desc }</p>

				<h4>
					<spring:message code="voirJob.salaire"></spring:message>
				</h4>
				<p>${job.prix }</p>

				<h4>
					<spring:message code="voirJob.contact"></spring:message>
				</h4>
				<p>${job.mail }</p>
			</div>
		</div>
	</div>
</body>
</html>