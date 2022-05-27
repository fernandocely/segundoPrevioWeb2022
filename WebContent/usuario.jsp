<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/style.css">
	<title>BANCO BBVA</title>

</head>

<body id="body_inicio_sesion">

    <div id="contenedor">
        <div id="central">
            <div id="login">
                <div class="titulo">
                    <img src="img/logo.jpg">
                </div>
                <form id="loginform">
                    <p>Username</p>
                    <input type="text" placeholder="User" id="user" required>
                    <p>Password</p>
                   <input type="password" placeholder="Contraseña" id="password" required>
                   
                    <button type="submit" value="ingresar" id="ingresar">Ingresar</button>
                </form>
            </div>
            </div>
    </div>
        
    <footer id="main-footer">
        <div class="row">
             <div class="col-12 col-md">
                <img class="mb-2" src="img/icono.png" alt="" width="24" height="19">
                <small class="d-block mb-3 text-muted">&copy; 2022</small>
              </div>
              
              <div class="col-6 col-md">
                <h5>Informacion</h5>
                <ul class="list-unstyled text-small">
                  <li><a class="link-secondary">Primer previo web</a></li>
                  
                </ul>
              </div>
            </div>
        
            <p>&copy; 2022 Derechos Reservados</p>
          </footer> 
 <script type="text/javascript" src="js/login.js"></script>
</body>
</html>