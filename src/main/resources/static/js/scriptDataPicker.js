$(document).ready(function(){

    alert("Santos Russo!!");
     $('#dataPartida').datepicker({
        format: 'yyyy/mm/dd',
        language: "pt-BR",
        endDate: '+0'
    });
    
     $('#dataChegada').datepicker({
        format: 'yyyy/mm/dd',
        language: "pt-BR",
        startDate: '+0'
    });
         
});