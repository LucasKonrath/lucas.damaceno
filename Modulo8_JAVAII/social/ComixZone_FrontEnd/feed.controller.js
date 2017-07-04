modulo.controller('FeedController', function ($scope, usuarioService, postagemService, authService, $routeParams, $location) {

    carregarUsuario();
    carregarSolicitacoes();
    $scope.curtir = curtir;
    $scope.aceitar=aceitar;
    $scope.descurtir = descurtir;
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
        var postagens = $scope.postagens;
        for(x = 0; x < postagens.length; x++){
            for(i = 0; i < postagens[x].curtidas.length; i++){
                if(postagens[x].curtidas[i].usuarioCurtidor.id == $scope.accountOwner.id && postagens[x].id == id){  
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
            var postagens = response.data;

            for(x = 0; x < postagens.length; x++){
                postagens[x].foiCurtida = false;
                for(i = 0; i < postagens[x].curtidas.length; i++){

                    if(postagens[x].curtidas[i].usuarioCurtidor.id == $scope.accountOwner.id ){  
                        postagens[x].foiCurtida = true;
                    }

                }


            }
            $scope.postagens = postagens;
            console.log($scope.postagens);
        });

    }





});