
    $('#myModal').on('show.bs.modal', function(event){

        var button = $(event.relatedTarget);

        var idUser = button.data('id');

        var nameUser = button.data('nome');
        var modal = $(this);

        var form = modal.find('form');

        var action = form.data('url-base');

        if(!action.endsWith('/')){
            action += '/';
        }

        form.attr('action', action + idUser);

       modal.find('.modal-body h5').html('Tem certeza que deseja eliminar o usuário <strong>' + nameUser + '</strong>?');


    });


    $(function() {
        $('[rel="tooltip"]').tooltip();
    });