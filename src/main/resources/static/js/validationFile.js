$(document).ready(function(){

    $("#messageFile").hide();

    $("#btnAdicionar").click(function () {

        var myFile = $("#myFile").val();
        if (myFile == "" || myFile==null) {
            $("#messageFile").fadeIn("slow");
            return false;
        }
    });


    $("#myFile").click(function(){
        $("#messageFile").hide();
    });


});