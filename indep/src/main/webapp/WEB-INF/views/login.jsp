<%--
  Created by IntelliJ IDEA.
  User: rumm
  Date: 12/06/17
  Time: 02:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <head>
        <title>Control Financiero</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <!--[if lte IE 8]><script src="./assets/js/ie/html5shiv.js"></script><![endif]-->
        <link rel="stylesheet" href="./assets/css/main.css" type="text/css"/>
        <!--[if lte IE 8]>
        <link rel="stylesheet" href="assets/css/ie8.css"/><![endif]-->
        <!--[if lte IE 9]>
        <link rel="stylesheet" href="assets/css/ie9.css"/><![endif]-->
        <script src="assets/js/login.js" type="text/javascript"></script>
        <script src="./assets/js/jquery.min.js"></script>
        <script src="./assets/js/jquery.poptrox.min.js"></script>
        <script src="./assets/js/jquery.scrolly.min.js"></script>
        <script src="./assets/js/jquery.scrollex.min.js"></script>
        <script src="./assets/js/skel.min.js"></script>
        <script src="./assets/js/util.js"></script>
        <!--[if lte IE 8]><script src="./assets/js/ie/respond.min.js"></script><![endif]-->
    </head>
</head>

<body>

<!-- Header -->
    <header id="header">
        <img src="./images/logo.png"/>
        <h1 id="desp">Control Financiero</h1>
        <nav>
            <ul>
                <li><a href="/#intro">Inicio</a></li>
                <li><a href="/#one">Quiénes Somos</a></li>
                <li><a href="/#two">Cómo Funciona</a></li>
                <li><a href="/#work">Servicios</a></li>
                <li><a href="/#contact">Contacto</a></li>
            </ul>
        </nav>
    </header>
    <h1>Login</h1>
    <div><h1 class="login-error-container"></h1></div>
    <form id="login-form">
        <table>
            <tr>
                <td>Usuario</td>
                <td><input type="text" name="username" /></td>
            </tr>
            <tr>
                <td>Contraseña</td>
                <td><input type="password" name="password" /></td>
            </tr>
        </table>
        <input type="submit" value="Iniciar Sesión"/>
    </form>
    <h1>Registrarse</h1>
    <div><h1 class="register-error-container"></h1></div>
    <form id="register-form">
        <table>
            <tr>
                <td>Usuario</td>
                <td><input type="text" name="username" /></td>
            </tr>
            <tr>
                <td>Contraseña</td>
                <td><input type="password" name="password" /></td>
            </tr>

            <tr>
                <td>Correo</td>
                <td><input type="text" name="email" /></td>
            </tr>
        </table>
        <input type="submit" value="Registrarse" />
    </form>


</body>

</html>
