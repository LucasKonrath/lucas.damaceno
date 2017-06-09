modulo.controller('PedidoController', function ($scope, clienteService, $routeParams, $location, $localStorage, imovelService) {






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