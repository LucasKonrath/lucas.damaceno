modulo.controller('UsuarioDetalhadoController', function ($scope, usuarioService, postagemService, authService, $routeParams, $location) {

    var idUsuarioEspecifico = $routeParams.idUsuario;
    carregarUsuarioLogado();
    carregarUsuario();
    checarSeEAmigo();
    $scope.logout = logout;
    $scope.adicionar = adicionar;
    $scope.checarSolicitacao = checarSolicitacao;
    $scope.exibirAdicionar = true;
    $scope.curtir = curtir;
    $scope.descurtir = descurtir;
    Array.prototype.contains = function(elem)
    {
        for (var i in this)
        {
            if (this[i] == elem) return true;
        }
        return false;
    }


    function logout(){
        authService.logout();
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
            var postagens = response.data;

            for(x = 0; x < postagens.length; x++){
                postagens[x].foiCurtida = false;
                for(i = 0; i < postagens[x].curtidas.length; i++){

                    if(postagens[x].curtidas[i].usuarioCurtidor.id == $scope.donoAntigo.id ){  
                        postagens[x].foiCurtida = true;
                    }

                }


            }
            $scope.postagensDoUsuario = postagens;

        });

    }
    
    
    
    
   
    
     function curtir(id){
        console.log('entrou aqui');
        postagemService.curtirPostagem(id).then(

            function(response){

                console.log(response.data);
                carregarPostagens();
            }

        )
    }

    function descurtir(id){
        console.log('entrou aqui');
        var idsLikeDoUser = [];
        var postagens = $scope.postagensDoUsuario;
        for(x = 0; x < postagens.length; x++){
            for(i = 0; i < postagens[x].curtidas.length; i++){
                console.log($scope.donoAntigo.id);
                if(postagens[x].curtidas[i].usuarioCurtidor.id == $scope.donoAntigo.id && postagens[x].id == id){  
                    idsLikeDoUser.push(postagens[x].curtidas[i].id);
                }
            }
        }
        var contador = 0;
        for(cadaId of idsLikeDoUser){
            console.log(cadaId);
            contador ++;
            postagemService.descurtirPostagem(cadaId).then(
                function(response){
                    console.log(response.data);
                    carregarPostagens();
                    
                     
                }
                
            );
        }
    }




});