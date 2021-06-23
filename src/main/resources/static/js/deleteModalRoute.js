
    $('#myModal').on('show.bs.modal', function(event){

        var button = $(event.relatedTarget);

        var idURoute = button.data('id');

        var modal = $(this);

        var form = modal.find('form');

        var action = form.data('url-base');

        if(!action.endsWith('/')){
            action += '/';
        }

        form.attr('action', action + idURoute);

       modal.find('.modal-body h5').html('Deseja Realmente eliminar essa rota?');


    });


    $(function() {
        $('[rel="tooltip"]').tooltip();
    });