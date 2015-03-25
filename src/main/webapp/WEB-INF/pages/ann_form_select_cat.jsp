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
		<h2 style="text-align:center"><spring:message code="annFormSelectCat.nouvelleAnnonce"></spring:message></h2>
		
		<!-- l'action dirige vers la fonction annonce/new/form -->
		<form:form id="catchoice" modelAttribute="annform" method="get"
					action="form" enctype="multipart/form-data">
		
			<form:input type="hidden" path="annonce.type" value="${annonce.type }" />
			<div>
				<h4 style="text-align:center"><spring:message code="annFormSelectCat.selection"></spring:message></h4><br/>
				<form:select path="cat_choisie" id="catList_fr_en">					
<%-- 					<form:options items="${catList}" itemValue="id" itemLabel="lib" /> --%>
				</form:select>				
			</div>
			<br/>
			<div>				
				<input class="button" type="submit" value="<spring:message code="annFormSelectCat.boutonSuivant"></spring:message>" >
			</div>
		</form:form>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
	var query = gup('lang');
	
	if (query == null){
		$('<c:forEach items="${catList}" var="cat">' 
		+ '<option id="${cat.id}" value="${cat.id}">${cat.lib}</option>'
		+ '</c:forEach>').appendTo('#catList_fr_en');
	}
	
	else if (query == "en"){
		$('<c:forEach items="${catList}" var="cat">' 
				+ '<option id="${cat.id}" value="${cat.id}">${cat.lib_en}</option>'
				+ '</c:forEach>').appendTo('#catList_fr_en');
	}
	else if (query == "fr"){
		$('<c:forEach items="${catList}" var="cat">' 
				+ '<option id="${cat.id}" value="${cat.id}">${cat.lib}</option>'
				+ '</c:forEach>').appendTo('#catList_fr_en');
	}
});
</script>
</html>