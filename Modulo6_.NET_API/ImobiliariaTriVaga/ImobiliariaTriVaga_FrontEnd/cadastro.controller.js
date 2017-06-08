
modulo.controller('CadastroController', function ($scope, clienteService, $routeParams, $location) {
 
$scope.obterCPF = function (){ 
    clienteService.obterClientePorCPF($scope.CPF).then(response => {

            
            console.log(response);

        })
                             }
});