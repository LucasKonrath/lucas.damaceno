modulo.controller('UsuarioDetalhadoController', function ($scope, usuarioService, postagemService, authService, $routeParams, $location) {

    var idUsuarioEspecifico = $routeParams.idUsuario;
    carregarUsuarioLogado();
    carregarUsuario();
    carregarPostagens();
    checarSeEAmigo();
    $scope.adicionar = adicionar;
    $scope.checarSolicitacao = checarSolicitacao;
    $scope.exibirAdicionar = true;
    Array.prototype.contains = function(elem)
{
for (var i in this)
{
if (this[i] == elem) return true;
}
return false;
}
    
    
    
    function adicionar(){
        usuarioService.adicionarAmigo(idUsuarioEspecifico).then(
        
            function(response){
                
                console.log(response);
                $scope.solicitado = true;
                $scope.exibirAdicionar = false;
            }
        
        );
        
    }
    
    
    function checarSolicitacao(){
        var retorno = ($scope.solicitado == true && $scope.amigos == false);
        $scope.exibirAdicionar = false;
    }
    
    
    function checarSeEAmigo(){
         usuarioService.getAmigos().then(
                function(response){
                console.log(response.data);
                var amigos = [];
                amigos = response.data;
                var idsAmigos = [];
                for( i = 0; i< amigos.length; i++){
                    idsAmigos.push(amigos[i].id);
                }
                    console.log(idsAmigos.contains(idUsuarioEspecifico));
                    if(idsAmigos.contains(idUsuarioEspecifico)){
                        $scope.solicitado = false;
                        $scope.exibirAdicionar=false;
                    }
                    $scope.amigos = idsAmigos.contains(idUsuarioEspecifico);
                }
        );
        
        
    }
    
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