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
        </script>
        <span>Recomendaciones para tu perfil <span class="w3-margin-left w3-text-purple" id="perfil-out"></span></span>
        <br>
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