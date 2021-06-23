$(document).ready(function(){

    $("#messageName").hide();
    $("#messageNeighborhood").hide();
    $("#messageBi").hide();
    $("#messagePhone").hide();


    $("#btnCadastrar").click(function () {

        var name = $("#name").val();
        var neighborhood = $("#neighborhood").val();
        var bi = $("#bi").val();
        var phone = $("#phone").val();

        if (name == "" || name==null) {
            $("#messageName").fadeIn("slow");
            return false;

        }else if (neighborhood == "" || neighborhood==null) {
            $("#messageNeighborhood").fadeIn("slow");
            return false;

        }else if (bi == "" || bi==null ) {
            $("#messageBi").fadeIn("slow");
            return false;

        }else if (phone == "") {
            $("#messagePhone").fadeIn("slow");
            return false;
        }

    });

    /* Eventos   */

    $("#name").keypress(function(){
        $("#messageName").hide();
    });

    $("#neighborhood").keypress(function(){
        $("#messageNeighborhood").hide();
    });

    $("#bi").keypress(function(){
        $("#messageBi").hide();
    });

    $("#phone").keypress(function(){
        $("#messagePhone").hide();
    });

    $("#name").click(function(){
        $("#messageName").hide();
    });

    $("#neighborhood").click(function(){
        $("#messageNeighborhood").hide();
    });

    $("#bi").click(function(){
        $("#messageBi").hide();
    });

    $("#phone").click(function(){
        $("#messagePhone").hide();
    });



});