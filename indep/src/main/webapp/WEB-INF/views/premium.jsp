<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
  <title>Control Financiero</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="../../assets/css/main2.css">
  <link rel="stylesheet" href="../../assets/css/premium.css">
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand">
        <img alt="Brand" src="../../images/logo-inv.png" width="35px">
      </a>
      <p class="navbar-text">Control Financiero</p>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="./tablero">Tablero</a></li>
        <li><a href="#">Gastos</a></li>
        <li><a href="#">Ingresos</a></li>
        <li><a href="#">Inversiones</a></li>
        <li class="active"><a href="./premium">Premium</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Mi Cuenta</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container-fluid text-center volver">
  <h2>Tu Perfil de Inversion es: valorDelBackend</h2>
  <a href="./premium-pf" class="btn btn-primary" role="button">Realizar el test de Inversion</a>
  <br>
  <br>
  <a href="./premium-op1.html" class="btn btn-info" role="button">Alternativa al Plazo fijo</a>
  <a href="#" class="btn btn-info" role="button">Comprar dolares al mejor precio</a>
  <a href="#" class="btn btn-info" role="button">Bonos Dolarizados</a>
  <a href="#" class="btn btn-info" role="button">Acciones Recomendadas</a>
</div>


<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
  <div class="container crop">
    <center><img src="../../images/bannerInv.png" class="img-responsive"></center>
  </div>
</div>

</body>
</html>