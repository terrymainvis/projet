<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="<c:url value="/resources/js/vendor/jquery.js" />"></script>

<title>List</title>


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

</head>
<body class="bg">
	<%@ include file="../templates/header.jsp"%>

	<div class="row">
		<div class="large-10 columns">
			<div class="panel" style="text-align: center">

				<b><b>liste des offres de job</b></b><br> <br>

				<div class="row" style="text-align: center">

					<table id="listejobs" class="display" cellspacing="0" width="200%">
						<thead>
							<tr>
								<th>Titre</th>
								<th>description</th>
								<th>Prix</th>
								
								<th></th>
								<th></th>
							</tr>
							<tr></tr>
						</thead>
						<tfoot>

						</tfoot>
						<tbody id="lignes">
							<c:if test="${!empty jobList}">
								<c:forEach items="${jobList}" var="job">
									<tr>
										<td><table border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td width="400" height="80"  colspan="2"><b><b>${job.titre}</b></b></td>
												</tr>
											</table></td>

										<td>
											<table border="0" cellspacing="0" cellpadding="0">
												<tr>
											
													<td width="500" height="80" style="word-break:break-all;"><i>${job.desc.toString().substring(0,50)}</i>...</td>
												</tr>
											</table>
										</td>
										<td>
											<table border="0" cellspacing="0" cellpadding="0">
												<tr>
													<td width="270" height="80" >${job.prix}</td>
												</tr>
											</table>


										</td>
									
										<td><a href="<c:url value='/job/${job.id}'/>"
											class="button round">Details</a></td>
									</tr>
								</c:forEach>
							</c:if>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

	<br>
<!-- 	il faut que ça soit accessible que pour l'admin,prof(tous sauf les étudiants) -->	
<a href="<c:url value="/job/new"  />">Ajout une nouvelle offre de job</a>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#listejobs').DataTable({});
		});
	</script>
</body>
</html>
