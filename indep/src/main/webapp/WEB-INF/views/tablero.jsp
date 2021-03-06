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
  <script src="assets/js/jquery-1.11.1.js" type="text/javascript"></script>
  <script src="assets/js/ajax.js" type="text/javascript"></script>
  <script src="assets/js/premium.js" type="text/javascript"></script>
  <script src="assets/js/tablero.js" type="text/javascript"></script>
  <script src="assets/js/gastos.js" type="text/javascript"></script>
  <script src="assets/js/moment.js" type="text/javascript"></script>
  <script src="assets/js/jspkg-archive/jquery.dynatable.js" type="text/javascript"></script>
  <link rel="stylesheet" href="assets/css/main2.css" />
  <link rel="stylesheet" href="assets/js/jspkg-archive/jquery.dynatable.css" />
  <link rel="stylesheet" href="assets/css/font-awesome-4.7.0/css/font-awesome.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="assets/css/w3.css" />
  <link rel="stylesheet" href="../../assets/css/premium.css">
  <style>
    html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
  </style>
</head>
<body class="w3-light-grey">

<nav class="navbar-inverse row">
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
        <li id="tb"><a id="showTablero"href="./tablero">Tablero</a></li>
        <li id="gs"><a id="showGastos" href="#gastos">Gastos</a></li>
        <li id="ing"><a id="showIngresos" href="#ingresos">Ingresos</a></li>
        <li id="inv"><a id="showInversiones" href="#inversiones">Inversiones</a></li>
        <li id="pr"><a id="showPremium" href="#premium">Premium</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Mi Cuenta</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li>
      </ul>
    </div>
  </div>
</nav>



<div class="main-container" style="height: 90%">
  <%
    String serverContent = (String)request.getAttribute("chartData");
    String monthlyChart = (String)request.getAttribute("monthlyChart");
    String inversiones = (String)request.getAttribute("inversiones");
    String gastos = (String)request.getAttribute("gastos");
    String ingresos = (String)request.getAttribute("ingresos");
    String balance = (String)request.getAttribute("balance");
  %>

  <script>
      activarTablero();
      AmCharts.makeChart("chart", <%=serverContent%>);

      function showEvolucion() {
          document.getElementById("chart").style.height="400px";
          AmCharts.makeChart("chart", <%=monthlyChart%>);
          document.getElementById("clickMe").value = "Tablero";
          document.getElementById("clickMe").setAttribute( "onClick", "javascript: showTablero();" );
      }

      function showTablero() {
          document.getElementById("chart").style.height="200px";
          AmCharts.makeChart("chart", <%=serverContent%>);
          document.getElementById("clickMe").value = "Evolución";
          document.getElementById("clickMe").setAttribute( "onClick", "javascript: showEvolucion()" );
      }
  </script>

  <div class="w3-main">

    <!-- Header -->
    <header class="w3-container" >
      <h5><b><i class="fa fa-dashboard"></i> Mi Tablero</b></h5>
    </header>

    <div class="w3-row-padding w3-margin-bottom">
      <div class="w3-quarter">
        <div class="w3-container w3-teal w3-padding-16">
          <div class="w3-left" id="inversionesSquare">
            <h2><%= inversiones %></h2>
          </div>
          <div class="w3-right"><i class="fa fa-dollar w3-xxxlarge"></i></div>
          <div class="w3-clear"></div>
          <h4>Inversiones</h4>
        </div>
      </div>
      <div class="w3-quarter">
        <div class="w3-container w3-red w3-padding-16">
          <div class="w3-right"><i class="fa fa-pie-chart w3-xxxlarge"></i></div>
          <div class="w3-left" id="gastosSquare">
            <h2><%= gastos %></h2>
          </div>
          <div class="w3-clear"></div>
          <h4>Gastos del Mes</h4>
        </div>
      </div>
      <div class="w3-quarter">
        <div class="w3-container w3-green w3-text-white w3-padding-16">
          <div class="w3-right"><i class="fa fa fa-money w3-xxxlarge"></i></div>
          <div class="w3-left" id="ingresosSquare">
            <h2><%= ingresos %></h2>
          </div>
          <div class="w3-clear"></div>
          <h4>Ingresos Del Mes</h4>
        </div>
      </div>
      <div class="w3-quarter">
        <div class="w3-container w3-blue w3-padding-16">
          <div class="w3-right"><i class="fa fa-suitcase w3-xxxlarge"></i></div>
          <div class="w3-left" id="balanceSquare">
            <h2><%= balance %></h2>
          </div>
          <div class="w3-clear"></div>
          <h4>Balance del Mes</h4>
        </div>
      </div>
    </div>
  </div>

  <div class="container-fluid">
    <div id="chart" style="width: 100%; height: 200px ;"></div>
  </div>

  <div class="container-fluid text-center">
    <input id="clickMe" class="btn btn-primary" role="button" type="button" value="Evolución" onclick="showEvolucion();" />
  </div>
  <br />
  <br />
  <br />
  <br />
</div>

<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation" style="border-top: 1px solid black">
  <div class="container crop">
    <img src="images/banner2.jpg" class="img-responsive">
  </div>
</nav>

</body>
</html>