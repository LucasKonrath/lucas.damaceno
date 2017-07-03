modulo.controller('UsuarioDetalhadoController', function ($scope, usuarioService, postagemService, authService, $routeParams, $location) {

    var idUsuarioEspecifico = $routeParams.idUsuario;
    carregarUsuario();
    carregarPostagens();
    function carregarUsuario(){
        
        usuarioService.getDadosEspecificos(idUsuarioEspecifico).then(
        
            response=> 
            {
                
                console.log(response);
                $scope.accountOwner = response.data;
                carregarPostagens();
            }
            
        )
        
    }
    
    
    function carregarPostagens(){
        
        
        usuarioService.getPostagensEspecificas(idUsuarioEspecifico)
            .then(function(response){
            
            console.log(response.data);
            $scope.postagensDoUsuario = response.data;
            
        });
        
    }
    

   

});