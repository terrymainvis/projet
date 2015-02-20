<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Consulter l'éxpérience</title>
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
									<span><h4>Détail de l'éxpérience :</h4></span>
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
				<a href="<c:url value='/signalisation/new/${forum.id}' />"
				class="button round">signaler</a>
		</div> 
		
		<!-- ajoute le modal ici cccccccccccccc-->
		<a href="#" class="button alert" id="modalLauncher">signaler</a>
		<form:form id="addsignal" command="signal" method="post" action="">	
			<div id="myModal" class="reveal-modal">
			    <h2 style="text-align: center">Refus de l'annonce</h2>
			    <br />
			    <div class="large-12 columns" >
			         <input path="desc" placeholder="Motif" id="motif" type="text"/> 
			    </div>
			    <br />
			    <div style="text-align: center">
			      
			    </div>
			    <br/>
			    <div>
			        <input class="button" type="submit" value="Envoyer"/>
			    </div>
			    <a class="close-reveal-modal">&#215;</a>
			</div>
		</form:form>
		<!-- ajoute le modalFIN MODAL cccccccccccccc-->
	</div>
	
	<!--ajoute le script ici  -->
	<script type="text/javascript">
    $("#modalLauncher").click(function (e) {
    $('#myModal').foundation('reveal', 'open');
    });
</script>
	
</body>

</html>