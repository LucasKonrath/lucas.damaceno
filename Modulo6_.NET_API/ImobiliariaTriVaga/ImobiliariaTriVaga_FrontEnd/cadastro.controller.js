modulo.controller('CadastroController', function ($scope, clienteService, $routeParams, $location, $localStorage) {

    
    $scope.exibirForm = false;
    $scope.cadastrarCliente = cadastrarCliente;
    
    
    function cadastrarCliente(){
  
        console.log($scope.cliente);
        clienteService.cadastrarCliente($scope.cliente).then(


            function(response){
                $localStorage.clienteAtivo = response.data.data;
                console.log($localStorage.clienteAtivo);
                $location.path('/pedido');
                swal("Feito!", "Cliente cadastrado com sucesso!", "success");
            },

            function(response){
                console.log(response);
                swal("Ops!", "Erro no cadastro. :(", "error");
            }

        )
        
        
    }
    
    
    
    
    $scope.obterCPF = function (){ 
        clienteService.obterClientePorCPF($scope.cliente.Cpf).then(


            function(response){

                console.log(response);
                $localStorage.clienteAtivo = response.data.data;
                $location.path('/pedido');
                swal("Feito!", "Cliente já existente, pode fazer o pedido!", "success");
            },

            function(response){
                 $scope.exibirForm = true;
            }

        )
    }
});