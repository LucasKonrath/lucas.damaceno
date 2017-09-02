modulo.controller('ProcurarController', function ($scope, usuarioService, authService, $routeParams, $location) {

   $scope.procurarUsuarios = procurarUsuarios;
    carregarUsuario();
    
    
     function carregarUsuario(){

        usuarioService.getDados().then(

            response=> 
            {
                $scope.accountOwner = response.data;
                console.log($scope.accountOwner);
                    getAmigosDoUsuario();
            }

        )

    }
    
    function procurarUsuarios(nome){
        
        usuarioService.getUsuarios().then(
        function(response)
        {
            
            console.log(response);
            var usuarios = response.data;
            for(usuario of usuarios){
                usuario.eAmigo = false;
                usuario.eVoce = false;
                 if(usuario.id == $scope.accountOwner.id)
                        usuario.eVoce = true;
                for(amigo of $scope.amigos){
                    if(amigo.id == usuario.id)
                        usuario.eAmigo = true;
                    
                }  
            }
            $scope.usuarios = usuarios;
            
        });
        
    }
    
    function getAmigosDoUsuario(){
        console.log('tamo aqui');
        
        usuarioService.getAmigos().then(
        
            function(response){
                
                $scope.amigos = response.data;
                procurarUsuarios();
            }
        
        )    
    }
     

});