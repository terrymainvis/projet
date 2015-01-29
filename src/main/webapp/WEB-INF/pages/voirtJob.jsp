<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Consulter une offre de job</title>
<link rel="stylesheet" href="<c:url value="/resources/css/form.css" />">
<link rel="stylesheet"
	href="http://cdn.foundation5.zurb.com/foundation.css">
	
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
						<span><h4><b>${job.titre}</b></h4> </span>
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
									<span><h4>Détail de l'offre :</h4></span>
									<p>${job.desc }</p>
								</div> 
								<div class="panel">
									<span><h4>Prix:</h4></span>
									<p>${job.prix }</p>
								</div> 
									
								<div class="panel callout radius">
									
									<div>
										<div>
										
											<div id="global" >
												<input name="secondMail" class="button small" type="submit"
													value="Postuler" />
											</div>
										</div>
									</div>
								</div> <!-- </div> -->
							</li>
							<li>
								<!-- <div class="large-8 columns"> -->
								
							</li>
						</ul>
						<!-- </div> -->
					</div>
				</div>
				<!-- </div> -->





			</div>
		</div>
	</div>
</body>
</html>