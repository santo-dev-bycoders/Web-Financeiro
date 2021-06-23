$(document).ready(function(){

    $("#messageName").hide();
    $("#messageLogin").hide();
    $("#messagePassword").hide();

    $("#btnCadastrar").click(function () {

        var name = $("#name").val();
        var login = $("#login").val();
        var password = $("#password").val();

        if (name == "" || name==null) {
            $("#messageName").fadeIn("slow");
            return false;

        }else if (login == "" || login==null) {
            $("#messageLogin").fadeIn("slow");
            return false;

        }else if (password == "" || password==null ) {
            $("#messagePassword").fadeIn("slow");
            return false;

        }

    });

    /* Eventos   */

    $("#name").keypress(function(){
        $("#messageName").hide();
    });

    $("#login").keypress(function(){
        $("#messageLogin").hide();
    });

    $("#password").keypress(function(){
        $("#messagePassword").hide();
    });

    $("#name").click(function(){
        $("#messageName").hide();
    });

    $("#login").click(function(){
        $("#messageLogin").hide();
    });

    $("#password").click(function(){
        $("#messagePassword").hide();
    });



});