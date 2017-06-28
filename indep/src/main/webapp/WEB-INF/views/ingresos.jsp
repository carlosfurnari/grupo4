<html>
<head>
    <%
        String serverContent = (String)request.getAttribute("chartData");
    %>

    <script>
        activarIngresos();
        AmCharts.makeChart("chart", <%=serverContent%>);
    </script>
</head>

<div class="container-fluid text-center">
    <div id="chart" style="width: 100%; height: 400px; background-color: #FFFFFF;"></div>
    <br>
    <br>
    <br>
    <br>
    <br>
</div>

<div class="container"></div>

</html>