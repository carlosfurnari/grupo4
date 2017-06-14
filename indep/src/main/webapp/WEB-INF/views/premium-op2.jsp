<%--
  Created by IntelliJ IDEA.
  User: Samsung
  Date: 14/06/2017
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Control Financiero</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
                <img alt="Brand" src="images/logo-inv.png" width="35px">
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

<div class="container-fluid">
    <h1 class="slogan">Invertir en acciones, aprendé a comprar y operar acciones</h1>
    <div class="row">
        <div class="col-xs-12">
            <h2 class="text-center main-title">¿Por qué hay que invertir en Acciones?</h2>
        </div>
        <div class="col-xs-12 col-md-6">
            <h4><i class="fa fa-check-square-o" aria-hidden="true"></i> Es muy fácil, ágil y sencillo</h4>
            <h4><i class="fa fa-check-square-o" aria-hidden="true"></i> No se requieren conocimientos previos sobre finanzas</h4>
            <h4><i class="fa fa-check-square-o" aria-hidden="true"></i> Podes comenzar a operar con una inversión mínima</h4>
        </div>
        <div class="col-xs-12 col-md-6">
            <h4><i class="fa fa-check-square-o" aria-hidden="true"></i> Podés ser socio de grandes compañías</h4>
            <h4><i class="fa fa-check-square-o" aria-hidden="true"></i> Realizá un seguimiento en tiempo real mediante Internet</h4>
        </div>
    </div>
</div>

<div class="container-fluid rend">
    <div class="row">
        <div class="col-xs-12">
            <h2 class="head2">Rendimiento Histórico Anual</h2>
            <table class="medWidth rendi">
                <thead>
                <tr>
                    <th></th>
                    <th>Dólar oficial</th>
                    <th>Plazo Fijo</th>
                    <th>Merval</th>
                    <th>Inmuebles m2</th>
                </tr>
                </thead>
                <tbody>
                <tr class="bold">
                    <td>Rendimiento acumulado</td>
                    <td class="red">203%</td>
                    <td class="red">100%</td>
                    <td class="green">414%</td>
                    <td class="red">182%</td>
                </tr>
                <tr>
                    <td> Junio 2016 </td>
                    <td> 15% </td>
                    <td> 14% </td>
                    <td> 26% </td>
                    <td> 3% </td>
                </tr>
                <tr>
                    <td> 2015 </td>
                    <td> 52% </td>
                    <td> 23% </td>
                    <td> 36% </td>
                    <td> 23% </td>
                </tr>
                <tr>
                    <td> 2014 </td>
                    <td> 31% </td>
                    <td> 22% </td>
                    <td> 59% </td>
                    <td> 44% </td>
                </tr>
                <tr>
                    <td> 2013 </td>
                    <td> 33% </td>
                    <td> 16% </td>
                    <td> 89% </td>
                    <td> 55% </td>
                </tr>
                </tbody>
            </table>
            <h5>Fuente</h5>
            <small>Acciones, MERVAL: Bolsar </small> -
            <small>Plazo fijo y dólar: BCRA</small><br>
            <small>Inmuebles: Incluye renta mensual del 5% nominal anual. Precio del m2 valuado en pesos a dólar blue hasta 12/2015, luego dólar oficial.</small>
        </div>
    </div>
</div>

<div class="container-fluid">
    <a href="./premium" class="btn btn-primary" role="button">Volver</a>
</div>

<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
    <div class="container crop">
        <center><img src="images/bannerInv.png" class="img-responsive"></center>
    </div>
    </div>

</body>
</html>
