$(document).ready(function(){

    $("#messageArrivelTime").hide();
    $("#messageTimeDeparture").hide();
    $("#messageArrivalDate").hide();
    $("#messageDateTravel").hide();

    $("#btnCadastrar").click(function () {

        var arrivelTime = $("#arrivelTime").val();
        var timeDeparture = $("#timeDeparture").val();
        var arrivalDate = $("#arrivalDate").val();
        var dateTravel = $("#dateTravel").val();

        if (arrivelTime == "" || arrivelTime==null) {
            $("#messageArrivelTime").fadeIn("slow");
            return false;

        }else if (timeDeparture == "" || timeDeparture==null) {
            $("#messageTimeDeparture").fadeIn("slow");
            return false;

        }else if (arrivalDate == "" || arrivalDate==null ) {
            $("#messageArrivalDate").fadeIn("slow");
            return false;

        }else if (dateTravel == "") {
            $("#messageDateTravel").fadeIn("slow");
            return false;
        }

    });

    /* Eventos   */

    $("#arrivelTime").keypress(function(){
        $("#messageArrivelTime").hide();
    });

    $("#timeDeparture").keypress(function(){
        $("#messageTimeDeparture").hide();
    });

    $("#arrivalDate").keypress(function(){
        $("#messageArrivalDate").hide();
    });

    $("#dateTravel").keypress(function(){
        $("#messageDateTravel").hide();
    });

    $("#arrivelTime").click(function(){
        $("#messageArrivelTime").hide();
    });

    $("#timeDeparture").click(function(){
        $("#messageTimeDeparture").hide();
    });

    $("#arrivalDate").click(function(){
        $("#messageArrivalDate").hide();
    });

    $("#dateTravel").click(function(){
        $("#messageDateTravel").hide();
    });



});