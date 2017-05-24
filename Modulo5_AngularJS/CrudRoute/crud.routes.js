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