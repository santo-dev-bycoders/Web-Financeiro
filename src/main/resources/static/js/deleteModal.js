
    $('#myModalCliente').on('show.bs.modal', function(event){

        var button = $(event.relatedTarget);

        var codigoCliente = button.data('id');

        var descricaoCliente = button.data('nome');

        var modal = $(this);

        var form = modal.find('form');

        var action = form.data('url-base');

        if(!action.endsWith('/')){
            action += '/';
        }

        form.attr('action', action + codigoCliente);

       modal.find('.modal-body h5').html('Tem certeza que deseja eliminar o cliente <strong>' + descricaoCliente + '</strong>?');


    });


    $('#myModalTickets').on('show.bs.modal', function(event){

        alert("djshdhdjhs");

        var button = $(event.relatedTarget);

        var idTickets = button.data('id');

        alert("ID="+idTickets);

        var modal = $(this);

        var form = modal.find('form');

        var action = form.data('url-base');

        if(!action.endsWith('/')){
            action += '/';
        }

        form.attr('action', action + idTickets);

        modal.find('.modal-body h5').html('Tem certeza que deseja eliminar esse bilhete');

    });


    $(function() {
        $('[rel="tooltip"]').tooltip();
    });

    $('#myModalCancelTrip').on('show.bs.modal', function(event){

        var button = $(event.relatedTarget);


        var codigoCliente = button.data('id');

        var descricaoCliente = button.data('nome');
        var modal = $(this);

        var form = modal.find('form');

        var action = form.data('url-base');

        if(!action.endsWith('/')){
            action += '/';
        }

        form.attr('action', action + codigoCliente);

        modal.find('.modal-body h5').html('Deseja Realmente Cancelar essa Viagem?');


    });

    $('#myModalFinishedTrip').on('show.bs.modal', function(event){

        var button = $(event.relatedTarget);


        var id = button.data('id');


        var modal = $(this);

        var form = modal.find('form');

        var action = form.data('url-base');

        if(!action.endsWith('/')){
            action += '/';
        }

        form.attr('action', action + id);

        modal.find('.modal-body h5').html('Deseja Realmente Finalizar essa Viagem?');


    });

    $('#myModalSearchTrip').on('show.bs.modal', function(event){

        var button = $(event.relatedTarget);

        var id = button.data('id');

        alert(id);

        var cliente = button.data('nome');

        var modal = $(this);

        var form = modal.find('form');

        var action = form.data('url-base');

        if(!action.endsWith('/')){
            action += '/';
        }

        form.attr('action', action + codigoCliente);

        modal.find('.modal-body h5').html('ID:<strong>' + id + '</strong>?');

    });