<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div id="main-gasto">
    <%
        String gastosPorCategoriaDonut = (String)request.getAttribute("gastosPorCategoriaDonut");
    %>
    <script src="assets/js/amcharts/amcharts.js" type="text/javascript"></script>
    <script src="assets/js/amcharts/pie.js" type="text/javascript"></script>
    <script>
        activarGastos();
        AmCharts.makeChart("chart", <%=gastosPorCategoriaDonut%>);
    </script>

    <div class="container-fluid text-center">
        <div id="chart" style="width: 100%; height: 350px ;"></div>
    </div>
    <div id="ing-gasto" style="padding: 10px 10px 10px 10px">
        <form class="form-inline" id="cargaForm">
            <div class="form-group" style="padding-right: 5px">
                <label for="categoria">Categoria</label>
                <select class="form-control" id="categoria" name="categoriaId">

                </select>
            </div>
            <div class="form-group" style="padding-right: 5px">
                <input type="hidden" class="form-control" id="userField" name="username">
            </div>
            <div class="form-group" style="padding-right: 5px">
                <label for="descripcionField">Descripcion</label>
                <input type="text" class="form-control" id="descripcionField" name="descripcion">
            </div>
            <div class="form-group" style="padding-right: 5px">
                <label for="montoField">Importe</label>
                <input type="text" class="form-control" id="montoField" placeholder="100.00" name="monto">
            </div>
            <div class="form-group" style="padding-right: 5px">
                <label for="datePicker">Fecha</label>
                <input class="form-control" type="date" id="datePicker" name="fecha">
            </div>

        </form>
        <div>
            <button type="submit" class="btn btn-success" id="addGasto">Agregar</button>
        </div>
    </div>

    <div id="ing-categoria" style="padding: 10px 10px 10px 10px">
        <form class="form-inline" id="categoriaForm">
            <div class="form-group" style="padding-right: 5px">
                <input type="hidden" class="form-control" id="userFieldCategoria" name="username">
            </div>
            <div class="form-group" style="padding-right: 5px">
                <label for="descripcionField">Nombre</label>
                <input type="text" class="form-control" id="nombreFieldCategoria" name="nombre">
            </div>
            <div class="form-group" style="padding-right: 5px">
                <label for="descripcionField">Descripcion</label>
                <input type="text" class="form-control" id="descripcionFieldCategoria" name="descripcion">
            </div>

        </form>
        <div>
            <button type="submit" class="btn btn-info" id="addCategoria">Nueva Categoria</button>
        </div>
    </div>
    <%--<div>--%>
        <%--<button type="submit" class="btn btn-success" id="cargagastos">Agregar Gasto</button>--%>
    <%--</div>--%>
    <div style="padding: 10px 10px 10px 10px">
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Gastos</h3>
                        <div class="pull-right">
                        </div>
                    </div>
                    <div class="gastos-table">
                        <table id="table-gastos" class="table table-bordered">
                            <thead>
                            <tr>
                                <th data-dynatable-column="descripcion" class="dynatable-head"><a class="dynatable-sort-header"
                                                                                                  href="#">Descripcion</a></th>
                                <th data-dynatable-column="categoria" class="dynatable-head"><a class="dynatable-sort-header"
                                                                                                href="#">Categoria</a></th>
                                <th data-dynatable-column="fecha" class="dynatable-head"><a class="dynatable-sort-header"
                                                                                            href="#">Fecha</a></th>
                                <th data-dynatable-column="monto" class="dynatable-head"><a class="dynatable-sort-header"
                                                                                            href="#">Monto ($)</a></th>
                            </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div style="padding: 10px 10px 10px 10px">
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Gastos por categoria</h3>
                        <div class="pull-right">
                        </div>
                    </div>
                    <div class="gastos-categoria-table">
                        <table id="table-gastos-categoria" class="table table-bordered">
                            <thead>
                            <tr>
                                <th data-dynatable-column="categoria" class="dynatable-head"><a class="dynatable-sort-header"
                                                                                                href="#">Categoria</a></th>
                                <th data-dynatable-column="monto" class="dynatable-head"><a class="dynatable-sort-header"
                                                                                            href="#">Monto ($)</a></th>
                            </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


