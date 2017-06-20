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
    $("#showPremium").click(function(){switchInnerPage("premium")});
    //$("#showPremium").click(switchInnerPage);


}

function switchInnerPage(page, callback){
    var innerPage = './'+ page + 'Page';
    $.get(innerPage,{ username: username }, function(data) {

        console.log(data);
        $('.main-container').html(data);
        //$('#gastos-table').dynatable();
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

}

function ingresosCallback(){

}

function inversionesCallback(){

}
