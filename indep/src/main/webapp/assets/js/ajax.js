var username;
window.onload=function() {
    username = localStorage.getItem("user");

    //TODO:hacer if aca que si no hay user vaya a la login page
    $("#showGastos").click(function(){switchInnerPage("gastos")});
    $("#showIngresos").click(function(){switchInnerPage("ingresos")});
    $("#showInversiones").click(function(){switchInnerPage("inversiones")});
    //$("#showPremium").click(switchInnerPage);
}

function switchInnerPage(page){
    var innerPage = './'+ page + 'Page';
    $.get(innerPage,{ username: username }, function(data) {

        console.log(data);
        $('.main-container').html(data);
    });
}

