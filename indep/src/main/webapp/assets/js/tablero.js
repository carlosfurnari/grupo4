/**
 * Created by rumm on 18/06/17.
 */
var username;
window.onload=function() {
    username = localStorage.getItem("user");

    //TODO:hacer if aca que si no hay user vaya a la login page
    $("#showGastos").click(function(){switchInnerPage("gastos", gastosCallback)});
    $("#showIngresos").click(function(){switchInnerPage("ingresos", ingresosCallback)});
    $("#showInversiones").click(function(){switchInnerPage("inversiones", inversionesCallback)});
    $("#showPremium").click(function(){switchInnerPage("premium", premiumCallback)});



}



function switchInnerPage(page, callback){
    var innerPage = './'+ page + 'Page';
    $.get(innerPage,{ username: username }, function(data) {

        console.log(data);
        $('.main-container').html(data);
        callback()
    });
}

function getFormData($form){
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}

function submitForm(formId, refreshTable, endpoint) {

    var $form = $(formId);
    var data = getFormData($form);
    var formData = JSON.stringify(data)
    $.ajax({
        type: "POST",
        url: endpoint,
        data: formData,
        complete: function(data){
            var status = data['status'];
            var responseObject = JSON.parse(data['responseText'])
            if (status != 200){
                console.log(data['responseText']);
                var errorMessage = responseObject.errorMessage;
                $('.page-error-container').html(errorMessage);
            }else {
                refreshTable();
                //switchInnerPage(switchToPage, switchPageCallback)
            }
        },
        dataType: "json",
        contentType : "application/json"
    });

}

function deleteRecord(id, endpoint, refreshTable){
    $.ajax({
        type: "GET",
        url: endpoint,
        data: { username: username , id: id},
        complete: function(data){
            console.log(data);
            refreshTable();
            // switchInnerPage(switchToPage, switchToPageCallback)

        },
        dataType: "json",
        contentType : "application/json"
    });
}

function getCategoriasList(elementId, withEmpty){
    $.ajax({
        type: "GET",
        url: "./listCategorias",
        data: { username: username },
        complete: function(data){
            console.log(data);

            var responseObject = JSON.parse(data['responseText']);
            var categoriasJSON = responseObject.categorias;
            var html = "";
            if (withEmpty){
                html += '<option value="empty"></option>';
            }
            for(var index in categoriasJSON) {
                html += "<option value=" + categoriasJSON[index]['id']  + ">" +categoriasJSON[index]['nombre'] + "</option>"
            }
            document.getElementById(elementId).innerHTML = html;
        },
        dataType: "json",
        contentType : "application/json"
    });
}

function activarTablero() {
    $('.navbar-nav li.active ').removeClass('active');
    $("#tb").addClass('active');
}

function activarGastos() {
    $('.navbar-nav li.active ').removeClass('active');
    $("#gs").addClass('active');
}

function activarIngresos() {
    $('.navbar-nav li.active ').removeClass('active');
    $("#ing").addClass('active');
}

function activarInversiones() {
    $('.navbar-nav li.active ').removeClass('active');
    $("#inv").addClass('active');
}

function activarPremium() {
    $('.navbar-nav li.active ').removeClass('active');
    $("#pr").addClass('active');
}

function procesarTablas(json, total, tableName) {
    $(tableName)
        .dynatable({
            dataset: {
                records: json
            }

        });
    $(tableName).find('tfoot').html('<tr><td colspan=3>Total:</td><td>' + total + '</td></tr>');
}

function updateTablas(json, total, tableName){
    var dynatable = $(tableName)
        .dynatable({}).data('dynatable');
    dynatable.settings.dataset.originalRecords = json;
    dynatable.process();
    $(tableName).find('tfoot').html('<tr><td colspan=3>Total:</td><td>' + total + '</td></tr>');
}


/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************Gastos******************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/

function refreshGastosList(){
    var e = document.getElementById("search_fecha");
    var filter = e.options[e.selectedIndex].value;

    e = document.getElementById("search_categoria");
    var filterCategoria = e.options[e.selectedIndex].value;

    getListGastos(filter, filterCategoria, updateTablas, "#table-gastos");

    getCategoriasList("categoria", false);
    getCategoriasList("search_categoria", true);

}

