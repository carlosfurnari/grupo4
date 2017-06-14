<%--
  Created by IntelliJ IDEA.
  User: rumm
  Date: 11/06/17
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
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
</head>
<body>

<!-- Header -->
<header id="header">
    <img src="images/logo.png">
    <h1>Control Financiero</h1>
    <nav id="all">
        <ul>
            <li><a href="#intro">Inicio</a></li>
            <li><a href="#one">Quines Somos</a></li>
            <li><a href="#two">Como Funciona</a></li>
            <li><a href="#work">Servicios</a></li>
            <li><a href="#contact">Contacto</a></li>
            <li><a href="./loginPage" class="button">Entrar</a></li>
        </ul>
    </nav>
    <nav id="only">
        <ul>
            <li><a href="./loginPage" class="button">Entrar</a></li>
        </ul>
    </nav>
</header>

<!-- Home -->
<section id="intro" class="main style1 dark fullscreen">
    <div class="content">
        <header>
            <h2>CONTROLA TUS FINANZAS</h2>
        </header>
        <p>Bienvenido a <strong>Control Financiero</strong> un portal que te permite, de un modo sencillo y autom�tico, registrar tus gastos e ingresos, monitorear inversiones, proyectar presupuestos o metas y mucho m�s !</p>
        <footer>
            <a href="#one" class="button style2 down">More</a>
        </footer>
    </div>
</section>

<!-- One -->
<section id="one" class="main style2 right dark fullscreen">
    <div class="content box style2">
        <header>
            <h2>Quienes somos</h2>
        </header>
        <p>Somos un grupo de estudiantes de la Facultad de Ingenier�a de la Universidad de
            Buenos Aires, con una gran vocaci�n de ser emprendedores en el desarrollo de
            aplicaciones. Buscamos soluciones simples y funcionales, frente a problemas
            habituales, haciendo uso de los conocimientos acad�micos, los cuales tratamos de
            reflejarlos en el mundo real. </p>
    </div>
    <a href="#two" class="button style2 down anchored">Next</a>
</section>

<!-- Two -->
<section id="two" class="main style2 left dark fullscreen">
    <div class="content box style2">
        <header>
            <h2>Como funciona</h2>
        </header>
        <p>Luego de un simple registro, vas a poder cargar tus gastos e ingresos de manera
            simple y r�pida. Si tenes inversiones tambi�n vas a poder cargarlas al sistema.
            Con esto, vas a tener toda tu informaci�n financiera en un solo lugar, lo que te va
            a permitir analizar tus movimientos y tener control de los mismos.</p>
    </div>
    <a href="#work" class="button style2 down anchored">Next</a>
</section>

<!-- Work -->
<section id="work" class="main style3 primary">
    <div class="content">
        <header>
            <h2>Servicios</h2>
            <p>El uso del portal es completamente gratuito. Para quienes deseen obtener una
                ayuda financiera se ofrece el servicio premium a solo $99 por mes. Este incluye
                capacitaci�n sobre diferentes activos financieros, as� como tambi�n los pasos a
                seguir para poder operarlos. Vas a poder elevar la calidad de tus inversiones !</p>
        </header>

        <!-- Gallery  -->
        <div class="gallery">
            <article class="from-left">
                <a href="./images/fulls/01.jpg" class="image fit"><img src="./images/thumbs/01.jpg" title="The Anonymous Red" alt="" /></a>
            </article>
            <article class="from-right">
                <a href="./images/fulls/02.jpg" class="image fit"><img src="./images/thumbs/02.jpg" title="Airchitecture II" alt="" /></a>
            </article>
            <article class="from-left">
                <a href="./images/fulls/03.jpg" class="image fit"><img src="./images/thumbs/03.jpg" title="Air Lounge" alt="" /></a>
            </article>
            <article class="from-right">
                <a href="./images/fulls/04.jpg" class="image fit"><img src="./images/thumbs/04.jpg" title="Carry on" alt="" /></a>
            </article>
            <article class="from-left">
                <a href="./images/fulls/05.jpg" class="image fit"><img src="./images/thumbs/05.jpg" title="The sparkling shell" alt="" /></a>
            </article>
            <article class="from-right">
                <a href="./images/fulls/06.jpg" class="image fit"><img src="./images/thumbs/06.jpg" title="Bent IX" alt="" /></a>
            </article>
        </div>

    </div>
</section>

<!-- Contact -->
<section id="contact" class="main style3 secondary">
    <div class="content">
        <header>
            <h2>Escribinos</h2>
            <p>Mandanos tus consultas, te responderemos a la brevedad. </p>
        </header>
        <div class="box">
            <form method="post" action="#">
                <div class="field half first"><input type="text" name="name" placeholder="Name" /></div>
                <div class="field half"><input type="email" name="email" placeholder="Email" /></div>
                <div class="field"><textarea name="message" placeholder="Message" rows="6"></textarea></div>
                <ul class="actions">
                    <li><input type="submit" value="Send Message" /></li>
                </ul>
            </form>
        </div>
    </div>
</section>

<!-- Footer -->
<footer id="footer">

    <!-- Icons -->
    <ul class="actions">
        <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
        <li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
        <li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
        <li><a href="#" class="icon fa-linkedin"><span class="label">LinkedIn</span></a></li>
        <li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
        <li><a href="#" class="icon fa-pinterest"><span class="label">Pinterest</span></a></li>
    </ul>

    <!-- Menu -->
    <ul class="menu">
        <li>&copy; Registered</li><li>Design: GRUPO 4</li>
    </ul>

</footer>

<!-- Scripts -->
<script src="./assets/js/jquery.min.js"></script>
<script src="./assets/js/jquery.poptrox.min.js"></script>
<script src="./assets/js/jquery.scrolly.min.js"></script>
<script src="./assets/js/jquery.scrollex.min.js"></script>
<script src="./assets/js/skel.min.js"></script>
<script src="./assets/js/util.js"></script>
<!--[if lte IE 8]><script src="./assets/js/ie/respond.min.js"></script><![endif]-->
<script src="./assets/js/main.js"></script>

</body>
</html>