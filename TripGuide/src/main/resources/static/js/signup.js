
(function ($) {
    "use strict";

    /*==================================================================
    [ Focus Contact2 ]*/
    $('.input100').each(function(){
        $(this).on('blur', function(){
            if($(this).val().trim() != "") {
                $(this).addClass('has-val');
            }
            else {
                $(this).removeClass('has-val');
            }
        })    
    })


    /*==================================================================
    [ Validate after type ]*/
    $('.validate-input .input100').each(function(){
        $(this).on('blur', function(){
            if(validate(this) == false){
                showValidate(this);
            }
            else {
                $(this).parent().addClass('true-validate');
            }
        })    
    })

    $('.validate-input .input101').each(function(){
        $(this).on('blur', function(){
            if(validate(this) == false){
                showValidate(this);
            }
            else {
                $(this).parent().addClass('true-validate');
            }
        })    
    })

    function isAdmin(input){
        if($(input).val() == "admin@admin.com"){
            console.log("admin detected");
            return true;
        } return false;
    }

    function isAdminPass(input){
        if($(input).val() == "admin"){
            console.log("admin pass correct");
            return true;
        } return false;
    }

    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');
    var loginFormInput = $('.validate-input .input101');

    $('.validate-form').on('submit',function(){
        var check = true;
        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }

        }

        return check;
    });

    $('.validate-form-login').on('submit',function(){
        var check = true;

        for(var i=0; i<loginFormInput.length; i++) {
            if(validate(loginFormInput[i]) == false){
                showValidate(loginFormInput[i]);
                check=false;
            }
        }

        if(isAdmin(loginFormInput[0]) == false){
            check = false;
        } else {
            if(isAdminPass(loginFormInput[1]) == false){
                check = false;
            }
        }
        return check;
    });

    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
           $(this).parent().removeClass('true-validate');
        });
    });

    function validate(input) {
        var firstPass = null;
        if($(input).attr('name') == 'pass') firstPass = $(input).val().trim();
        if($(input).attr('name') == 'email') {
            return validateEmail($(input));
        } else if($(input).attr('name') == 'repeat-pass' && $(input).val().trim() != '') {
            firstPass = $('input[name ="pass"]').val().trim();
            return validateRepeatedPassword(firstPass, $(input));
        } else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function validateEmail(input) {
        if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
            return false;
        }
    }

    function validateRepeatedPassword(firstPass, input) {
        if($(input).val().trim() != firstPass) {
            return false;
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();
        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();
        $(thisAlert).removeClass('alert-validate');
    }

})(jQuery);