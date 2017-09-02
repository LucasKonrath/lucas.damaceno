app.controller('modificarInstrutoresController', function ($scope, $http, aulaService, instrutorService) {


    $scope.listarInstrutores = listarInstrutores;
    function listarInstrutores(){
        instrutorService.list().then(function(response){
            $scope.listaDeInstrutores = response.data;
        });
    }


    $scope.listarAulas = listarAulas; 
    function listarAulas (){
        aulaService.list().then(function(response){

            $scope.listaDeAulas = response.data;
            $scope.listaDeAulas.splice(0,1);

        });}



    $scope.povoarMudancas = povoarMudancas;

    function povoarMudancas(){

        var instrutor = {}  
        instrutorService.findById($scope.instrutorAModificar.id).then(
            function(response){
                instrutor = response.data;
                $scope.ImagemInstrutorTrocar = response.data.urlFoto;
                $scope.nomeInstrutorTrocar = response.data.nome;
                $scope.sobrenomeInstrutorTrocar = response.data.sobrenome;
                $scope.idadeInstrutorTrocar = response.data.idade;
                $scope.emailInstrutorTrocar = response.data.email;
                $scope.dandoAulaInstrutorTrocar = response.data.dandoAula;
                $scope.fotoInstrutorTrocar = response.data.urlFoto;
                listarAulas();
            }
        )


    }

    $scope.modificaInstrutor = modificaInstrutor;

    function modificaInstrutor(){
        console.log($scope.instrutorAModificar);
        console.log($scope.selecionarAulaATrocar);
        let idsAulas = [];
        if(typeof $scope.selecionarAulaATrocar === "undefined"){
            let nenhumaAula = {id:0, nome:'Nenhuma'};
            idsAulas.push(nenhumaAula.id);
        }
        else{
            for(aula of $scope.selecionarAulaATrocar){
                idsAulas.push(aula.id);
            }
        }
        let instrutorCriar = {
            aula:idsAulas,
            nome:$scope.nomeInstrutorTrocar,
            sobrenome:$scope.sobrenomeInstrutorTrocar,
            urlFoto:$scope.fotoInstrutorTrocar,
            idade:$scope.idadeInstrutorTrocar,
            email:$scope.emailInstrutorTrocar,
            dandoAula:$scope.dandoAulaInstrutorTrocar,
            id: $scope.instrutorAModificar.id
        }

        instrutorService.update(instrutorCriar).then(function(response){

            $scope.listarInstrutores();
            swal("Feito!", "Instrutor modificado com sucesso!", "success");
        });


    }

    $scope.excluiInstrutor = excluiInstrutor;
    function excluiInstrutor(){

        instrutorService.delete($scope.instrutorAModificar).then(function(response){
            $scope.listarInstrutores();
            $scope.listarAulas;
            swal("Feito!", "Instrutor deletado Com Sucesso!", "success");
            $scope.ImagemInstrutorTrocar = '';
            $scope.instrutorAModificar = '';
            $scope.nomeInstrutorTrocar= ''
            $scope.sobrenomeInstrutorTrocar= ''
            $scope.fotoInstrutorTrocar= ''
            $scope.idadeInstrutorTrocar= ''
            $scope.emailInstrutorTrocar= ''
            $scope.dandoAulaInstrutorTrocar= ''
            $scope.instrutorAModificar.id = ''

        });


    }



});