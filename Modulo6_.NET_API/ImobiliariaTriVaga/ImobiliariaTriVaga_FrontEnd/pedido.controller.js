modulo.controller('PedidoController', function ($scope, clienteService, $routeParams, $location, $localStorage, authService, imovelService) {

    
       $scope.auth = authService;
    
    
     $scope.logout = function (usuario) {

        authService.logout(usuario);

    }
    
    $scope.obterPedido = function(){
        console.log($routeParams.id);
        var idPedido = $routeParams.id;

        imovelService.obterPedido(idPedido).then(

            function(response){
                $scope.clienteDetalhe = response.data.data.Cliente;
                $scope.tipoImovelDetalhe = response.data.data.TipoImovel;
                $scope.pacoteDetalhe = response.data.data.Pacote;
                $scope.totalAPagar = response.data.data.TotalASerPago;
                $scope.totalPorDia = 700;
                $scope.dataRealizadaDetalhe = response.data.data.DataEntregaRealizada;
                $scope.dataVendaDetalhe = response.data.data.DataVenda;
                $scope.dataEntregaPrevistaDetalhe = response.data.data.DataEntregaPrevista;
                console.log(response);
            }


        )

    }
    
    $scope.obterPedidos = function(){
     
        imovelService.obterPedidos().then(

            function(response){
         
                $scope.pedidos = response.data.data;
            }


        )

    }
      $scope.obterPedidos();

    
    
    

    $scope.excluirPedido = function(){
        console.log($routeParams.id);
        var idPedido = $routeParams.id;

        imovelService.excluirPedido(idPedido).then(

            function(response){
                swal("Feito!", "Excluido com sucesso!", "success");
                $location.url('/cadastro');
            }


        )

    }

    $scope.listarTipos = function (){ 
        imovelService.obterImoveis().then(


            function(response){

                console.log(response);
                $scope.tiposDeImoveis = response.data.data;
            },

            function(response){
                console.log('jabulani');
            }

        )
    }


    $scope.listarAdicionais = function (){ 
        imovelService.obterAdicionais().then(


            function(response){

                console.log(response);
                $scope.listaDeAdicionais = response.data.data;
            },

            function(response){
                console.log('jabulani');
            }

        )
    }



    $scope.gerarPedido = function (){ 
        pedidoAGerar = {};
        pedidoAGerar.IdCliente = $localStorage.clienteAtivo.Id;
        pedidoAGerar.DataEntregaPrevista = $scope.pedido.DataEntregaPrevista;
        pedidoAGerar.IdTipoImovel = $scope.selecionarTipoImovel.Id;
        pedidoAGerar.IdPacote= $scope.selecionarTamanhoImovel.Pacote.Id;
        pedidoAGerar.Adicionais = [];
        console.log($scope.selecionarTamanhoImovel);
        console.log(pedidoAGerar);
        imovelService.gerarPedido(pedidoAGerar).then(

            function(response){
                $scope.listarAdicionais();
                $scope.listarTipos();
                $location.url('/visualizarPedido/'+response.data.data.id)
                console.log(response);
            },

            function(response){
                console.log('jabulani');
            }

        )
    }


    $scope.povoarTamanhos = function(){
        console.log($scope.selecionarTipoImovel);
        imovelService.obterTamanhos($scope.selecionarTipoImovel.Id).then(

            function(response){
                console.log(response.data.data);
                $scope.tamanhosImoveis = response.data.data;
            },

            function(response){
                console.log('jabulani');
            }


        )

    }
});