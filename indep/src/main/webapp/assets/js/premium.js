/**
 * Created by Samsung on 17/06/2017.
 */

var cantPreguntas = 5;
var pregActual    = 1;
var pregAnterior  = 0;
var resVisible    = null;
var acumPonderaciones = 0;
var perfil = "Desconocido";

function seleccionaOpcion(ponderacionOpcion) {
    acumPonderaciones += ponderacionOpcion;

    if(pregAnterior > 0){
        $("#preg_"+pregAnterior).removeClass("perfilPreg_anterior");
    }
    //apago pregunta actual
    $("#preg_"+pregActual).removeClass("perfilPreg_on");
    $("#holder_preg_"+pregActual).hide();

    pregAnterior++;
    $("#preg_"+pregAnterior).addClass("perfilPreg_anterior");

    //hay pregunta siguiente?
    if (pregActual < cantPreguntas) {
        //prendo pregunta siguiente
        pregActual++;
        $("#holder_preg_"+pregActual).show();
        $("#preg_"+pregActual).addClass("perfilPreg_on");
    } else {
        //prendo resultado
        $("#preg_res").addClass("perfilPreg_on");


        if (acumPonderaciones  >= 0 &&
            acumPonderaciones  <= 20) {
            perfil = "Conservador";
            $("#holder_res_1").show();
            resVisible = 1;
        }

        if (acumPonderaciones  >= 25 &&
            acumPonderaciones  <= 40) {
            perfil = "Moderado";
            $("#holder_res_2").show();
            resVisible = 2;
        }

        if (acumPonderaciones  >= 45 &&
            acumPonderaciones  <= 50) {
            perfil = "Arriesgado";
            $("#holder_res_3").show();
            resVisible = 3;
        }

    }
}

function reiniciarTest() {
    $("#preg_res").removeClass("perfilPreg_on");
    $("#preg_"+pregAnterior).removeClass("perfilPreg_anterior");
    $("#holder_res_"+resVisible).hide();
    resVisible = null;

    //apago pregunta actual
    $("#preg_"+pregActual).removeClass("perfilPreg_on");
    $("#holder_preg_"+pregActual).hide();

    pregActual    = 1;
    pregAnterior    = 0;
    acumPonderaciones = 0;

    $("#holder_preg_"+pregActual).show();
    $("#preg_"+pregActual).addClass("perfilPreg_on");
}

function mostrarTest() {
    $("#main-premium").hide();
    $("#testInversor").show();
}

function volver() {
    $("#testInversor").hide();
    document.getElementById("perfil-out").innerHTML = perfil;
    $("#main-premium").show();
    if (perfil !== "Desconocido"){
        mostrarRecomendacion();
    }
}

function mostrarRecomendacion() {
    $("#reco-default").hide();
    $("#reco-conservador").hide();
    $("#reco-moderado").hide();
    $("#reco-agresivo").hide();
    if (perfil === "Conservador"){
        $("#reco-conservador").show();
    } else if (perfil === "Moderado"){
        $("#reco-moderado").show();
    } else {
        $("#reco-agresivo").show();
    }
}

function volverL() {
    $("#lebacs").hide();
    $("#main-premium").show();
}

function volverA() {
    $("#acciones").hide();
    $("#main-premium").show();
}

function mostrarDolar() {
    mostrarLebacs();
}

function mostrarLebacs() {
    $("#main-premium").hide();
    $("#lebacs").show();
}

function mostrarAcciones() {
    $("#main-premium").hide();
    $("#acciones").show();
}

function ocultarMenus(){
    $("#resumen").hide();
    $("#monedas").hide();
    $("#bolsas").hide();
    $("#commodities").hide();
}

function mostrarResumen() {
    ocultarMenus();
    $("#resumen").show();
}

function mostrarMonedas() {
    ocultarMenus();
    $("#monedas").show();
}

function mostrarBolsas() {
    ocultarMenus();
    $("#bolsas").show();
}

function mostrarCommodities() {
    ocultarMenus();
    $("#commodities").show();
}