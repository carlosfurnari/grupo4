<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="assets/js/amcharts/amcharts.js" type="text/javascript"></script>
    <script src="assets/js/amcharts/serial.js" type="text/javascript"></script>
    <script src="assets/js/amcharts/pie.js" type="text/javascript"></script>

    <%
        String chartTablero = (String)request.getAttribute("chartTablero");
        String monthlyChartTablero = (String)request.getAttribute("monthlyChartTablero");
        String ingresosTablero = (String)request.getAttribute("ingresosTablero");
        String gastoPorCategoria = (String)request.getAttribute("gastoPorCategoria");
    %>

    <script>
        function showMonthlyChartTablero() {
            AmCharts.makeChart("chart", <%=monthlyChartTablero%>)
        }
        function showChartTablero() {
            AmCharts.makeChart("chart", <%=chartTablero%>);
        }
        function showIngresosNormal() {
            AmCharts.makeChart("chart", <%=ingresosTablero%>);
        }
        function showGastoPorCategoria() {
            AmCharts.makeChart("chart", <%=gastoPorCategoria%>);
        }
    </script>
</head>
<body>
    <div class="container-fluid text-center">
        <div id="chart" style="width: 100%; height: 350px ;"></div>
    </div>

    <div class="container-fluid text-center">
        <input id="tableroEvolucion" class="btn btn-primary" role="button" type="button" value="tableroEvolucion"
               onclick="showMonthlyChartTablero();" />
        <input id="tableroNormal" class="btn btn-primary" role="button" type="button" value="tableroNormal"
               onclick="showChartTablero();" />
        <input id="ingresosNormal" class="btn btn-primary" role="button" type="button" value="ingresosNormal"
               onclick="showIngresosNormal();" />
        <input id="gastoPorCategoria" class="btn btn-primary" role="button" type="button" value="gastoPorCategoria"
               onclick="showGastoPorCategoria();" />
    </div>
</body>
</html>
