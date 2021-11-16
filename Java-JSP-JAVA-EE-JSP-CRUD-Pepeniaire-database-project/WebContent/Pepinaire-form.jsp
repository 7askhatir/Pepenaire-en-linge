<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Pépinière en ligne</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
				<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
					<div>
						<a href="" class="navbar-brand"> Pépinière en ligne </a>
					</div>
		
					<ul class="navbar-nav">
						<li><a href="<%=request.getContextPath()%>/list"
							class="nav-link">Produit</a></li>
					</ul>
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		    
		    </ul>
		    <form class="form-inline my-2 my-lg-0" action="search" >
		      <input class="form-control mr-sm-2" type="search" name="search" placeholder="Search" aria-label="Search">
		      <button class="btn btn-outline-success my-2 my-sm-0"   type="submit">Search</button>
		    </form>
		  </div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${Pepinaire != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${Pepinaire == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${Pepinaire != null}">
            			Edit User
            		</c:if>
						<c:if test="${Pepinaire == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>

				<c:if test="${Pepinaire != null}">
					<input type="hidden" name="id" value="<c:out value='${Pepinaire.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Name Produit</label> <input type="text"
						value="<c:out value='${Pepinaire.nom}' />" class="form-control"
						name="nom" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Categorie</label> <input type="text"
						value="<c:out value='${Pepinaire.cate}' />" class="form-control"
						name="cate">
				</fieldset>


				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>