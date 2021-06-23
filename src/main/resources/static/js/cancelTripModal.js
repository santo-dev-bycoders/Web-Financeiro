
    $('#myModal').on('show.bs.modal', function(event){


        var button = $(event.relatedTarget);

        var idTrip = button.data('id');

        idTrip=idTrip-1;

        var modal = $(this);

        var form = modal.find('form');

        var action = form.data('url-base');

        if(!action.endsWith('/')){
            action += '/';
        }

        form.attr('action', action + idTrip);

       modal.find('.modal-body h5').html('Deseja Realmente Cancelar essa Viagem com o  Nº Bilhete: 000<strong>' + idTrip + '</strong>'+ '?');


    });


    $(function() {
        $('[rel="tooltip"]').tooltip();
    });