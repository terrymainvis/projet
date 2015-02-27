<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Découvrez des expériences</title>
<link rel="stylesheet" href="<c:url value="/resources/css/font.css" />	">
<link rel="stylesheet" href="<c:url value="/resources/css/form.css" />">
<link rel="stylesheet" href="http://cdn.foundation5.zurb.com/foundation.css"/>
<link rel="stylesheet" href="http://cdn.foundation5.zurb.com/reveal.css"/>
	<link rel="stylesheet"
	href="<c:url value='/resources/css/foundation.min.css'/>">


	
	<style type="text/css">
	#global
	{
		
		margin: 0 auto;
		width: 200px;
	}
	#backg
	{
		background-color: #E6E6E6;
	}
	
	
	</style>
</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>
	
	<div class="row">
		<div class="large-10 columns">
			<div class="panel">
			<c:if test="${ !empty param[' estSignale ']}">
		Ce témoignage a été bien signalé.
	</c:if>

				<div   class="row" style="text-align: center">
					<!-- <div class="large-10 columns"> -->
					<div  class="panel">
						<span><h4><b>${forum.titre}</b></h4> </span>
					</div>
					<!-- </div> -->
				</div>

				<!-- <div class="panel"> -->

				<div class="row">
					<div class="span">
						<!-- <div class="large-8 columns"> -->
						<ul
							class="large-12 columns">
							<li>
								<div class="panel">
									<span><h4>Détail de l'expérience :</h4></span>
									<p>${forum.desc }</p>
								</div> 
								<div class="panel">
									<span><h4>Date de publication:</h4></span>
									<p><fmt:formatDate pattern="yyyy-MM-dd" 
         								   value="${forum.date_pub }"/> </p>
								</div> 
									
								<!-- </div> --> 
							</li>
							
						</ul>
						<!-- </div> -->
					</div>
				</div>
			</div>
		</div>	
		 <div class="small-5 columns">
<%-- 				<a href="<c:url value='/signalisation/new/${forum.id}' />" --%>
<!-- 				class="button round">signaler</a> -->
				<a href="#" class="button alert" id="modalLauncher">signaler</a>
						
		</div> 
		<div id="myModal" class="reveal-modal" data-reveal>
		<h2 style="text-align: center">Entrez le motif</h2>
		<br />
	  <form method="get" action="<c:url value='/signalisation/newModal/${forum.id}' />">
	  	<div style="text-align: center">
	  	 	 ${forum.titre } 
	  	</div>
	  	<div class="large-12 columns" >
	  		<input placeholder="Motif" name="motif" type="text"/>
	  	</div>
	  		<br /> 
	  	
	  		<br/>
	  	<div>
	  		<input class="button alert" type="submit" value="Signaler"/>
	  	</div>
	  </form>
	    <a href="#" class="close-reveal-modal" id="closeModal">&#215;</a>
	</div>
		
	</div>
	
</body>
<script type="text/javascript">
		$("#modalLauncher").click(function (e) {
		    $('#myModal').foundation('reveal', 'open');
		    $('[data-reveal]').foundation('reveal','close')
		});

	</script>
</html>