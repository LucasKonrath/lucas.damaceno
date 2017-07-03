modulo.controller('FeedController', function ($scope, usuarioService, postagemService, authService, $routeParams, $location) {

    carregarUsuario();
    carregarSolicitacoes();
    $scope.aceitar=aceitar;
  
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
    
    function aceitar(id){
        usuarioService.aceitar(id).then(
        
            function(response){
                carregarUsuario();
                carregarSolicitacoes();
            }
        
        )
    }
    
    function carregarSolicitacoes(){
        usuarioService.getSolicitacoes().then(
        
        function(response){
            console.log(response.data);
            $scope.solicitacoes = response.data;
            console.log($scope.solicitacoes);
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