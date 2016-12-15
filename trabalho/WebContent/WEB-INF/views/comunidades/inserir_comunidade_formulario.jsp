<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Comunidade</title>

    <!--  Import Google Icon Font-->
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!-- Import materialize.css -->
	<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

	<!-- Compiled and minified CSS -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>          
	<!-- Compiled and minified JavaScript -->
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

<div class="container">
        <div class="row">
    </div>
        <div class="row">
            <div class="col s12 m12 l6 offset-l3">
                <form action="inserirComunidade" method="post" enctype="multipart/form-data">
                    <div class="card white darken-1">
                        <div class="card-content black-text">
                            <div class="row">
                                <div class="input-field col s12">
                                    <label for="nome">Nome da Comunidade</label>
                                    <input id="nome" name="nome" type="text" class="validate">             
                                </div> 
                            </div>
                            <div class="row">
                            	<div class="input-field col s12">
                            		<div>
                                		<label for="categoria">Categoria:</label>
                                		<div class="input-field col s12">
										    <select name="categoria">
											    <c:forEach items="${categorias}" var="categoria">
											    	<option value="${categoria}">${categoria}</option>
											     </c:forEach>
											</select>
										</div>
									</div>
                                </div>		
                            </div>
                            <div class="row">
                                <div class="file-field input-field">
							      <div class="btn">
							        <span>Imagem</span>
							        <input id="image" name="image" type="file">
							      </div>
							      <div class="file-path-wrapper">
							        <input  class="file-path validate" type="text" placeholder="Selecione uma imagem para sua a nova comunidade" />
							      </div>
							    </div>
                            </div>
                        </div>
                        <div class="card-action right-align">
                            <button class="waves-effect waves-red btn indigo darken-4"><i class="material-icons left"></i>Entrar</button>
                        </div>
                    </div>
                </form>
            </div>
</body>
</html>