<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Listar Forum</title>

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
  <center> 
   <h2>${forum.titulo}</h2>
   <h3>${forum.descricao}</h3>
  </center>
 
 <div class="row">
 
	<div class="row">
	   <label><h5>Mensagens:</h5></label>
	   <table border="1">
	   		<thead>
	   			<tr>
	   				<th>Foto</th>
	   				<th>Mensagem</th>
	   			</tr>
	   		</thead>
	   		<tbody>
   			   	<c:forEach var="mensagem" items="${forum.mensagens}">
   			   	<tr>
   			   		<td>
   			   			<div>
   			   				<center>
	   			   			<img src='<c:url value="/${mensagem.usuario.fotoPerfil}"></c:url>' width="50"  />
	   			   			</center>
   			   			</div>
   			   			<div>
   			   				<a href='<c:url value="/perfil/${mensagem.usuario.id}"></c:url>'>${mensagem.usuario.nome} ${mensagem.usuario.sobrenome}</a>
   			   			</div>
   			   		</td>
			   		<td>${mensagem.texto}</td>
			   	</tr>
			   	</c:forEach>
	   		</tbody>
	   </table>
   </div>
   
   <div class="row">
   <h5>Nova Mensagem</h5>
    <form action='<c:url value="/adicionarMensagem/${comunidade.id}/${forum.forumId}"></c:url>' method="post" enctype="multipart/form-data">
         <div class="card white darken-1">
             <div class="card-content black-text">
                 <div class="row">
                 	<div class="input-field col s12">
                     	<label for="texto">Texto:</label>
                     	<input id="texto" name="texto" type="text" class="validate">
                     </div>
                 </div>
             </div>
             <div class="card-action right-align">
                 <button class="waves-effect waves-red btn indigo darken-4"><i class="material-icons left"></i>Enviar</button>
             </div>
         </div>
     </form>
   </div>
</div>   
</body>
</html>