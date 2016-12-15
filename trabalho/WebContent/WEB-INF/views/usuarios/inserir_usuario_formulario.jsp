<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulario</title>

<!--Import Google Icon Font-->
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!--Import materialize.css-->
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
        <li><a href="login">Login</a></li>
	    <li><a href="inserirUsuarioFormulario">Cadastre-se</a></li>
      </ul>
    </div>
  </nav>

<div class="container">
        <div class="row">
    </div>
        <div class="row">
            <div class="col s12 m12 l6 offset-l3">
                <form action="inserirUsuario" method="post" enctype="multipart/form-data">
                    <div class="card white darken-1">
                        <div class="card-content black-text">
                            <center><span class="card-title blue-text text-darken-4">Informe seus dados</span></center>
                            <div class="row">
                                <div class="input-field col s6">
                                    <input id="nome" name="nome" type="text" class="validate">
                                    <label for="nome">Nome</label>
                                </div> 
                                <div class="input-field col s6">
                                    <input id="sobrenome" name="sobrenome" type="text" class="validate">
                                    <label for="sobrenome">Sobrenome</label>
                                </div>
                            </div>
                            <div class="row">
                            	<div class="input-field col s6">
                                	<input id="idade" name="idade" type="text" class="validate">
                                	<label for="idade">Idade</label>
                                </div>	
                                <div class="input-field col s6">
                                	<input id="email" name="email"type="text" class="validate">
                                	<label for="email">Email</label>
                                </div>	
                            </div>
                            <div class="row">
                            	<div class="input-field col s6">
                                	<input id="login" name="login" type="text" class="validate">
                                	<label for="login">Login</label>
                                </div>	
                                <div class="input-field col s6">
                                    <input id="senha" name="senha" type="password" class="validate">
                                    <label for="senha">Senha</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="file-field input-field">
							      <div class="btn">
							        <span>Imagem</span>
							        <input id="image" name="image" type="file">
							      </div>
							      <div class="file-path-wrapper">
							        <input  class="file-path validate" type="text" placeholder="Selecione uma imagem para sua foto de perfil" />
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

<!--   
<h2>Inserir Usuário</h2>

<form action="inserirUsuario" method="post" enctype="multipart/form-data">
	Nome: <input type="text" name="nome"><br />
	Idade: <input type="text" name="idade"><br />
	Email: <input type="text" name="email"><br />
	Login: <input type="text" name="login"><br />
	Senha: <input type="text" name="senha"><br />
	<input type="file" name="image" /><br />
	<input type="submit" value="Enviar">
</form>
 -->

</body>
</html>