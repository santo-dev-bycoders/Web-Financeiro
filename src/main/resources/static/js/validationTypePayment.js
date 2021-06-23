$(document).ready(function(){

    $("#messageTypePayment").hide();

    $("#btnCadastrar").click(function () {
        var typePayment = $("#typePayment").val();

        if (typePayment == "" || typePayment==null) {
            $("#messageTypePayment").fadeIn("slow");
            return false;
        }

    });

    /* Eventos   */

    $("#typePayment").keypress(function(){
        $("#messageTypePayment").hide();
    });

    $("#typePayment").click(function(){
        $("#messageTypePayment").hide();
    });

});