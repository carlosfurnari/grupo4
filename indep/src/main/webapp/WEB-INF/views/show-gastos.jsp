<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div id="main-gasto">
    <div id="ing-gasto" style="padding: 10px 10px 10px 10px">
        <form class="form-inline">
            <div class="form-group" style="padding-right: 5px">
                <label for="categ">Categoria</label>
                <select class="form-control" id="categ">
                    <option>Caja Chica</option>
                    <option>Comida</option>
                    <option>Celular</option>
                    <option>Alquiler</option>
                    <option>Internet</option>
                    <option>Seguro Auto</option>
                    <option>Seguro Casa</option>
                    <option>Seguro Vida</option>
                </select>
            </div>
            <div class="form-group" style="padding-right: 5px">
                <label for="formGroupExampleInput2">Importe</label>
                <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="100.00">
            </div>
            <div class="form-group"style="padding-right: 5px">
                <label for="example-date-input"">Fecha</label>
                <input class="form-control" type="date" value="2017-06-21" id="example-date-input">
            </div>
            <button type="submit" class="btn btn-success">Listo</button>
            <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Ingresa la categoria">
            <button type="submit" class="btn btn-info">Nueva Categoria</button>
        </form>
    </div>
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


