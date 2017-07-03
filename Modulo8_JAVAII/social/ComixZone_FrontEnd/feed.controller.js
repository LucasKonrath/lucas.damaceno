modulo.controller('FeedController', function ($scope, usuarioService, postagemService, authService, $routeParams, $location) {

    carregarUsuario();
    $scope.enviarPostagem = enviarPostagem;
    
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
    
    function enviarPostagem(){
        
        postagemService.inserirPostagem($scope.postagem).then(
        function(response){
            
            console.log(response.data);
            $location.path('/feed');
            
        }
        
        );
    }
    
    function carregarPostagens(){
        
        
        usuarioService.getPostagensDosAmigos()
            .then(function(response){
            
            console.log(response.data);
            $scope.postagens = response.data;
            
        });
        
    }

   

});