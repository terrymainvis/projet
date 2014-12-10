<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>
<link rel="stylesheet"
	href="<c:url value="/resources/css/header.css" />	">
<!-- <nav class="top-bar" data-topbar role="navigation">
	<section class="top-bar-section">
		<ul class="right">

			<li class="has-form"><input type="text" placeholder="Search"></li>

			<li class="has-dropdown not-click"><a href="#">Dropdown</a>
				<ul class="dropdown">
					<li class="title back js-generated">kjkjkj</li>

				</ul></li>

			<li class="has-form"><a href="#" class="alert button expand">Search</a>
			</li>
		</ul>
	</section>
</nav> -->

<nav class="top-bar" data-topbar role="navigation">

  <section class="top-bar-section">
    <!-- Right Nav Section -->
    <ul class="center">
      <li class="has-form"><input type="text" placeholder="Search"></li>
      <li class="has-dropdown">
      
        <a href="#">Categories</a>
        <ul class="dropdown">
        
        <c:forEach items="${catList}" var="cat">  
        
          
                <li ><a href="categorie/annonceByCat?idCatSelect=<c:out value='${cat.id}' />"><c:out value='${cat.lib}' /> </a></li>  
          
    
          
        </c:forEach> 
    
        </ul>
      </li>
      			<li class="has-form"><a href="#" class="alert button expand">Search</a>
      
    </ul>

    <!-- Left Nav Section -->
    
  </section>
</nav>





<nav class="top-bar" data-topbar role="navigation">
	<section class="top-bar-section">

		<ul class="title-area">
			<li class="name">
				<h1>
					<a href="<c:url value="/" />">Accueil L1C</a>
				</h1>
			</li>
		</ul>
		<ul class="right">
			<li><a href="#">Covoiturage</a></li>
			<li><a href="#">Petites annonce</a></li>
			<li><a href="#">Job</a></li>
			<li><a href="#">Forum</a></li>
		</ul>

		<ul class="left">
			<li><a href="#">Mon compte</a></li>
		</ul>
	</section>
</nav>