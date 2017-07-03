modulo.controller('ProcurarController', function ($scope, usuarioService, authService, $routeParams, $location) {

   $scope.procurarUsuarios = procurarUsuarios;
    procurarUsuarios();
    
    function procurarUsuarios(nome){
        
        usuarioService.getUsuarios().then(
        function(response)
        {
            
            console.log(response);
            $scope.usuarios = response.data;
            
        });
        
    }
     

});