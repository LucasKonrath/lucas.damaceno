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
          pedidoAGerar.IdTipoImovel = $scope.selecionarTipoImovel.Id;
          pedidoAGerar.Adicionais = $scope.pedido.Adicionais;
          console.log(pedidoAGerar);
        imovelService.gerarPedido(pedidoAGerar).then(


            function(response){

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