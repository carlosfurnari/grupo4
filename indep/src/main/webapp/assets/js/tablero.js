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

function gastosCallback(){
    $.ajax({
        type: "GET",
        url: "./listGasto",
        data: { username: username },
        complete: function(data){
            console.log(data);

            var responseObject = JSON.parse(data['responseText']);
            var gastosJSON = responseObject.gastos;
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
    $("#cargagastos").click(function(){switchInnerPage("cargargastos", cargarGastos)});
    cargarGastos()
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

function ingresosCallback(){

}

function inversionesCallback(){

}

function premiumCallback(){

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