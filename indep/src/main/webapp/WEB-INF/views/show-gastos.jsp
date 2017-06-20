<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
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
<div>
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