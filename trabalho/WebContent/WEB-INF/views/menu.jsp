<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu</title>

	 <!-- Import Google Icon Font-->
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!--Import materialize.css-->
	<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

	<!-- Compiled and minified CSS-->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>          
	Compiled and minified JavaScript
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

<div class="row">

      <div class="col s3">
        <!-- Grey navigation panel -->
		
		<table border="1">
			<c:forEach var="usuario" items="${usuario_logado}">
				<tr>
					<td><img width="50" height="50" src='<c:url value="WebContent/resources/images/${usuario_logado.login}.png" />' /> </td>
					<td><p class="flow-text">Bem-vindo, ${usuario_logado.nome}!</p></td>
				</tr>
			</c:forEach>	
        </table>
        
		<ul class="collection">
		    <li class="collection-item avatar">
		      <i class="material-icons circle">perm_identity</i>
		      <span class="title">Buscar amigos</span>
		      <p>Search friends</p>
		      <a href="inserirAmizadeFormulario" class="secondary-content"><i class="material-icons">play_arrow</i></a>
		    </li>
		    <li class="collection-item avatar">
		      <i class="material-icons circle green">group_work</i>
		      <span class="title">Comunidades</span>
		      <p>Community</p>
		      <a href="#!" class="secondary-content"><i class="material-icons">play_arrow</i></a>
		    </li>
		    <li class="collection-item avatar">
		      <i class="material-icons circle red">play_arrow</i>
		      <span class="title">Title</span>
		      <p>First Line <br>
		         Second Line
		      </p>
		      <a href="#!" class="secondary-content"><i class="material-icons">play_arrow</i></a>
		    </li>
		</ul>
            
          

        
      </div>

      <div class="col s9">
        <!-- Teal page content  -->
       <!--  <a href="listarUsuario">Listar usuarios</a><br /> -->
      </div>

    </div>


<!-- <div class="row">
  <div class="card col s2 cyan darken-4">
    <div class="card-image waves-effect waves-block waves-light" >
      <img class="activator" src="images/office.jpg">
    </div>
    <div class="card-content">
      <span class="card-title activator grey-text text-white-4">Comunidades<i class="material-icons right">more_vert</i></span>
      <p><a href="#">Visitar</a></p>
    </div>
    <div class="card-reveal">
      <span class="card-title grey-text text-darken-4">Comunidades<i class="material-icons right">close</i></span>
      <p>Here is some more information about this product that is only revealed once clicked on.</p>
    </div>
  </div>
 </div>
 -->            

<a href="inserirAmizadeFormulario">AMIZADE</a>

	

</body>
</html>