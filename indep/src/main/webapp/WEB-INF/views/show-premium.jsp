<%--
  Created by IntelliJ IDEA.
  User: Samsung
  Date: 17/06/2017
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="main-premium" style="height: 100%">
    <style>
        body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}
        /* Full height image header */
        .bgimg-1 {
            background-image: url("/images/cashbook-blog1.jpg");
            height:150px;
            width:100%;
        }

    </style>

    <div class="container-fluid  bgimg-1" style="">
        <span class="w3-jumbo w3-black w3-padding w3-text-white w3-large w3-margin-top w3-opacity-min tit">Descubre tu perfil de inversión</span><br>
        <span class="w3-xxlarge w3-black w3-padding-small w3-text-white w3-large w3-margin-top w3-opacity-min tit">
            Con tan solo 5 preguntas
            <button class="w3-button w3-white w3-large w3-margin-left w3-opacity-min w3-hover-opacity-off" onclick="mostrarTest()">Realizar el test de Inversion</button>
        </span>
    </div>

    <div class="container-fluid ">
        <script>
            document.getElementById("perfil-out").innerHTML = perfil;
            if (perfil !== "Desconocido"){
                mostrarRecomendacion();
            }
        </script>
        <span class="w3-xxlarge w3-gray w3-padding-small w3-text-black w3-large">Recomendaciones para tu perfil <span class="w3-margin-left w3-text-purple" id="perfil-out"></span></span>
        <br>
    </div>

    <div id="reco-default">
        <h2>Conoce tu perfil para obtener tus recomendaciones</h2>
    </div>

    <div id="reco-conservador" style="display:none;" class="w3-padding-small">
        <div style="display:inline-block">
            <button id="con-1" onclick="mostrarDolar()"><img src="images/dolar.PNG"></button>
            <button id="con-2" onclick="mostrarLebacs()"><img src="images/lebacs.PNG"></button>
        </div>
    </div>

    <div id="reco-moderado" style="display:none;" class="w3-padding-small">
        <div style="display:inline-block">
            <button id="mod-1" onclick="mostrarBonos()"><img src="images/bonos.PNG"></button>
            <button id="mod-2" onclick="mostrarFCI()"><img src="images/fci.PNG"></button>
        </div>
    </div>

    <div id="reco-agresivo" style="display:none;" class="w3-padding-small">
        <button id="agre-1" onclick="mostrarAcciones()"><img src="images/acciones.PNG"></button>
    </div>
</div>

<div id="testInversor" class="container-fluid text-center" style="display:none">
    <br>
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
                    <img src="../../images/Conservador.jpg" />
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
                    <img src="../../images/Moderado.jpg" />
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
                    <img src="../../images/Agresivo.jpg" />
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

    <button onclick="volver()">Volver</button>

</div>

<div id="lebacs" class="container-fluid text-center" style="display:none">
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
        <button id="volv2" onclick="volverL()">Volver</button>
    </div>
</div>

<div id="acciones" class="container-fluid text-center" style="display:none">
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
        <button id="volv3" onclick="volverA()">Volver</button>
    </div>
</div>