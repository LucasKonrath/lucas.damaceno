modulo.controller('UsuarioDetalhadoController', function ($scope, usuarioService, postagemService, authService, $routeParams, $location) {

    var idUsuarioEspecifico = $routeParams.idUsuario;
    carregarUsuarioLogado();
    carregarUsuario();
    carregarPostagens();
    function carregarUsuario(){
        
        usuarioService.getDadosEspecificos(idUsuarioEspecifico).then(
        
            response=> 
            {
                
                console.log(response);
                $scope.accountOwner = response.data;
                console.log($scope.accountOwner.id);
                console.log(idUsuarioEspecifico);
                carregarPostagens();
            }
            
        )
        
    }
    
    function carregarUsuarioLogado(){
        
        usuarioService.getDados().then(
        
            response=> 
            {
                
                console.log(response.data.id);
                $scope.donoAntigo = response.data;
                if($scope.donoAntigo.id == idUsuarioEspecifico){
                   $location.path("/feed");
                }
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