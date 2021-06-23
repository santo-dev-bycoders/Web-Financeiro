$(document).ready(function(){

    $("#messageCityArrival").hide();
    $("#messageDepartureCity").hide();
    $("#messagePrice").hide();


    $("#btnCadastrar").click(function () {

        var cityArrival = $("#cityArrival").val();
        var departureCity = $("#departureCity").val();
        var price = $("#price").val();


        if (cityArrival == "" || cityArrival==null) {
            $("#messageCityArrival").fadeIn("slow");
            return false;

        }else if (departureCity == "" || departureCity==null) {
            $("#messageDepartureCity").fadeIn("slow");
            return false;

        }else if (price == "" || price==null ) {
            $("#messagePrice").fadeIn("slow");
            return false;

        }

    });

    /* Eventos   */

    $("#cityArrival").keypress(function(){
        $("#messageCityArrival").hide();
    });

    $("#departureCity").keypress(function(){
        $("#messageDepartureCity").hide();
    });

    $("#price").keypress(function(){
        $("#messagePrice").hide();
    });

    $("#cityArrival").click(function(){
        $("#messageCityArrival").hide();
    });

    $("#departureCity").click(function(){
        $("#messageDepartureCity").hide();
    });

    $("#price").click(function(){
        $("#messagePrice").hide();
    });



});