function getListGastos(filter, filterCategoria, postProcess, tableName) {

    $.ajax({
        type: "GET",
        url: "./listGasto",
        data: {username: username, filtro: filter, filtroCategoria: filterCategoria},
        complete: function (data) {
            console.log(data);

            var responseObject = JSON.parse(data['responseText']);
            var gastosJSON = responseObject.gastos;
            gastosJSON = addEditAndDeleteLinksToGastosTable(gastosJSON)

            postProcess(gastosJSON, responseObject.total, tableName)

        },
        dataType: "json",
        contentType: "application/json"
    });
    $.ajax({
        type: "GET",
        url: "./listGastoByCategoria",
        data: {username: username, filtro: filter, filtroCategoria: filterCategoria},
        complete: function (data) {
            console.log(data);

            var responseObject = JSON.parse(data['responseText']);
            var gastosJSON = responseObject.gastoByCategoria;
            postProcess(gastosJSON, responseObject.total, "#table-gastos-categoria")

            /*$('#table-gastos-categoria').dynatable({
                dataset: {
                    records: gastosJSON
                }
            });*/
        },
        dataType: "json",
        contentType: "application/json"
    });
}
function gastosCallback(){

    getListGastos("","", procesarTablas, "#table-gastos");
    cargarGastos()
}

function addEditAndDeleteLinksToGastosTable(json){
    for (var index in json) {
        var idGasto = json[index]['id'];
        json[index]['borrar'] = '<button type="submit" class="btn btn-info" id='+ idGasto+' onclick=javascript:deleteGasto(id)>Borrar</button>';
        json[index]['editar'] = '<button type="submit" class="btn btn-info" id='+ idGasto+' onclick=javascript:editGasto(id)>Editar</button>';

    }
    return json;
}

function deleteGasto(id){
    deleteRecord(id, "./deleteGasto", refreshGastosList);

}

function editGasto(id){
    var dynatable = $('#table-gastos').data('dynatable');
    var records = dynatable.settings.dataset.records;

    for (var index in records){
        if (records[index]['id'] == id){
            document.getElementById("userField").value = username;
            document.getElementById("categoria").value = records[index]['categoriaId'];
            document.getElementById("idField").value = records[index]['id'];
            document.getElementById("descripcionField").value = records[index]['descripcion'];
            document.getElementById("montoField").value = records[index]['monto'];
            var d = records[index]['fecha'];
            d = d.split('-').reverse().join('-');

            document.getElementById("datePicker").value = d;
            break;
        }
    }
}


function cargarGastos() {
    var today = moment().format('YYYY-MM-DD');
    document.getElementById("datePicker").value = today;
    document.getElementById("userField").value = username;
    document.getElementById("userFieldCategoria").value = username;

    getCategoriasList("categoria", false);
    getCategoriasList("search_categoria", true);

    $("#addGasto").click(function(){
        submitForm("#cargaForm", refreshGastosList, "./addGasto");
        var today = moment().format('YYYY-MM-DD');
        document.getElementById("datePicker").value = today;
        document.getElementById("userField").value = username;
        document.getElementById("categoria").value = "0";
        document.getElementById("idField").value = "";
        document.getElementById("descripcionField").value = "";
        document.getElementById("montoField").value = "";

    });

    $("#addCategoria").click(function(){
        submitForm("#categoriaForm", refreshGastosList, "./addCategoria");
        document.getElementById("userFieldCategoria").value = username;
        document.getElementById("descripcionFieldCategoria").value = "";
        document.getElementById("nombreFieldCategoria").value = "";

    });

    $("#filter").click(function(){
        refreshGastosList();
    });



}


/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************Ingresos****************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/

function refreshIngresosList(){
    var e = document.getElementById("search_fecha");
    var filter = e.options[e.selectedIndex].value;

    e = document.getElementById("search_categoria");
    var filterCategoria = e.options[e.selectedIndex].value;

    getListIngresos(filter, filterCategoria, updateTablas, "#table-ingresos");

    getCategoriasList("categoria", false);
    getCategoriasList("search_categoria", true);

}

