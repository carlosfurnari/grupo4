<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Control Financiero</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="./assets/css/premium.css">
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
        <li><a href="./tablero.jsp">Tablero</a></li>
        <li><a href="#">Gastos</a></li>
        <li><a href="#">Ingresos</a></li>
        <li><a href="#">Inversiones</a></li>
        <li class="active"><a href="./premium.jsp">Premium</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Mi Cuenta</a></li>
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div id="testInversor" class="container-fluid text-center">
    <script type="text/javascript"> 
    var cantPreguntas = 5;
    var pregActual    = 1;
    var pregAnterior  = 0;
    var resVisible    = null;
    var acumPonderaciones = 0;

    function seleccionaOpcion(ponderacionOpcion) {
      acumPonderaciones += ponderacionOpcion;

      if(pregAnterior > 0){
        $("#preg_"+pregAnterior).removeClass("perfilPreg_anterior");
      }
      //apago pregunta actual
      $("#preg_"+pregActual).removeClass("perfilPreg_on");
      $("#holder_preg_"+pregActual).hide();
    
      pregAnterior++;
      $("#preg_"+pregAnterior).addClass("perfilPreg_anterior");

      //hay pregunta siguiente?
      if (pregActual < cantPreguntas) {
        //prendo pregunta siguiente
        pregActual++; 
        $("#holder_preg_"+pregActual).show();
        $("#preg_"+pregActual).addClass("perfilPreg_on");
      } else {
        //prendo resultado
        $("#preg_res").addClass("perfilPreg_on");

        
        if (acumPonderaciones  >= 0 &&  
            acumPonderaciones  <= 20) {
          $("#holder_res_1").show();
          resVisible = 1;
        }
        
        if (acumPonderaciones  >= 25 &&  
            acumPonderaciones  <= 40) {
          $("#holder_res_2").show();
          resVisible = 2;
        }
        
        if (acumPonderaciones  >= 45 &&  
            acumPonderaciones  <= 50) {
          $("#holder_res_3").show();
          resVisible = 3;
        }
        
      }
    }

    function reiniciarTest() {
      $("#preg_res").removeClass("perfilPreg_on");
      $("#preg_"+pregAnterior).removeClass("perfilPreg_anterior");
      $("#holder_res_"+resVisible).hide();
      resVisible = null;

      //apago pregunta actual
      $("#preg_"+pregActual).removeClass("perfilPreg_on");
      $("#holder_preg_"+pregActual).hide();

      pregActual    = 1;
      pregAnterior    = 0;
      acumPonderaciones = 0;

      $("#holder_preg_"+pregActual).show();
      $("#preg_"+pregActual).addClass("perfilPreg_on");
    }

    </script>
    <ul style="display:inline;" class="hidden-xs">
      <li class="perfilPreg_on" id="preg_1" style="display:inline-block;">Pregunta 1</li>
      <li class="" id="preg_2" style="display:inline-block;">Pregunta 2</li>
      <li class="" id="preg_3" style="display:inline-block;">Pregunta 3</li>
      <li class="" id="preg_4" style="display:inline-block;">Pregunta 4</li>
      <li class="" id="preg_5" style="display:inline-block;">Pregunta 5</li>
      <li id="preg_res" class="boxResultado" style="display:inline-block; background-image:none;">Resultado </li>
    </ul>
    <div id="testContentNew">
      <div id="holder_preg_1" class="holderPregunta" style=";">
        <div class="visible-xs row">
          <h3 class="tituloPregunta">Cual es tu objetivo de inversión?</h3>
        </div>
        <div class="optTest" style="padding-bottom:10px;">
          <h3 style="display: inline;" class="hidden-xs">Cual es tu objetivo de inversión?</h3>
        </div>
        <div class="optTest" style="padding-top:10px;">
          <a href="javascript:seleccionaOpcion(10)">Alto rendimiento</a>
        </div>
        <div class="optTest">
          <a href="javascript:seleccionaOpcion(5)">Rendimiento sin bruscas variaciones</a></div>
        <div class="optTest">
          <a href="javascript:seleccionaOpcion(0)">Rendimiento moderado, con alta estabilidad</a>
        </div>
      </div>
      <div id="holder_preg_2" class="holderPregunta" style="display:none;">
        <div class="circuloNumero visible-xs row">
          <h3 class="tituloPregunta">Indicá tu experiencia en inversiones</h3>
        </div>
          <div class="optTest" style="padding-bottom:10px;">
            <h3 style="display: inline;" class="hidden-xs">Indicá tu experiencia en inversiones</h3>
          </div>
          <div class="optTest" style="padding-top:10px;">
            <a href="javascript:seleccionaOpcion(10)">He invertido alguna vez en bonos, acciones o fondos comunes de inversión</a>
          </div>
          <div class="optTest">
            <a href="javascript:seleccionaOpcion(5)">Conozco los productos, pero nunca he invertido en ellos</a>
          </div>
          <div class="optTest">
            <a href="javascript:seleccionaOpcion(0)">No conozco los productos, nunca he invertido en ellos</a>
          </div>
        </div>
        <div id="holder_preg_3" class="holderPregunta" style="display:none;">
          <div class="circuloNumero visible-xs row">
            <h3 class="tituloPregunta">Cómo te sentís frente al riesgo</h3>
          </div>
          <div class="optTest" style="padding-bottom:10px;">
            <h3 style="display: inline;" class="hidden-xs">Cómo te sentís frente al riesgo</h3>
          </div>
          <div class="optTest" style="padding-top:10px;">
            <a href="javascript:seleccionaOpcion(10)">Puedo  admitir una mayor fluctuación del valor mi inversión, con el objeto de obtener una mayor rentabilidad</a>
          </div>
          <div class="optTest">
            <a href="javascript:seleccionaOpcion(5)">Puedo admitir moderadas fluctuaciones del valor de mi inversión, con el objeto de obtener una mayor rentabilidad</a>
          </div>
          <div class="optTest">
            <a href="javascript:seleccionaOpcion(0)">Estoy dispuesto a aceptar solo una disminución mínima en el valor de mi inversión</a>
          </div>
        </div>
        <div id="holder_preg_4" class="holderPregunta" style="display:none;">
          <div class="circuloNumero visible-xs row">
            <h3 class="tituloPregunta">Determiná la evolución de tus ingresos</h3>
          </div>
          <div class="optTest" style="padding-bottom:10px;">
            <h3 style="display: inline;" class="hidden-xs">Determiná la evolución de tus ingresos</h3>
          </div>
          <div class="optTest" style="padding-top:10px;">
            <a href="javascript:seleccionaOpcion(10)">Tengo una situación estable en mis ingresos y dispongo de un margen para incrementar mis reservas</a>
          </div>
          <div class="optTest">
            <a href="javascript:seleccionaOpcion(5)">Tengo una situación estable en mis ingresos, sin modificaciones importantes</a>
          </div>
          <div class="optTest">
            <a href="javascript:seleccionaOpcion(0)">No estoy seguro de mi situación futura</a>
          </div>
        </div>
        <div id="holder_preg_5" class="holderPregunta" style="display:none;">
          <div class="circuloNumero visible-xs row">
            <h3 class="tituloPregunta">Determiná durante cuánto tiempo pensás mantener tu inversión</h3>
          </div>
          <div class="optTest" style="padding-bottom:10px;">
            <h3 style="display: inline;" class="hidden-xs">Determiná durante cuánto tiempo pensás mantener tu inversión</h3>
          </div>
          <div class="optTest" style="padding-top:10px;">
            <a href="javascript:seleccionaOpcion(10)">Más de 3 años (Largo Plazo)</a>
          </div>
          <div class="optTest">
            <a href="javascript:seleccionaOpcion(5)">Entre 2 y 3 años (Mediano Plazo)</a>
          </div>
          <div class="optTest">
            <a href="javascript:seleccionaOpcion(0)">Entre 1 y 2 años (Corto Plazo)</a>
          </div>
        </div>
        <div id="holder_res_1" class="holderPregunta" style="display:none;">
          <div>
            <div class="circuloNumero visible-xs row">
             <h3 class="tituloResultado"> Resultado </h3>
            </div>
            <div class="boxResultadoPerfil">
              <p style="color:#6800ff;font-size:16px; text-align: center;">Su perfil de inversor es: <br /></p>
              <img src="./images/Conservador.jpg" />
            </div>
            <div class="resultadoTest">
              <p>Las personas que se ajustan a este perfil se caracterizan por buscar inversiones que representen un crecimiento moderado, sin asumir riesgos importantes.<br />Habitualmente se prioriza la liquidez inmediata de las inversiones minimizando al máximo posible la incidencia de las variaciones del mercado.</p>
              <p><br />Los inversores identificados con este grupo buscan invertir en fondos de muy corto plazo y baja volatilidad. Los fondos de Plazo Fijo y los de bonos de corto plazo y baja volatilidad podran adaptarse a este perfil.</p>
              <p> </p>
            </div>
          </div>
          <div class="btVolverAtras" style="text-align:center;">
            <a href="javascript:reiniciarTest()" style="">Volver a realizar el test</a>
          </div>
        </div>
        <div id="holder_res_2" class="holderPregunta" style="display:none;">
          <div>
            <div class="circuloNumero visible-xs row">
              <h3 class="tituloResultado"> Resultado </h3>
            </div>
            <div class="boxResultadoPerfil">
              <p style="color:#6800ff;font-size:16px; text-align: center;">Su perfil de inversor es: <br /></p>
              <img src="./images/Moderado.jpg" />
            </div>
            <div class="resultadoTest">
              <p>Un inversor moderado está dispuesto a asumir ciertas oscilaciones en sus inversiones, en la búsqueda de una mayor rentabilidad en el mediano/largo plazo.<br />Es un perfil intermedio, son personas que pueden tolerar cierto riesgo en sus inversiones, a cambio de una mayor rentabilidad.</p>
              <p><br />Para este tipo de inversores, los fondos de bonos de corto y mediano plazo se adaptarán a una cartera de inversión.</p>
            </div>
          </div>
          <div class="btVolverAtras" style="text-align:center;">
            <a href="javascript:reiniciarTest()" style="">Volver a realizar el test</a>
          </div>
        </div>
        <div id="holder_res_3" class="holderPregunta" style="display:none;">
          <div>
            <div class="circuloNumero visible-xs row">
              <h3 class="tituloResultado"> Resultado </h3>
            </div>
            <div class="boxResultadoPerfil">
              <p style="color:#6800ff;font-size:16px; text-align: center;">Su perfil de inversor es: <br /></p>
              <img src="./images/Agresivo.jpg" />
            </div>
            <div class="resultadoTest">
              <p>Este perfil se caracteriza por la búsqueda de la maximización del rendimiento de sus inversiones, asumiendo en contrapartida un alto componente de riesgo. Para ello, estarán dispuestos a mantener sus inversiones por períodos largos, sin asignarle una alta prioridad a la disponibilidad inmediata de sus activos.</p>
              <p>En general, se trata de inversores que eligen suscribir fondos de mediano y largo plazo compuestos por bonos y acciones. Las carteras de estos fondos son consideradas de alta volatilidad.</p>
              <p> </p>
            </div>
          </div>
          <div class="btVolverAtras" style="text-align:center;">
            <a href="javascript:reiniciarTest()" style="">Volver a realizar el test</a>
          </div>
        </div>
      </div>
      
     <div class="clearDiv"></div>
</div>

<div class="container-fluid text-center volver">
  <a href="premium.jsp" class="btn btn-primary" role="button">Volver</a>
</div>

<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
  <div class="container">
    <img src="images/banner2.jpg" class="img-responsive">
  </div>
</div>

</body>
</html>