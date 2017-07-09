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

function submitForm(formId, switchToPage, switchPageCallback, endpoint) {

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
                switchInnerPage(switchToPage, switchPageCallback)
            }
        },
        dataType: "json",
        contentType : "application/json"
    });

}

function deleteRecord(id, endpoint, switchToPage, switchToPageCallback){
    $.ajax({
        type: "GET",
        url: endpoint,
        data: { username: username , id: id},
        complete: function(data){
            console.log(data);
            switchInnerPage(switchToPage, switchToPageCallback)

        },
        dataType: "json",
        contentType : "application/json"
    });
}

function getCategoriasList(elementId){
    $.ajax({
        type: "GET",
        url: "./listCategorias",
        data: { username: username },
        complete: function(data){
            console.log(data);

            var responseObject = JSON.parse(data['responseText']);
            var categoriasJSON = responseObject.categorias;
            var html = "";
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

/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************Gastos******************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/
/*******************************************************************************************************************/


function gastosCallback(){
    $.ajax({
        type: "GET",
        url: "./listGasto",
        data: { username: username },
        complete: function(data){
            console.log(data);

            var responseObject = JSON.parse(data['responseText']);
            var gastosJSON = responseObject.gastos;
            gastosJSON = addEditAndDeleteLinksToGastosTable(gastosJSON)
            $('#table-gastos').dynatable({
                dataset: {
                    records: gastosJSON
                }
            });
        },
        dataType: "json",
        contentType : "application/json"
    });
    $.ajax({
        type: "GET",
        url: "./listGastoByCategoria",
        data: { username: username },
        complete: function(data){
            console.log(data);

            var responseObject = JSON.parse(data['responseText']);
            var gastosJSON = responseObject.gastoByCategoria;
            $('#table-gastos-categoria').dynatable({
                dataset: {
                    records: gastosJSON
                }
            });
        },
        dataType: "json",
        contentType : "application/json"
    });
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
    deleteRecord(id, "./deleteGasto", "gastos", gastosCallback);

}

function editGasto(id){
    console.log("<<<<<<<<<<<<<lllego>>>>>>>>>>");
    console.log(id);
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

    getCategoriasList("categoria")

    $("#addGasto").click(function(){
        submitForm("#cargaForm", "gastos", gastosCallback, "./addGasto")
    });

    $("#addCategoria").click(function(){
        submitForm("#categoriaForm", "gastos", gastosCallback, "./addCategoria")
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



function ingresosCallback(){

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


function inversionesCallback(){

}

function premiumCallback(){

}

