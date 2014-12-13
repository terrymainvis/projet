<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Consulter une annonce</title>
<link rel="stylesheet" href="<c:url value="/resources/css/form.css" />">
<link rel="stylesheet"
	href="http://cdn.foundation5.zurb.com/foundation.css">
</head>
<body>
<%@ include file="../templates/header.jsp" %>
<div class="row">
<div class="large-10 columns">
<div class = "panel">		
 
					<div class="row" style="text-align : center">
						<!-- <div class="large-10 columns"> -->
							<div class="panel">
								<span><h4> Titre : ${annonce.titre} </h4> </span>
							</div>
						<!-- </div> -->
					</div>
		
		<!-- <div class="panel"> -->
					
						<div class="row">
							<div class="span">
							<!-- <div class="large-8 columns"> -->
								<ul class="small-block-grid-2 medium-block-grid-2 large-block-grid-2">
									<li>
										<div class="panel">
											<span><h4> La description de l'annonce :</h4></span>
											<p>
												${annonce.desc }
											</p>
										</div>
									</li>
									<li>
										<!-- <div class="large-4 columns">
											<div class="panel callout radius">
												<h5>Contact</h5>
												<span> telephone : 098766</span>
												
											</div>
										</div> -->
										<!-- <div class="large-8 columns"> -->
											<div class="panel callout radius">
												<h4>Contact</h4>
														<div>
															<div>
																<span><h5>Telephone:</h5> 060000000 </span>
																<span></span>
																</br>								
																<div >
																	<span><h5>Adresse mail</h5></span> 
																	<span>${current_user.mailLille1} </span>
																</div>
																</br>
																<div>
																	<input name="secondMail" class="button small" type="submit" value="Envoyer un message" />
																</div>
															</div>
														</div>
											</div>
										<!-- </div> -->
									</li>
								</ul>
							<!-- </div> -->
						</div>
					</div>
			<!-- </div> -->
			<div class="panel">
				<div class="row">
					<!-- <div class="large-8 columns"> -->
								
									<div >
										 <span><h4>images</h4></span>
									</div>
									<div class="small-2 medium-2 large-2 columns">
										<img height="100" width="auto" src="<c:url value="/resources/img/chat.png" />">
									</div>	
									<div class="small-2 medium-2 large-2 columns">
										<img height="100" width="auto" src="<c:url value="/resources/img/chat.png" />">
									</div>	
									<div class="small-2 medium-2 large-2 columns">
										<img height="100" width="auto" src="<c:url value="/resources/img/chat.png" />">
									</div>	
					<!-- </div> -->			
				</div>
			</div>	
			
			
		

</div>
</div>
</div>
</body>
</html>