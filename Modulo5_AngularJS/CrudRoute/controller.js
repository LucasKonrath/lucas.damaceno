var app = angular.module('app',['ngRoute']);
app.config(function ($routeProvider) {

    $routeProvider
        .when('/addAulas', {
        controller: 'adicionarAulasController',
        templateUrl: 'adicionarAulas.html'
    })
        .when('/addInstrutores', {
        controller: 'adicionarInstrutores',
        templateUrl: 'adicionarInstrutores.html'
    })
        .when('/modInstrutores', {
        controller: 'modificarInstrutores',
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
            aulaService.create(aula);
             $scope.listarAulas;       
        }
        });
        
    }
    $scope.listarAulas = aulaService.list().then(function(response){
        
        $scope.listaDeAulas = response.data; 
        
    });

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


