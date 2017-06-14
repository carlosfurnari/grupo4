/**
 * Created by rumm on 13/06/17.
 */
/**
/* * A handler function to prevent default submission and run our custom script.
 * @param  {Event} event  the submit event triggered by the user
 * @return {void}
 *!/
const handleLoginFormSubmit = event => {

    // Stop the form from submitting since we’re handling that with AJAX.
    event.preventDefault();

    // TODO: Call our function to get the form data.
    const data = {};

};

const handleRegisterFormSubmit = event => {

    // Stop the form from submitting since we’re handling that with AJAX.
    event.preventDefault();

    // TODO: Call our function to get the form data.
    const data = {};

    // ...this is where we’d actually do something with the form data...
};

/!*
 * This is where things actually get started. We find the form element using
 * its class name, then attach the `handleFormSubmit()` function to the
 * `submit` event.
 *!/
const login_form = document.getElementsByClassName('login-form')[0];
login_form.addEventListener('submit', handleLoginFormSubmit);

const form = document.getElementsByClassName('register-form')[0];
form.addEventListener('submit', handleRegisterFormSubmit);*/

function doLogin(e) {
    if (e.preventDefault) e.preventDefault();

    /* do what you want with the form */
    /*var formData = JSON.stringify($("#login-form").serializeArray());*/
    var $form = $("#login-form");
    var data = getFormData($form);
    var formData = JSON.stringify(data)
    $.ajax({
        type: "POST",
        url: "./login",
        data: formData,
        success: function(){},
        dataType: "json",
        contentType : "application/json"
    });
    // You must return false to prevent the default form behavior
    return false;
}

function doRegister(e) {
    if (e.preventDefault) e.preventDefault();

    /* do what you want with the form */
    /*var formData = JSON.stringify($("#login-form").serializeArray());*/
    var $form = $("#register-form");
    var data = getFormData($form);
    var formData = JSON.stringify(data)
    $.ajax({
        type: "POST",
        url: "./register",
        data: formData,
        success: function(){},
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
