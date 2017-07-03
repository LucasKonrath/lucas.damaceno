modulo.controller('FeedController', function ($scope, usuarioService, postagemService, authService, $routeParams, $location) {

    carregarUsuario();
    carregarSolicitacoes();
    var idUsuarioEspecifico = $routeParams.idUsuario;
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
    
    function carregarSolicitacoes(){
        usuarioService.getSolicitacoes().then(
        
        function(response){
            console.log(response);
            $scope.solicitacoes = response.data;
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
    
    function carregarPostagensDoUsuario(){
        
        
        usuarioService.getPostagensDosAmigos()
            .then(function(response){
            
            console.log(response.data);
            $scope.postagens = response.data;
            
        });
        
    }

   

});