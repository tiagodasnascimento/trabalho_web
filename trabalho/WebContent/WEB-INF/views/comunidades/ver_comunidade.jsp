<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Comunidade</title>

	 <!-- Import Google Icon Font-->
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!--Import materialize.css-->
	<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

	<!-- Compiled and minified CSS-->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>          
	<!--  Compiled and minified JavaScript -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>

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
   <h5>${comunidade.nome}</h5>
   <c:choose>
   		<c:when test="${participando == true}">
   			<h6>Você está participando desta Comunidade</h6>
   			<br>
   		</c:when>
   		<c:when test="${participando == false}">
   			<a href="<c:url value="/participarComunidade/${comunidade.id}" />">Participar</a>
   		</c:when>
   </c:choose>
   
   <div class="row">
	   <label><h5>Participantes:</h5></label>
	   <ul>
	   	<c:forEach var="usuario" items="${comunidade.usuarios}">
	   		<li>${usuario.nome}</li>
	   	</c:forEach>
	   </ul>
   </div>
   
<div class="row">
<h5>Novo Forum</h5>
	<div class="col s6">
		<form action='<c:url value="/adicionarForum/${comunidade.id}"></c:url>' method="post" enctype="multipart/form-data">
	    	<div class="card white darken-1">
	             <div class="card-content black-text">
	                 <div class="row">
	                 	<div class="input-field col s12">
	                     	<label for="titulo">Título:</label>
	                     	<input id="titulo" name="titulo" type="text" class="validate">
	                     </div>
	                 </div>
	                 <div class="row">	
	                     <div class="input-field col s12">
	                         <label for="descricao">Descrição:</label>
	                         <input id="descricao" name="descricao" type="text" class="validate">
	                     </div>
	                 </div>
	             </div>
	             <div class="card-action right-align">
	                 <button class="waves-effect waves-red btn indigo darken-4"><i class="material-icons left"></i>Enviar</button>
	             </div>
	         </div>
	     </form>
	</div>
	<div class="col s6">
		<h5>Fóruns</h5>
		<table border="1">
	   		<thead>
	   			<tr>
	   				<th>Título</th>
	   				<th>Descrição</th>
	   				<th>Opções</th>
	   			</tr>
	   		</thead>
	   		<tbody>
   			   	<c:forEach var="forum" items="${comunidade.foruns}">
   			   	<tr>
			   		<td>${forum.titulo}</td>
			   		<td>${forum.descricao}</td>
			   		<td><a href="<c:url value="/verForum/${comunidade.id}/${forum.forumId}"/>">Ver</a></td>
			   	</tr>
			   	</c:forEach>
	   		</tbody>
	   </table>
   </div>
</div>
   
</body>
</html>