function getListIngresos(filter, filterCategoria, postProcess, tableName) {

    $.ajax({
        type: "GET",
        url: "./listIngreso",
        data: {username: username, filtro: filter, filtroCategoria: filterCategoria},
        complete: function (data) {
            console.log(data);

            var responseObject = JSON.parse(data['responseText']);
            var ingresosJSON = responseObject.ingresos;
            ingresosJSON = addEditAndDeleteLinksToIngresosTable(ingresosJSON)

            postProcess(ingresosJSON, responseObject.total, tableName)

        },
        dataType: "json",
        contentType: "application/json"
    });
    $.ajax({
        type: "GET",
        url: "./listIngresoByCategoria",
        data: {username: username, filtro: filter, filtroCategoria: filterCategoria},
        complete: function (data) {
            console.log(data);

            var responseObject = JSON.parse(data['responseText']);
            var ingresosJSON = responseObject.ingresoByCategoria;
            postProcess(ingresosJSON, responseObject.total, "#table-ingresos-categoria")

        },
        dataType: "json",
        contentType: "application/json"
    });
}
function ingresosCallback(){

    getListIngresos("","", procesarTablas, "#table-ingresos");
    cargarIngresos()
}

function addEditAndDeleteLinksToIngresosTable(json){
    for (var index in json) {
        var idIngreso = json[index]['id'];
        json[index]['borrar'] = '<button type="submit" class="btn btn-info" id='+ idIngreso+' onclick=javascript:deleteIngreso(id)>Borrar</button>';
        json[index]['editar'] = '<button type="submit" class="btn btn-info" id='+ idIngreso+' onclick=javascript:editIngreso(id)>Editar</button>';

    }
    return json;
}

function deleteIngreso(id){
    deleteRecord(id, "./deleteIngreso", refreshIngresosList);

}

function editIngreso(id){
    var dynatable = $('#table-ingresos').data('dynatable');
    var records = dynatable.settings.dataset.records;

    for (var index in records){
        if (records[index]['id'] == id){
            document.getElementById("userField").value = username;
            document.getElementById("categoria").value = records[index]['categoriaId'];
            document.getElementById("idField").value = records[index]['id'];
            document.getElementById("descripcionField").value = records[index]['descripcion'];
            document.getElementById("montoField").value = records[index]['monto'];
            var d = records[index]['fecha'];
            d = d.split('-').reverse().join('-');

            document.getElementById("datePicker").value = d;
            break;
        }
    }
}


function cargarIngresos() {
    var today = moment().format('YYYY-MM-DD');
    document.getElementById("datePicker").value = today;
    document.getElementById("userField").value = username;
    document.getElementById("userFieldCategoria").value = username;

    getCategoriasList("categoria", false);
    getCategoriasList("search_categoria", true);

    $("#addIngreso").click(function(){
        submitForm("#cargaForm", refreshIngresosList, "./addIngreso");
        var today = moment().format('YYYY-MM-DD');
        document.getElementById("datePicker").value = today;
        document.getElementById("userField").value = username;
        document.getElementById("categoria").value = "0";
        document.getElementById("idField").value = "";
        document.getElementById("descripcionField").value = "";
        document.getElementById("montoField").value = "";

    });

    $("#addCategoria").click(function(){
        submitForm("#categoriaForm", refreshIngresosList, "./addCategoria");
        document.getElementById("userFieldCategoria").value = username;
        document.getElementById("descripcionFieldCategoria").value = "";
        document.getElementById("nombreFieldCategoria").value = "";

    });

    $("#filter").click(function(){
        refreshIngresosList();
    });



}


/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************Inversiones*************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/


function refreshInversionesList(){
    var e = document.getElementById("search_fecha");
    var filter = e.options[e.selectedIndex].value;

    e = document.getElementById("search_categoria");
    var filterCategoria = e.options[e.selectedIndex].value;

    getListinversiones(filter, filterCategoria, updateTablas, "#table-inversiones");

    getCategoriasList("categoria", false);
    getCategoriasList("search_categoria", true);

}

