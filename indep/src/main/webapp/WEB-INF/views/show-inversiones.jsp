<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div id="main-inversion">

    <%
        String inversionPorCategoriaDonut = (String)request.getAttribute("inversionPorCategoriaDonut");
    %>
    <script src="assets/js/amcharts/amcharts.js" type="text/javascript"></script>
    <script src="assets/js/amcharts/pie.js" type="text/javascript"></script>
    <script>
        activarIngresos();
        AmCharts.makeChart("chart", <%=inversionPorCategoriaDonut%>);
    </script>

    <div class="container-fluid text-center">
        <div id="chart" style="width: 100%; height: 550px ;"></div>
    </div>

    <div id="ing-inversion" style="padding: 20px 5px 20px 20px; border: 3px ridge purple; border-radius: 4px; background-color: #E2A9F3">
        <form class="form-inline" id="cargaForm" style="padding-left: 30px; font-family: Georgia">
            <div class="form-group" style="padding-right: 5px">
                <label for="categoria" style="padding-right: 10px">Categoria</label>
                <select class="form-control" id="categoria" name="categoriaId">

                </select>
            </div>
            <div class="form-group" style="padding-right: 5px">
                <input type="hidden" class="form-control" id="userField" name="username">
            </div>
            <div class="form-group" style="padding-right: 5px">
                <input type="hidden" class="form-control" id="idField" name="id">
            </div>
            <div class="form-group" style="padding-right: 5px">
                <label for="descripcionField" style="padding-right: 5px">Descripcion</label>
                <input type="text" class="form-control" id="descripcionField" name="descripcion">
            </div>
            <div class="form-group" style="padding-right: 20px">
                <label for="montoField" style="padding-right: 5px">Importe</label>
                <input type="text" class="form-control" id="montoField" placeholder="50000.00" name="monto">
            </div>
            <div class="form-group" style="padding-right: 20px">
                <label for="datePicker" style="padding-right: 5px">Fecha</label>
                <input class="form-control" type="date" id="datePicker" name="fecha">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-success" id="addinversion">Listo</button>
            </div>
        </form>
    </div>
    <br>
    <div id="ing-categoria" style="padding: 20px 0px 20px 20px; border: 3px outset blue; border-radius: 4px; background-color: #CEECF5; width: 64%">
        <form class="form-inline" id="categoriaForm" style="padding-left: 30px; font-family: Georgia">
            <div class="form-group" style="padding-right: 0px">
                <input type="hidden" class="form-control" id="userFieldCategoria" name="username">
            </div>
            <div class="form-group" style="padding-right: 20px">
                <label for="descripcionField" style="padding-right: 5px">Nombre</label>
                <input type="text" class="form-control" id="nombreFieldCategoria" name="nombre">
            </div>
            <div class="form-group" style="padding-right: 20px">
                <label for="descripcionField" style="padding-right: 5px">Descripcion</label>
                <input type="text" class="form-control" id="descripcionFieldCategoria" name="descripcion">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-success" id="addCategoria">Nueva Categoria</button>
            </div>

        </form>

    </div>

    <div class="container" style="padding-top: 30px">
        <div class="row">
            <div class="col-md-8">
                <div class="panel panel-primary">
                    <div class="panel-heading" style="background-color: #E2A9F3">
                        <h3 class="panel-title" style="color: black;">Inversiones</h3>
                        <div class="pull-right">
                        </div>
                    </div>
                    <div>
                        <div class="form-inline inversiones-table" style="padding-top: 5px; padding-left: 20px; padding-bottom: 5px">
                            <div  class="form-group" id="fecha-filter" style="padding-right: 20px">
                                Fecha:
                                <select id="search_fecha" name="Filtros">
                                    <option value="empty" selected></option>
                                    <option value="today">Hoy</option>
                                    <option value="month">Mes Actual</option>
                                    <option value="lastmonth">Mes Anterior</option>
                                    <option value="year">Anio Actual</option>
                                    <option value="12months">Ultimos 12 Meses</option>
                                    <option value="nextmonth">Proximo Mes</option>
                                    <option value="next12months">Proximos 12 Meses</option>

                                </select>
                            </div>
                            <div class="form-group" id="categoria-filter" style="padding-right: 20px">
                                Categoria:
                                <select id="search_categoria" name="Categoria">

                                </select>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-info" id="filter" style="background-color: #E2A9F3">Filtrar</button>
                            </div>
                    </div>

                        <table id="table-inversiones" class="table table-bordered">
                            <thead>
                            <tr>
                                <th data-dynatable-column="id" class="dynatable-head" style="display:none"><a class="dynatable-sort-header"
                                                                                                              href="#">ID</a></th>
                                <th data-dynatable-column="descripcion" class="dynatable-head"><a class="dynatable-sort-header"
                                                                                                  href="#">Descripcion</a></th>
                                <th data-dynatable-column="categoria" class="dynatable-head"><a class="dynatable-sort-header"
                                                                                                href="#">Categoria</a></th>
                                <th data-dynatable-column="fecha" class="dynatable-head"><a class="dynatable-sort-header"
                                                                                            href="#">Fecha</a></th>
                                <th data-dynatable-column="monto" class="dynatable-head"><a class="dynatable-sort-header"
                                                                                            href="#">Monto ($)</a></th>
                                <th data-dynatable-column="borrar" class="dynatable-head"><a class="dynatable-sort-header"
                                                                                             href="#">Borrar</a></th>
                                <th data-dynatable-column="editar" class="dynatable-head"><a class="dynatable-sort-header"
                                                                                             href="#">Editar</a></th>
                            </tr>
                            </thead>
                            <tbody>
                            </tbody>
                            <tfoot></tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container" style="padding-top: 30px">
        <div class="row">
            <div class="col-md-6">
                <div class="panel panel-primary">
                    <div class="panel-heading" style="background-color: #E2A9F3">
                        <h3 class="panel-title" style="color: black;">Inversions por categoria</h3>
                        <div class="pull-right">
                        </div>
                    </div>
                    <div class="inversiones-categoria-table">
                        <table id="table-inversiones-categoria" class="table table-bordered">
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


