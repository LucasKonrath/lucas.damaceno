var app = angular.module('app',['ngRoute']);
app.config(function ($routeProvider) {

    $routeProvider
        .when('/addAulas', {
        controller: 'adicionarAulasController',
        templateUrl: 'adicionarAulas.html'
    })
        .when('/addInstrutores', {
        controller: 'adicionarInstrutoresController',
        templateUrl: 'adicionarInstrutores.html'
    })
        .when('/modInstrutores', {
        controller: 'modificarInstrutoresController',
        templateUrl: 'modificarInstrutores.html'
    }).when('/pokemon', {
        controller: 'PokemonController',
        templateUrl: 'pokemon.html'
    })
        .otherwise({redirectTo: 'adicionarAulas.html'});
});



app.controller('adicionarAulasController', function ($scope, $routeParams, aulaService) {
    $scope.insereAula = function(aula){
        let inserir = true;
        aulaService.list().then(function (response){
            var aulas = response.data;
            console.log(aulas);
            for(aulaTestar of aulas){
                if (aulaTestar.nome.toLowerCase() === aula.toLowerCase()) inserir = false;
                swal({
                    title: "Error!",
                    text: "Nome ja cadastrado!",
                    type: "error",
                    confirmButtonText: "Cool"
                });
            }
            if(inserir) {
                aulaService.create(aula).then(function (response) {

                    swal("Feito!", "Aula Inserida Com Sucesso!", "success");
                    $scope.listarAulas();
                });
            }
        });

    }


    $scope.povoarAulaMod = function(){
        if(typeof $scope.selecionarAula !== 'undefined' && $scope.selecionarAula !== null){
            let aulaPovoar = $scope.getAulaByID($scope.selecionarAula.id) || '';
            $scope.novoNome = aulaPovoar.nome;
            $scope.modificarAulaUtilizada = aulaPovoar.estaSendoUtilizada;
        }
    }

    $scope.modificaAula = modificaAula;


    function modificaAula(){
        var aulaAAtualizar = $scope.getAulaByID($scope.selecionarAula.id);
        aulaAAtualizar = aulaAAtualizar.id;
        console.log(aulaAAtualizar);
        var aulaNova = {id:aulaAAtualizar,nome:$scope.novoNome};
        console.log(aulaNova);
        aulaService.update(aulaNova).then(function(response){
            swal("Feito!", "Aula Modificada Com Sucesso!", "success");
            $scope.listarAulas();
            $scope.novoNome =  '';
        });
    }

    $scope.excluiAula = excluiAula;
    function excluiAula(){

        aulaService.delete($scope.getAulaByID($scope.selecionarAula.id)).then(function(response){
            swal("Feito!", "Aula Deletada Com Sucesso!", "success");
            $scope.novoNome = '';
            $scope.listarAulas();
        });

    }

    $scope.getAulaByID = function(ID){

        for(aula of $scope.listaDeAulas){
            if(aula.id === ID) return aula;
        }
        return;
    }

    $scope.listarAulas = listarAulas; 
    function listarAulas (){
        aulaService.list().then(function(response){

            $scope.listaDeAulas = response.data; 
            $scope.listaDeAulas.splice(0,1);
        });}

    $scope.findById = findById;

    function findById(id) {
        aulaService.findById(id).then(function (response) {
            $scope.aula = response.data;
        });
    };
});

app.controller('PokemonController', function ($scope, $http) {

    let url = 'http://pokeapi.co/api/v2/pokemon/25/';

    $http.get(url).then(function (response) {
        $scope.name = response.data.name;
    });
});


app.controller('adicionarInstrutoresController', function($scope,$http,$routeParams, instrutorService, aulaService){

    $scope.listarInstrutores = listarInstrutores;
    function listarInstrutores(){
        instrutorService.list().then(function(response){
            $scope.listaDeInstrutores = response.data;
        });
    }
    $scope.insereInstrutor = insereInstrutor;
    function insereInstrutor(){
        let instrutor = {
            nome:$scope.nomeInstrutorAInserir,
            sobrenome:$scope.sobrenomeInstrutorAInserir,
            idade:$scope.idadeInstrutorAInserir,
            email:$scope.emailInstrutorAInserir,
            dandoAula:$scope.dandoAulalInstrutorAInserir,
            urlFoto: $scope.fotoInstrutorAInserir || "https://cdn.pensador.com/img/authors/me/st/mestre-dos-magos-l.jpg",
        }
        
        let idAulasInstrutor = [];
        if(typeof $scope.selecionarAulaInstrutor === "undefined"){
            idAulasInstrutor.push(0);
        }
        else{
            for(aulas of $scope.selecionarAulaInstrutor){
            idAulasInstrutor.push(aulas.id);
        }
        }
        instrutor.aula = idAulasInstrutor;
        instrutorService.create(instrutor).then(function(response){
            swal("Feito!", "Instrutor adicionado com sucesso!", "success");
            $scope.listarInstrutores();
        });

    }
    $scope.listarAulas = listarAulas; 
    function listarAulas (){
        aulaService.list().then(function(response){

            $scope.listaDeAulas = response.data;
            $scope.listaDeAulas.splice(0,1);

        });}

    $scope.getAulaByID = function(ID){
        if (typeof $scope.listaDeAulas === 'undefined') return; 
        for(aula of $scope.listaDeAulas){
            if(aula.id === ID) return aula;
        }
        return;
    }

});



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

