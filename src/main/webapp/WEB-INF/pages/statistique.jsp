
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="<c:url value="/resources/css/form.css" />">
<link rel="stylesheet"
	href="<c:url value='/resources/css/foundation.min.css'/>">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/foundation/foundation.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/datepicker-fr.js" />">
	
</script>

<style>
.scroll {
	padding: 2px; /* équivalent cellpadding */
	display: inline-block;
	overflow-y: auto;
	width: 200px;
}

<style type="text/css"> 
  td { 
    word-wrap: break-word; 
  } 

</style>
<title>Statistique</title>
</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>


	<div class="row">
		<div class="large-6 columns">
			<div class="panel" style="text-align: center">

				<b><b>Statistique</b></b><br> <br>

			

					<table id=stat class="display">
						<tr>
							
							<td width="300" height="80" colspan="2">Nombre d'utilisateur </td>
							<td width="300" height="80" colspan="2">${nbUser}</td>
						</tr>
						<tr>
							<td width="300" height="80" colspan="2">Nombre d'annonce en ligne</td>
							<td width="300" height="80" colspan="2">${nbAnnonceEnligne}</td>
						</tr>

						<c:if test="${!empty annonceByCat}">
							<c:forEach items="${annonceByCat}" var="ann">
								<tr>

									<td width="300" height="80" colspan="2">nombre de ${ann.key}</td>
									<td width="300" height="80" colspan="2">${ann.value}</td>
								</tr>

								<br>
							</c:forEach>
						
							</c:if>
							</table>
							</div>
							</div>
							
							</div>
							
</body>
</html>