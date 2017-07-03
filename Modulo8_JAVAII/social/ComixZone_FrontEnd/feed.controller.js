modulo.controller('FeedController', function ($scope, usuarioService, authService, $routeParams, $location) {

    carregarUsuario();
 
    
    function carregarUsuario(){
        
        usuarioService.getDados().then(
        
            response=> 
            {
                
                console.log(response);
                $scope.accountOwner = response.data;
                carregarPostagens();
            }
            
        )
        
    }
    
    function carregarPostagens(){
        
        
        usuarioService.getPostagensDosAmigos()
            .then(function(response){
            
            console.log(response.data);
            $scope.postagens = response.data;
            
        });
        
    }

   

});