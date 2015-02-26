    <%@ page language="java" contentType="text/html; charset=UTF-8"  
     pageEncoding="UTF-8"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
    <html>  
    <head>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <link rel="stylesheet"
	href="http://cdn.foundation5.zurb.com/foundation.css">
    <title>Liste des catégories</title>  
    </head>  
    <body class="bg">  
      <%@ include file="../templates/header.jsp" %>
 
      <c:if test="${!empty catList}">  
       <table border="1" bgcolor="black" width="600px">  
        <tr  
         style="background-color: teal; color: white; text-align: center;"  
         height="40px">  
           
         <td>Libellé</td>  
         <td>Description</td>  
        </tr>  
        <c:forEach items="${catList}" var="cat">  
         <tr  
          style="background-color: white; color: black; text-align: center;"  
          height="30px">  
            
          <td><c:out value="${cat.lib}" />  
          </td>  
          <td><c:out value="${cat.desc}" />  
          </td>  
         </tr>  
        </c:forEach>  
       </table>  
      </c:if>  
      
      
      <a href="cat_form">Ajouter une catégorie</a>  
    </body>  
    </html>  