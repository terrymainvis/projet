<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
				<!-- </div> -->

			<!-- <div class="large-4 columns">
			<a href="#" data-reveal-id="firstModal" class="radius button"> signaler;</a>
			
			</div> -->


			
			</div>
		</div>	
		<div id="myModal" class="reveal-modal">
		     <h1>Modal Title</h1>
		     <p>Any content could go in here.</p>
		     <a class="close-reveal-modal">&#215;</a>
		</div>
		<div class="large-4 columns">
			<a href="#" data-reveal-id="myModal">Click Me For A Modal</a>
		</div>
		<span data-tooltip aria-haspopup="true" class="has-tip" title="Tooltips are awesome, you should totally use them!">extended information</span>
		
	</div>
</body>
<script src="<c:url value="/resources/js/foundation/foundation.reveal.js" />" type="text/javascript"> </script>
<script src="<c:url value="/resources/js/foundation.min.js"  /> " type="text/javascript" type="text/javascript"> </script>
<script type="text/javascript"> 
	$(document).ready(function(){
		$(document).foundation();
		$('#myModal')
		.click(	
				function() {
					document.getElementById("myModal").innerHTML=" ";
				}	);
		
	});
</script>
</html> --%>