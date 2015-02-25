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
		<h2 style="text-align:center">Nouvelle annonce</h2> <br/>
		
		<!-- l'action dirige vers la fonction annonce/new/form -->
		<form method="get" action="form" >
			<div>
				<form:select path="annform.cat_choisie" id="selectCat" onchange="changeFunc();">
					<form:option value=""  style="text-align:center"><spring:message code="annFormSelectCat.selection"></spring:message></form:option>
					<form:options items="${catlist}" itemValue="id" itemLabel="lib" />
				</form:select>				
			</div>
			<br/>
			<div id="inputs">
			</div>
			<br/>
			<div style="text-align:center">				
				<input class="button" id="boutonSoumettre" type="submit" value="Soumettre" />
			</div>
		</form>
	</div>
</body>

<script type="text/javascript">
	function changeFunc() {
	    var selectBox = document.getElementById("selectCat");
	    var selectedValue = selectBox.options[selectBox.selectedIndex].value;
		var selectedCat = selectBox.options[selectBox.selectedIndex].text;
		
	    if(selectBox.options[selectBox.selectedIndex].text != "Choisissez une catégorie"){
	    	if(selectBox.options[selectBox.selectedIndex].text != "Please choose a category"){
	    		document.getElementById('inputs').innerHTML = '';
    			<c:forEach items="${champs}" var="champ">
	    			var catID = "<c:out value="${champ.cat.id}"/>"; 
	    			
    				if (catID == selectedValue){
    	    			var champType = "<c:out value="${champ.type}"/>";
    	    			var champID = "<c:out value="${champ.id}"/>";
    	    			var champName = "<c:out value="${champ.nom}"/>";
    	    			
    		    		if (champType == 'TEXTE' || champType == 'DESCRIPTION'){
        		    		document.getElementById('inputs').innerHTML += 
        		    			'<input type="text" name="champ_id['+ champID +']" placeholder="'+ champName +'" />';
    		    		} else if (champType == 'NUMERIQUE'){
    		    			document.getElementById('inputs').innerHTML += 
        		    			'<input type="text" name="champ_id['+ champID +']" placeholder="'+ champName +'" />';
    		    		} else if (champType == 'DATE'){
    		    			document.getElementById('inputs').innerHTML += 
        		    			'METTRE UN DATEPICKER';
    		    		}
    				}
    				
    			</c:forEach>
	    		
	    		document.getElementById('boutonSoumettre').className = 'button';
	    	}
	    }
	    if(selectBox.options[selectBox.selectedIndex].text == "Choisissez une catégorie" || selectBox.options[selectBox.selectedIndex].text == "Please choose a category"){
    		document.getElementById('inputs').innerHTML = '';
    		document.getElementById('boutonSoumettre').className = 'button disabled';
    		
	    }
	    
	}
	

</script>
</html>