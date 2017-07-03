modulo.controller('EditarController', function ($scope, usuarioService, authService, $routeParams, $location) {


    carregarUsuario();
    $scope.modificar = modificarUsuario;
    function carregarUsuario(){
        
        usuarioService.getDados().then(
        
        function(response){
            
            console.log(response);
            response.data.senha = '';
            $scope.usuario = response.data;
        }
        )
        
    }
    
    
    function modificarUsuario(){
        console.log('entrou aqui');
        console.log($scope.usuario);
        usuarioService.modificar($scope.usuario).then(
        
            function(response){
                
                console.log(response);
                authService.login($scope.usuario);   
            }
            
        );
        
        
    }
     

});