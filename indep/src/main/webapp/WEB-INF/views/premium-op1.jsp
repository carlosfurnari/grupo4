<%--
  Created by IntelliJ IDEA.
  User: Samsung
  Date: 14/06/2017
  Time: 14:59
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
    <div class="grayBox">
        <h2 class="main-title">Invierta en LEBACS</h2>
        <ul>
            <li><i class="fa fa-check-circle"></i> RENTA FIJA EN PESOS</li>
            <li><i class="fa fa-check-circle"></i> MEJOR RENTA QUE UN PLAZO FIJO</li>
            <li><i class="fa fa-check-circle"></i> SE PUEDE SALIR EN EL MOMENTO QUE QUIERA</li>
            <li><i class="fa fa-check-circle"></i> SE HACE DE FORMA ONLINE SIN MOVERSE DE SU CASA</li>
        </ul>
    </div>
    <h3>¿Qué es una LEBAC?</h2>
        <p>Las Letras del Banco Central (LEBACs) son títulos de deuda que emite la entidad monetaria a corto plazo, y que dependiendo la licitación los mismo oscilan entre los 28 y los 273 días de vencimiento.<br>
            Tienen como objetivo, entre otras cosas bajar la demanda del dólar y bajar la inflación. Se licitan una vez por mes y el total del capital más intereses se paga al vencimiento.<br>
            Para quienes no hayan podido licitar dentro de las fechas correspondientes, es posible comprarlas en el mercado secundario como cualquier otro instrumento de renta fija.</p>

        <h3>¿Cómo se operan?</h3>
        <p>Mediante un banco o un agente de Bolsa. Recomendamos el agente de bolsa ya que suele tener comisiones menores. Agentes recomendados: A1, A2, A3.</p>
        <h3>¿Hay un mínimo sugerido?</h3>
        <p>Recomendamos invertir un mínimo de $ 50.000</p>
</div>

<div class="container-fluid info">
    <div class="col-xs-12 col-sm-6">
        <h3>Rendimientos</h3>
        <p>Los rendimientos de las LEBAC varían en cada licitación. <br>El precio de suscripción de las LEBAC, que determina cual será el rendimiento del instrumento, se determina a través del sistema de subasta holandesa.</p>
        <h4>Se opera en dos tramos: </h4>
        <p>Competitivo, en donde ofertan grandes operadores y que define el precio de corte, y el no competitivo, en donde los adjudicatarios aceptan el precio de corte determinado en el tramo competitivo</p>
    </div>
    <div class="col-xs-12 col-sm-6">
        <h3>Cuadro Comparativo</h3>
        <br>
        <small class="date">Actualizado al 13.06.2017</small>
        <table class="fullWidth lebacs">
            <thead>
            <tr>
                <th class="magBg">LEBACS</th>
                <th class="cyanBg">Plazo Fijo</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>
                    <small>28 días</small>
                    <span>24.25%</span>
                </td>
                <td>
                    <small>35 días</small>
                    <span>17.50%</span>
                </td>
            </tr>
            <tr>
                <td>
                    <small>98 días</small>
                    <span>22.50%</span>
                </td>
                <td>
                    <small>98 días</small>
                    <span>18.50%</span>
                </td>
            </tr>
            </tbody>
        </table>
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
