<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Amizades</title>

<!-- <!-- 	 Import Google Icon Font
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	Import materialize.css
	<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

	Compiled and minified CSS
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>          
	 Compiled and minified JavaScript
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script> 
 -->


</head>
<body>

<nav class="indigo darken-4">
    <div class="container">
      <a href="#" class="brand-logo">Orkut</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a href="logout">Logout</a></li>
      </ul>
    </div>
</nav>


<h2>Inserir amigos para ${usuario.nome} </h2>

<form action="inserirAmizade" method="post">
	<table border="1">
		<c:forEach var="u" items="${potenciais_amigos}">
			<c:if test="${usuario.id != u.id}">
			<tr>
				<td>${u.id}</td>
				<td>${u.nome}</td>
				<td><img width="100" height="100" src='<c:url value="/resources/images/${u.login}.png" />' /></td>
				
				<td><form:checkbox path="amizade.amigos" value="${u.id}" /></td>
				
			</tr>
			</c:if>
		</c:forEach>	
	</table>
	<input type="submit" value="OK">
</form>
</body>
</html>