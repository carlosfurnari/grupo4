
function doLogin(e) {
    if (e.preventDefault) e.preventDefault();

    var $form = $("#login-form");
    var data = getFormData($form);
    var formData = JSON.stringify(data)
    $.ajax({
        type: "POST",
        url: "./login",
        data: formData,
        complete: function(data){
            var status = data['status'];
            var responseObject = JSON.parse(data['responseText'])
            if (status != 200){
                console.log(data['responseText']);
                var errorMessage = responseObject.errorMessage;
                $('.login-error-container').html(errorMessage);
            }else {
                localStorage.setItem("user", responseObject.user.username);
                window.location.href = "./tablero";
            }
        },
        dataType: "json",
        contentType : "application/json"
    });
    // You must return false to prevent the default form behavior
    return false;
}

function doRegister(e) {
    if (e.preventDefault) e.preventDefault();

    var $form = $("#register-form");
    var data = getFormData($form);
    var formData = JSON.stringify(data)
    $.ajax({
        type: "POST",
        url: "./register",
        data: formData,
        complete: function(data){
                var status = data['status'];
                var responseObject = JSON.parse(data['responseText'])
                if (status != 200){
                    console.log(data['responseText']);
                    var errorMessage = responseObject.errorMessage;
                    $('.register-error-container').html(errorMessage);
                }else {
                    localStorage.setItem("user", responseObject.user.username);
                    window.location.href = "./tablero";
                }
            },
        dataType: "json",
        contentType : "application/json"
    });
    // You must return false to prevent the default form behavior
    return false;
}

function getFormData($form){
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}

window.onload=function() {

    var form = document.getElementById('login-form');
    if (form.attachEvent) {
        form.attachEvent("submit", doLogin);
    } else {
        form.addEventListener("submit", doLogin);
    }
    form = document.getElementById('register-form');
    if (form.attachEvent) {
        form.attachEvent("submit", doRegister);
    } else {
        form.addEventListener("submit", doRegister);
    }
}
