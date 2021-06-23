
    $('#myModal').on('show.bs.modal', function(event){

        var button = $(event.relatedTarget);

        var idTypePayment = button.data('id');

        var typePayment = button.data('payment');

        alert(idTypePayment);

        var modal = $(this);

        var form = modal.find('form');

        var action = form.data('url-base');

        if(!action.endsWith('/')){
            action += '/';
        }

        form.attr('action', action + idTypePayment);

       modal.find('.modal-body h5').html('Deseja Realmente eliminar esse tipo de pagamento: <strong>'+typePayment+'</strong>');

    });


    $(function() {
        $('[rel="tooltip"]').tooltip();
    });