function getListinversiones(filter, filterCategoria, postProcess, tableName) {

    $.ajax({
        type: "GET",
        url: "./listInversion",
        data: {username: username, filtro: filter, filtroCategoria: filterCategoria},
        complete: function (data) {
            console.log(data);

            var responseObject = JSON.parse(data['responseText']);
            var inversionesJSON = responseObject.inversiones;
            inversionesJSON = addEditAndDeleteLinksToinversionesTable(inversionesJSON)

            postProcess(inversionesJSON, responseObject.total, tableName)

        },
        dataType: "json",
        contentType: "application/json"
    });
    $.ajax({
        type: "GET",
        url: "./listInversionByCategoria",
        data: {username: username, filtro: filter, filtroCategoria: filterCategoria},
        complete: function (data) {
            console.log(data);

            var responseObject = JSON.parse(data['responseText']);
            var inversionesJSON = responseObject.inversionByCategoria;
            postProcess(inversionesJSON, responseObject.total, "#table-inversiones-categoria")

        },
        dataType: "json",
        contentType: "application/json"
    });
}
function inversionesCallback(){

    getListinversiones("","", procesarTablas, "#table-inversiones");
    cargarinversiones()
}

function addEditAndDeleteLinksToinversionesTable(json){
    for (var index in json) {
        var idinversion = json[index]['id'];
        json[index]['borrar'] = '<button type="submit" class="btn btn-info" id='+ idinversion+' onclick=javascript:deleteInversion(id)>Borrar</button>';
        json[index]['editar'] = '<button type="submit" class="btn btn-info" id='+ idinversion+' onclick=javascript:editInversion(id)>Editar</button>';

    }
    return json;
}

function deleteInversion(id){
    deleteRecord(id, "./deleteInversion", refreshInversionesList);

}

function editInversion(id){
    var dynatable = $('#table-inversiones').data('dynatable');
    var records = dynatable.settings.dataset.records;

    for (var index in records){
        if (records[index]['id'] == id){
            document.getElementById("userField").value = username;
            document.getElementById("categoria").value = records[index]['categoriaId'];
            document.getElementById("idField").value = records[index]['id'];
            document.getElementById("descripcionField").value = records[index]['descripcion'];
            document.getElementById("montoField").value = records[index]['monto'];
            var d = records[index]['fecha'];
            d = d.split('-').reverse().join('-');

            document.getElementById("datePicker").value = d;
            break;
        }
    }
}


function cargarinversiones() {
    var today = moment().format('YYYY-MM-DD');
    document.getElementById("datePicker").value = today;
    document.getElementById("userField").value = username;
    document.getElementById("userFieldCategoria").value = username;

    getCategoriasList("categoria", false);
    getCategoriasList("search_categoria", true);

    $("#addinversion").click(function(){
        submitForm("#cargaForm", refreshInversionesList, "./addInversion");
        var today = moment().format('YYYY-MM-DD');
        document.getElementById("datePicker").value = today;
        document.getElementById("userField").value = username;
        document.getElementById("categoria").value = "0";
        document.getElementById("idField").value = "";
        document.getElementById("descripcionField").value = "";
        document.getElementById("montoField").value = "";

    });

    $("#addCategoria").click(function(){
        submitForm("#categoriaForm", refreshInversionesList, "./addCategoria");
        document.getElementById("userFieldCategoria").value = username;
        document.getElementById("descripcionFieldCategoria").value = "";
        document.getElementById("nombreFieldCategoria").value = "";

    });

    $("#filter").click(function(){
        refreshInversionesList();
    });



}

function tableroCallback() {
    $.ajax({
        type: "GET",
        url: "./tableroData",
        data: {username: username},
        complete: function (data) {
            console.log(data);

            var responseObject = JSON.parse(data['responseText']);
            var tableroDataJSON = responseObject.inversiones;
            $('.inversionesSquare').html("<h2>" + tableroDataJSON['inversion'] + "</h2>");
            $('.gastosSquare').html("<h2>" + tableroDataJSON['gastos']  + "</h2>");
            $('.ingresosSquare').html("<h2>" + tableroDataJSON['ingresos']  + "</h2>");
            $('.balanceSquare').html("<h2>" + tableroDataJSON['balance']  + "</h2>");


        },
        dataType: "json",
        contentType: "application/json"
    });
}

function premiumCallback(){

}

