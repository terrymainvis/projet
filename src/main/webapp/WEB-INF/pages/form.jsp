    <%@ page language="java" contentType="text/html; charset=UTF-8"  
     pageEncoding="UTF-8"%>  
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
    <html>  
    <head>  
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
    <title>Creation categorie</title>  
    </head>  
    <body>  
      <c:url var="userRegistration" value="saveUser.html" />  
      <form:form id="addCatForm" modelAttribute="categorie" method="post"  
       action="addCat">  
       <table width="400px" height="150px">  
        <tr>  
         <td><form:label path="lib">Libelle</form:label>  
         </td>  
         <td><form:input path="lib" />  
         </td>  
        </tr>  
        <tr>  
         <td><form:label path="desc">Description</form:label>  
         </td>  
         <td><form:input path="desc" />  
         </td>  
        </tr>  
        <tr>  
         <td></td>  
         <td><input type="submit" value="Ajouter" /></td>  
        </tr>  
       </table>  
      </form:form>  
       
      <a href="list">Liste des categories</a>  
    </body>  
    </html>  