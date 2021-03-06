<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
  <title>Control Financiero</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="assets/js/amcharts/amcharts.js" type="text/javascript"></script>
  <script src="assets/js/amcharts/serial.js" type="text/javascript"></script>
  <!--<link rel="stylesheet" href="estilos3.css">-->

  <%
    String serverContent = (String)request.getAttribute("chartData");
  %>

  <script>
      AmCharts.makeChart("chart", <%=serverContent%>);
  </script>
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
        <img alt="Brand" src="images/logo-inv.png" width="35px"> 
      </a>
      <p class="navbar-text">Control Financiero</p>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="./tablero.jsp">Tablero</a></li>
        <li><a href="#">Gastos</a></li>
        <li><a href="#">Ingresos</a></li>
        <li><a href="#">Inversiones</a></li>
        <li><a href="./premium.jsp">Premium</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Mi Cuenta</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li>
      </ul>
    </div>
  </div>
</nav>
 

<div class="container-fluid text-center">
<%
    Object total = request.getAttribute("total");
	Object ingresos = request.getAttribute("ingresos");
	Object egresos = request.getAttribute("egresos");
%>
  <div id="chart" style="width: 100%; height: 200px;"></div>
  <br>
  <br>
  <br>
  <br>
  <br>
</div>

<div class="container-fluid text-center">
  <a href="#" class="btn btn-primary" role="button">Evolución</a>
</div>

<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
  <div class="container">
    <img src="images/banner2.jpg" class="img-responsive">
  </div>
</nav>

</body>
</html>